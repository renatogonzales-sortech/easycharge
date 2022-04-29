package br.com.alura.srtch;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "divida")
public class Divida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable=false)
    private BigDecimal valorDaDivida;

    @Column(nullable=false)
    private LocalDate dataDeAbertura = LocalDate.now();


    private LocalDate dataDeQuitacao;


    @Column(length=255)
    private String descricaoDeQuitacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private StatusDivida status;



    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @OneToMany(mappedBy = "divida", cascade = CascadeType.ALL)
    private final List<Cobranca> cobrancas = new ArrayList<>();

    public Divida() {
    }

    public Divida(BigDecimal valorDaDivida, String descricaoDeQuitacao,StatusDivida status, Cliente cliente) {
        this.valorDaDivida = valorDaDivida;
        this.dataDeAbertura = LocalDate.now();
        this.descricaoDeQuitacao = descricaoDeQuitacao;
        this.status = status;
        this.cliente = cliente;
    }


    public BigDecimal getValorDaDivida() {
        return valorDaDivida;
    }

    public void setValorDaDivida(BigDecimal valorDaDivida) {
        this.valorDaDivida = valorDaDivida;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cobranca> getCobrancas() {
        return cobrancas;
    }

    @Override
    public String toString() {
        return "Divida{" +
                "valorDaDivida=" + valorDaDivida + '\'' +
                ", dataDeAbertura=" + dataDeAbertura + '\'' +
                ", dataDeQuitacao=" + dataDeQuitacao + '\'' +
                ", status=" + status + '\'' +
                ", status=" + descricaoDeQuitacao + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
