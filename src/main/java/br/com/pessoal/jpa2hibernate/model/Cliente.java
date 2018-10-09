package br.com.pessoal.jpa2hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String nome;
	private String profissao;
	private String endereco;
	
	@JoinColumn(unique=true)//Faz com que essa conta seja somente desse CLIENTE. Porém ele só funciona na hora da criação do esquema, Ficar atento.
	@OneToOne //Porém dependendo da sua regra de negocio ele pode ter várias contas, e essas contas pertence a 1 cliente
	private Conta conta;
	
	
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
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
}
