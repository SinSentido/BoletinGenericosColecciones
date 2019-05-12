package ejercicio4;

import static keyboard.Keyboard.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Menu {
	List<Float> lista = new ArrayList<>();
	int firstPosition=0, lastPosition;
	int position = 0;
	
	public Menu() {
		lista.add(1f);
		lista.add(1.5f);
		lista.add(2f);
		lista.add(2.5f);
		lista.add(3f);
		calcularUltimaPosicion();
	}
	
	public void runMenu() {
		int opcion;
		do {
			showMenu();
			opcion = readNumberInRange(1,4, Limit.MAX_MIN_INCLUDED);
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
			}
		}while(opcion != 4);
	}

	private void showMenu() {
		System.out.printf("MENU DE LA LISTA CIRCULAR%n"
				+ "1.Mostrar la lista%n"
				+ "2.Mostrar siguiente%n"
				+ "3.Eliminar último mostrado%n"
				+ "4.Salir%n");
	}
	
	private void opcion1() {
		for(Float e: lista) {
			System.out.println(e);
		}
	}
	
	private void opcion2() {
		if(position > lastPosition) {
			position = 0;
		}
		System.out.printf("%.2f%n", lista.get(position));
		position++;
	}
	
	private void opcion3() {
		if(position == 0) {
			lista.remove(lastPosition);
			position--;
		}
		else {
			lista.remove(position-1);
			position--;
		}
		calcularUltimaPosicion();
	}
	
	private void calcularUltimaPosicion() {
		lastPosition = lista.size()-1;
	}
}
	

