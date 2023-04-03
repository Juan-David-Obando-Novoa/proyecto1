package bin.modelo;

import java.util.ArrayList;
import java.util.Map;

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
		for(int i = 0; i < camas.length; i++) {
		    String cama = camas[i];
		    if(cama.equals("kingsize")) {
				this.capacidadadulto += 3; 
			}
			else if(cama.equals("queensize")) {
				this.capacidadadulto += 3; 
			}
			else if(cama.equals("semidoble")) {
				this.capacidadadulto += 2;  
			}
			else if(cama.equals("doble")) {
				this.capacidadadulto += 2;  
			}
			else if(cama.equals("sencilla")) {
				this.capacidadadulto += 1; 
			}
			else if(cama.equals("infantilDoble")) {
				this.capacidadniños += 2; 
			}
			else if(cama.equals("infantil")) {
				this.capacidadniños += 1; 
			}
		}
		

	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

public String getIdentificador() {
	return identificador;
}

public void setIdentificador(String identificador) {
	this.identificador = identificador;
}

public String getTipoHabitacion() {
	return tipoHabitacion;
}

public void setTipoHabitacion(String tipoHabitacion) {
	this.tipoHabitacion = tipoHabitacion;
}

public String getNumerocamas() {
	return numerocamas;
}

public void setNumerocamas(String numerocamas) {
	this.numerocamas = numerocamas;
}

public String[] getCamas() {
	return camas;
}

public void setCamas(String[] camas) {
	this.camas = camas;
}

public String getUbicacion() {
	return ubicacion;
}

public void setUbicacion(String ubicacion) {
	this.ubicacion = ubicacion;
}

public int getCapacidadadulto() {
	return capacidadadulto;
}

public void setCapacidadadulto(int capacidadadulto) {
	this.capacidadadulto = capacidadadulto;
}

public int getCapacidadniños() {
	return capacidadniños;
}

public void setCapacidadniños(int capacidadniños) {
	this.capacidadniños = capacidadniños;
}

public Tarifa getTarifa() {
	return tarifa;
}

public void setTarifa(Tarifa tarifa) {
	this.tarifa = tarifa;
}

public String getFechaInicialTarifa() {
	return fechaInicialTarifa;
}

public void setFechaInicialTarifa(String fechaInicialTarifa) {
	this.fechaInicialTarifa = fechaInicialTarifa;
}

public String getFechaFinalTarifa() {
	return fechaFinalTarifa;
}

public void setFechaFinalTarifa(String fechaFinalTarifa) {
	this.fechaFinalTarifa = fechaFinalTarifa;
}

public String getDiasTarifa() {
	return diasTarifa;
}

public void setDiasTarifa(String diasTarifa) {
	this.diasTarifa = diasTarifa;
}

public boolean isBalcon() {
	return balcon;
}

public void setBalcon(boolean balcon) {
	this.balcon = balcon;
}

public boolean isVistas() {
	return vistas;
}

public void setVistas(boolean vistas) {
	this.vistas = vistas;
}

public boolean isCocina() {
	return cocina;
}

public void setCocina(boolean cocina) {
	this.cocina = cocina;
}

}
