package bin.modelo;

public class Cama {
	// Atributos//
	private String tamaño;
	private int capacidad;
	private boolean cabenadultos;

	// Constructor//
	public Cama(String tamaño) {
		this.tamaño = tamaño;
		if(tamaño.equals("kingsize")) {
			this.capacidad= 3; 
			this.cabenadultos = true; 
		}
		else if(tamaño.equals("queensize")) {
			this.capacidad= 3; 
			this.cabenadultos = true; 
		}
		else if(tamaño.equals("semidoble")) {
			this.capacidad= 2; 
			this.cabenadultos = true; 
		}
		else if(tamaño.equals("doble")) {
			this.capacidad= 2; 
			this.cabenadultos = true; 
		}
		else if(tamaño.equals("sencilla")) {
			this.capacidad= 1; 
			this.cabenadultos = false; 
		}
		else if(tamaño.equals("infantil")) {
			this.capacidad= 1; 
			this.cabenadultos = false; 
		}
		
		
	}
}
