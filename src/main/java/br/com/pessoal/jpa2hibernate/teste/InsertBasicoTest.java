package br.com.pessoal.jpa2hibernate.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pessoal.jpa2hibernate.model.Conta;

public class InsertBasicoTest {

	public static void main(String[] args) {
		
		Conta objConta = new Conta();
		//objConta.setId(1); -- Seta sozinho Hibernate
		objConta.setTitular("Murillo Pezzuol");
		objConta.setAgencia("1234");
		objConta.setBanco("Santander");
		objConta.setNumero("543897");
		
		
		//Classe Persistence representa nosso arquivo 'Persistence.xml' onde temos:
		//<persistence-unit name="jpa2-hibernate"> que foi passado como param do método
		//Criando instancia da Fábrica para nossa entidade
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa2hibernate");
		
		//Para realizar as operações precisamos de um EntityManager, nele pegamos o Factory criado das config do 'persistence.xml'
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();//Abre a transação
		em.persist(objConta);//Realiza a operação necessária
		em.getTransaction().commit();//Fecha a transação 
		
		em.close();
		emf.close();

	}

}
