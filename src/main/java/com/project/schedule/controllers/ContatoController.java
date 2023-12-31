package com.project.schedule.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.schedule.entidades.Contato;
import com.project.schedule.Repository.ContatoRepository;
import com.project.schedule.services.ContatoService;

@RestController
@RequestMapping("/contatos") /*http://localhost:8080*/
@CrossOrigin
public class ContatoController {
	List<Contato> contatos = new ArrayList<>();
	
	@Autowired
	ContatoRepository repo;
	
	@Autowired
	ContatoService service;
	
	@PostMapping
	public ResponseEntity<Contato> salvar(@RequestBody Contato contato) {
		/*contato.setId(contatos.size()+1l);
		contatos.add(contato);*/
		/*repo.save(contato);
		return ResponseEntity.status(HttpStatus.CREATED).body(contato);*/
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(contato));
	}
	
	@PutMapping("/{idcontato}")
	public ResponseEntity<Object> alterar(@PathVariable("idcontato") Long idcontato,
			@RequestBody Contato contato) {
		/*for(Contato ct : contatos) {
			if(ct.getId() == idcontato) {
			  ct.setNome(contato.getNome());	
			  ct.setEmail(contato.getEmail());
			  ct.setFone(contato.getFone());
			  return ResponseEntity.status(HttpStatus.OK).body(ct);				
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado");	
		*/
		/*Optional<Contato> opt = repo.findById(idcontato);
		try {
		    Contato ct = opt.get();
		    ct.setNome(contato.getNome());	
			ct.setEmail(contato.getEmail());
			ct.setFone(contato.getFone());
		    repo.save(ct);
		    return ResponseEntity.status(HttpStatus.OK).body(ct);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado");
		}	*/
		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idcontato, contato));
	}
	
	@DeleteMapping("/{idcontato}")
	public ResponseEntity<?> excluir(@PathVariable("idcontato") Long idcontato) {
		/*for(Contato ct : contatos) {
			if(ct.getId() == idcontato) {
			  contatos.remove(ct);
			  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();				
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado");	
		*/
		/*Optional<Contato> opt = repo.findById(idcontato);
		try {
		    Contato ct = opt.get();
		    repo.delete(ct);
		    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado");
		}*/
		service.excluir(idcontato);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	/*@GetMapping
	public List<Contato> consultar() {
		return contatos;
	}*/
	@GetMapping
	public ResponseEntity<List<Contato>> consultar() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
	
	@GetMapping("/{idcontato}")
	public ResponseEntity<Object> consultar(@PathVariable("idcontato") Long idcontato) {
		/*for(Contato contato : contatos) {
			if(contato.getId() == idcontato) {
				return ResponseEntity.status(HttpStatus.OK).body(contato);				
			}
		}*/
		/*Optional<Contato> opt = repo.findById(idcontato);
		try {
		    Contato ct = opt.get();
		    return ResponseEntity.status(HttpStatus.OK).body(ct);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado");
		}	*/
		return ResponseEntity.status(HttpStatus.OK).body(service.consultar(idcontato));
	}
}
