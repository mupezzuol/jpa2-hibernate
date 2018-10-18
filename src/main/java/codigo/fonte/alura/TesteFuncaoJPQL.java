package codigo.fonte.alura;

import codigo.fonte.alura.Conta;
import codigo.fonte.alura.TipoMovimentacao;
import codigo.fonte.alura.MovimentacaoDao;
import codigo.fonte.alura.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
public class TesteFuncaoJPQL {
    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(3);

        TypedQuery<Double> query = manager.createNamedQuery("MediasPorDiaETipo", Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Double> medias = query.getResultList();

        for (Double media : medias) {
            System.out.println("A média é: " + media);
        }

    }

}

