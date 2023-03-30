package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

import logica.Huesped;
import logica.Servicio;
import logica.Usuario;
import logica.Habitacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date; 


public class Hotel {
	//Atributos//
	private ArrayList<Habitacion> habitaciones;
	private ArrayList<Huesped> grupos;
	private ArrayList<Servicio> servicios;
	private ArrayList<Usuario> usuarios; 
	private Restaurante restaurante = new Restaurante();
	
	//Constructor//
	public Hotel(){
	}
	
	
	
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}



	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}



	public ArrayList<Servicio> getServicios() {
		return servicios;
	}



	public void setServicios(ArrayList<Servicio> servicios) {
		this.servicios = servicios;
	}



	public List<Habitacion> loadhabitaciones(String filename) throws FileNotFoundException {	
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
		
		
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            String[] partes = line.split(";"); 
            
            String identificador = partes[0];
            String ubicacion = partes[1];
            String tipo = partes[2];
            String numerocamas = partes[3];
            Tarifa tarifa = new Tarifa();
            String fechainicial = partes[4]; 
            String fechaFinal = partes[5]; 
            String Dias = partes[6]; 
            boolean balcon = partes[7].equals("t");
            boolean vistas = partes[8].equals("t");
            boolean cocina = partes[9].equals("t");
            String[] tipocamas = partes[10].split(",");
          
            System.out.println(tipocamas);
            
            Habitacion habitacion = new Habitacion(identificador, ubicacion, tipo,
            		numerocamas,  tarifa, fechainicial, fechaFinal, Dias,  balcon,
            		vistas,  cocina ,tipocamas); 
            
            habitaciones.add(habitacion);
         
          
        }
        this.habitaciones = habitaciones;
        scanner.close();
        return habitaciones;
    }
	
		public void cambiartarifas(String tipohabitacion, int tarifa, String fechainicial, String fechafinal) {
		SimpleDateFormat feinicial = new SimpleDateFormat(fechainicial);
		SimpleDateFormat fefinal = new SimpleDateFormat(fechafinal);
		if(tipohabitacion.equals("suit")) {
			Tarifa.setSuit(tarifa);
			Tarifa.setFechainicialsuit(feinicial);
			Tarifa.setFechafinalsuit(fefinal);
		}
		else if (tipohabitacion.equals("estandar")) {
			Tarifa.setEstandar(tarifa);
			Tarifa.setFechainicialestandar(feinicial);
			Tarifa.setFechafinalestandar(fefinal);
		}
		else if(tipohabitacion.equals("DoubleSuite")) {
			Tarifa.setDoubleSuite(tarifa);
			Tarifa.setFechainicialDoubleSuite(feinicial);
			Tarifa.setFechafinalDoubleSuite(fefinal);
		}
		else {
			System.out.print("Escribe un tipo de habitacion valida \n");
		}

		System.out.print(Tarifa.getEstandar());
		}
		// cargar servicios
		
		public List<Bebida> cargarbebidas(String filename) throws FileNotFoundException {	
	        File file = new File(filename);
	        Scanner scanner = new Scanner(file);
	        ArrayList<Bebida> bebidas = new ArrayList<>();
			
			
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();

	            String[] partes = line.split(";"); 
	            System.out.print(partes);
	            String nombre = partes[0];
	            double precio = Double.parseDouble(partes[1]);
	            String[] disponible = partes[2].split(",");
	            String[] ubicacion = partes[3].split(",");
	          
	            
	            Bebida bebida = new Bebida(nombre, precio, disponible, ubicacion); 
	            
	            bebidas.add(bebida);
	  
	          
	        }
	        
	        restaurante.setBebidas(bebidas);
	        
	        scanner.close();
	        return bebidas;
	    }		
		
		// cargar servicios
		
		public List<Plato> cargarplatos(String filename) throws FileNotFoundException {	
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		ArrayList<Plato> platos = new ArrayList<>();
					
					
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			            
			String[] partes = line.split(";"); 
			            
			String nombre = partes[0];
			double precio = Double.parseDouble(partes[1]);
			String[] disponible = partes[2].split(",");
			String[] ubicacion = partes[3].split(",");
			          
			            
			Plato plato = new Plato(nombre, precio, disponible, ubicacion); 
			            
			platos.add(plato);
			  
			          
			}
			        
			restaurante.setPlatos(platos);
			
			scanner.close();
			return platos;
			    }
		
		
		
		public List<Servicio> cargarservicios(String filename) throws FileNotFoundException {	
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			ArrayList<Servicio> servicios = new ArrayList<>();
						
						
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				            
				String[] partes = line.split(";"); 
				            
				String nombre = partes[0];
				String ubicacion = partes[1];
				
				double precio = Double.parseDouble(partes[2]);
				String[] dias = partes[3].split(",");
				String horario = partes[4];
				String tipoCobro = partes[5];
				          
				            
				Servicio servicio = new Servicio(nombre, ubicacion, precio, dias, horario, tipoCobro); 
				            
				servicios.add(servicio);
				  
				          
				}
				        
				this.servicios= servicios;     
				System.out.print("los servicios son "+ getServicios()); 
				scanner.close();
				return servicios;
				    }		
		
	}



	

