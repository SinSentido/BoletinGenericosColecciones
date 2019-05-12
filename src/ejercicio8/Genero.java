package ejercicio8;

public enum Genero {
	COMEDIA('C'), FICCION('F'), TERROR('T');
	
	private char codigo;
	int terror = 0, comedia = 0, ficcion = 0;
	
	//Constructor
	Genero(char codigo){
		this.codigo = codigo;
	}
	
	//Metodo get del codigo del genero
	public char getCodigo() {
		return codigo;
	}

}
