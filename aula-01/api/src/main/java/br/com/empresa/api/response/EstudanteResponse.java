package br.com.empresa.api.response;

import java.util.HashSet;
import java.util.Set;

import br.com.empresa.api.entity.Endereco;
import br.com.empresa.api.entity.Estudante;
import br.com.empresa.api.entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstudanteResponse {
	private Long id;
	private String nome;
	private String email;
	private Endereco endereco;
	private Set<Livro> livros = new HashSet<>();
	
	public static EstudanteResponse of(Estudante estudante) {
		return EstudanteResponse.builder()
				.id(estudante.getId())
				.nome(estudante.getNome())
				.email(estudante.getEmail())
				.endereco(estudante.getEndereco())
				.livros(estudante.getLivros())
				.build();
	}
}
