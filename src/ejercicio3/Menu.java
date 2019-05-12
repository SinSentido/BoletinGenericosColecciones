package ejercicio3;

import static keyboard.Keyboard.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Menu {
	List<String> listaCadenas;
	Iterator<String> it;
	
	public Menu() {
		listaCadenas = new ArrayList<>();
	}
	
	public void runMenu() {
		int opcion = 0;
		do {
			showMenu();
			opcion = readNumberInRange(1,7, Limit.MAX_MIN_INCLUDED);
			switch(opcion) {
			case 1:
				opcion1();
				break;
			case 2:
				opcion2();
				break;
			case 3:
				opcion3();
				break;
			case 4:
				opcion4();
				break;
			case 5:
				opcion5();
				break;
			case 6:
				opcion6();
				break;
			}
		}while(opcion != 7);
	}
	
	private void showMenu() {
		System.out.printf("MENU DE LA LISTA %n"
				+ "1.Nueva lista%n"
				+ "2.Número de cadenas%n"
				+ "3.Añadir cadena%n"
				+ "4.Eliminar cadena%n"
				+ "5.Contiene cadena%n"
				+ "6.Mostrar lista entera%n"
				+ "7. Salir%n");
	}
	
	private void opcion1() {
		listaCadenas.clear();
	}
	
	private void opcion2() {
		int numCadenas = 0;
		for(String c : listaCadenas) {
			numCadenas++;
		}
		System.out.printf("En la lista hay %d cadenas%n", numCadenas);
	}
	
	private void opcion3() {
		String cadena;
		
		System.out.printf("Introduce una cadena para agregar a la lista:%n");
		cadena = readString();
		
		listaCadenas.add(cadena);	
	}
	
	private void opcion4() {
		String cadena;
		
		System.out.printf("Introduce una cadena para eliminar de la lista:%n");
		cadena = readString();
		
		listaCadenas.remove(cadena);
	}
	
	private void opcion5() {
		it = listaCadenas.iterator();
		String cadena;
		boolean salir = false;
		
		System.out.printf("Introduce la cadena que quieres buscar en la lista:%n");
		cadena = readString();
		
		while(it.hasNext() && !salir) {
			if(it.next().equals(cadena)) {
				salir = true;
			}
		}
		if(salir) {
			System.out.println("La palabra se encuentra en la lista");
		}
		else {
			System.out.println("La palabra no se encuentra en la lista");
		}
	}
	
	private void opcion6() {
		for(String e : listaCadenas) {
			System.out.printf("%s%n", e);
		}
	}
}
