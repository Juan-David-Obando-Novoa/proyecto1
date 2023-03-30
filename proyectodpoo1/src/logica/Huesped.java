package logica;
import java.util.ArrayList;



public class Huesped {
	//Atributos//
	private String nombre;
	private int edad;
	private int documentoIdentidad;
	private String correo;
	private int celular;
	private ArrayList<Acompañante> acompañantes;
	private ArrayList<String> identificadoresHabitaciones;
	private ArrayList<Factura> consumosGrupo;
	
	//Constructor//
	public Huesped(String nombre, int edad, int numeroI, String correo, int celular) {
	this.nombre=nombre;
	this.edad=edad;
	this.documentoIdentidad=numeroI;
	this.correo=correo;
	this.celular=celular;
	this.acompañantes=new ArrayList<Acompañante>();
	this.identificadoresHabitaciones=new ArrayList<String>();
	this.consumosGrupo=new ArrayList<Factura>();
	}
	
}
