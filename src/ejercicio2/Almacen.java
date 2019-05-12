package ejercicio2;

import static keyboard.Keyboard.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Almacen implements Contenido{
	protected int tamañoAlmacen;
	List<Caja> listaCajas = new ArrayList<>();
	Iterator<Caja> it;
	
	public Almacen(int tamañoAlmacen) {
		this.tamañoAlmacen = tamañoAlmacen;
		Caja caja1 = new Caja("Fresas");
		Caja caja2 = new Caja("Naranjas");
		Caja caja3 = new Caja("Manzanas");
		Caja caja4 = new Caja("Platanos");
		Caja caja5 = new Caja("Kiwis");
		listaCajas.add(caja1);
		listaCajas.add(caja2);
		listaCajas.add(caja3);
		listaCajas.add(caja4);
		listaCajas.add(caja5);
		it = listaCajas.iterator();
	}
	
	@Override
	public String primerContenido() {
		return listaCajas.get(0).contenido;
	}

	@Override
	public String ultimoContenido() {
		return listaCajas.get(listaCajas.size()-1).contenido;
	}

}
