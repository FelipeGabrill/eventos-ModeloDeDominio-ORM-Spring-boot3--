package com.ds.evento.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_participante")
@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Setter
	private String name;
	
	@Setter
	@Column(unique = true)
	private String email;
	
	@ManyToMany(mappedBy = "participantes")
	private Set<Atividade> atividades = new HashSet<>();
	
	public Participante() {
	}
}
