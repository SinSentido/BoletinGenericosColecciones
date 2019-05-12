package ejercicio6;

import java.util.List;
import java.util.LinkedList;
import static keyboard.Keyboard.*;

public class Menu {
	
	LinkedList<Byte> lista = new LinkedList<>();
	
	
	public void runMenu() {
		int opcion;
		do {
			showMenu();
			opcion = readNumberInRange(1,6,Limit.MAX_MIN_INCLUDED);
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
			}
		}while(opcion != 6);
	}
	
	private void showMenu() {
		System.out.printf("MENU PILA%n"
				+ "1.Nueva pila%n"
				+ "2.Consultar elemento%n"
				+ "3.Añadir elemento%n"
				+ "4.Eliminar elemento%n"
				+ "5.Consultar toda la pila%n"
				+ "6.Salir%n");
	}
	
	private void opcion1() {
		lista.clear();
	}
	
	private void opcion2() {
		if(lista.size() > 0) {
			System.out.printf("%d%n", lista.getLast());
		}
		else {
			System.out.printf("No hay elementos en la lista");
		}
	}
	
	private void opcion3() {
		byte numero;
		System.out.printf("Introduce un número:%n");
		numero = readByte();
		lista.add(numero);
	}
	
	private void opcion4() {
		lista.remove(lista.getLast());
	}
	
	private void opcion5() {
		for(Byte b: lista) {
			System.out.println(b);
		}
	}
}
