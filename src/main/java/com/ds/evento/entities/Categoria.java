package com.ds.evento.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_categoria")
@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Setter
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	@OneToMany(mappedBy = "categoria")
	private List<Atividade> atividades = new ArrayList<>();
	
	public Categoria() {
	}
}
