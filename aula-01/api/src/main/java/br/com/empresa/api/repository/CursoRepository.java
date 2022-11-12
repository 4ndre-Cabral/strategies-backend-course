package br.com.empresa.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.api.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

	Optional<Curso> findByNome(String nomeCurso);

}
