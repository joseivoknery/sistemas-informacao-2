/**
 *
 */
package br.com.api.backend.livros.persistence.dto.livro;

/**
 * @author José Ivo K. Nery
 *
 */
public class LivroDto {

  private Long id;

  private String titulo;

  private String editora;

  private Integer numeroPaginas;



  /**
   * @return the id
   */
  public Long getId() {
    return this.id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return the titulo
   */
  public String getTitulo() {
    return this.titulo;
  }

  /**
   * @param titulo the titulo to set
   */
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  /**
   * @return the editora
   */
  public String getEditora() {
    return this.editora;
  }

  /**
   * @param editora the editora to set
   */
  public void setEditora(String editora) {
    this.editora = editora;
  }

  /**
   * @return the numeroPaginas
   */
  public Integer getNumeroPaginas() {
    return this.numeroPaginas;
  }

  /**
   * @param numeroPaginas the numeroPaginas to set
   */
  public void setNumeroPaginas(Integer numeroPaginas) {
    this.numeroPaginas = numeroPaginas;
  }

}