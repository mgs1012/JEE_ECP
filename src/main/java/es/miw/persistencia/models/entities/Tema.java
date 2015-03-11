package es.miw.persistencia.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tema {
	public static final String TABLE = "tema";

	public static final String ID = "ID";
	
	@Id
    @GeneratedValue
    @Column(name = ID)
    private Integer id;
	
    public static final String TITULO = "TITULO";
	
    @Column(name = TITULO)
    private String titulo;
    
    public static final String DESCRIPCION = "DESCRIPCION";

    @Column(name = DESCRIPCION)
    private String descripcion;
    
    public static final String PREGUNTA = "PREGUNTA";
    
    @Column(name = PREGUNTA)
    private String pregunta;

    // Relacion unidireccional: 1:0..n
    // Tema con lista votos. Votos a parte.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Voto> votos;

    public Tema() {

    }

    public Tema(Integer id,String titulo, String descripcion, String pregunta) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.pregunta = pregunta;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}
    
	 @Override
	    public String toString() {
	        return "Tema [Identificador :" + id + "\n" + "Título: "+ titulo + "\n" + "Descripcion :" + descripcion  + "\n"+ " Pregunta : " +  pregunta  + "\n"+ "Votos :" + votos + "]";
	    }

	 @Override
	 public boolean equals(Object obj) {
		Tema tema = (Tema) obj; 
		return id.equals(tema.id) && titulo.equalsIgnoreCase(tema.titulo) && pregunta.equalsIgnoreCase(tema.pregunta);
	}


}
