package utils;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by yurii on 23.04.17.
 */
@Component
public class MyConectionToDB {

    public static EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("appDB");
        return entityManagerFactory.createEntityManager();
    }
}
