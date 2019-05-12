package ejercicio10;

public class Clave {
	private Categoria categoria;
	Integer n;
	
	public Clave(Categoria categoria, Integer n) {
		this.categoria = categoria;
		this.n = n;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public Integer getN() {
		return n;
	}
	
	public boolean equals(Object o) {
		boolean sonIguales = false;
		if(o instanceof Clave) {
			Clave c = (Clave)o;
			sonIguales = categoria.getCodigo().equals(c.categoria.getCodigo()) && n == c.getN();
		}
		return sonIguales;
	}
	
	public int hashCode() {
		return categoria.hashCode()+n.hashCode();
	}
	
	public String toString() {
		return String.format("%s%d", categoria.getCodigo(), n);
	}
}
