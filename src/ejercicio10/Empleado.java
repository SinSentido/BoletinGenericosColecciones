package ejercicio10;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Empleado implements Comparable<Empleado>{
	private DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/LL/yyyy");
	private Clave clave;
	private String nombre;
	private LocalDate fechaAlta;
	private LocalDate fechaBaja;
	private Long diasTrabajados;
	
	public Empleado(String nombre, Categoria categoria, LocalDate fechaAlta, LocalDate fechaBaja) {
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		clave = generarClave(categoria);
		diasTrabajados = calcularDiasTrabajados();
	}
	
	public Empleado(Empleado empleado) {
		this.nombre = empleado.getNombre();
		this.clave = empleado.getClave();
		this.fechaAlta = empleado.getFechaAlta();
		this.fechaBaja = empleado.getFechaBaja();
		this.diasTrabajados = empleado.getDiasTrabajados();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Clave getClave() {
		return clave;
	}
	
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	
	public LocalDate getFechaBaja() {
		return fechaBaja;
	}
	
	public Long getDiasTrabajados() {
		return diasTrabajados;
	}
	
	private Clave generarClave(Categoria categoria) {
		Clave clave = new Clave(categoria, ++categoria.contador);
		return clave;
	}
	
	private Long calcularDiasTrabajados() {
		Long dias;
		if(fechaBaja == null) {
			dias = ChronoUnit.DAYS.between(fechaAlta, LocalDate.now());
		}
		else {
			dias = ChronoUnit.DAYS.between(fechaAlta, fechaBaja);
		}
		return dias;
	}

	@Override
	public int compareTo(Empleado o) {
		int comparacion;
		comparacion = o.getDiasTrabajados().compareTo(diasTrabajados);
		return comparacion;
	}
	
	public String toString() {
		return String.format("%-12sNombre: %-10sClave: %-5sFecha alta: %-13sFecha baja: %-13sDias trabajados: %-8s", 
				clave.getCategoria(), nombre, clave.toString(), formatoFecha.format(fechaAlta), 
				fechaBaja == null?"No tiene":formatoFecha.format(fechaBaja), diasTrabajados);
	}

}
