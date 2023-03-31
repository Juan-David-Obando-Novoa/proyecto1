package logica;

import logica.Producto;

public class Bebida extends Producto {
	// Atributos//
	// Constructor//
	public Bebida(String nombre, int precio, String[] disponible, String[] ubicacion) {
		super(nombre, precio, disponible, ubicacion); 
	}

public String printbebidas() {
	String respuesta=  super.nombre + "\nPreciobase: "+ super.precio + "\n"; 
	return respuesta; 
}


}
