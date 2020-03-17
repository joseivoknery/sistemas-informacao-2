/**
 * 
 */
package br.com.api.backend.livros.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.api.backend.livros.persistence.dto.livro.LivroDto;
import br.com.api.backend.livros.persistence.dto.livro.VisualizarLivro;
import br.com.api.backend.livros.persistence.model.Livro;

/**
 * @author José Ivo K. Nery
 *
 */
public class LivroMapper {

	private LivroMapper() {
	}

	public static Livro mapper(LivroDto livroDto) {

		Livro livro = new Livro();

		livro.setTitulo(livroDto.getTitulo());

		livro.setEditora(livroDto.getEditora());

		livro.setNumeroPaginas(livroDto.getNumeroPaginas());

		return livro;

	}
	
	public static Livro mapper(LivroDto livroDto, Livro livro) {

		livro.setTitulo(livroDto.getTitulo());

		livro.setEditora(livroDto.getEditora());

		livro.setNumeroPaginas(livroDto.getNumeroPaginas());

		return livro;

	}

	public static VisualizarLivro mapper(Livro livro) {

		VisualizarLivro viewerLivro = new VisualizarLivro();

		viewerLivro.setId(livro.getId());

		viewerLivro.setTitulo(livro.getTitulo());

		viewerLivro.setEditora(livro.getEditora());

		viewerLivro.setNumeroPaginas(livro.getNumeroPaginas());

		return viewerLivro;

	}

	public static List<VisualizarLivro> mapper(List<Livro> livros) {
		return livros.stream().map(LivroMapper::mapper).collect(Collectors.toList());
	}

}
