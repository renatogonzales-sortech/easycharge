package br.com.alura.srtch.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "cobranca")
public class Cobranca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=10)
    private long id;

    @Column(nullable=false)
    private LocalDate dataDeRealizacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private MeioDeContatoCobranca meioDeContato;

    @Column(nullable=false, length=50)
    private String agente;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private TipoDeAgenteCobranca tipoDeAgente;

    @Column(nullable=false, length=500)
    private String comentarioDoAgente;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private TipoDeAcordoCobranca tipoDeAcordo;

    @Column(length=500, nullable=false)
    private String acordo;

    private LocalDate dataDePromessaDePagamento;

    private Integer numeroDeParcelas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Divida divida;

    public Cobranca() {
    }

    public Cobranca(MeioDeContatoCobranca meioDeContato, String agente, TipoDeAgenteCobranca tipoDeAgente, String comentarioDoAgente, TipoDeAcordoCobranca tipoDeAcordo, String acordo, Divida divida) {
        this.dataDeRealizacao = LocalDate.now();
        this.meioDeContato = meioDeContato;
        this.agente = agente;
        this.tipoDeAgente = tipoDeAgente;
        this.comentarioDoAgente = comentarioDoAgente;
        this.tipoDeAcordo = tipoDeAcordo;
        this.acordo = acordo;
        this.divida = divida;
    }

    public LocalDate getDataDeRealizacao() {
        return dataDeRealizacao;
    }

    public void setDataDeRealizacao(LocalDate dataDeRealizacao) {
        this.dataDeRealizacao = dataDeRealizacao;
    }

    public MeioDeContatoCobranca getMeioDeContato() {
        return meioDeContato;
    }

    public void setMeioDeContato(MeioDeContatoCobranca meioDeContato) {
        this.meioDeContato = meioDeContato;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public TipoDeAgenteCobranca getTipoDeAgente() {
        return tipoDeAgente;
    }

    public void setTipoDeAgente(TipoDeAgenteCobranca tipoDeAgente) {
        this.tipoDeAgente = tipoDeAgente;
    }

    public String getComentarioDoAgente() {
        return comentarioDoAgente;
    }

    public void setComentarioDoAgente(String comentarioDoAgente) {
        this.comentarioDoAgente = comentarioDoAgente;
    }

    public String getAcordo() {
        return acordo;
    }

    public void setAcordo(String acordo) {
        this.acordo = acordo;
    }

    public TipoDeAcordoCobranca getTipoDeAcordo() {
        return tipoDeAcordo;
    }

    public void setTipoDeAcordo(TipoDeAcordoCobranca tipoDeAcordo) {
        this.tipoDeAcordo = tipoDeAcordo;
    }

    public LocalDate getDataDePromessaDePagamento() {
        return dataDePromessaDePagamento;
    }

    public void setDataDePromessaDePagamento(LocalDate dataDePromessaDePagamento) {
        this.dataDePromessaDePagamento = dataDePromessaDePagamento;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Divida getDivida() {
        return divida;
    }

    public void setDivida(Divida divida) {
        this.divida = divida;
    }

    @Override
    public String toString() {
        return "Cobranca{" +
                "dataDeRealizacao=" + dataDeRealizacao +
                ", meioDeContato=" + meioDeContato +
                ", agente='" + agente + '\'' +
                ", tipoDeAgente=" + tipoDeAgente +
                ", comentarioDoAgente='" + comentarioDoAgente + '\'' +
                ", tipoDeAcordo=" + tipoDeAcordo +
                ", acordo='" + acordo + '\'' +
                ", divida=" + divida +
                '}';
    }
}
