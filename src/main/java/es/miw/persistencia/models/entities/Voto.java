package es.miw.persistencia.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.miw.persistencia.models.utils.NivelEstudios;

@Entity
@Table(name = Voto.TABLE)
public class Voto {

	    public static final String TABLE = "voto";

	    public static final String ID = "ID";
	    
	    @Id
	    @GeneratedValue
	    @Column(name = ID)
	    private Integer id;

	    public static final String IP = "IP";

	    @Column(name = IP)
	    private String ip;
	    
	    public static final String NIVELESTUDIOS = "NIVELESTUDIOS";

	    @Enumerated(EnumType.STRING)
	    private NivelEstudios nivelEstudios;
	    
	    public static final String VALORACION = "VALORACION";
	    
	    @Column(name = VALORACION)
	    private Integer valoracion;

	    public Voto(String ip, NivelEstudios nivelEstudios, Integer valoracion) {
	        this.ip = ip;
	        this.nivelEstudios = nivelEstudios;
	        this.valoracion = valoracion;
	    }

		public Voto() {
	    }
	    
	    public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public NivelEstudios getNivelEstudios() {
			return nivelEstudios;
		}

		public void setNivelEstudios(NivelEstudios nivelEstudios) {
			this.nivelEstudios = nivelEstudios;
		}
		
	    public int getValoracion() {
			return this.valoracion;
		}

		public void setValoracion(Integer valoracion) {
				this.valoracion = valoracion;
		}
		
		 @Override
		    public String toString() {
		        return "Voto [Identificador :" + id + "\n" + "Ip: "+ ip + "\n" + "Nivel de Estudios: "+ nivelEstudios  + "Valoración: "+ valoracion  + "]";
		    }

		 @Override
		 public boolean equals(Object obj) {
			Voto voto = (Voto) obj; 
			return id.equals(voto.id) && ip.equals(voto.ip) && nivelEstudios.equals(voto.nivelEstudios) && valoracion.equals(voto.valoracion);
		}

}
