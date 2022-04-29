package br.com.alura.srtch;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvRecurse;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @CsvBindByName
  private String nome;

  @CsvBindByName
  private String cpf;



  @CsvBindByName
  private String profissao;

  @CsvBindByName
  private BigDecimal renda;

  @CsvBindByName
  private StatusCliente status;



  @CsvRecurse
  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "endereco", referencedColumnName = "id_endereco")
  private Endereco endereco;


  public Endereco getEndereco() {
    return endereco;
  }
  public Cliente() {

  }

  public Cliente( String nome, String cpf, String profissao, BigDecimal renda,
                  StatusCliente status, Endereco endereco) {

    this.nome = nome;
    this.cpf = cpf;
    this.profissao = profissao;
    this.renda = renda;
    this.status = status;
    this.endereco = endereco;
  }



  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }



  public String getProfissao() {
    return profissao;
  }

  public void setProfissao(String profissao) {
    this.profissao = profissao;
  }

  public BigDecimal getRenda() {
    return renda;
  }

  public void setRenda(BigDecimal renda) {
    this.renda = renda;
  }

  public StatusCliente getStatus() {
    return status;
  }

  public void setStatus(StatusCliente status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Cliente{" +
        "nome='" + nome + '\'' +
        ", cpf='" + cpf + '\'' +
        ", telefone='" + getEndereco().getTelefone() + '\'' +
        ", email='" + getEndereco().getEmail() + '\'' +
        ", rua='" + getEndereco().getRua() + '\'' +
        ", numero='" + getEndereco().getNumero() + '\'' +
        ", complemento='" + getEndereco().getComplemento() + '\'' +
        ", bairro='" + getEndereco().getBairro() + '\'' +
        ", cidade='" + getEndereco().getCidade() + '\'' +
        ", estado='" + getEndereco().getEstado() + '\'' +
        ", profissao='" + profissao + '\'' +
        ", renda=" + renda + '\'' +
        ", status=" + status +
        '}';
  }
}
