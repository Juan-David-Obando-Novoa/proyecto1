package logica;

public class Producto {
	//Atributos//
	private String nombre;
	private double precio;
	private String[] disponible;
	private String[] ubicacion;
	
	//Concstructor//
	public Producto(String nombre, double precio, String[] disponible, String[] ubicacion) {
	this.nombre=nombre;
	this.precio=precio;
	this.disponible=disponible;
	this.ubicacion=ubicacion;
	}
}
