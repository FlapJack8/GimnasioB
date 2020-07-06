package modelo;

public class Pelicula {
	private String nombre;
	private String director;
	private String genero;
	private String duracion;//STRING!
	private String idioma;
	private String subtitulos;
	private float calificacion;
	private String observaciones;
	private String estado;

	// CONSTRUCTOR
	public Pelicula(String nombre, String director, String genero, String duracion, String idioma, String subtitulos,
			float calificacion, String observaciones) {
		super();
		this.nombre = nombre;
		this.director = director;
		this.genero = genero;
		this.duracion = duracion;
		this.idioma = idioma;
		this.subtitulos = subtitulos;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
	}
	
	public Pelicula(String nombre, String director, String genero, String duracion, String idioma, String subtitulos,
			float calificacion, String observaciones, String estado) {
		super();
		this.nombre = nombre;
		this.director = director;
		this.genero = genero;
		this.duracion = duracion;
		this.idioma = idioma;
		this.subtitulos = subtitulos;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getSubtitulos() {
		return subtitulos;
	}

	public void setSubtitulos(String subtitulos) {
		this.subtitulos = subtitulos;
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public String getEstado()
	{
		return this.estado;
	}
	
	//Metodos que utilizo en la base de datos
	public void bajaLogica() {
		this.estado = "Inactivo";	
	}
	
	public void esActivo() {
		this.estado="Activo";
	}
}
