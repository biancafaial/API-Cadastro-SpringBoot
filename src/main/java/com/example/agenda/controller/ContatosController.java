package com.example.agenda.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.agenda.controller.dto.ContatoDto;
import com.example.agenda.controller.form.AtualizarContatoForm;
import com.example.agenda.controller.form.ContatoForm;
import com.example.agenda.model.Contato;
import com.example.agenda.repository.ContatoRepository;

@RestController
@RequestMapping("/contatos")
public class ContatosController {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	
	@GetMapping
	public List<ContatoDto>lista(Integer idadeContato){
		List<Contato>contatos = contatoRepository.findAll();
		return ContatoDto.toContatoDto(contatos);
	}
	
	@PostMapping
	public ResponseEntity<ContatoDto> cadastrar(@RequestBody @Valid ContatoForm form, UriComponentsBuilder uriBuilder) { 
		 Contato contato= form.toContatoDto();
		contatoRepository.save(contato);
		
		URI uri = uriBuilder.path("/contatos/{id}").buildAndExpand(contato.getId()).toUri();
		return ResponseEntity.created(uri).body(new ContatoDto(contato));
		
	}
	
	@GetMapping("/{id}")
	public ContatoDto detalhar (@PathVariable Long id) {
		Contato contato = contatoRepository.getOne(id);
		return new ContatoDto(contato);
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ContatoDto> atualizar (@PathVariable Long id, @RequestBody @Valid AtualizarContatoForm form) {
		Contato contato= form.atualizar(id, contatoRepository);
		
		return ResponseEntity.ok(new ContatoDto(contato));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover (@PathVariable Long id) {
		 contatoRepository.deleteById(id);;
		return ResponseEntity.ok().build();
		
	}
	
}
