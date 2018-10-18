package codigo.fonte.alura;

import codigo.fonte.alura.Conta;
import codigo.fonte.alura.Movimentacao;
import codigo.fonte.alura.TipoMovimentacao;
import codigo.fonte.alura.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
public class TesteJPQL {

    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(1);

        Query query = manager
                .createQuery("select m from Movimentacao m where m.conta=:pConta "
                           + "and m.tipo = :pTipo order by m.valor desc");

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.ENTRADA);

        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao m : movimentacoes) {
            System.out.println("Descricao: " + m.getDescricao());
            System.out.println("Conta.id:" + m.getValor());
        }
    }


}
