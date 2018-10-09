package br.com.pessoal.jpa2hibernate.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pessoal.jpa2hibernate.model.Movimentacao;
import br.com.pessoal.jpa2hibernate.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		//Vou selecionar MOVIMENTACOES quando a conta for igual a 1
		//Repare que usamos na clausula WHERE a relacao que temos na nossa classe, ou seja (movimentacao.conta.id) da mesma forma que mapeamos
		//no hibernate em nossas classes
		String jpql = "select m from Movimentacao m where m.conta.id = 2";
		Query query = em.createQuery(jpql);
		
		List<Movimentacao> resultados = query.getResultList();//Retorna uma lista do banco
		for (Movimentacao m : resultados) {
			System.out.println("Descrição: " + m.getDescricao());
			System.out.println("Conta.id: " + m.getConta().getId());
		}
		
		
		em.getTransaction().commit();
		em.close();
		
		
	}

}
