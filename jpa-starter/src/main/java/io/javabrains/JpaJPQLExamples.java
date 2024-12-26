package io.javabrains;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class JpaJPQLExamples {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        int minAge = 25;
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.age>:minAge ", Employee.class);
        query.setParameter("minAge",minAge);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(System.out::println);

        entityManager.close();
        entityManagerFactory.close();

    }
}