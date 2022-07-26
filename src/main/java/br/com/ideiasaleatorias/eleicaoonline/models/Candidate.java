package br.com.ideiasaleatorias.eleicaoonline.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String name;
	@NotBlank
	@Column(unique = true)
	private String number;
	@ManyToOne
	@NotNull
	private Election election;

	/**
	 * @deprecated
	 */
	public Candidate() {

	}

	public Candidate(@NotBlank String name, @NotBlank String number, @NotNull Election election) {
		super();
		this.name = name;
		this.number = number;
		this.election = election;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getId() {
		return id;
	}

	public String getNumber() {
		return this.number;
	}
	
	public Election getElection() {
		return election;
	}

}
