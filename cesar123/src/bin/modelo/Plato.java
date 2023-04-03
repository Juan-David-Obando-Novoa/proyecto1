package bin.modelo;

import bin.modelo.Producto;

public class Plato extends Producto{

	
public Plato(String nombre, int precio, String[] disponible, String[] ubicacion) {
	super(nombre,precio, disponible, ubicacion); 
}
public String printPlato() {
	String respuesta=  super.nombre + "\nPreciobase: "+ super.precio + "\n"; 
	return respuesta; 
}


}