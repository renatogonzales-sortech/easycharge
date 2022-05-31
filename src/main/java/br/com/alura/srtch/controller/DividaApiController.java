package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.DividaDTO;
import br.com.alura.srtch.form.DividaForm;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.repository.ClienteRepository;
import br.com.alura.srtch.repository.DividaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;

@RestController
@RequestMapping("/DividasAPI")
public class DividaApiController {


    @Autowired
    private ClienteRepository clienteRepository;



    @Autowired
    private DividaRepository dividaRepository;


    @PostMapping
    public ResponseEntity<DividaDTO> cadastrar(@RequestBody DividaForm form, UriComponentsBuilder uriBuilder) {
        Cliente cliente = clienteRepository.getById(form.getIdCliente());

        if (cliente.getRenda().multiply(new BigDecimal(12)).doubleValue() < form.getValor().doubleValue()) {

        }
        Divida divida = form.converter(cliente);
        dividaRepository.save(divida);

        URI uri = uriBuilder.path("/dividas/{id}").buildAndExpand(divida.getId()).toUri();
        return ResponseEntity.created(uri).body(new DividaDTO(divida));
    }
}
