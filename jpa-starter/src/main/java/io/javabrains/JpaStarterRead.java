package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLOutput;

public class JpaStarterRead {

    public static void main(String[] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        EmailGroup emailGroup = entityManager.find(EmailGroup.class, 7);

        System.out.println("Got email group, now accessing members");
        System.out.println(emailGroup.getMembers());

//        PayStub payStub = entityManager.find(PayStub.class, 5);
//        System.out.println(payStub.getEmployee());


    }
}
