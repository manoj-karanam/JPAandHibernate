package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterMain {
    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Foo Bar");
        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("Bar bazzzz");
        Employee employee3 = new Employee();
        employee3.setId(3);
        employee3.setName("Choco pie");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction =  entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        entityManager.persist(employee2);
        entityManager.persist(employee3);
        transaction.commit();

    }
}