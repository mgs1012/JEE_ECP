package es.miw.persistencia.models.dao.jpa;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.miw.persistencia.jpa.JpaFactory;
import es.miw.persistencia.models.daos.DaoFactory;
import es.miw.persistencia.models.daos.VotoDao;
import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.entities.Voto;
import es.miw.persistencia.models.utils.NivelEstudios;


public class VotoDaoJpaTest {
	
	private VotoDao votodao;

	private Voto voto1, voto2;

	@BeforeClass
	public static void beforeClass() {
		// Inicializar DAO
		DaoFactory.setFactory(new DaoJpaFactory());
		JpaFactory.dropAndCreateTables();

	}

	@Before
	public void init() {
		votodao = DaoJpaFactory.getFactory().getVotoDao();

		voto1 = new Voto(001,"138.100.152.01" , NivelEstudios.SUPERIORES);
		voto2 = new Voto(002,"138.100.152.02" , NivelEstudios.MEDIOS);
		votodao.create(voto1);
		votodao.create(voto2);

		/*
		 * List<VotoE> votos = new ArrayList<VotoE>(); votos.add(new VotoE(001,
		 * "138.100.152.01", NivelEstudios.MEDIOS, tema)); votos.add(new
		 * VotoE(002, "138.100.152.02", NivelEstudios.SUPERIORES, tema));
		 * tema.setVotos(votos);
		 */

	}

}
