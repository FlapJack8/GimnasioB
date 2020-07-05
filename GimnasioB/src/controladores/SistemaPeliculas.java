package controladores;

import java.util.Vector;

import modelo.Pelicula;
import persistencia.PeliculasMapper;

import javax.swing.JOptionPane;

public class SistemaPeliculas {
	public Vector<Pelicula> peliculas;

	private static SistemaPeliculas instanciaSistemaPeliculas;

	// CONSTRUCTOR
	public SistemaPeliculas() {
		super();
		peliculas = new Vector<Pelicula>();
	}

	// SINGLETON
	public static SistemaPeliculas getInstancia() {

		if (instanciaSistemaPeliculas == null) {
			instanciaSistemaPeliculas = new SistemaPeliculas();
		}
		return instanciaSistemaPeliculas;
	}

	// ALTA PELICULA
	public void altaPelicula(String nombre, String director, String genero, String duracion, String idioma,
			String subtitulos, float calificacion, String observaciones) {
		Pelicula p = buscarPeliculaAll(nombre); // Busco en memoria.
		
		if (p == null) {
			Pelicula pe = new Pelicula(nombre, director, genero, duracion, idioma, subtitulos, calificacion,
					observaciones);
			peliculas.add(pe); 
			pe.esActivo();
			JOptionPane.showMessageDialog(null, "\nLa pelicula se cargo con exito\n");
			PeliculasMapper.getInstance().insertarPelicula(pe); // Inserto en la Base de Datos
		} else
			System.out.printf("\nLa pelicula ya existe\n");
	}

	// ELIMINAR PELICULA
	// Yo mando el nombre de una pelicula, Eli se fija en las funcioens que
	// tengan esa pelicula si hay entradas vendidas
	public void eliminarPelicula(String nombre) {
		Pelicula pe = buscarPeliculaAll(nombre);
		
		if (pe != null) {
			if (!SistemaCines.getInstancia().funcionActiva(nombre)) {
				peliculas.remove(pe);
				pe.bajaLogica(); 
				PeliculasMapper.getInstance().updatePelicula(pe);
				JOptionPane.showMessageDialog(null, "La pelicula se elimino con exito.");
			} else {
				JOptionPane.showMessageDialog(null, "La pelicula tiene funciones activas, no se puede eliminar.");
			}
		}else {
			JOptionPane.showMessageDialog(null, "La pelicula no existe.");
		}
	}

	// MODIFICAR PELICULA
	public void modificarPelicula(String nombre, String director, String genero, String duracion, String idioma,
			String subtitulos, float calificacion, String observaciones) {

		Pelicula peli = buscarPeliculaAll(nombre);
		
		if (peli != null) {
			for (int i = 0; i < peliculas.size(); i++) {
				if (peliculas.elementAt(i) == peli) {
					peliculas.elementAt(i).setDirector(director);
					peliculas.elementAt(i).setGenero(genero);
					peliculas.elementAt(i).setDuracion(duracion);
					peliculas.elementAt(i).setIdioma(idioma);
					peliculas.elementAt(i).setSubtitulos(subtitulos);
					peliculas.elementAt(i).setCalificacion(calificacion);
					peliculas.elementAt(i).setObservaciones(observaciones); 
					Pelicula peliAux=peliculas.elementAt(i); //Agrego un aux ya que el atributo estado le corresponde a BD y no a memoria. 
					peliAux.esActivo();
					PeliculasMapper.getInstance().updatePelicula(peliAux); // Modifico en BD.
					System.out.printf("%s se modifico con exito\n", peliculas.elementAt(i).getNombre());
				}
			}
		}

	}

	// BUSCO PELICULA
	private Pelicula buscarPelicula(String nombre) {
		for (int i = 0; i < peliculas.size(); i++) {
			if (peliculas.elementAt(i).getNombre().equals(nombre)) {
				return peliculas.elementAt(i);
			}
		}
		return null;
	}

	
	public Pelicula buscarPeliculaAll(String nombre) {
		Pelicula p= buscarPelicula(nombre); 
		if(p==null) {
			p=PeliculasMapper.getInstance().buscarPeliculaBD(nombre); 
			peliculas.add(p);//Agrego a memoria para que futuros cambios. 
		}
		return p;
	}
	public void imprimirPelicula() { //NO ESTAS PREGUNTANDO EN LA BD
		for (Pelicula p : peliculas) { // For each
			String nombre = new String();
			String director = new String();
			String genero = new String();
			String duracion;
			String idioma = new String();
			String subtitulos = new String();
			float calificacion;
			String observaciones = new String();
			nombre = p.getNombre();
			director = p.getDirector();
			genero = p.getGenero();
			duracion = p.getDuracion();
			idioma = p.getIdioma();
			subtitulos = p.getSubtitulos();
			calificacion = p.getCalificacion();
			observaciones = p.getObservaciones();
			System.out.printf("%s, %s, %s, %s, %s, %s, %f, %s\n", nombre, director, genero, duracion, idioma,
					subtitulos, calificacion, observaciones);

		}
		System.out.println("\n");
	}

}
