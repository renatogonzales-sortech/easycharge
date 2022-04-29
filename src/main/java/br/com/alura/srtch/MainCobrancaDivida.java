package br.com.alura.srtch;


import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;

public class MainCobrancaDivida {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        ClienteDAO clienteDao = new ClienteDAO(em);
        DividaDAO dividaDao = new DividaDAO(em);
        EnderecoDAO enderecoDao = new EnderecoDAO(em);
        CobrancaDAO cobrancaDao = new CobrancaDAO(em);


        //preenche os dados do endereco
        Endereco endereco = new Endereco ("916661234",
                "email@email.com",
                "Rua Um",
                "123",
                "Casa",
                "Bairro1",
                "City",
                "EstadoSP");

        System.out.println("Endereço: " + endereco);

        // cadastra o endereço
        em.getTransaction().begin();
        enderecoDao.cadastrar(endereco);
        em.getTransaction().commit();

        // preenche os dados dos clientes
        Cliente cliente1 = new Cliente("Renato","1235","Analista",new BigDecimal(10),StatusCliente.ATIVO,endereco);
        Cliente cliente2 = new Cliente("Daniela","98775","Fisio",new BigDecimal(10),StatusCliente.ATIVO,endereco);


        System.out.println("Cliente1: " + cliente1);
        System.out.println("Cliente2: " + cliente2);

        // cadastra o cliente
        em.getTransaction().begin();
        clienteDao.cadastrar(cliente1);
        clienteDao.cadastrar(cliente2);
        em.getTransaction().commit();

        //preenche os dados das dividas
        Divida divida1 = new Divida(new BigDecimal(10),"Pago",StatusDivida.QUITADA,cliente1);
        Divida divida2 = new Divida(new BigDecimal(10),"Divida Aberta",StatusDivida.ABERTA,cliente2);
        Divida divida3 = new Divida(new BigDecimal(90),"Divida Aberta",StatusDivida.ABERTA,cliente2);

        System.out.println("Divida1: " + divida1);
        System.out.println("Divida2: " + divida2);
        System.out.println("Divida3: " + divida2);

        // cadastra a divida
        em.getTransaction().begin();
        dividaDao.cadastrar(divida1);
        dividaDao.cadastrar(divida2);
        dividaDao.cadastrar(divida3);
        em.getTransaction().commit();


        //atualiza a divida2
        em.getTransaction().begin();
        dividaDao.atualizar(divida2);
        divida2.setStatus(StatusDivida.QUITADA);
        divida2.setDescricaoDeQuitacao("Pago");
        System.out.println("Divida2 Atualizada: " + divida2);
        em.getTransaction().commit();

        em.getTransaction().begin();
        dividaDao.remover(2l);
        em.getTransaction().commit();



        Cobranca cobranca1 = new Cobranca(
                MeioDeContatoCobranca.TELEFONE,
                "Antonietta",
                TipoDeAgenteCobranca.EXTERNO,
                "Sempre Cobrando",
                TipoDeAcordoCobranca.PARCELAMENTO,
                10,
                "Acordado",
                LocalDate.of(2022, 10, 01),
                divida1
                );
        Cobranca cobranca2 = new Cobranca(
                MeioDeContatoCobranca.EMAIL,
                "Renato",
                TipoDeAgenteCobranca.INTERNO,
                "Nem Cobra Nadas",
                TipoDeAcordoCobranca.PROMESSA,
                1,
                "Vou cumprir",
                LocalDate.of(2023, 02, 01),
                divida1
        );
        Cobranca cobranca3 = new Cobranca(
                MeioDeContatoCobranca.EMAIL,
                "Renato",
                TipoDeAgenteCobranca.INTERNO,
                "Nem Cobra Nadas",
                TipoDeAcordoCobranca.PROMESSA,
                1,
                "Vou cumprir",
                LocalDate.of(2023, 02, 01),
                divida3
        );

        System.out.println(cobranca1);
        System.out.println(cobranca2);
        System.out.println(cobranca3);

        // cadastra as cobranças
        em.getTransaction().begin();
        cobrancaDao.cadastrar(cobranca1);
        cobrancaDao.cadastrar(cobranca2);
        cobrancaDao.cadastrar(cobranca3);
        em.getTransaction().commit();

        //System.out.println(dividaDao.somaDividaCliente(1l));

        //System.out.println(dividaDao.buscarDividasSemCobranca());

        System.out.println(cobrancaDao.buscarPorTipoDeAcordo(TipoDeAcordoCobranca.PARCELAMENTO));

        System.out.println("Quantidade de Cobrança do Cliente: " + cobrancaDao.quantidadeDeCobrancas(1l));

        //System.out.println(dividaDao.relatorioCliente());
        }

}
