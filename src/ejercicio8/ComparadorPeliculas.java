package ejercicio8;

import java.util.Comparator;

public class ComparadorPeliculas  implements Comparator<Pelicula>{

	public int compare(Pelicula p1, Pelicula p2) {
		int comparacion = p1.getDiasEstreno().compareTo(p2.getDiasEstreno());
		if(comparacion == 0) {
			return p1.getNombre().compareToIgnoreCase(p2.getNombre());
		}
		return comparacion;

	}

}
