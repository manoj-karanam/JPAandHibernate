package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaStarterMain {
    public static void main(String[] args) {

        //updating a field
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = entityManager.find(Employee.class, 1);


        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(employee);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();




//
//        Employee employee = new Employee();
////        employee.setId(1);
//        employee.setName("Foo Bar");
//        employee.setSsn("123");
//        employee.setDob(new Date());
//        employee.setAge(20);
//        employee.setType(EmployeeType.CONTRACTOR);
//
//        Employee employee2 = new Employee();
////        employee2.setId(2);
//        employee2.setName("Bar bazzzz");
//        employee2.setSsn("456");
//        employee2.setDob(new Date());
//        employee2.setAge(30);
//        employee2.setType(EmployeeType.FULL_TIME);
//
//
//
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        EntityTransaction transaction =  entityManager.getTransaction();
//        transaction.begin();
//        entityManager.persist(employee);
//        entityManager.persist(employee2);
//
//        transaction.commit();
//        entityManager.close();
//        entityManagerFactory.close();

    }
}