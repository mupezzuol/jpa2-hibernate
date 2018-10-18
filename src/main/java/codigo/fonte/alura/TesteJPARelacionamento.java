package codigo.fonte.alura;

import codigo.fonte.alura.Conta;
import codigo.fonte.alura.Movimentacao;
import codigo.fonte.alura.TipoMovimentacao;
import codigo.fonte.alura.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
public class TesteJPARelacionamento {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setAgencia("111");
        conta.setBanco("Itau");
        conta.setNumero("54321");
        conta.setTitular("Leonardo");

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Churrascaria");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("200.0"));

        movimentacao.setConta(conta);

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();

        manager.persist(conta);
        manager.persist(movimentacao);

        manager.getTransaction().commit();
        manager.close();

    }

}
