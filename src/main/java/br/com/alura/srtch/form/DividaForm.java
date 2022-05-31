package br.com.alura.srtch.form;

import br.com.alura.srtch.dto.DividaDTO;
import br.com.alura.srtch.model.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DividaForm {

    @NotNull @Positive
    private BigDecimal valor = BigDecimal.ZERO;

    @NotNull @PastOrPresent
    private LocalDate dataDeAbertura;

    @PastOrPresent
    private LocalDate dataDeQuitacao;

    @Enumerated(EnumType.STRING)
    private StatusDivida status = StatusDivida.ABERTA;

    private String descricaoDeQuitacao;

    @NotNull
    private Long idCliente;


    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(LocalDate dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public LocalDate getDataDeQuitacao() {
        return dataDeQuitacao;
    }

    public void setDataDeQuitacao(LocalDate dataDeQuitacao) {
        this.dataDeQuitacao = dataDeQuitacao;
    }

    public StatusDivida getStatus() {
        return status;
    }

    public void setStatus(StatusDivida status) {
        this.status = status;
    }

    public String getDescricaoDeQuitacao() {
        return descricaoDeQuitacao;
    }

    public void setDescricaoDeQuitacao(String descricaoDeQuitacao) {
        this.descricaoDeQuitacao = descricaoDeQuitacao;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }


    public Divida converter(Cliente cliente) {
        Divida divida = new Divida(this.valor,this.dataDeAbertura,this.status,cliente);
        if (this.dataDeQuitacao != null) {
            divida.setDataDeQuitacao(this.dataDeQuitacao);
        }
        if (this.descricaoDeQuitacao != null) {
            divida.setDescricaoDeQuitacao(this.descricaoDeQuitacao);
        }
        return divida;
    }
}
