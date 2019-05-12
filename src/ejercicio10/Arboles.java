package ejercicio10;

import java.time.LocalDate;
import java.util.*;

public class Arboles {
	public static void main(String[] args) {
		Empleado empleado1 = new Empleado("Pepe", Categoria.EMPLEADO, LocalDate.of(2011,3,21), LocalDate.of(2013,4,22));
		Empleado empleado2 = new Empleado("Juan", Categoria.ENCARGADO, LocalDate.of(2012,2,29), null);
		Empleado empleado3 = new Empleado("Maria", Categoria.JEFE, LocalDate.of(2010,4,30), LocalDate.of(2014,5,31));
		Empleado empleado4 = new Empleado("Laura", Categoria.EMPLEADO, LocalDate.of(2010,12,30), null);
		Empleado empleado5 = new Empleado("Esteban", Categoria.ENCARGADO, LocalDate.of(2010,11,5), LocalDate.of(2015,2,11));
		Empleado empleado6 = new Empleado("Pedro", Categoria.JEFE, LocalDate.of(2009,8,16), null);
		Empleado empleado7 = new Empleado("Yolanda", Categoria.EMPLEADO, LocalDate.of(2012,7,27), LocalDate.of(2013,10,1));
		Empleado empleado8 = new Empleado("Nuria", Categoria.JEFE, LocalDate.of(2009,8,31), null);
		Empleado empleado9 = new Empleado("Antonio", Categoria.ENCARGADO, LocalDate.of(2011,1,28), LocalDate.of(2014,5,14));
		Empleado empleado10 = new Empleado(empleado1);
		Empleado empleado11 = new Empleado(empleado5);
		Empleado empleado12 = new Empleado(empleado6);
		
		//Arbol 1
		Set<Empleado> arbol1 = new TreeSet<>();
		arbol1.add(empleado1);
		arbol1.add(empleado2);
		arbol1.add(empleado3);
		arbol1.add(empleado4);
		arbol1.add(empleado5);
		arbol1.add(empleado6);
		arbol1.add(empleado7);
		arbol1.add(empleado8);
		arbol1.add(empleado9);
		arbol1.add(empleado10);
		arbol1.add(empleado11);
		arbol1.add(empleado12);
		
		System.out.println("ARBOL1: ordenado descendentemente por días trabajados\n");
		for(Empleado e : arbol1) {
			System.out.println(e.toString());
		}
		
		//Arbol 2
		Set<Empleado> arbol2 = new TreeSet<>((e1, e2) -> e1.getNombre().compareToIgnoreCase(e2.getNombre()));
		arbol2.addAll(arbol1);
		
		System.out.println("\n\nARBOL2: ordenado ascendentemente por orden alfabético del nombre\n");
		for(Empleado e : arbol2) {
			System.out.println(e.toString());
		}
		
		//Arbol 3
		Map<Clave, Empleado> arbol3 = new TreeMap<>(new Comparator<Clave>() {
			public int compare(Clave c1, Clave c2) {
				int comparacion;
				comparacion = c2.getCategoria().getCodigo().compareTo(c1.getCategoria().getCodigo());
				if(comparacion == 0) {
					comparacion = c1.getN().compareTo(c2.getN());
				}
				return comparacion;
			}
		});
		for(Empleado e : arbol2) {
			arbol3.put(e.getClave(), e);
		}	
		
		System.out.println("\n\nTREEMAP: ordenado descendentemente por categoría profesional y a misma categoría, ordenado ascendentemente por número\n");
		for(Empleado e : arbol3.values()) {
			System.out.println(e.toString());
		}
		
	}
}
