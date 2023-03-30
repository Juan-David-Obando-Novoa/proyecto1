package logica;

public class Servicio {
	//Atributos//
	private String nombre;
	private double precio;
	private String horario;
	private String tipoCobro;
	private String ubicacion;
	private String[] dias;
	
	//Constructor//
	public Servicio(String nombre,String ubicacion, double precio, String[] dias, String horario, String tipoCobro) {
	this.nombre=nombre;
	this.precio=precio;
	this.horario=horario;
	this.tipoCobro=tipoCobro;
	this.ubicacion=ubicacion;
	this.dias=dias;
	}
	

}
