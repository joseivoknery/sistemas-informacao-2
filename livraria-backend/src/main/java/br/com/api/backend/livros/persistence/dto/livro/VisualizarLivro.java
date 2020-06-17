/**
 * 
 */
package br.com.api.backend.livros.persistence.dto.livro;

/**
 * @author José Ivo K. Nery
 *
 */
public class VisualizarLivro extends LivroDto{

	private Long id;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
		
}
