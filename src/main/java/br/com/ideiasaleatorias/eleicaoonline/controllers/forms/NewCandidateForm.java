package br.com.ideiasaleatorias.eleicaoonline.controllers.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.ideiasaleatorias.eleicaoonline.daos.ElectionDao;
import br.com.ideiasaleatorias.eleicaoonline.models.Candidate;

public class NewCandidateForm {

	@NotBlank
	private String name;
	@NotNull
	private Integer electionId;
	@NotBlank
	private String number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getElectionId() {
		return electionId;
	}

	public void setElectionId(Integer electionId) {
		this.electionId = electionId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Candidate toCandidate(ElectionDao electionDao) {
		return new Candidate(name,number,electionDao.findById(electionId).get());
	}

}
