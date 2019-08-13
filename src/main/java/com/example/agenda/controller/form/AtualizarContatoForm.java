package com.example.agenda.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.agenda.model.Contato;
import com.example.agenda.repository.ContatoRepository;

public class AtualizarContatoForm {
	
	@NotNull @NotEmpty
	private String email;
	@NotNull @NotEmpty
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Contato atualizar(Long id, ContatoRepository contatoRepository) {
			Contato contato = contatoRepository.getOne(id);
			contato.setEmail(this.email);
			contato.setSenha(this.senha);
			
			return contato;
		}
		

}
