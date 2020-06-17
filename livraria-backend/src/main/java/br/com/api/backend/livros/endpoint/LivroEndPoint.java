/**
 *
 */
package br.com.api.backend.livros.endpoint;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.api.backend.livros.persistence.dto.livro.CadastrarLivroDto;
import br.com.api.backend.livros.persistence.dto.livro.LivroDto;
import br.com.api.backend.livros.service.LivroService;
import io.swagger.annotations.Api;

/**
 * @author José Ivo K. Nery
 *
 */
@CrossOrigin()
@Api(tags = "Livro", description = "Recursos para testes da aplicação")
@RestController
@RequestMapping(path = "/livros")
public class LivroEndPoint {

  @Autowired
  private LivroService livroService;

  @PostMapping(consumes = "application/json", produces = "application/json")
  public ResponseEntity<LivroDto> cadastrar(@RequestBody CadastrarLivroDto cadastrarLivroDto) {
    return this.livroService.cadastro(cadastrarLivroDto);
  }

  @PutMapping(consumes = "application/json", produces = "application/json", path = "/{id}")
  public ResponseEntity<LivroDto> editar(@RequestBody CadastrarLivroDto cadastrarLivroDto,
      @PathVariable Long id) {
    return this.livroService.editar(cadastrarLivroDto, id);
  }

  @GetMapping(produces = "application/json")
  public ResponseEntity<List<LivroDto>> listarTodos() {
    return this.livroService.listarTodos();
  }

  @GetMapping(produces = "application/json", path = "/{id}")
  public ResponseEntity<LivroDto> pesquisarPorId(@PathVariable Long id) {
    return this.livroService.pesquisarPorId(id);
  }

  @DeleteMapping(produces = "plain/text", path = "/{id}")
  public ResponseEntity<String> excluir(@PathVariable Long id) {
    return this.livroService.excluir(id);
  }

}
