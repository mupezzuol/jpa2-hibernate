package br.com.pessoal.jpa2hibernate.teste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.pessoal.jpa2hibernate.model.Categoria;
import br.com.pessoal.jpa2hibernate.model.Conta;
import br.com.pessoal.jpa2hibernate.model.Movimentacao;
import br.com.pessoal.jpa2hibernate.util.JPAUtil;
import br.com.pessoal.jpa2hibernate.util.TipoMovimentacao;

public class TesteMovimentacaoComCategoria {

    public static void main(String[] args) { 

        Categoria categoria1 = new Categoria("Viagem");
        Categoria categoria2 = new Categoria("Negócios");

        Conta conta = new Conta();
        conta.setId(2); 
        
        //Preenchendo a movimentacao na conta de id 2
        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setData(LocalDate.now()); // hoje
        movimentacao1.setDescricao("Viagem à SP");
        movimentacao1.setTipo(TipoMovimentacao.SAIDA);
        movimentacao1.setValor(new BigDecimal("100.0"));
        movimentacao1.setCategorias(Arrays.asList(categoria1, categoria2));
        movimentacao1.setConta(conta);

        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setData(LocalDate.now()); // hoje
        movimentacao2.setDescricao("Viagem ao RJ");
        movimentacao2.setTipo(TipoMovimentacao.SAIDA);
        movimentacao2.setValor(new BigDecimal("300.0"));
        movimentacao2.setCategorias(Arrays.asList(categoria1, categoria2));
        movimentacao2.setConta(conta);
        
        
        //Operacoes/transacoes hibernate
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(categoria1); // Agora a 'categoria1' é Managed
        em.persist(categoria2); // Agora a 'categoria2' é Managed

        em.persist(movimentacao1);
        em.persist(movimentacao2);

        em.getTransaction().commit();    
        em.close();    

    }
}
