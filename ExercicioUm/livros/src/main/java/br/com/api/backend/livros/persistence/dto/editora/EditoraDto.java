/**
 *
 */
package br.com.api.backend.livros.persistence.dto.editora;

/**
 * @author José Ivo K. Nery
 *
 */
public class EditoraDto {

  private Long id;

  private String nomeEditora;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNomeEditora() {
    return this.nomeEditora;
  }

  public void setNomeEditora(String nomeEditora) {
    this.nomeEditora = nomeEditora;
  }

}
