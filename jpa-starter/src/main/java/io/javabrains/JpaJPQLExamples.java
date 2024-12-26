package io.javabrains;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class JpaJPQLExamples {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<String> query = entityManager.createQuery("select e.name from Employee e ", String.class);
        List<String> resultList = query.getResultList();
        resultList.forEach(System.out::println);

        entityManager.close();
        entityManagerFactory.close();

    }
}