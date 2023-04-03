package bin.modelo;

import java.util.ArrayList;

import bin.modelo.Servicio;

public class Factura {
	//Atributos//
	private ArrayList<Servicio> servicios;
	private double total;
	// private formaPago;
	
	//Constructor//
	public Factura() {
	this.servicios= new ArrayList<Servicio>();
	this.total=0;
	}

	//Getter/Setter
	public ArrayList<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<Servicio> servicios) {
		this.servicios = servicios;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	//Metodos//
}
