package br.com.pessoal.jpa2hibernate.teste;

import javax.persistence.EntityManager;

import br.com.pessoal.jpa2hibernate.model.Cliente;
import br.com.pessoal.jpa2hibernate.model.Conta;
import br.com.pessoal.jpa2hibernate.util.JPAUtil;

public class TesteContaCliente {
	
	public static void main (String args[]) {
		
		Cliente cliente = new Cliente();
        cliente.setNome("Murillo");
        cliente.setEndereco("Rua Ciclano, 123");
        cliente.setProfissao("Jogador");
		
        Cliente cliente2 = new Cliente();
        cliente2.setNome("Murillo");
        cliente2.setEndereco("Rua Ciclano, 123");
        cliente2.setProfissao("Jogador");
        
        
        Conta conta = new Conta();
        conta.setId(2);//Se possui ID é pq essa conta já foi DETACHED, ou seja, já foi um dia gerenciada (MANAGED)

        cliente.setConta(conta);
       // cliente2.setConta(conta);
        
        //Passos do HIBERNATE
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        em.persist(cliente);
        
        em.getTransaction().commit();
        em.close();
        
        
	}
}
