/**
 *
 */
package br.com.api.backend.livros.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.api.backend.livros.persistence.dao.LivroDao;
import br.com.api.backend.livros.persistence.dto.livro.CadastrarLivroDto;
import br.com.api.backend.livros.persistence.dto.livro.LivroDto;
import br.com.api.backend.livros.persistence.model.Editora;
import br.com.api.backend.livros.persistence.model.Livro;
import br.com.api.backend.livros.service.mapper.LivroMapper;

/**
 * @author José Ivo K. Nery
 */
@Service
public class LivroService {

  @Autowired
  private LivroDao livroDao;

  @Autowired
  private EditoraService editoraService;

  public ResponseEntity<LivroDto> cadastro(CadastrarLivroDto cadastrarLivroDto) {

    Editora editora = this.editoraService.recuperarEditoraPorId(cadastrarLivroDto.getIdEditora());

    Livro livro = LivroMapper.mapper(cadastrarLivroDto, editora);

    LivroDto livroDto = LivroMapper.mapper(this.livroDao.save(livro));

    return new ResponseEntity<>(livroDto, HttpStatus.OK);
  }

  public ResponseEntity<LivroDto> editar(CadastrarLivroDto cadastrarLivroDto, Long id) {

    Editora editora = this.editoraService.recuperarEditoraPorId(cadastrarLivroDto.getIdEditora());

    Livro livro = LivroMapper.mapperEdicao(cadastrarLivroDto, editora, this.livroDao.getOne(id));

    LivroDto livroDto = LivroMapper.mapper(this.livroDao.save(livro));

    return new ResponseEntity<>(livroDto, HttpStatus.OK);
  }

  public ResponseEntity<List<LivroDto>> listarTodos() {

    List<LivroDto> livrosDto = LivroMapper.mapperList(this.livroDao.findAll());

    return new ResponseEntity<>(livrosDto, HttpStatus.OK);
  }

  public ResponseEntity<LivroDto> pesquisarPorId(Long id) {

    LivroDto livroDto = LivroMapper.mapper(this.livroDao.getOne(id));

    return new ResponseEntity<>(livroDto, HttpStatus.OK);
  }

  public ResponseEntity<String> excluir(Long id) {

    this.livroDao.deleteById(id);

    return new ResponseEntity<>("Livro excluido com Sucesso!", HttpStatus.OK);
  }



}
