package br.com.pessoal.jpa2hibernate.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pessoal.jpa2hibernate.model.Conta;
import br.com.pessoal.jpa2hibernate.model.Movimentacao;
import br.com.pessoal.jpa2hibernate.util.JPAUtil;
import br.com.pessoal.jpa2hibernate.util.TipoMovimentacao;

public class TesteJPQL2 {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		//Criando uma conta
		Conta conta = new Conta();
	    conta.setId(4);//Se estamos setando quer dizer que ela já foi um dia DETACHED
	    
		//Utilizando NamedParameter para passarmos parametros para nossa query
	    //Nós usamos ':' dois pontos para mostrar que será um parametro e por convencao usamos sempre um 'p' para facilitar o entendimento
	    //Na query nós setamos o Parametros jogando o alias dele na query seguida do valor daquele parametro
		String jpql = "select m from Movimentacao m where m.conta = :pConta" +
	    " and m.tipo = :pTipoMovimentacao" +
	    " order by m.valor desc";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);//Nome do parametro + valor do parametro
		query.setParameter("pTipoMovimentacao", TipoMovimentacao.SAIDA);
		
		
		List<Movimentacao> resultados = query.getResultList();//Retorna uma lista do banco
		for (Movimentacao m : resultados) {
			System.out.println("Descrição: " + m.getDescricao());
			System.out.println("Conta.id: " + m.getConta().getId());
		}
		em.getTransaction().commit();
		em.close();
	}

}
