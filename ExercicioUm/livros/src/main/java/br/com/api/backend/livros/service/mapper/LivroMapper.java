/**
 *
 */
package br.com.api.backend.livros.service.mapper;

import java.util.List;
import java.util.stream.Collectors;
import br.com.api.backend.livros.persistence.dto.livro.CadastrarLivroDto;
import br.com.api.backend.livros.persistence.dto.livro.LivroDto;
import br.com.api.backend.livros.persistence.model.Editora;
import br.com.api.backend.livros.persistence.model.Livro;

/**
 * @author José Ivo K. Nery
 *
 */
public class LivroMapper {

  public static Livro mapper(CadastrarLivroDto cadastrarLivroDto, Editora editora) {

    Livro livro = new Livro();

    livro.setEditora(editora);

    livro.setNumeroPaginas(cadastrarLivroDto.getNumeroPaginas());

    livro.setTitulo(cadastrarLivroDto.getTitulo());

    return livro;
  }

  public static Livro mapperEdicao(CadastrarLivroDto cadastrarLivroDto, Editora editora,
      Livro livro) {

    livro.setEditora(editora);

    livro.setNumeroPaginas(cadastrarLivroDto.getNumeroPaginas());

    livro.setTitulo(cadastrarLivroDto.getTitulo());

    return livro;
  }

  public static LivroDto mapper(Livro livro) {

    LivroDto livroDto = new LivroDto();

    livroDto.setEditora(livro.getEditora().getNome());

    livroDto.setNumeroPaginas(livro.getNumeroPaginas());

    livroDto.setTitulo(livro.getTitulo());

    return livroDto;
  }

  public static List<LivroDto> mapperList(List<Livro> livros) {
    return livros.stream().map(LivroMapper::mapper).collect(Collectors.toList());
  }

}
