package br.com.alura.srtch.dto;

import br.com.alura.srtch.form.DividaForm;
import br.com.alura.srtch.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DividaDTO {

    private Long id;

    private BigDecimal valor;

    private LocalDate dataDeAbertura;

    private LocalDate dataDeQuitacao;

    private StatusDivida status;

    private String descricaoDeQuitacao;

    private Long idCliente;

    public DividaDTO() {
    }

    public DividaDTO(Divida divida){
        this.id = divida.getId();
        this.valor = divida.getValor();
        this.dataDeAbertura = divida.getDataDeAbertura();
        this.dataDeQuitacao = divida.getDataDeQuitacao();
        this.status = divida.getStatus();
        this.descricaoDeQuitacao = divida.getDescricaoDeQuitacao();
        this.idCliente = divida.getCliente().getId();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getDataDeAbertura() {
        return dataDeAbertura;
    }

    public LocalDate getDataDeQuitacao() {
        return dataDeQuitacao;
    }

    public StatusDivida getStatus() {
        return status;
    }

    public String getDescricaoDeQuitacao() {
        return descricaoDeQuitacao;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public static List<DividaDTO> converter(List<Divida> dividas){
        return dividas.stream().map(DividaDTO::new).collect(Collectors.toList());
    };
}
