package br.com.empresa.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.empresa.api.entity.Estudante;

@Service
public class EstudanteService {

	private static Map<Long, Estudante> listaEstudantes = new HashMap<>();
	
	public ResponseEntity<Estudante> buscarEstudadePorId(Long id) {
		Estudante estudante = listaEstudantes.get(id);
		if (estudante == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estudante);
	}

	public List<Estudante> buscarEstudades() {
		return new ArrayList<>(listaEstudantes.values());
	}
	
	public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante) {
		listaEstudantes.put(estudante.getId(), estudante);
		return new ResponseEntity<Estudante>(HttpStatus.CREATED);
	}

	public ResponseEntity<Estudante> atualizarEstudante(Long id, Estudante estudante) {
		Estudante found = listaEstudantes.get(id);
		if (found == null) {
			return ResponseEntity.notFound().build();
		}
		listaEstudantes.put(estudante.getId(), estudante);
		return new ResponseEntity<Estudante>(HttpStatus.OK);
	}
	
	public ResponseEntity<Estudante> excluirEstudate(Long id) {
		Estudante found = listaEstudantes.get(id);
		if (found == null) {
			return ResponseEntity.notFound().build();
		}
		listaEstudantes.remove(id);
		return new ResponseEntity<Estudante>(HttpStatus.OK);
	}
}
