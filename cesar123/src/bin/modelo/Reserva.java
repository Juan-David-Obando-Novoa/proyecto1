package bin.modelo;

import java.text.SimpleDateFormat;

public class Reserva {
	//Atributos//
	private Huesped grupo;
	private SimpleDateFormat fechaLlegada;
	private SimpleDateFormat fechaSalida;
	private SimpleDateFormat fechaMaxCancelacion;
	//Constructor//
	public Reserva(Huesped grupo, SimpleDateFormat llegada, SimpleDateFormat salida, SimpleDateFormat max) {
	this.grupo=grupo;
	this.fechaLlegada=llegada;
	this.fechaSalida=salida;
	this.fechaMaxCancelacion=max;
	}
	public Huesped getGrupo() {
		return grupo;
	}
	public void setGrupo(Huesped grupo) {
		this.grupo = grupo;
	}
	public SimpleDateFormat getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(SimpleDateFormat fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public SimpleDateFormat getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(SimpleDateFormat fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public SimpleDateFormat getFechaMaxCancelacion() {
		return fechaMaxCancelacion;
	}
	public void setFechaMaxCancelacion(SimpleDateFormat fechaMaxCancelacion) {
		this.fechaMaxCancelacion = fechaMaxCancelacion;
	}
	
	
	
}
