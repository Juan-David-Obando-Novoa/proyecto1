package bin.controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import bin.modelo.Bebida;
import bin.modelo.Habitacion;
import bin.modelo.Plato;
import bin.modelo.Servicio;
import bin.modelo.Tarifa;
import bin.modelo.TipoCobro;

public class ControlDatos {
	
	
	
//Funciones del Administrador//
	//Cargar habitaciones
	
public Map<String,Habitacion> loadhabitaciones(String filename) throws FileNotFoundException {	
	File file = new File(filename);
	Scanner scanner = new Scanner(file);
	Map<String,Habitacion> habitaciones = new HashMap<>();
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
				Habitacion habitacion = new Habitacion(identificador, ubicacion, tipo,
						numerocamas,  tarifa, fechainicial, fechaFinal, Dias,  balcon,
						vistas,  cocina ,tipocamas); 
				habitaciones.put(identificador,habitacion);
		}
	scanner.close();
	return habitaciones;
		}

	//Calcular capacidad maxima//
public ArrayList<Integer> calcularCapacidadHotel(Map<String, Habitacion> habitaciones) {
	int capacidadAdultos=0;
	int capacidadNiños=0;
	ArrayList<Integer>devolver=new ArrayList();
	for(String identificador: habitaciones.keySet()) {
		Habitacion habitacion= habitaciones.get(identificador);
		capacidadAdultos+=habitacion.getCapacidadadulto();
		capacidadNiños+=habitacion.getCapacidadniños();

	}
	
	devolver.add(capacidadAdultos);
	devolver.add(capacidadNiños);
	return devolver;
}

	//Modificar tarifa de las habitaciones//

	public void cambiarTarifasHabitaciones(String tipohabitacion, int tarifa, String fechainicial, String fechafinal) {
		SimpleDateFormat feinicial = new SimpleDateFormat(fechainicial);
		SimpleDateFormat fefinal = new SimpleDateFormat(fechafinal);
		if(tipohabitacion.equals("suit")) {
			Tarifa.precioSuit=tarifa;
			Tarifa.fechainicialsuit=feinicial;
			Tarifa.fechafinalsuit=fefinal;
		}
		else if (tipohabitacion.equals("estandar")) {
			Tarifa.precioEstandar=tarifa;
			Tarifa.fechainicialestandar=feinicial;
			Tarifa.fechafinalestandar=fefinal;
		}
		else if(tipohabitacion.equals("DoubleSuite")) {
			Tarifa.precioDoubleSuite=tarifa;
			Tarifa.fechainicialDoubleSuite=feinicial;
			Tarifa.fechafinalDoubleSuite=fefinal;
		}
		else {
			System.out.print("Escribe un tipo de habitacion valida \n");
		}

		System.out.print(Tarifa.precioEstandar);
		}

	//Funciones referentes al restaurante//

	//Cargar las bebidas//
	public Map<String,Bebida> cargarbebidas(String filename) throws FileNotFoundException {	
	    File file = new File(filename);
	    Scanner scanner = new Scanner(file);
	    Map<String,Bebida> bebidas = new HashMap<>();
	    while (scanner.hasNextLine()) {
	        String line = scanner.nextLine();

	        String[] partes = line.split(";"); 
	        if (partes.length >= 4) {
	        String nombre = partes[0];
	        int precio = Integer.parseInt(partes[1]);
	        		
	        String[] disponible = partes[2].split(",");
	        String[] ubicacion = partes[3].split(",");
	      
	        
	        Bebida bebida = new Bebida(nombre, precio, disponible, ubicacion); 
	        
	        bebidas.put(nombre,bebida);
	        
	        
	        
	        //Preguntar a obando por esto de abajo//
	        
	        
	        
	        }else {
	        	System.out.println(partes.length);
	        	System.out.println(partes[0]);
	        }
	    }
	    scanner.close();
	    return bebidas;
	}

	//Cargar Platos//
	public Map<String,Plato> cargarplatos(String filename) throws FileNotFoundException {	
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		Map<String,Plato> platos = new HashMap<>();			
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();         
			String[] partes = line.split(";");           
			String nombre = partes[0];
			int precio = Integer.parseInt(partes[1]);	
			String[] disponible = partes[2].split(",");
			String[] ubicacion = partes[3].split(",");            
			Plato plato = new Plato(nombre, precio, disponible, ubicacion); 	            
			platos.put(nombre,plato);
			}
		scanner.close();
		return platos;
	}

	//Cargar Servicios//
	public Map<String, Servicio> cargarservicios(String filename) throws FileNotFoundException {	
		File file = new File(filename);
		Map<String, Servicio> servicios = new HashMap<String, Servicio>();
		Scanner scanner = new Scanner(file);
					
					
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			System.out.println(line);
			            
			String[] partes = line.split(";"); 
			            
			String nombre = partes[0];
			String ubicacion = partes[1];
			
			double precio = Double.parseDouble(partes[2]);
			String[] dias = partes[3].split(",");
			String horario = partes[4];
			if(partes[5].equals("grupo")) {
				TipoCobro tipoCobro= TipoCobro.grupo;
				
			} else if(partes[5].equals("persona")) {
				TipoCobro tipoCobro= TipoCobro.persona;
				
			} else if(partes[5].equals("habitacion")) {
				TipoCobro tipoCobro= TipoCobro.habitacion;
			}
			          
			            
			Servicio servicio = new Servicio(nombre, ubicacion, precio, dias, horario, tipoCobro); 
			            
			servicios.put(nombre,servicio);        
			}     
			System.out.print("los servicios son ");
			for(String nombre :servicios.keySet()) {
				System.out.println(nombre);
			}
			scanner.close();
			return servicios;
	}	

	
	
//Funciones del Recepcionista//

public ArrayList<String> llenarHabitaciones(int adultos, int niños, Map<String,Habitacion> habitaciones) {
ArrayList<String> respuesta= new ArrayList<String>();
	for(String identificador: habitaciones.keySet()) {
	Habitacion habitacion=habitaciones.get(identificador);
	if (!habitacion.isOcupada() && (adultos>0|| niños>0)){
		int capacidadAdultos=habitacion.getCapacidadadulto();
		int capacidadNiños=habitacion.getCapacidadniños();
		adultos-=capacidadAdultos;
		niños-=capacidadNiños;
		habitacion.setOcupada(true);
		respuesta.add(identificador);
	}
	}
	return respuesta;
	}

//public crearGrupo()
	
	
	
	
	
	
	
	
	
	
}
