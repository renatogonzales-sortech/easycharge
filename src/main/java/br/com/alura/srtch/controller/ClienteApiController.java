package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.form.ClienteForm;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

@RestController
@RequestMapping("/ClientesAPI")
public class ClienteApiController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteDTO> lista() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ClienteDTO.converter(clientes);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrar(@RequestBody ClienteForm form, UriComponentsBuilder uriBuilder) {
        Cliente cliente = form.converter(clienteRepository);
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
    }
}
