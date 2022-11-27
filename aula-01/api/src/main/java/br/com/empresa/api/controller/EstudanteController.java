package br.com.empresa.api.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.api.entity.Estudante;
import br.com.empresa.api.request.PaginacaoRequest;
import br.com.empresa.api.service.EstudanteService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/estudates")
public class EstudanteController {
	
	EstudanteService estudanteService;

	@GetMapping("/{id}")
	public ResponseEntity<Estudante> buscarEstudadePorId(@PathVariable Long id) {
		return estudanteService.buscarEstudadePorId(id);
	}
	
	@GetMapping
	public Page<Estudante> buscarEstudades(
			@RequestParam(defaultValue = "0") Integer pagina,
			@RequestParam(defaultValue = "5") Integer itensPorPagina) {
		
		return estudanteService.buscarEstudades(PageRequest.of(pagina, itensPorPagina));
	}
	
	@PostMapping
	public ResponseEntity<List<Estudante>> cadastrarEstudante(@RequestBody List<Estudante> estudantes) {
		return estudanteService.cadastrarEstudante(estudantes);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Estudante> atualizarEstudante(@PathVariable Long id, @RequestBody Estudante estudante) {
		return estudanteService.atualizarEstudante(id, estudante);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirEstudate(@PathVariable Long id) {
		return estudanteService.excluirEstudate(id);
	}
}
