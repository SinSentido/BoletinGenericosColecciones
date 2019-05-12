package ejercicio8;

public class Clave {
	private Genero genero;
	private Integer n;
	
	public Clave(Genero genero) {
		this.genero = genero;
		if(genero == Genero.TERROR) {
			n = ++genero.terror;
		}
		else if(genero == Genero.COMEDIA) {
			n = ++genero.comedia;
		}
		else if(genero == Genero.FICCION) {
			n = ++genero.ficcion;
		}
	}
	
	public Genero getGenero() {
		return genero;
	}
	
	public Integer getN() {
		return n;
	}
	
	public String toString() {	
		return String.format("%c%d", genero.getCodigo(), n);
	}
}
