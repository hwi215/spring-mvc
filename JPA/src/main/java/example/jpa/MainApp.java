package example.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("시작하기");
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("JPAProject");



    }
}
