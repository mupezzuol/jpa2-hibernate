package br.com.pessoal.jpa2hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String nome;
	
	
	//Constructors
	@Deprecated //Indica que não é para ser utilizado esse construtor. Somente o Hibernate q irá utilizar
	public Categoria() {}
	
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}
	
	//Getter's and Setter's
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	
}
