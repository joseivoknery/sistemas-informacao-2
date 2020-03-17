/**
 * 
 */
package br.com.api.backend.livros.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.backend.livros.persistence.dto.livro.LivroDto;
import br.com.api.backend.livros.persistence.model.Livro;

/**
 * @author José Ivo K. Nery
 *
 */
@Repository
public interface LivroDao extends JpaRepository<Livro, Long>, LivroMethodes {
}

interface LivroMethodes {

	List<Livro> pesquisarPorFiltro(LivroDto filtro);

}

class LivroDaoImpl implements LivroMethodes {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Livro> pesquisarPorFiltro(LivroDto filtro) {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Livro> cq = cb.createQuery(Livro.class);

		Root<Livro> root = cq.from(Livro.class);

		List<Predicate> condicoes = new ArrayList<>();

		if (StringUtils.isNotEmpty(filtro.getTitulo())) {

			Path<String> atributoNome = root.get("titulo");
			Predicate whereNome = cb.like(cb.upper(atributoNome), "%" + filtro.getTitulo().toUpperCase() + "%");
			condicoes.add(whereNome);
		}
		
		if (StringUtils.isNotEmpty(filtro.getEditora())) {

			Path<String> atributoEditora = root.get("editora");
			Predicate whereEditora = cb.like(cb.upper(atributoEditora), "%" + filtro.getEditora().toUpperCase() + "%");
			condicoes.add(whereEditora);
		}
		
		if (filtro.getNumeroPaginas() != null) {

			Path<Integer> atributoNumeroPaginas = root.get("numeroPaginas");
			Predicate whereNumeroPaginas = cb.like(atributoNumeroPaginas.as(String.class), "%" + filtro.getNumeroPaginas().toString().toUpperCase() + "%");
			condicoes.add(whereNumeroPaginas);
		}

		Predicate[] condicoesComoArray = condicoes.toArray(new Predicate[condicoes.size()]);

		Predicate todasCondicoes = cb.and(condicoesComoArray);

		cq.where(todasCondicoes);

		TypedQuery<Livro> query = em.createQuery(cq);

		return query.getResultList();
	}

}
