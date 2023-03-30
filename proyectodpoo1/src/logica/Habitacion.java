package logica;

import java.util.ArrayList;

public class Habitacion {
	// Atributos//
	private String identificador;
	private String tipoHabitacion;
	private String numerocamas;
	private String[] camas;
	private String ubicacion;
	private int capacidadadulto;
	private int capacidadniños;

	private Tarifa tarifa;
	private String fechaInicialTarifa;
	private String fechaFinalTarifa;
	private String diasTarifa;
	private boolean balcon;
	private boolean vistas;
	private boolean cocina;
	private boolean ocupada;

	// Constructor
	public Habitacion(String identificador, String ubicacion, String tipo,String numerocamas, Tarifa tarifa, String fechainicial,
			String fechaFinal, String Dias, boolean balcon, boolean vistas, boolean cocina, String[] camas) {
		
		this.identificador = identificador;
		this.tipoHabitacion = tipo;
		this.camas = camas;
		for(int i = 0; i < camas.length; i++) {
		    String cama = camas[i];
		    if(cama.equals("kingsize")) {
				this.capacidadadulto += 3; 
				this.capacidadniños += 3; 
			}
			else if(cama.equals("queensize")) {
				this.capacidadadulto += 3; 
				this.capacidadniños += 3; 
			}
			else if(cama.equals("semidoble")) {
				this.capacidadadulto += 2; 
				this.capacidadniños += 2; 
			}
			else if(cama.equals("doble")) {
				this.capacidadadulto += 2; 
				this.capacidadniños += 2; 
			}
			else if(cama.equals("sencilla")) {
				this.capacidadadulto += 1; 
				this.capacidadniños += 1; 
			}
			else if(cama.equals("infantil")) {
				this.capacidadniños += 1; 
			}
		}
		this.capacidadadulto = 0;
		this.capacidadniños = 0; 
		this.ubicacion = ubicacion;
		this.fechaInicialTarifa = fechainicial;
		this.fechaFinalTarifa = fechaFinal;
		this.tarifa = tarifa;
		this.diasTarifa = Dias;
		this.balcon = balcon;
		this.vistas = vistas;
		this.cocina = cocina;
		this.ocupada = false;

	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}


}
