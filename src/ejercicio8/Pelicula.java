package ejercicio8;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Pelicula implements Comparable<Pelicula>{
	private Clave clave;
	private String nombre;
	private LocalDate fechaEstreno, fechaDVD;
	private Long diasEstreno;
	
	public Pelicula(String nombre, Genero genero, LocalDate fechaEstreno, LocalDate fechaDVD) {
		this.nombre = nombre;
		this.fechaEstreno = fechaEstreno;
		this.fechaDVD = fechaDVD;
		clave = asignarClave(genero);
		diasEstreno = calcularDiasEstreno(this);  
	}
	
	public Pelicula(Pelicula pelicula) {
		this(pelicula.nombre, pelicula.clave.getGenero() , pelicula.fechaEstreno, pelicula.fechaDVD);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}
	
	public Long getDiasEstreno() {
		return diasEstreno;
	}
	
	public Clave getClave() {
		return clave;
	}
	
	private Clave asignarClave(Genero genero) {
		Clave clave = new Clave(genero);
		return clave;
	}

	public Long calcularDiasEstreno(Pelicula pelicula) {
		Long dias = ChronoUnit.DAYS.between(pelicula.fechaEstreno, pelicula.fechaDVD);
		return dias;
	}
	
	public int compareTo(Pelicula p) {
		int comparacion = p.getDiasEstreno().compareTo(diasEstreno);
		if(comparacion == 0) {
			return nombre.compareToIgnoreCase(p.getNombre());
		}
		return comparacion;
	}
	
	public boolean equals(Object obj) {
		String name = null;
		if(obj instanceof Pelicula) {
			Pelicula p = (Pelicula)obj;
			name = p.getNombre();
			return name.equals(nombre);
		}
		return false;
	}
	
	public int hashCode() {
		return nombre.hashCode();
	}
	
	public String toString() {
		return String.format("%-10S %-40s Clave: %-5s Fecha Estreno: %-13s Fecha DVD: %-13s",clave.getGenero(), nombre, clave.toString(), fechaEstreno, fechaDVD);
	}
}
