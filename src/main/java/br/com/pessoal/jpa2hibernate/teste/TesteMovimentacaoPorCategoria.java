package br.com.pessoal.jpa2hibernate.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pessoal.jpa2hibernate.model.Categoria;
import br.com.pessoal.jpa2hibernate.model.Movimentacao;
import br.com.pessoal.jpa2hibernate.util.JPAUtil;

public class TesteMovimentacaoPorCategoria{

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		//Criando uma conta
		Categoria categoria = new Categoria();
		categoria.setId(15);//Se estamos setando quer dizer que ela já foi um dia DETACHED
	    
		//Repare que o JOIN que é uma outra tabela, na verdade é um ATRIBUTO da classe Movimentacao que o hibernate cria outra tabela
		String jpql = "select m from Movimentacao m" +
	    " join m.categoria c" +
		" where c = :pCategoria";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> resultados = query.getResultList();//Retorna uma lista do banco
		for (Movimentacao m : resultados) {
			System.out.println("Descrição: " + m.getDescricao());
			System.out.println("Conta.id: " + m.getConta().getId());
		}
		em.getTransaction().commit();
		em.close();
	}

}
