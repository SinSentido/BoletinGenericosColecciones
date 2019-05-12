package ejercicio8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Videoclub {
	public static void main(String[] args) {
		DateTimeFormatter fechaFormateada;
		fechaFormateada = DateTimeFormatter.ofPattern("yyyy/LL/dd");
		
		//Creacion de las peliculas
		Pelicula peli1 = new Pelicula("Poltergeist, juegos diabólicos", Genero.TERROR, 
				LocalDate.of(2015, 5, 22), LocalDate.of(2015,9,22));
		Pelicula peli2 = new Pelicula("La cumbre escarlata", Genero.TERROR, 
				LocalDate.parse("2015/10/09", fechaFormateada), LocalDate.parse("2016/02/12", fechaFormateada));		
		Pelicula peli3 = new Pelicula("Ocho apellidos catalanes", Genero.COMEDIA, 
				LocalDate.parse("2015/11/20", fechaFormateada), LocalDate.parse("2016/03/18", fechaFormateada));		
		Pelicula peli4 = new Pelicula("Padres por desigual", Genero.COMEDIA, 
				LocalDate.parse("2016/01/02", fechaFormateada), LocalDate.parse("2016/05/11", fechaFormateada));
		Pelicula peli5 = new Pelicula("Star Wars: El despertar de la fuerza", Genero.FICCION, 
				LocalDate.parse("2015/12/19", fechaFormateada), LocalDate.parse("2016/04/20", fechaFormateada));		
		Pelicula peli6 = new Pelicula("Mad Max: Furia en la carretera", Genero.FICCION, 
				LocalDate.parse("2015/05/15", fechaFormateada), LocalDate.parse("2015/09/01", fechaFormateada));		
		Pelicula peli7 = new Pelicula(peli1);		
		Pelicula peli8 = new Pelicula(peli5);
		
		List<Pelicula> lista = new ArrayList<>();
		lista.add(peli1);
		lista.add(peli2);
		lista.add(peli3);
		lista.add(peli4);
		lista.add(peli5);
		lista.add(peli6);
		lista.add(peli7);
		lista.add(peli8);
		
		//COLECCION 1
		Set<Pelicula> coleccion1 = new LinkedHashSet<>(lista);
		System.out.println("1. Lista sin duplicados que consigue mantener el órden en el que los datos fueron insertados\n");
		for(Pelicula p : coleccion1) {
			System.out.printf("%s%n", p.toString());
		}
		
		//COLECCION 2
		SortedSet<Pelicula> coleccion2 = new TreeSet<>(lista);
		System.out.println("\n\n2. Arbol ordenado descendentemente por días que ha tardado en salir en DVD desde que se estrenó\n");
		for(Pelicula p: coleccion2) {
			System.out.printf("%s Dias: %d%n", p.toString(), p.getDiasEstreno());
		}

		//COLECCION 3
		//Forma 1 con función anónima
		SortedSet<Pelicula> coleccion3 = new TreeSet<>(new Comparator<>() {
			public int compare(Pelicula p1, Pelicula p2) {
				int comparacion = p1.getFechaEstreno().compareTo(p2.getFechaEstreno());
				if(comparacion == 0) {
					return p1.getNombre().compareToIgnoreCase(p2.getNombre());
				}
				return comparacion;
			}
			
		});
		
		//Forma2 con lambda
//		SortedSet<Pelicula> coleccion3 = new TreeSet<>((p1, p2) -> p1.getFechaEstreno().compareTo(p2.getFechaEstreno()));
		
		for(Pelicula p : lista) {
			coleccion3.add(p);
		}
		
		System.out.println("\n\n3. Arbol ordenado ascendentemente por fecha de estreno\n");
		for(Pelicula p:coleccion3) {
			System.out.println(p.toString());
		}
	
		//COLECCION 4

		Map<Clave, Pelicula> coleccion4 = new TreeMap<>(new Comparator<Clave>() {
			public int compare(Clave o1, Clave o2) {
				Character clave1, clave2;
				int comparacion;
				clave1 = o1.getGenero().getCodigo();
				clave2 = o2.getGenero().getCodigo();
				comparacion = clave1.compareTo(clave2);
				if(comparacion == 0) {
					comparacion = o1.getN().compareTo(o2.getN());
				}
				return comparacion;
			}			
		});
		
		for(Pelicula p : coleccion1) {
			coleccion4.put(p.getClave(), p);
		}
		
		System.out.println("\n\n4.Mapa ordenado por clave\n");
		for(Pelicula p : coleccion4.values()) {
			System.out.println(p.toString());
		}
		
		//COLECCION 5
		Map<Clave, Pelicula> coleccion5 = new TreeMap<>(new Comparator<Clave>() {
			public int compare(Clave o1, Clave o2) {
				Character clave1, clave2;
				int comparacion;
				clave1 = o1.getGenero().getCodigo();
				clave2 = o2.getGenero().getCodigo();
				comparacion = clave2.compareTo(clave1);
				if(comparacion == 0) {
					comparacion = o2.getN().compareTo(o1.getN());
				}
				return comparacion;
			}			
		});
		
		for(Pelicula p : coleccion1) {
			coleccion5.put(p.getClave(), p);
		}
		
		System.out.println("\n\n4.Mapa ordenado por clave\n");
		for(Pelicula p : coleccion5.values()) {
			System.out.println(p.toString());
		}

	}
}
