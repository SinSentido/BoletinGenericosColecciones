package ejercicio9;


import java.time.*;
import java.util.*;

import static keyboard.Keyboard.*;

import keyboard.Keyboard.Limit;


public class Main {
	public static void main(String[] args) {
		int num1, num2;
		
		Examen examen1 = new Examen("Programacion", "Herencia y colecciones", LocalDate.of(2017,06,16), 
				LocalTime.of(8, 15), LocalTime.of(13,30));
		Examen examen2 = new Examen("Base de datos", "Programación y SQL", LocalDate.of(2017,06,15),
				LocalTime.of(11, 45), LocalTime.of(14, 30));
		Examen examen3 = new Examen("Sistemas informáticos", "Sistemas en red", LocalDate.of(2017,06,20),
				LocalTime.of(10,15), LocalTime.of(11,45));
		Examen examen4 = new Examen("Entornos de desarrollo", "Diagrama de clases", LocalDate.of(2017,06,19),
				LocalTime.of(9,15), LocalTime.of(11,15));
		Examen examen5 = new Examen("Lenguaje de marcas", "Hojas de estilos", LocalDate.of(2017,06,14),
				LocalTime.of(8,15), LocalTime.of(11,15));
		Examen examen6 = new Examen("FOL", "Derechos del trabajador", LocalDate.of(2017,06,13),
				LocalTime.of(10,15), LocalTime.of(11,15));
		Examen examen7 = new Examen("Base de datos", "Entidad-Relación", LocalDate.of(2017,06,15),
				LocalTime.of(8,15), LocalTime.of(11,30));
		Examen examen8 = new Examen(examen1);
		Examen examen9 = new Examen(examen5);
		
		//a) Insertarlos en un ArrayList. Muestra el contenido del ArrayList.
		List<Examen> lista = new ArrayList<>();
		lista.add(examen1);
		lista.add(examen2);
		lista.add(examen3);
		lista.add(examen4);
		lista.add(examen5);
		lista.add(examen6);
		lista.add(examen7);
		lista.add(examen8);
		lista.add(examen9);
		System.out.println("A)");
		for(Examen e : lista) {
			System.out.println(e.toString());
		}
		
		//b) Inserta los exámenes en una colección sin duplicados que mantenga el órden de inserción. Muestra
		//la colección sin duplicados.
		Set<Examen> sinDuplicados = new LinkedHashSet<>(lista);
		System.out.println("\n\nB)");
		for(Examen e : sinDuplicados) {
			System.out.println(e.toString());
		}
		
		//c) Muestra el contenido de la colección sin duplicados del apartado 2 al revés utilizando iteradores.
		System.out.println("\n\nC)");
		for(int i=sinDuplicados.toArray().length-1; i>=0; i--) {
			System.out.println(sinDuplicados.toArray()[i]);
		}
		
		//d)Utilizando la interfaz List, solicítale al usuario los valores necesarios para mostrar una sublista de la
		//colección sin duplicados del apartado 2. Ejemplo: si el usuario introduce 3 y 5, se muestran los
		//exámenes de Sistemas Informáticos, Entornos de Desarrollo y Lenguaje de Marcas.
		System.out.println("\n\nD)");
		List<Examen> lista2 = new ArrayList<>(sinDuplicados);
		System.out.println("Introduce el primer examen que quieres ver: ");
		num1 = readNumberInRange(1, lista2.size(), Limit.MAX_MIN_INCLUDED)-1;
		System.out.println("Introduce el último examen que quieres ver: ");
		num2 = readNumberInRange(num1, lista2.size(), Limit.MAX_MIN_INCLUDED)-1;
		
		for(int i=num1; i<=num2; i++) {
			System.out.println(lista2.get(i).toString());
		}
		
		//e) Inserta los exámenes en un árbol. Utilizando la interfaz Comparable, ordena los exámenes en el
		//árbol por órden ascendente de asignatura, fecha y hora de inicio en este órden. Es decir, si la
		//asignatura es la misma, entonces ordena por fecha, y si la fecha también es la misma, entonces
		//ordena por hora. El primer examen será el de Base de Datos que empieza a las 08:15 y el último
		//será el de Sistemas Informáticos.
		Set<Examen> arbol = new TreeSet<>(sinDuplicados);
		System.out.println("\n\nE)");
		for(Examen e : arbol) {
			System.out.println(e.toString());
		}
		
		//f)Inserta los exámenes en otro árbol pero esta vez utilizando la interfaz Comparator de manera
		//anónima. En dicho árbol, el órden será por órden descendente de fecha y hora de inicio en este
		//órden. El primer examen será el de Sistemas Informáticos y el último será el de FOL.
		Set<Examen> arbolComparator = new TreeSet<>(new Comparator<Examen>() {
			public int compare(Examen e1, Examen e2) {
				int comparacion;
				comparacion = e2.getFecha().compareTo(e1.getFecha());
				if(comparacion == 0) {
					comparacion = e2.getHoraInicio().compareTo(e1.getHoraInicio());
				}
				return comparacion;
			}
		});	
		arbolComparator.addAll(sinDuplicados);
		
		System.out.println("\n\nF)");
		for(Examen e : arbolComparator) {
			System.out.println(e.toString());
		}
		
		//g) Hacer el apartado anterior con lambda.
		Set<Examen> arbolLambda = new TreeSet<>((e1, e2) -> (e2.getFecha().compareTo(e1.getFecha())==0)?
				e2.getHoraInicio().compareTo(e1.getHoraInicio()):e2.getFecha().compareTo(e1.getFecha()));
		arbolLambda.addAll(sinDuplicados);
		
		System.out.println("\n\nG)");
		for(Examen e : arbolLambda) {
			System.out.println(e.toString());
		}
		
		//h) Inserta los exámenes en un mapa utilizando como clave del mapa el campo clave de los exámenes.
		//Utilizar un mapa que respete el órden de inserción. Mostrar el contenido del mapa.
		Map<Clave, Examen> mapa = new LinkedHashMap<>();
		for(Examen e : lista) {
			mapa.put(e.getClave(), e);
		}
		
		System.out.println("\n\nH)");
		for(Examen e : mapa.values()) {
			System.out.println(e.toString());
		}
 		
		//i)Inserta los exámenes en un mapa ordenado utilizando como clave del mapa el campo clave de los
		//exámenes. Mostrar el contenido del mapa ordenado.
		Map<Clave, Examen> mapaOrdenado = new TreeMap<>(new Comparator<Clave>() {
			public int compare(Clave c1, Clave c2) {
				int comparacion;
				comparacion = c1.getDiaExamen().compareTo(c2.getDiaExamen());
				if(comparacion == 0) {
					comparacion = c1.getHoraExamen().compareTo(c2.getHoraExamen());
				}
				return comparacion;
			}
		});
		for(Examen e : lista) {
			mapaOrdenado.put(e.getClave(), e);
		}
		
		System.out.println("\n\nI)");
		for(Examen e : mapaOrdenado.values()) {
			System.out.println(e.toString());
		}
	}
}
