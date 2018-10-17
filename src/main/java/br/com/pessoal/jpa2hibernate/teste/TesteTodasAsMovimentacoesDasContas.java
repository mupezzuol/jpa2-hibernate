package br.com.pessoal.jpa2hibernate.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pessoal.jpa2hibernate.model.Conta;
import br.com.pessoal.jpa2hibernate.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {
	
	public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        //JOIN FETCH -> para usarmos EAGER LOADING e fazer um Select só já trazendo as movimentacoes
        //A query que ele executará será como se fosse um INNER JOIN
        //JOIN FETCH -> Hibernate coloca automaticamente o INNER JOIN
        //LEFT JOIN -> Trazer tudo que está do lado ESQUERDO do JOIN, ou seja as Contas
        String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";

        Query query = em.createQuery(jpql);//Cria a query

        List<Conta> todasAsContas = query.getResultList();//Retorno da nossa query em lista

        for (Conta conta : todasAsContas) {
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Movimentacoes: ");
            System.out.println(conta.getMovimentacoes().toString());//Por padrão usa LAZY, porém usamos o JOIN FETCH (Eager Loading)
        }
    }
}
