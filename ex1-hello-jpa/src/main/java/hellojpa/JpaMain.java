package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜젝션 시작

        try {

            //영속
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            em.clear();

            System.out.println("=========================");
            tx.commit(); // 트랜젝션 커밋
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
