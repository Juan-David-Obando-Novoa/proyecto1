package bin.modelo;

import bin.modelo.Producto;

public class Bebida extends Producto {
	// Atributos//
	// Constructor//
	public Bebida(String nombre, int precio, String[] disponible, String[] ubicacion) {
		super(nombre, precio, disponible, ubicacion); 
	}

public String printBebida() {
	String respuesta=  super.nombre + "\nPreciobase: "+ super.precio + "\n"; 
	return respuesta; 
}


}
