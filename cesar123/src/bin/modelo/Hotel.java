package bin.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import bin.modelo.Habitacion;
import bin.modelo.Huesped;
import bin.modelo.Servicio;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap; 


public class Hotel {
	//Atributos//
	private Map<String,Habitacion> habitaciones;
	private int capacidadMaxAdultos;
	private int capacidadMaxNiños;
	private int capacidadActualAdultos;
	private int capacidadActualNiños;
	private  Map<String, Reserva> reservas= new HashMap<>();
	private  Map<String,Huesped> grupos= new HashMap<>();
	private  Map<String, Servicio> servicios;
	private  Map<String,String> administradores= new HashMap<>();
	private  Map<String,String> recepcionistas= new HashMap<>();
	private  Map<String,String> empleados= new HashMap<>();
	private  Restaurante restaurante = new Restaurante();
	
	//Constructor//
	public Hotel(){
		this.administradores.put("j", "1");
		this.administradores.put("Cesar", "202214746");
		this.recepcionistas.put("j", "1");
		this.recepcionistas.put("Eduardo", "1234");
		this.empleados.put("j", "1");
		this.empleados.put("Roberto", "1234");
		this.capacidadActualAdultos=0;
		this.capacidadActualNiños=0;
		this.capacidadMaxAdultos=0;
		this.capacidadMaxNiños=0;

	}

	public Map<String, Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Map<String, Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Map<String, Huesped> getGrupos() {
		return grupos;
	}

	public void setGrupos(Map<String, Huesped> grupos) {
		this.grupos = grupos;
	}

	public Map<String, Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(Map<String, Servicio> servicios) {
		this.servicios = servicios;
	}

	public Map<String, String> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(Map<String, String> administradores) {
		this.administradores = administradores;
	}

	public Map<String, String> getRecepcionistas() {
		return recepcionistas;
	}

	public void setRecepcionistas(Map<String, String> recepcionistas) {
		this.recepcionistas = recepcionistas;
	}

	public Map<String, String> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Map<String, String> empleados) {
		this.empleados = empleados;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public int getCapacidadMaxAdultos() {
		return capacidadMaxAdultos;
	}

	public void setCapacidadMaxAdultos(int capacidadMaxAdultos) {
		this.capacidadMaxAdultos = capacidadMaxAdultos;
	}

	public int getCapacidadMaxNiños() {
		return capacidadMaxNiños;
	}

	public void setCapacidadMaxNiños(int capacidadMaxNiños) {
		this.capacidadMaxNiños = capacidadMaxNiños;
	}

	public int getCapacidadActualAdultos() {
		return capacidadActualAdultos;
	}

	public void setCapacidadActualAdultos(int capacidadActualAdultos) {
		this.capacidadActualAdultos = capacidadActualAdultos;
	}

	public int getCapacidadActualNiños() {
		return capacidadActualNiños;
	}

	public void setCapacidadActualNiños(int capacidadActualNiños) {
		this.capacidadActualNiños = capacidadActualNiños;
	}

	public Map<String, Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Map<String, Reserva> reservas) {
		this.reservas = reservas;
	}

}





	

