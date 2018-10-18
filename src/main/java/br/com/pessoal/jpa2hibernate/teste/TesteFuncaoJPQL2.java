package br.com.pessoal.jpa2hibernate.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.pessoal.jpa2hibernate.model.Conta;
import br.com.pessoal.jpa2hibernate.util.JPAUtil;
import br.com.pessoal.jpa2hibernate.util.TipoMovimentacao;

public class TesteFuncaoJPQL2 {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		//Criando uma conta
		Conta conta = new Conta();
	    conta.setId(4);//Se estamos setando quer dizer que ela já foi um dia DETACHED
	    
	    //Estou retornando a SOMA dos valores das movimentacoes
	    //SUM -> Retorna a soma
	    //AVG -> Retorna a média dos valores (função AVG trabalha com Double)
		String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" +
	    " and m.tipo = :pTipoMovimentacao" +
		" group by day(m.data), month(m.data), year(m.data)";		
		
		//Eu forço minha tipagem dizendo que o retorno dessa query será DOUBLE
		TypedQuery<Double> query = em.createQuery(jpql, Double.class); 
		query.setParameter("pConta", conta);
		query.setParameter("pTipoMovimentacao", TipoMovimentacao.SAIDA);
		
		//Não precisamos dizer que o ResultList retorna um Double etc.. Já declaramos usando TypedQuery
		List<Double> medias = query.getResultList();
		System.out.println("A média do dia X é: " + medias.get(0));
		System.out.println("A média do dia X é: " + medias.get(1));
		
		
		em.getTransaction().commit();
		em.close();
	}
}
