package bin.modelo;
import java.util.HashMap;
import java.util.Map;

public class Restaurante {
	//Atributos//
	private String ubicacion;
	private String dias;
	private String horario;
	private Map<String,Bebida> bebidas;
	private Map<String,Plato> platos;
	//Constructor//
	public Restaurante() {
	this.ubicacion="plaza central";
	this.dias="lunes-sabado";
	this.horario="8:00-20:00";
	this.bebidas= new HashMap<String,Bebida>();
	this.platos= new HashMap<String,Plato>();
	}
	
	//Bebidas//
	public Map<String,Bebida> getBebidas() {
		return bebidas;
	}
	public void setBebidas(Map<String,Bebida> bebidas) {
		this.bebidas = bebidas;
	}
	
	//Platos
	public Map<String,Plato> getPlatos() {
		return platos;
	}
	public void setPlatos(Map<String,Plato> platos) {
		this.platos = platos;
	}

}
