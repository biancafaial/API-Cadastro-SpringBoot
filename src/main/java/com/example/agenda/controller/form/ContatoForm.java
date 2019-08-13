package com.example.agenda.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.agenda.model.Contato;

public class ContatoForm {
	
	@NotNull @NotEmpty
	private String nome;
	@NotNull 
	private Integer idade;
	@NotNull @NotEmpty
	private String email;
	@NotNull @NotEmpty
	private String telefone;
	@NotNull @NotEmpty
	private String senha;
	private LocalDateTime dataNascimento;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Contato toContatoDto() {
		return new Contato(nome, idade, email, telefone, senha, dataNascimento);
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}


}
