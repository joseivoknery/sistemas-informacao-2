/**
 *
 */
package br.com.api.backend.livros.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author José Ivo K. Nery
 *
 */
@Entity
@Table(name = "Livro")
public class Livro {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @Column(name = "titulo", nullable = false, length = 255)
  private String titulo;

  @OneToOne
  private Editora editora;

  @Column(name = "numero_paginas", nullable = false, length = 255)
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
  public Editora getEditora() {
    return this.editora;
  }

  /**
   * @param editora the editora to set
   */
  public void setEditora(Editora editora) {
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
