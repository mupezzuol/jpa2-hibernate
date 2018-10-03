package br.com.pessoal.jpa2hibernate.teste;

import javax.persistence.EntityManager;

import br.com.pessoal.jpa2hibernate.model.Conta;
import br.com.pessoal.jpa2hibernate.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String args[]) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();//Abro minha transação
		
		//Método find. Onde procura por ID
		//O método FIND retorna nosso objeto Conta no estado MANAGED
		// Managed = É um estado da JPA/Entidade que faz automáticamente com que ela sincronize com os dados do banco de dados automaticamente
		// Ou seja, qnd temos entidade com estado de MANAGED qnd quisermos fazer alterações direto no banco ele fará o UPDATE automaticamente
		Conta conta = em.find(Conta.class, 8);//Recebe o valor que virá do banco na consulta
		
		
		//Ele altera no banco essa alteração também
		conta.setTitular("Nome Alterado");//Ele verifica que o 'nome alterado' existe portanto mantém
		conta.setAgencia("7864");//Ele verifica que essa agencia está diferente, como a conta está em estado MANAGED ele altera automaticamente
		
		
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		em.close();
	}
	
	
}
