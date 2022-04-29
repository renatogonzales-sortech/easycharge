package br.com.alura.srtch;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class DividaDAO {

    private EntityManager em;

    public DividaDAO(EntityManager em) {
        this.em = em;
    }



    public void cadastrar(Divida divida){
        this.em.persist(divida);
    }

    public void atualizar(Divida divida) {
        this.em.merge(divida);
    }

    public void remover(Long id) {
        Divida divida = em.find(Divida.class, id);
        this.em.remove(divida);
    }

    public Divida buscarPorId(Long id) {
        return em.find(Divida.class, id);
    }

    public List<Divida> buscarTodos() {
        String jpql = "SELECT d FROM Divida d";
        return em.createQuery(jpql, Divida.class).getResultList();
    }

    public Divida somaDividaCliente(long id) {
        return em.createQuery("SELECT SUM(d.valorDaDivida) FROM Divida d JOIN d.cliente WHERE d.id = :id", Divida.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public BigDecimal valorTotalVendido() {
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return em.createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }

    public List<Divida> buscarDividasSemCobranca() {
        String jpql = "SELECT d FROM Divida d WHERE d.cobrancas is EMPTY";
        return em.createQuery(jpql, Divida.class)
                .getResultList();
    }

    public Divida buscarDividaPorCliente(Long id) {
        return em.createQuery("SELECT d FROM Divida d JOIN FETCH d.cliente WHERE d.id = :id", Divida.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<RelatorioCliente> relatorioCliente() {
        String jpql = "SELECT new br.com.alura.srtch.RelatorioCliente("
                + "cliente.nome, "
                + "SUM(divida.valorDaDivida), "
                //+ "COUNT(cobranca.id)) "S
                + "1"
                + "FROM Cliente cliente "
                + "JOIN Divida divida "
                + "GROUP BY cliente.nome ";
        return em.createQuery(jpql, RelatorioCliente.class)
                .getResultList();
    }
}
