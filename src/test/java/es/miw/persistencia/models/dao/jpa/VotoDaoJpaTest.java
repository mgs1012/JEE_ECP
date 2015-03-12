package es.miw.persistencia.models.dao.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.miw.persistencia.jpa.JpaFactory;
import es.miw.persistencia.models.daos.DaoFactory;
import es.miw.persistencia.models.daos.VotoDao;
import es.miw.persistencia.models.entities.Voto;
import es.miw.persistencia.models.utils.NivelEstudios;


public class VotoDaoJpaTest {
	
	private VotoDao votodao;

	private Voto voto1, voto2;
	
	private List<Voto> votos;

	@BeforeClass
	public static void beforeClass() {
		// Inicializar DAO
		DaoFactory.setFactory(new DaoJpaFactory());
		JpaFactory.dropAndCreateTables();
	}

	@Before
	public void init() {
		votodao = DaoJpaFactory.getFactory().getVotoDao();

		voto1 = new Voto("138.100.152.01" , NivelEstudios.SUPERIORES, 6);
		voto2 = new Voto("138.100.152.02" , NivelEstudios.MEDIOS, 9);
		votodao.create(voto1);
		votodao.create(voto2);
		votos = new ArrayList<Voto>();
		votos.add(voto1);
		votos.add(voto2);
	}
	
	@Test
	public void testCreate() {
		Voto voto3 = new Voto("138.100.152.03" , NivelEstudios.BASICOS, 7);
		votodao.create(voto3);
		assertEquals(voto3, votodao.read(voto3.getId()));
	}

	@Test
	public void testRead() {
		//System.out.println("Compara: "+voto1);
		//System.out.println(" Con:"+ votodao.read(voto1.getId()));
		assertEquals(this.voto1, votodao.read(voto1.getId()));
	}

	@Test
	public void testUpdate() {
		voto1.setIp("192.100.152.01");;
		votodao.update(voto1);
		Voto voto = votodao.read(voto1.getId());
		assertEquals(voto.getIp(), "192.100.152.01");
	}

	@Test
	public void testDeleteByID() {
		Voto v = new Voto();
		votodao.create(v);
		votodao.deleteById(v.getId());
		assertNull(votodao.read(v.getId()));
	}

	@Test
	public void testFindAll() {
		assertEquals(votos, votodao.findAll());
	}

	@After
	public void after() {
		JpaFactory.dropAndCreateTables();
	}
}
