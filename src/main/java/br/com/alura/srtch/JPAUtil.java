package br.com.alura.srtch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("easy-charge");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

}
