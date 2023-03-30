package logica;

public class Reserva {
	//Atributos//
	private Huesped grupo;
	private String fechaLlegada;
	private String fechaSalida;
	private String fechaMaxCancelacion;
	//Constructor//
	public Reserva(Huesped grupo, String llegada, String salida) {
	this.grupo=grupo;
	this.fechaLlegada=llegada;
	this.fechaSalida=salida;
	this.fechaMaxCancelacion="";
	}
}
