package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaStarterWrite {
    public static void main(String[] args) {

        AccessCard card1 = new AccessCard();
        AccessCard card2 = new AccessCard();
        card1.setIssueDate(new Date());
        card1.setActive(true);
        card1.setFirmwareVersion("1.0.0");


        card2.setIssueDate(new Date());
        card2.setActive(false);
        card2.setFirmwareVersion("1.2.0");

        Employee employee = new Employee();

//        employee.setId(1);
        employee.setName("Foo Bar");
        employee.setSsn("123");
        employee.setDob(new Date());
        employee.setAge(20);
        employee.setCard(card1);
        employee.setType(EmployeeType.CONTRACTOR);

        Employee employee2 = new Employee();
//        employee2.setId(2);
        employee2.setName("Bar bazzzz");
        employee2.setSsn("456");
        employee2.setDob(new Date());
        employee2.setAge(30);
        employee2.setCard(card2);
        employee2.setType(EmployeeType.FULL_TIME);

        card1.setOwner(employee);
        card2.setOwner(employee2);

        PayStub payStub1 = new PayStub();
        payStub1.setPayPeriodStart(new Date());
        payStub1.setPayPeriodEnd(new Date());
        payStub1.setSalary(1000);

        PayStub payStub2 = new PayStub();
        payStub2.setPayPeriodStart(new Date());
        payStub2.setPayPeriodEnd(new Date());
        payStub2.setSalary(2000);


        payStub1.setEmployee(employee);
        payStub2.setEmployee(employee);


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction =  entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        entityManager.persist(employee2);
        entityManager.persist(card1);
        entityManager.persist(card2);
        entityManager.persist(payStub1);
        entityManager.persist(payStub2);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}