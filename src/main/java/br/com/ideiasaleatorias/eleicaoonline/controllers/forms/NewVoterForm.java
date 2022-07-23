package br.com.ideiasaleatorias.eleicaoonline.controllers.forms;

import javax.validation.constraints.NotNull;

import br.com.ideiasaleatorias.eleicaoonline.daos.ElectionDao;
import br.com.ideiasaleatorias.eleicaoonline.models.Voter;

public class NewVoterForm {

	@NotNull
	private Long number;
	@NotNull
	private Integer electionId;

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Integer getElectionId() {
		return electionId;
	}

	public void setElectionId(Integer electionId) {
		this.electionId = electionId;
	}

	public Voter toVoter(ElectionDao electionDao) {
		return new Voter(number.toString(),electionDao.findById(electionId).get());
	}

}
