package bin.modelo;
import java.util.ArrayList;



public class Huesped {
	//Atributos//
	private String nombre;
	private int edad;
	private int documentoIdentidad;
	private String correo;
	private int celular;
	private int cantidadAdultos;
	private int cantidadInfantes;
	private ArrayList<Acompañante> acompañantes;
	private ArrayList<String> identificadoresHabitaciones;
	private ArrayList<Factura> consumosGrupo;
	
	//Constructor//
	public Huesped(String nombre, int edad, int numeroI, String correo, int celular) {
	this.nombre=nombre;
	this.edad=edad;
	this.documentoIdentidad=numeroI;
	this.cantidadAdultos=1;
	this.cantidadInfantes=0;
	this.correo=correo;
	this.celular=celular;
	this.acompañantes=new ArrayList<Acompañante>();
	this.consumosGrupo=new ArrayList<Factura>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	public void setDocumentoIdentidad(int documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public ArrayList<Acompañante> getAcompañantes() {
		return acompañantes;
	}

	public void setAcompañantes(ArrayList<Acompañante> acompañantes) {
		this.acompañantes = acompañantes;
	}

	public ArrayList<String> getIdentificadoresHabitaciones() {
		return identificadoresHabitaciones;
	}

	public void setIdentificadoresHabitaciones(ArrayList<String> identificadoresHabitaciones) {
		this.identificadoresHabitaciones = identificadoresHabitaciones;
	}

	public ArrayList<Factura> getConsumosGrupo() {
		return consumosGrupo;
	}

	public void setConsumosGrupo(ArrayList<Factura> consumosGrupo) {
		this.consumosGrupo = consumosGrupo;
	}

	public int getCantidadAdultos() {
		return cantidadAdultos;
	}

	public void setCantidadAdultos(int cantidadAdultos) {
		this.cantidadAdultos = cantidadAdultos;
	}

	public int getCantidadInfantes() {
		return cantidadInfantes;
	}

	public void setCantidadInfantes(int cantidadInfantes) {
		this.cantidadInfantes = cantidadInfantes;
	}
	
}
