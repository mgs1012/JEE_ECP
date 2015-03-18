package es.miw.persistencia.models.dao.jpa;


import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.miw.persistencia.models.daos.TemaDao;
import es.miw.persistencia.models.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

	/*
	 * @Id private Integer id;
	 * 
	 * private String titulo;
	 * 
	 * private String descripcion;
	 */

	public TemaDaoJpa() {
		super(Tema.class);
	}

	@Override
	public Tema getTemaByTitle(String tituloTema) {
		EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory()
				.createEntityManager();
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tema> query = criteria.createQuery(Tema.class);

		Root<Tema> root = query.from(Tema.class);
		query.select(root);

		Predicate predicate1 = criteria.equal(root.get("titulo"), tituloTema);
		query.where(predicate1);
		// query ejecutar
		query.select(root).where(predicate1);
		//System.out.println("Buscar en los titulos: " + tituloTema);
		return entityManager.createQuery(query).getSingleResult();
	}

	/*
	 * @Override public void removeTema(String titulo) { EntityManager
	 * entityManager = DaoJpaFactory.getEntityManagerFactory()
	 * .createEntityManager(); CriteriaBuilder criteria =
	 * entityManager.getCriteriaBuilder(); CriteriaQuery<Tema> query =
	 * criteria.createQuery(Tema.class);
	 * 
	 * Root<Tema> root = query.from(Tema.class);
	 * 
	 * query.select(root);
	 * 
	 * Predicate predicado = criteria.equal(root.get("titulo"), titulo);
	 * query.where(predicado); query.select(root).where(predicado);
	 * entityManager.getTransaction().begin();
	 * entityManager.remove(entityManager.createQuery(query).getSingleResult());
	 * entityManager.getTransaction().commit(); return;
	 * 
	 * }
	 */

}