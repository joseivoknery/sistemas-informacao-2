/**
 *
 */
package br.com.api.backend.livros.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.api.backend.livros.persistence.dao.EditoraDao;
import br.com.api.backend.livros.persistence.dto.editora.EditoraDto;
import br.com.api.backend.livros.persistence.dto.editora.EditoraUpdate;
import br.com.api.backend.livros.persistence.model.Editora;
import br.com.api.backend.livros.service.mapper.EditoraMapper;

/**
 * @author José Ivo K. Nery
 *
 */
@Service
public class EditoraService {

  @Autowired
  private EditoraDao editoraDao;

  public Editora recuperarEditoraPorId(Long id) {

    return this.editoraDao.getOne(id);
  }

  public ResponseEntity<EditoraDto> pesquisarPorId(Long id) {

    return new ResponseEntity<>(EditoraMapper.mapper(this.editoraDao.getOne(id)), HttpStatus.OK);
  }

  public ResponseEntity<List<EditoraDto>> recuperarTodos() {

    return new ResponseEntity<>(EditoraMapper.mapper(this.editoraDao.findAll()), HttpStatus.OK);
  }

  public ResponseEntity<EditoraDto> cadastro(EditoraUpdate editoraDto) {

    Editora editora = EditoraMapper.mapperCadastro(editoraDto);

    return new ResponseEntity<>(EditoraMapper.mapper(this.editoraDao.save(editora)), HttpStatus.OK);
  }

  public ResponseEntity<EditoraDto> editar(EditoraUpdate editoraUpdateDto, Long id) {

    Editora editora = this.editoraDao.getOne(id);

    return new ResponseEntity<>(
        EditoraMapper.mapper(this.editoraDao
            .save(EditoraMapper.mapperUpdate(editoraUpdateDto, editora))),
        HttpStatus.OK);
  }

  public ResponseEntity<String> excluir(Long id) {

    this.editoraDao.deleteById(id);

    return new ResponseEntity<>("Editora excluida com Sucesso!", HttpStatus.OK);
  }

}
