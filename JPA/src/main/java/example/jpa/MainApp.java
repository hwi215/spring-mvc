package example.jpa;

import example.jpa.domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("시작하기");
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("JPAProject");

        EntityManager em = emf.createEntityManager();
        EntityTransaction ex = em.getTransaction();

        ex.begin();
        // 등록

        /*
        em.persist(Customer.builder().age(25).userName("hwi").birthDay(new Date()).build());
        em.persist(Customer.builder().age(10).userName("hwi2").birthDay(new Date()).build());
        em.persist(Customer.builder().age(20).userName("hwi3").birthDay(new Date()).build());
        em.persist(Customer.builder().age(45).userName("hwi4").birthDay(new Date()).build());
        em.persist(Customer.builder().age(75).userName("hwi5").birthDay(new Date()).build());

         */

        // 조회
        Customer cu = em.find(Customer.class, 3L);
        System.out.println("cu = " + cu);




        ex.commit();
        em.close();


    }
}
