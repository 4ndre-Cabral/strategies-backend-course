package br.com.empresa.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.api.entity.Estudante;
import br.com.empresa.api.service.EstudanteService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EstudanteController {
	
	EstudanteService estudanteService;

	@GetMapping("/{id}")
	public ResponseEntity<Estudante> buscarEstudadePorId(@PathVariable Long id) {
		return estudanteService.buscarEstudadePorId(id);
	}
	
	@GetMapping
	public List<Estudante> buscarEstudades() {
		return estudanteService.buscarEstudades();
	}
	
	@PostMapping
	public ResponseEntity<Estudante> cadastrarEstudante(@RequestBody Estudante estudante) {
		return estudanteService.cadastrarEstudante(estudante);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Estudante> atualizarEstudante(@PathVariable Long id, @RequestBody Estudante estudante) {
		return estudanteService.atualizarEstudante(id, estudante);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Estudante> excluirEstudate(@PathVariable Long id) {
		return estudanteService.excluirEstudate(id);
	}
}
