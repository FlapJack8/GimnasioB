package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Pelicula;
import persistencia.PoolConnection;

public class PeliculasMapper {

	private static PeliculasMapper instancia;

	private PeliculasMapper() {
	}
	
	public static PeliculasMapper getInstance() {
		if (instancia == null)
			instancia = new PeliculasMapper();
		return instancia;
	}

	public Pelicula buscarPeliculaBD(String nombrePelicula) {
		try {
			Pelicula p = null;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("select * from dbo.Peliculas where nombrePelicula = ?");
			s.setString(1, nombrePelicula);
			ResultSet result = s.executeQuery();
			while (result.next()) {
				String nombrePeli = result.getString(2);
				String director = result.getString(3);
				String genero = result.getString(4);
				String duracion = result.getString(5);
				String idioma = result.getString(6);
				String subtitulos = result.getString(7);
				float calificacion = result.getFloat(8);
				String observaciones = result.getString(9);
				String estado = result.getString(10);
				p = new Pelicula(nombrePeli, director, genero, duracion, idioma, subtitulos, calificacion,
						observaciones, estado);
			}
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return p;
		} catch (Exception e) {
			System.out.println("Error Query: " + e.getMessage());
			return null;
		}
	}

	public void deletePelicula(Pelicula peli) {

		try {
			Pelicula p = (Pelicula) peli;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("delete from dbo.Peliculas where nombrePelicula = ?");
			s.setString(1, p.getNombre());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		} catch (Exception e) {
			System.out.println("Error delete Pelicula\n");
			System.out.println("Stack Trace: " + e.getStackTrace());
		}
	}

	/*
	 * public ResultSet listarPeliculas() { try { Connection con =
	 * PoolConnection.getPoolConnection().getConnection(); PreparedStatement s =
	 * con.prepareStatement("SELECT * from A_Interactivas_07.dbo.Peliculas");
	 * ResultSet rs = s.executeQuery(); return rs;
	 * 
	 * } catch (Exception e) { System.out.println("Error Query: " +
	 * e.getMessage()); return null; } }
	 */

	public void insertarPelicula(Pelicula p) {
		try {
			Pelicula peli = (Pelicula) p;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("insert into dbo.Peliculas (nombrePelicula, director, genero, duracion, "
													+ "idioma, subtitulos, calificacion, observaciones, estado) values (?,?,?,?,?,?,?,?,?)");
			// agregar campos
			s.setString(1, p.getNombre());
			s.setString(2, p.getDirector());
			s.setString(3, p.getGenero());
			s.setString(4, p.getDuracion());
			s.setString(5, p.getIdioma());
			s.setString(6, p.getSubtitulos());
			s.setFloat(7, p.getCalificacion());
			s.setString(8, p.getObservaciones());
			s.setString(9, p.getEstado());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		} catch (Exception e) {
			System.out.println("Error Query: " + e.getMessage());
			// e.printStackTrace();

		}
	}

	public void updatePelicula(Pelicula pelicula) {
		try { 
			Pelicula p=(Pelicula)pelicula;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("update Peliculas " + "set nombrePelicula = ?," + " director =?,"
					+ " genero =?," + " duracion =?," + " idioma =?," + " subtitulos = ?," + " calificacion =?,"
					+ " observaciones =?," + " estado =?" + " where nombrePelicula = ?");
			// agregar campos
			s.setString(1, p.getNombre());
			s.setString(2, p.getDirector());
			s.setString(3, p.getGenero());
			s.setString(4, p.getDuracion());
			s.setString(5, p.getIdioma());
			s.setString(6, p.getSubtitulos());
			s.setFloat(7, p.getCalificacion());
			s.setString(8, p.getObservaciones());
			s.setString(9, p.getEstado());
			s.setString(10, p.getNombre());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		} catch (Exception e) {
			System.out.println("Error update Pelicula\n");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());

		}
	}
	
	
	public int averiguaridPelicula(String nombrePelicula) {
		try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("select * from dbo.Peliculas where nombrePelicula = ?");
			s.setString(1, nombrePelicula);
			ResultSet result = s.executeQuery();
			while (result.next()) {
				return result.getInt(1);
						
			}
			PoolConnection.getPoolConnection().realeaseConnection(con);
		} catch (Exception e) {
			System.out.println("Error Query: " + e.getMessage());
		}
		return 0;
	}

	
	
	
	
}