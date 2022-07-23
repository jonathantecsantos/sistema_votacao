package br.com.ideiasaleatorias.eleicaoonline.controllers.forms;

import javax.validation.constraints.NotNull;

public class ChooseElectionForm {

	@NotNull
	private Integer electionId;
	
	public Integer getElectionId() {
		return electionId;
	}
	
	public void setElectionId(Integer electionId) {
		this.electionId = electionId;
	}
}
