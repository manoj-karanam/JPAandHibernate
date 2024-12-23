package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLOutput;

public class JpaStarterRead {

    public static void main(String[] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        System.out.println("***************** before fetching employee");
        Employee employee = entityManager.find(Employee.class, 1);
        System.out.println("***************** before accessing paystubs");

        System.out.println(employee.getPayStub());

//        PayStub payStub = entityManager.find(PayStub.class, 5);
//        System.out.println(payStub.getEmployee());


    }
}
