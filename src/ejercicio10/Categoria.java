package ejercicio10;

public enum Categoria {
	JEFE('J'), ENCARGADO('E'), EMPLEADO('D');
	
	private Character codigo;
	int contador;
	
	Categoria(Character codigo) {
		this.codigo = codigo;
	}
	
	public Character getCodigo() {
		return codigo;
	}
}
