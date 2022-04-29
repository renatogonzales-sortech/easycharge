package br.com.alura.srtch;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cobranca")
public class Cobranca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private LocalDate dataDeRealizacao  = LocalDate.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private MeioDeContatoCobranca meioDeContato;

    @Column(nullable=false, length=100)
    private String agente;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private TipoDeAgenteCobranca tipoDeAgente;

    @Column(nullable=false, length=500)
    private String comentarioDoAgente;

    @Column(nullable=false, length=500)
    private String acordo;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private TipoDeAcordoCobranca tipoDeAcordo;

    private LocalDate dataDePromessaDePagamento;

    @Column(nullable=false)
    private Integer numeroDeParcelas = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Divida divida;

    public Divida getDivida() {
        return divida;
    }

    public Cobranca (MeioDeContatoCobranca meioDeContato, String agente, TipoDeAgenteCobranca tipoDeAgente, String comentarioDoAgente, TipoDeAcordoCobranca tipoDeAcordo, Integer numeroDeParcelas,String acordo,LocalDate dataDePromessaDePagamento, Divida divida) {
        this.dataDeRealizacao = LocalDate.now();
        this.meioDeContato = meioDeContato;
        this.agente = agente;
        this.tipoDeAgente = tipoDeAgente;
        this.comentarioDoAgente = comentarioDoAgente;
        this.tipoDeAcordo = tipoDeAcordo;
        this.numeroDeParcelas = numeroDeParcelas;
        this.acordo = acordo;
        this.dataDePromessaDePagamento = dataDePromessaDePagamento;
        this.divida = divida;
    }


    public Cobranca() {
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

    public LocalDate getDatDePromessaDePagamento() {
        return dataDePromessaDePagamento;
    }

    public void setDatDePromessaDePagamento(LocalDate datDePromessaDePagamento) {
        this.dataDePromessaDePagamento = datDePromessaDePagamento;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public void setDivida(Divida divida) {
        this.divida = divida;
    }

    @Override
    public String toString() {
        return "Cobranca{" +
                "dataDeRealizacao='" + dataDeRealizacao + '\'' +
                ", meioDeContato='" + meioDeContato + '\'' +
                ", agente='" + agente + '\'' +
                ", tipoDeAgente='" + tipoDeAgente + '\'' +
                ", comentarioDoAgente='" + comentarioDoAgente + '\'' +
                ", acordo='" + acordo + '\'' +
                ", tipoDeAcordo='" + tipoDeAcordo + '\'' +
                ", dataDePromessaDePagamento='" + dataDePromessaDePagamento + '\'' +
                ", numeroDeParcelas='" + numeroDeParcelas + '\'' +
                ", divida='" + getDivida().getValorDaDivida() +
                '}';
    }


}
