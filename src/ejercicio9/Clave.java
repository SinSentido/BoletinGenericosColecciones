package ejercicio9;

import java.time.LocalTime;

public class Clave {
	private Integer diaExamen;
	private LocalTime horaExamen;
		
	public Clave(Examen examen) {
		diaExamen = examen.getFecha().getDayOfMonth();
		horaExamen = examen.getHoraInicio();
	}
	
	public Integer getDiaExamen() {
		return diaExamen;
	}
	
	public LocalTime getHoraExamen() {
		return horaExamen;
	}
		
	public boolean equals(Object o) {
		boolean sonIguales = false;
		if(o instanceof Clave) {
			Clave c = (Clave)o;
			sonIguales = diaExamen == c.getDiaExamen() && horaExamen.equals(c.getHoraExamen());
		}
		return sonIguales;
	}
	
	public int hashCode() {
		return diaExamen.hashCode()+horaExamen.hashCode();
	}
	
	public String toString() {
		return String.format("%d-%s", diaExamen, horaExamen);
	}
}
