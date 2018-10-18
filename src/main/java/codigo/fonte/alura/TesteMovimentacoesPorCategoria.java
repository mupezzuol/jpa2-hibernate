package codigo.fonte.alura;

import codigo.fonte.alura.Categoria;
import codigo.fonte.alura.Movimentacao;
import codigo.fonte.alura.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
public class TesteMovimentacoesPorCategoria {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        Categoria categoria = new Categoria();
        categoria.setId(1);

        Query query = manager
                .createQuery("select m from Movimentacao m join m.categoria c where c = :pCategoria");

        query.setParameter("pCategoria", categoria);

        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao m : movimentacoes) {
            System.out.println("\nDescricao ..: " + m.getDescricao());
            System.out.println("Valor ......: R$ " + m.getValor());
        }

    }
}
