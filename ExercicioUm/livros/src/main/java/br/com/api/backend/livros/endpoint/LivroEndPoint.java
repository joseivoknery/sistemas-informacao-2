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

import br.com.api.backend.livros.persistence.dto.livro.LivroDto;
import br.com.api.backend.livros.persistence.dto.livro.VisualizarLivro;
import br.com.api.backend.livros.service.LivroService;
import io.swagger.annotations.Api;

/**
 * @author José Ivo K. Nery
 *
 */
@Api(tags = "Livro", description = "Recursos para testes da aplicação")
@RestController
@RequestMapping(path = "/livros")
public class LivroEndPoint{

	@Autowired
	private LivroService livroService;
	
	@GetMapping(path = "all",produces = "application/json")
	public ResponseEntity<List<VisualizarLivro>> listarTodos(){
		return this.livroService.listarTodos();
	}
	
	@GetMapping(path = "filtro",produces = "application/json")
	public ResponseEntity<List<VisualizarLivro>> pesquisarPorFiltro(LivroDto filtro){
		return this.livroService.pesquisarPorFiltro(filtro);
	}
	
	@GetMapping(path = "{id}",produces = "application/json")
	public ResponseEntity<VisualizarLivro> listarPorId(@PathVariable Long id){
		return this.livroService.pesquisarPorId(id);
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<LivroDto> cadastrar(@RequestBody LivroDto livroDto){
		return this.livroService.cadastro(livroDto);
	}
	
	@PutMapping(path = "{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<VisualizarLivro> atualizar(@RequestBody LivroDto livroDto, @PathVariable Long id){
		return this.livroService.atualizar(livroDto, id);
	}
	
	@DeleteMapping(path = "{id}",produces = "application/json")
	public ResponseEntity<VisualizarLivro> deletar(@PathVariable Long id){
		return this.livroService.deletar(id);
	}
	
	

}
