package logica;

import java.util.ArrayList;

import logica.Servicio;

public class Factura {
	//Atributos//
	private ArrayList<Servicio> servicios;
	private int total;
	// private formaPago;
	
	//Constructor//
	public Factura() {
	this.servicios= new ArrayList<Servicio>();
	this.total=0;
	}

	public ArrayList<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<Servicio> servicios) {
		this.servicios = servicios;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
