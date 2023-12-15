package com.project.schedule.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.schedule.entidades.Contato;
import com.project.schedule.exceptions.RecursoJaExistente;
import com.project.schedule.exceptions.RecursoNaoEncontrado;
import com.project.schedule.exceptions.ValidaDadosException;
import com.project.schedule.Repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	ContatoRepository repo;
	
	public Contato consultar(Long idcontato) {
		Optional<Contato> opt = repo.findById(idcontato);
		Contato ct = opt.orElseThrow(() -> new RecursoNaoEncontrado("Contato não encontrado."));
		return ct;						
	}
	
	public void excluir(Long id) {
		Contato ct = consultar(id);
		repo.delete(ct);
	}
	
	public Contato salvar(Contato contato) {
		validaCampos(contato);
		
		if (repo.findByEmail(contato.getEmail()) != null) {
			throw new RecursoJaExistente("Contato já cadastrado para esse email");
		}	
		return repo.save(contato);
	}
	
	public Contato alterar(Long idContato, Contato contato) {
		Contato ct = consultar(idContato);
		validaCampos(contato);
		ct.setNome(contato.getNome());
		ct.setEmail(contato.getEmail());
		ct.setFone(contato.getFone());
		return repo.save(ct);
	}
	
	private void validaCampos(Contato contato) {
		if(contato.getNome().equals("")) {
			throw new ValidaDadosException("O nome deve ser informado");
		}
		if(contato.getEmail().equals("")) {
			throw new ValidaDadosException("O email deve ser informado");
		}
		
		if(contato.getFone() == null ) {
			throw new ValidaDadosException("O fone deve ser informado");
		}
		else {
			if(contato.getFone().equals("")) {
				throw new ValidaDadosException("O fone deve ser informado");
			}
		}
	}
	
	
}
