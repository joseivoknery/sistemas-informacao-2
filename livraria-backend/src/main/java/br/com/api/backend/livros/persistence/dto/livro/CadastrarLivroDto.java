/**
 *
 */
package br.com.api.backend.livros.persistence.dto.livro;

/**
 * @author José Ivo K. Nery
 *
 */
public class CadastrarLivroDto {

  private String titulo;

  private Long idEditora;

  private Integer numeroPaginas;

  public String getTitulo() {
    return this.titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Long getIdEditora() {
    return this.idEditora;
  }

  public void setIdEditora(Long idEditora) {
    this.idEditora = idEditora;
  }

  public Integer getNumeroPaginas() {
    return this.numeroPaginas;
  }

  public void setNumeroPaginas(Integer numeroPaginas) {
    this.numeroPaginas = numeroPaginas;
  }

}
