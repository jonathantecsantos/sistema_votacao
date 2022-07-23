package br.com.ideiasaleatorias.eleicaoonline.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ideiasaleatorias.eleicaoonline.controllers.forms.NewCandidateForm;
import br.com.ideiasaleatorias.eleicaoonline.daos.CandidateDao;
import br.com.ideiasaleatorias.eleicaoonline.daos.ElectionDao;
import br.com.ideiasaleatorias.eleicaoonline.infra.ViewMessages;
import br.com.ideiasaleatorias.eleicaoonline.models.Election;
import br.com.ideiasaleatorias.eleicaoonline.security.SystemUser;

@Controller
@Transactional
public class CandidatesController {
	
	@Autowired
	private CandidateDao candidateDao;
	@Autowired
	private ElectionDao electionDao;

	@GetMapping("/candidates/form")
	public String form(Model model, NewCandidateForm form,@AuthenticationPrincipal SystemUser owner) {
		model.addAttribute("elections",electionDao.findByOwnerId(owner.getId()));
		return "/candidate/form";
	}
	
	@PostMapping("/candidates")
	public String save(Model model, @Valid NewCandidateForm form, BindingResult bindingResult,
			RedirectAttributes redirectAttributes,@AuthenticationPrincipal SystemUser owner) {
		if (bindingResult.hasErrors()) {
			return form(model, form,owner);
		}
		
		Election election = electionDao.findById(form.getElectionId()).get();
		
		if(election.isOwnedByUser(owner)){
			candidateDao.save(form.toCandidate(electionDao));
			ViewMessages.successFlash("candidato cadastrado com sucesso", redirectAttributes);
			return "redirect:/candidates/form";			
		}
		throw new RuntimeException("Acesso negado...");
	}
}
