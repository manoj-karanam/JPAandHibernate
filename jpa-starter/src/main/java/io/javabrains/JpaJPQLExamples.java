package io.javabrains;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class JpaJPQLExamples {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.card.isActive=true", Employee.class);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(System.out::println);

        entityManager.close();
        entityManagerFactory.close();

    }
}