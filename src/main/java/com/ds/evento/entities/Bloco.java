package com.ds.evento.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_bloco")
@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Bloco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	@Setter
	private Date inicio;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	@Setter
	private Date fim;
	
	@ManyToOne
	@JoinColumn(name = "atividade_id")
	private Atividade atividade;
	
	public Bloco() {
	}
	
}
