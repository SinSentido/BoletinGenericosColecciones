package ejercicio9;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Examen implements Comparable<Examen>{
	DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/LL/yyyy");
	private String asignatura;
	private String descripcion;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private Clave clave;
	
	public Examen(String asignatura, String descripcion, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
		this.asignatura = asignatura;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		clave = new Clave(this);
	}
	
	public Examen(Examen examen) {
		this(examen.asignatura, examen.descripcion, examen.fecha, examen.horaInicio, examen.horaFin);
	}
	
	public String getAsignatura() {
		return asignatura;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	
	public Clave getClave() {
		return clave;
	}
	
	
	public int compareTo(Examen o) {
		int comparacion;
		comparacion = asignatura.compareToIgnoreCase(o.getAsignatura());
		if(comparacion == 0) {
			comparacion = fecha.compareTo(o.getFecha());
			if(comparacion == 0) {
				comparacion = horaInicio.compareTo(o.getHoraInicio());
			}
		}
		return comparacion;
	}
	
	public boolean equals(Object o) {
		boolean sonIguales = false;
		if(o instanceof Examen) {
			Examen ex = (Examen)o;
			sonIguales = ex.getClave().equals(clave);
		}
		return sonIguales;
	}
	
	public int hashCode() {
		return clave.hashCode();
	}
	
	public String toString() {
		return String.format("%-25s%-26s%-13s%-8s%-8s%-10s", asignatura, descripcion, formatoFecha.format(fecha), 
				horaInicio, horaFin, clave);
	}


}
