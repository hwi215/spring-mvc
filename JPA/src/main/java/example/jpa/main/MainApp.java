package example.jpa.main;

import example.jpa.domain.Customer;
import example.jpa.domain.Member;
import example.jpa.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("시작하기");
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("JPAProject");

        //EntityManager em = emf.createEntityManager();
        //EntityTransaction ex = em.getTransaction();

        EntityManager em = emf.createEntityManager();
        EntityTransaction ex = em.getTransaction();
        ex.begin(); // 트랜잭션 시작


        // 팀등록

        Team team1 = new Team(null, "team01");
        Team team2 = new Team(null, "team02");
        Team team3 = new Team(null, "team03");
        Team team4 = new Team(null, "team04");

        em.persist(team1);
        em.persist(team2);
        em.persist(team3);
        em.persist(team4);

        // 멤버 등록
        em.persist(Member.builder().name("hwi").age(20).team(team1).build());
        em.persist(Member.builder().name("미나").age(60).team(team2).build());
        em.persist(Member.builder().name("민석").age(20).team(team3).build());
        em.persist(Member.builder().name("미유").age(20).team(team4).build());


        // 회원 검색
        //em.find(Member.class, 3L);


        // 다양한 조건에 해당하는 검색
        /**
         * 직접 쿼리를 만들때 객체 중심으로 쿼리를 작성할 수 있다 - JPQL 문접 제공
         *  1. 이름이 'hwi'인 정보 검색
         */
        /*
        String sql = "select c from Customer c where c.userName = 'hwi'";

        List<Customer> list = em.createQuery(sql, Customer.class).getResultList();

        for(Customer li : list){
            System.out.println(li);
        }

         */

        /**
         * 2. parameter 정보를 조건으로 사용하기 - :name(:속성명)
         */

        /*
        String sql = "select c from Customer c where c.userName like :name";

        List<Customer> list =
                em.createQuery(sql, Customer.class)
                        .setParameter("name", "%hwi%").getResultList();

        for(Customer li : list){
            System.out.println(li);
        }

         */

        /**
         * 3. parameter 정보 2개를 조건으로 사용하기 - ?1(첫번째 parameter), ?2
         */
/*
        String sql = "select c from Customer c where c.userName like ?1 or c.age > ?2";

        List<Customer> list =
                em.createQuery(sql, Customer.class)
                        .setParameter(1, "%hwi%")
                        .setParameter(2, 20)
                        .getResultList();

        for(Customer li : list){
            System.out.println(li);
        }

 */

/*
        // 등록
        em.persist(Customer.builder().age(25).userName("hwi").birthDay(new Date()).build());
        em.persist(Customer.builder().age(10).userName("hwi2").birthDay(new Date()).build());
        em.persist(Customer.builder().age(20).userName("hwi3").birthDay(new Date()).build());
        em.persist(Customer.builder().age(45).userName("hwi4").birthDay(new Date()).build());
        em.persist(Customer.builder().age(75).userName("hwi5").birthDay(new Date()).build());





        // 조회
        Customer cu = em.find(Customer.class, 3L);
        System.out.println("cu = " + cu);

        // 수정
        cu.setAge(50);

        // 삭제
        em.remove(cu);
*/

        /**
         * ======================
         */

        // 회원 검색

        Member m = em.find(Member.class, 3L);

        System.out.println(m.toString());

        ex.commit();
        em.close();




    }
}
