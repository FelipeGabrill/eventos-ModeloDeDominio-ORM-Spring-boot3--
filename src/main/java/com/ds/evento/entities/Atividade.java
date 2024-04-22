package com.ds.evento.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_atividade")
@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Setter
	private String nome;
	
	@Setter
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	@Setter
	private Double preco;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@ManyToMany
	@JoinTable(name = "tb_atividade_participante",
					joinColumns = @JoinColumn(name = "atividade_id"),
					inverseJoinColumns = @JoinColumn(name = "participante_id"))
	private Set<Participante> participantes = new HashSet<>(); 
	
	@OneToMany(mappedBy = "atividade")
	private List<Bloco> blocos = new ArrayList<>();
	
	public Atividade() {
	}
}
