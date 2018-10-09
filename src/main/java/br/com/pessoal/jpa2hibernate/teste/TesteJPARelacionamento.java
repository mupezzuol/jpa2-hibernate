package br.com.pessoal.jpa2hibernate.teste;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.com.pessoal.jpa2hibernate.model.Conta;
import br.com.pessoal.jpa2hibernate.model.Movimentacao;
import br.com.pessoal.jpa2hibernate.util.JPAUtil;
import br.com.pessoal.jpa2hibernate.util.TipoMovimentacao;

public class TesteJPARelacionamento {
	public static void main(String[] args) {
		
		//Criação da conta
		Conta conta = new Conta();
	    conta.setAgencia("0001");
	    conta.setBanco("Banco Inter");
	    conta.setNumero("1234");
	    conta.setTitular("Pezzuka");
	    //A conta é TRANSIENT preciso transforma-la em MANAGER para persistir a Movimentacao que usa a conta
	    
		
		//Criando uma movimentação e RELACIONANDO a Conta criada
	    Movimentacao movimentacao = new Movimentacao();
	    movimentacao.setData(LocalDate.now());
	    movimentacao.setDescricao("Churrascaria Teste2");
	    movimentacao.setTipo(TipoMovimentacao.SAIDA);
	    movimentacao.setValor(new BigDecimal("240.0"));
		movimentacao.setConta(conta);
		
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(conta);//Preciso persistir a conta para que ela possa existir para não ficar como DETACHED, pois movimentacao usa ela
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
