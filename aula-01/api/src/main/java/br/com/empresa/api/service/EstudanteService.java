package br.com.empresa.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.empresa.api.entity.Estudante;
import br.com.empresa.api.repository.EstudanteRepository;
import br.com.empresa.api.request.PaginacaoRequest;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstudanteService {
	
	private EstudanteRepository estudanteRepository;
	
	public ResponseEntity<Estudante> buscarEstudadePorId(Long id) {
		Optional<Estudante> estudanteOpt = estudanteRepository.findById(id);
		if (!estudanteOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estudanteOpt.get());
	}

	public Page<Estudante> buscarEstudades(PaginacaoRequest paginacaoRequest) {
		Pageable pageable = PageRequest.of(paginacaoRequest.getPagina(), paginacaoRequest.getItensPorPagina());
		return estudanteRepository.findAll(pageable);
	}
	
	public ResponseEntity<List<Estudante>> cadastrarEstudante(List<Estudante> estudantes) {
		List<Estudante> estudantesSalvos = estudanteRepository.saveAll(estudantes);
		return new ResponseEntity<List<Estudante>>(estudantesSalvos, HttpStatus.CREATED);
	}

	public ResponseEntity<Estudante> atualizarEstudante(Long id, Estudante estudante) {
		if (!isEstudantePresent(id)) {
			return ResponseEntity.notFound().build();
		}
		estudante.setId(id); // deixar sem e mostrar a importancia de setar o id ao editar
		estudanteRepository.save(estudante);
		return new ResponseEntity<Estudante>(HttpStatus.OK);
	}
	
	public ResponseEntity<Estudante> excluirEstudate(Long id) {
		if (estudanteRepository.existsById(id))
		{
			estudanteRepository.deleteById(id);
			return new ResponseEntity<Estudante>(HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}

	private Boolean isEstudantePresent (Long id) {
		Optional<Estudante> estudanteOpt = estudanteRepository.findById(id);
		return estudanteOpt.isPresent();
	}
}
