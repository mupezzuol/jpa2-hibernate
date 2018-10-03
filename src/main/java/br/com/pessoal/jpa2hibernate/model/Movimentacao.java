package br.com.pessoal.jpa2hibernate.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.pessoal.jpa2hibernate.util.TipoMovimentacao;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode @ToString
public class Movimentacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer Id;
	
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)//Preciso dizer para JPA que ele é um ENUM
	private TipoMovimentacao tipo; 
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDate data;
	
	private String descricao;
	
	@ManyToOne //Muitos PARA Um (cardinalidade). Relacionamento entre as entidades
	private Conta conta;
}
