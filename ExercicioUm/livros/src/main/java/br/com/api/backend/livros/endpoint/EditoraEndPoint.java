/**
 *
 */
package br.com.api.backend.livros.endpoint;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.api.backend.livros.persistence.dto.editora.EditoraDto;
import br.com.api.backend.livros.persistence.dto.editora.EditoraUpdate;
import br.com.api.backend.livros.service.EditoraService;
import io.swagger.annotations.Api;

/**
 * @author José Ivo K. Nery
 *
 */
@Api(tags = "Editora", description = "Recursos para testes da aplicação")
@RestController
@RequestMapping(path = "/editoras")
public class EditoraEndPoint {

  @Autowired
  private EditoraService editoraService;

  @PostMapping(consumes = "application/json", produces = "application/json")
  public ResponseEntity<EditoraDto> cadastrar(@RequestBody EditoraUpdate editoraDto) {
    return this.editoraService.cadastro(editoraDto);
  }

  @PutMapping(consumes = "application/json", produces = "application/json", path = "/{id}")
  public ResponseEntity<EditoraDto> editar(
      @RequestBody EditoraUpdate editoraUpdateDto,
      @PathVariable Long id) {
    return this.editoraService.editar(editoraUpdateDto, id);
  }

  @DeleteMapping(produces = "plain/text", path = "/{id}")
  public ResponseEntity<String> excluir(@PathVariable Long id) {
    return this.editoraService.excluir(id);
  }

  @GetMapping(produces = "application/json")
  public ResponseEntity<List<EditoraDto>> listarTodos() {
    return this.editoraService.recuperarTodos();
  }

  @GetMapping(produces = "application/json", path = "/{id}")
  public ResponseEntity<EditoraDto> pesquisarPorId(@PathVariable Long id) {
    return this.editoraService.pesquisarPorId(id);
  }

}
