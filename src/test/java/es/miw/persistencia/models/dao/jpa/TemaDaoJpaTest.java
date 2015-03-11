package es.miw.persistencia.models.dao.jpa;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.miw.persistencia.jpa.JpaFactory;
import es.miw.persistencia.models.daos.DaoFactory;
import es.miw.persistencia.models.daos.TemaDao;
import es.miw.persistencia.models.entities.Tema;

public class TemaDaoJpaTest {

	private TemaDao temadao;

	private Tema tema;

	@BeforeClass
	public static void beforeClass() {
		// Inicializar DAO
		DaoFactory.setFactory(new DaoJpaFactory());
		JpaFactory.dropAndCreateTables();

	}

	@Before
	public void init() {
		temadao = DaoJpaFactory.getFactory().getTemaDao();
		// temadao = DaoFactory.getFactory().getTemaDao();
		tema = new Tema(1, "Baloncesto",
				"Tema dedicado a dicha actividad deportiva.",
				"¿Cómo valorarías tu pasión por este deporte?");
		temadao.create(tema);

		/*
		 * List<VotoE> votos = new ArrayList<VotoE>(); votos.add(new VotoE(001,
		 * "138.100.152.01", NivelEstudios.MEDIOS, tema)); votos.add(new
		 * VotoE(002, "138.100.152.02", NivelEstudios.SUPERIORES, tema));
		 * tema.setVotos(votos);
		 */

	}

	@Test
	public void testCreate() {
		Tema tema2 = new Tema(2, "Fútbol",
				"Tema dedicado a dicha actividad deportiva.",
				"¿Cómo valorarías tu pasión por este deporte?");
		temadao.create(tema2);
		assertEquals(tema2, temadao.read(tema2.getId()));
	}

	@Test
	public void testRead() {
		assertEquals(this.tema, temadao.read(tema.getId()));
	}

	@Test
	public void testUpdate() {
		tema.setTitulo("Lectura");
		tema.setPregunta("¿Te gusta leer?");
		temadao.update(tema);
		Tema tema1 = temadao.read(tema.getId());
		assertEquals(tema1.getTitulo(), "Lectura");
		assertEquals(tema1.getPregunta(), "¿Te gusta leer?");
	}

	@Test
	public void testDeleteByID() {
		Tema t = new Tema();
		temadao.create(t);
		temadao.deleteById(t.getId());
		assertNull(temadao.read(t.getId()));
	}

	@Test
	public void testFindAll() {
		assertEquals(1, temadao.findAll().size());
	}

	@After
	public void after() {
		JpaFactory.dropAndCreateTables();
	}

}
