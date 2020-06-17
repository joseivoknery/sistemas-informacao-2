/**
 *
 */
package br.com.api.backend.livros.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.api.backend.livros.persistence.model.Editora;

/**
 * @author José Ivo K. Nery
 *
 */
@Repository
public interface EditoraDao extends JpaRepository<Editora, Long> {

}
