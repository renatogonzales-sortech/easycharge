package br.com.alura.srtch;

public class RelatorioCliente {

    String nomeCliente;
    Long dividaCliente;
    Integer numeroTotalDivida;

    public RelatorioCliente(String nomeCliente, Long dividaCliente, Integer numeroTotalDivida) {
        this.nomeCliente = nomeCliente;
        this.dividaCliente = dividaCliente;
        this.numeroTotalDivida = numeroTotalDivida;
    }

    @Override
    public String toString() {
        return "RelatorioCliente [nomeCliente=" + nomeCliente + ", dividaCliente=" + dividaCliente
                + ", numeroTotalDivida=" + numeroTotalDivida + "]";
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public Long getDividaCliente() {
        return dividaCliente;
    }

    public Integer getNumeroTotalDivida() {
        return numeroTotalDivida;
    }
}
