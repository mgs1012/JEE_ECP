package es.miw.persistencia.models.dao.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.miw.persistencia.jpa.JpaFactory;
import es.miw.persistencia.models.daos.DaoFactory;
import es.miw.persistencia.models.daos.TemaDao;
import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.entities.Voto;
import es.miw.persistencia.models.utils.NivelEstudios;

public class TemaDaoJpaTest {

	private TemaDao temadao;

	private Tema tema, tema2;
	
	private Voto voto1, voto2;
	
	private List<Tema> temas;
	
	private List<Voto> votos;

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
		temas = new ArrayList<Tema>();
		
		votos = new ArrayList<Voto>();		
		
		voto1 = new Voto("138.100.152.04" , NivelEstudios.SUPERIORES, 7);
		voto2 = new Voto("138.100.152.05" , NivelEstudios.MEDIOS, 9);
		
		votos.add(voto1);
		votos.add(voto2);
		
		tema = new Tema("Baloncesto",
				"Tema dedicado a dicha actividad deportiva.",
				"¿Cómo valorarías tu pasión por este deporte?");
		tema.addListaVotos(votos);
		temadao.create(tema);	
		
		tema2 = new Tema("Baloncesto",
				"Tema dedicado a dicha actividad deportiva.",
				"¿Cómo valorarías tu pasión por este deporte?");
		temadao.create(tema2);

		
		temas.add(tema);
		temas.add(tema2);
		


		/*
		 * List<VotoE> votos = new ArrayList<VotoE>(); votos.add(new VotoE(001,
		 * "138.100.152.01", NivelEstudios.MEDIOS, tema)); votos.add(new
		 * VotoE(002, "138.100.152.02", NivelEstudios.SUPERIORES, tema));
		 * tema.setVotos(votos);
		 */
	}
	
	@Test
	public void testCreate() {
		Tema tema3 = new Tema("Fútbol",
				"Tema dedicado a dicha actividad deportiva.",
				"¿Cómo valorarías tu pasión por este deporte?");
		temadao.create(tema3);
		assertEquals(tema3, temadao.read(tema3.getId()));
	}

	@Test
	public void testRead() {
		assertEquals(this.tema, temadao.read(tema.getId()));
		assertEquals(this.tema2, temadao.read(tema2.getId()));
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
		assertEquals(temas, temadao.findAll());
	}

	@After
	public void after() {
		JpaFactory.dropAndCreateTables();
	}

}
