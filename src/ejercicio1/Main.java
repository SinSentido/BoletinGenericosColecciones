package ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main{
	public static void main(String args[]) {
		//Creación de los objetos
		Caja<String> caja1 = new Caja<>("Caja1");
		Caja<String> caja2 = new Caja<>("Caja2");
		Caja<String> caja3 = new Caja<>("Caja3");
		Caja<String> caja4 = new Caja<>("Caja4");
		Caja<String> caja5 = new Caja<>("Caja5");
		Caja<String> caja6 = new Caja<>("Caja6");
		Caja<String> caja7 = new Caja<>("Caja7");
		Caja<String> caja8 = new Caja<>("Caja8");
		Caja<String> caja9 = new Caja<>("Caja9");
		Caja<String> caja10 = new Caja<>("Caja10");
		
		//Adición de los objetos a la lista
		List<String> listaCajasStrings = new ArrayList<>();
		listaCajasStrings.add(caja1.nombreCaja);
		listaCajasStrings.add(caja2.nombreCaja);
		listaCajasStrings.add(caja3.nombreCaja);
		listaCajasStrings.add(caja4.nombreCaja);
		listaCajasStrings.add(caja5.nombreCaja);
		listaCajasStrings.add(caja6.nombreCaja);
		listaCajasStrings.add(caja7.nombreCaja);
		listaCajasStrings.add(caja8.nombreCaja);
		listaCajasStrings.add(caja9.nombreCaja);
		listaCajasStrings.add(caja10.nombreCaja);
		
		//Se recorre la lista
		Iterator<String> it = listaCajasStrings.iterator();

		
		//Creación de los objetos
		Caja<Long> caja1L = new Caja<>(1L);
		Caja<Long> caja2L = new Caja<>(2L);
		Caja<Long> caja3L = new Caja<>(3L);
		Caja<Long> caja4L = new Caja<>(4L);
		Caja<Long> caja5L = new Caja<>(5L);
		Caja<Long> caja6L = new Caja<>(6L);
		Caja<Long> caja7L = new Caja<>(7L);
		Caja<Long> caja8L = new Caja<>(8L);
		Caja<Long> caja9L = new Caja<>(9L);
		Caja<Long> caja10L = new Caja<>(10L);
		
		//Adicion de los objetos a la lista
		List<Long> listaCajasLong = new ArrayList<>();
		listaCajasLong.add(caja1L.nombreCaja);
		listaCajasLong.add(caja2L.nombreCaja);
		listaCajasLong.add(caja3L.nombreCaja);
		listaCajasLong.add(caja4L.nombreCaja);
		listaCajasLong.add(caja5L.nombreCaja);
		listaCajasLong.add(caja6L.nombreCaja);
		listaCajasLong.add(caja7L.nombreCaja);
		listaCajasLong.add(caja8L.nombreCaja);
		listaCajasLong.add(caja9L.nombreCaja);
		listaCajasLong.add(caja10L.nombreCaja);
		
		//Se recorre la lista y se suman los elementos.
		Iterator<Long> it2 = listaCajasLong.iterator();
		long total = 0;
		while(it2.hasNext()) {
			total += it2.next();
		}
		System.out.println(total);
	}
}

