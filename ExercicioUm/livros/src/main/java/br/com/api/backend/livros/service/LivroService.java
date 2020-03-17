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
import br.com.api.backend.livros.persistence.dto.livro.LivroDto;
import br.com.api.backend.livros.persistence.dto.livro.VisualizarLivro;
import br.com.api.backend.livros.persistence.model.Livro;
import br.com.api.backend.livros.service.mapper.LivroMapper;

/**
 * @author José Ivo K. Nery
 */
@Service
public class LivroService {

	@Autowired
	private LivroDao livroDao;

	public ResponseEntity<List<VisualizarLivro>> listarTodos() {
		return new ResponseEntity<List<VisualizarLivro>>(LivroMapper.mapper(this.livroDao.findAll()), HttpStatus.OK);
	}

	public ResponseEntity<List<VisualizarLivro>> pesquisarPorFiltro(LivroDto filtro) {
		return new ResponseEntity<List<VisualizarLivro>>(LivroMapper.mapper(this.livroDao.pesquisarPorFiltro(filtro)),
				HttpStatus.OK);
	}

	public ResponseEntity<VisualizarLivro> pesquisarPorId(Long id) {
		return new ResponseEntity<VisualizarLivro>(LivroMapper.mapper(this.livroDao.getOne(id)), HttpStatus.OK);
	}

	public ResponseEntity<LivroDto> cadastro(LivroDto livroDto) {
		this.livroDao.save(LivroMapper.mapper(livroDto));
		return new ResponseEntity<LivroDto>(livroDto, HttpStatus.OK);
	}

	public ResponseEntity<VisualizarLivro> atualizar(LivroDto livroDto, Long id) {
		return new ResponseEntity<VisualizarLivro>(
				LivroMapper.mapper(this.livroDao.save(LivroMapper.mapper(livroDto, this.livroDao.getOne(id)))),
				HttpStatus.OK);
	}

	public ResponseEntity<VisualizarLivro> deletar(Long id) {
		Livro livro = this.livroDao.getOne(id);
		this.livroDao.delete( this.livroDao.getOne(id));
		return new ResponseEntity<VisualizarLivro>(LivroMapper.mapper(livro), HttpStatus.OK);
	}

}
