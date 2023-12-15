package com.project.schedule.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.schedule.entidades.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{
	Contato findByEmail(String email);
}
