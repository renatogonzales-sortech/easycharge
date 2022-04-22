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

    public Cliente buscarPorId(Long id) {
        return em.find(Cliente.class, id);
    }

}
