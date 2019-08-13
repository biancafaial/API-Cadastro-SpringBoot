package com.example.agenda.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.example.agenda.model.Contato;
                              
public class ContatoDto {
	
	Long id;
	String nome;
	Integer idade;
	String email;
	String telefone;
	LocalDateTime dataNascimento;
	
	public ContatoDto(Contato contato) {
		this.id = contato.getId();
		this.nome = contato.getNome();
		this.idade = contato.getIdade();
		this.email = contato.getEmail();
		this.telefone= contato.getTelefone();
		this.dataNascimento = contato.getDataNascimento();
	}
		
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefone() {
		return telefone;
	}
	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}
	
	public static List<ContatoDto>toContatoDto(List<Contato>contatos){
		return contatos.stream().map(ContatoDto::new).collect(Collectors.toList());
	}

}
