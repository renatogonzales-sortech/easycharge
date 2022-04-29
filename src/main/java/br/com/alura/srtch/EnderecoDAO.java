package br.com.alura.srtch;

import javax.persistence.EntityManager;

public class EnderecoDAO {
    private EntityManager em;

    public EnderecoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Endereco endereco){
        this.em.persist(endereco);
    }

    public void atualizar(Endereco endereco) {
        this.em.merge(endereco);
    }

    public void remover(Endereco endereco) {
        endereco = em.merge(endereco);
        this.em.remove(endereco);
    }
}
