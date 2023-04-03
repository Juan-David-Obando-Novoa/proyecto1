package bin.modelo;

public class Producto {
	//Atributos//
	protected String nombre;
	protected int precio;
	private String[] disponible;
	private String[] ubicacion;
	
	//Concstructor//
	public Producto(String nombre, int precio, String[] disponible, String[] ubicacion) {
	this.nombre=nombre;
	this.precio=precio;
	this.disponible=disponible;
	this.ubicacion=ubicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String[] getDisponible() {
		return disponible;
	}

	public void setDisponible(String[] disponible) {
		this.disponible = disponible;
	}

	public String[] getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String[] ubicacion) {
		this.ubicacion = ubicacion;
	}
	
}
