package br.com.alura.srtch;


import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDAO {

    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public List<Cliente> buscarTodos() {
        String jpql = "SELECT p FROM Cliente p";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public void cadastrar(Cliente cliente){
        this.em.persist(cliente);
    }

    public void atualizar(Cliente cliente) {
        this.em.merge(cliente);
    }

    public void remover(Cliente cliente) {
        cliente = em.merge(cliente);
        this.em.remove(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return em.find(Cliente.class, id);
    }

    public List<Cliente> buscarPorStatus(StatusCliente status) {
        String jpql = "SELECT p FROM Cliente p WHERE p.status = :status";
        return em.createQuery(jpql, Cliente.class)
                .setParameter("status", status)
                .getResultList();
    }

    public List<Cliente> buscarPorNomeCliente(String nome) {
        String jpql = "SELECT p FROM Cliente p WHERE p.nome = :nome";
        return em.createQuery(jpql, Cliente.class)
                .setParameter("nome", nome)
                .getResultList();
    }
}
