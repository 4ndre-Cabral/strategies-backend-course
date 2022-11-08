package br.com.empresa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.api.entity.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long>{

}
