package br.com.pessoal.jpa2hibernate.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pessoal.jpa2hibernate.model.Conta;
import br.com.pessoal.jpa2hibernate.util.JPAUtil;
import br.com.pessoal.jpa2hibernate.util.TipoMovimentacao;

public class TesteFuncaoJPQL {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		//Criando uma conta
		Conta conta = new Conta();
	    conta.setId(4);//Se estamos setando quer dizer que ela já foi um dia DETACHED
	    
	    //Estou retornando a SOMA dos valores das movimentacoes
	    //SUM -> Retorna a soma
	    //AVG -> Retorna a média dos valores (função AVG trabalha com Double)
		String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :pConta" +
	    " and m.tipo = :pTipoMovimentacao" +
	    " order by m.valor desc";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);//Nome do parametro + valor do parametro
		query.setParameter("pTipoMovimentacao", TipoMovimentacao.SAIDA);
		
		BigDecimal soma = (BigDecimal) query.getSingleResult();
		System.out.println("A soma é: " + soma);
		
		
		em.getTransaction().commit();
		em.close();
	}
}
