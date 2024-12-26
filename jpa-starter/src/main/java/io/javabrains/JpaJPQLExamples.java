package io.javabrains;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class JpaJPQLExamples {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Object[]> query = entityManager.createQuery("select e.name, e.card.id from Employee e ", Object[].class);
        List<Object[]> resultList = query.getResultList();
        resultList.forEach(e -> System.out.println(e[0]+ " "+e[1]));

        entityManager.close();
        entityManagerFactory.close();

    }
}