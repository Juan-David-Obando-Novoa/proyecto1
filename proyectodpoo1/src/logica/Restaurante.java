package logica;

import java.util.ArrayList;

public class Restaurante {
	//Atributos//
	private String ubicacion;
	private String dias;
	private String horario;
	private ArrayList<Bebida> bebidas;
	private ArrayList<Plato> platos;
	//Constructor//
	public Restaurante() {
	this.ubicacion="plaza central";
	this.dias="lunes-sabado";
	this.horario="8:00-20:00";
	this.bebidas= new ArrayList<Bebida>();
	this.platos= new ArrayList<Plato>();
	}
	public ArrayList<Bebida> getBebidas() {
		return bebidas;
	}
	public void setBebidas(ArrayList<Bebida> bebidas) {
		this.bebidas = bebidas;
	}
	public ArrayList<Plato> getPlatos() {
		return platos;
	}
	public void setPlatos(ArrayList<Plato> platos) {
		this.platos = platos;
	}

}
