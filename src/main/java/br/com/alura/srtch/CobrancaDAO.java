package br.com.alura.srtch;

import javax.persistence.EntityManager;
import java.util.List;

public class CobrancaDAO {

    private EntityManager em;

    public CobrancaDAO(EntityManager em) {
        this.em = em;
    }


    public void cadastrar(Cobranca cobranca){
        this.em.persist(cobranca);
    }

    public void atualizar(Cobranca cobranca) {
        this.em.merge(cobranca);
    }

    public void remover(Cobranca cobranca) {
        cobranca = em.merge(cobranca);
        this.em.remove(cobranca);
    }

    public Cobranca buscarPorId(Long id) {
        return em.find(Cobranca.class, id);
    }

    public List<Cobranca> buscarTodos() {
        String jpql = "SELECT c FROM Cobranca c";
        return em.createQuery(jpql, Cobranca.class).getResultList();
    }

    public List<Cobranca> buscarPorTipoDeAcordo(TipoDeAcordoCobranca tipoAcordo) {
        String jpql = "SELECT c FROM Cobranca c WHERE c.tipoDeAcordo = :tipoDeAcordo";
        return em.createQuery(jpql, Cobranca.class)
                .setParameter("tipoDeAcordo", tipoAcordo)
                .getResultList();
    }


    public Long quantidadeDeCobrancas(Long id){
        String jpql = "SELECT COUNT(c) FROM Cobranca c WHERE c.divida.cliente.id = :id";
        return em.createQuery(jpql, Long.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
