package br.com.pessoal.jpa2hibernate.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	//Crio uma entityManager referente ao nome que contem no persistence.xml
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa2hibernate");
	
	
	//Retorna uma EntityManager criada pela nossa instancia da Fábrica.
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
