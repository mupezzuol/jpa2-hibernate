package br.com.pessoal.jpa2hibernate.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.pessoal.jpa2hibernate.util.TipoMovimentacao;

@Entity
public class Movimentacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer Id;
	
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)//Preciso dizer para JPA que ele é um ENUM
	private TipoMovimentacao tipo; 
	
	private LocalDate data;
	
	private String descricao;
	
	@ManyToOne //Muitos PARA Um (cardinalidade). Relacionamento entre as entidades
	private Conta conta;
	
	@ManyToMany //Usamos dessa forma para poder reutilizar uma mesma categoria em uma outra movimentacao
	private List<Categoria> categoria;
	
	
	//Getter's and Setter's
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategorias(List<Categoria> categoria) { 
        this.categoria = categoria;
    }
	
	
}
