package br.com.pessoal.jpa2hibernate.teste;

import javax.persistence.EntityManager;

import br.com.pessoal.jpa2hibernate.model.Conta;
import br.com.pessoal.jpa2hibernate.model.Movimentacao;
import br.com.pessoal.jpa2hibernate.util.JPAUtil;

public class TesteMovimentacaoConta {
	
	public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Movimentacao movimentacao = em.find(Movimentacao.class, 3);//Pego a movimentacao de id 3
        Conta conta = movimentacao.getConta();//Pego a conta da movimentacao 3
        
        //Printa os testes
        System.out.println(conta.getTitular()); 
        System.out.println(conta.getMovimentacoes().size());
    }
}
