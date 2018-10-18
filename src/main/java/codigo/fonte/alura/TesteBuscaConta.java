package codigo.fonte.alura;

import codigo.fonte.alura.Conta;
import codigo.fonte.alura.JPAUtil;

import javax.persistence.EntityManager;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
public class TesteBuscaConta {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = em.find(Conta.class, 1);

        em.getTransaction().commit();
        em.close();
    }

}
