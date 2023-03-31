package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.*;
import java.util.Scanner;
import java.util.Set;

import logica.Habitacion;
import logica.Hotel;
import logica.Restaurante;
import logica.Servicio;
import logica.Bebida;
import logica.Factura;

public class Consola {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Consola consola = new Consola();
		consola.ejecutarAplicacion();

	}

	public void mostrarMenu() {
		System.out.println("Indique el tipo de usuario\n");
		System.out.println("1. Administrador");
		System.out.println("2. Empleado");
		System.out.println("3. Recepcionista");

		System.out.println("4. Salir de la aplicacion");

	}

	public void opcionesAdmin() {
		System.out.println("Indique que quiere hacer como administrador\n");
		System.out.println("1. CargarHabitaciones");
		System.out.println("2. CambiarTarifa");
		System.out.println("3. CargarServicios");
		System.out.println("4. CambiarTarifaServicios");
		System.out.println("5. Salir de funciones de admin");

	}

	public void opcionesEmpleado() {
		System.out.println("Indique que quiere hacer como empleado\n");
		System.out.println("1.CrearFactura");
		System.out.println("2. Salir de funciones de empleado");

	}

	public void opcionesRecepcionista() {

		System.out.println("Indique que quiere hacer como recepcionista\n");
		System.out.println("1. CheckIn");
		System.out.println("2. CheckOut");
		System.out.println("3. VerificarDisponibilidad");
		System.out.println("4. CrearReservas");
		System.out.println("5. Salir de funciones de recepcionista");

	}

	public void ejecutarAplicacion() throws FileNotFoundException {

		boolean continuar = true;
		while (continuar) {
			try {
				mostrarMenu();
				Hotel hotelito = new Hotel();
				Restaurante restaurantico = new Restaurante();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));

				if (opcion_seleccionada == 1) {
					boolean continuar1 = true;
					while (continuar1) {
					
						try {

						opcionesAdmin();

						int opcion_admin = Integer.parseInt(input("Por favor seleccione una opción"));

						// AQUÍ VAN LOS REQURIMIENTOS

						if (opcion_admin == 1) {
							hotelito.loadhabitaciones("data\\Habitaciones.txt");
							
							ArrayList<Habitacion> habitaciones = hotelito.getHabitaciones();
							
							for (Habitacion habitacion : habitaciones) {
								System.out.println(habitacion.toString());
							}
						} else if (opcion_admin == 2) {
							
						boolean error = true;
						while(error) {
						String tipohabitacion = input("Por favor ingrese el tipo de habitacion que desea cambiar(Ej:suit,estandar,doubleSuite)");
						int tarifa = Integer.parseInt(input("Por favor ingrese la tarifa(Ej: un numero)"));
						String fecha_inicial = input("Por favor ingrese la fecha inicial en la que aplicar la factura (Ej: 29/03/2023)");
						String fecha_final = input("Por favor ingrese la fecha final en la que aplicar la factura(Ej: 30/03/2023)");
						try {
						hotelito.cambiartarifas(tipohabitacion, tarifa, fecha_inicial, fecha_final);
						error = false;

						}catch(IllegalArgumentException e) {
						System.out.println("Asegurese de poner todo en el formato adecuado");
						}
						}
						
						} else if (opcion_admin == 3) {
							hotelito.cargarplatos("data\\platos.txt");
							hotelito.cargarbebidas("data\\bebidas.txt");
							hotelito.cargarservicios("data\\servicios.txt");
							
							
						} else if (opcion_admin == 4) {
							System.out.println("Eliga cual de los siguientes servicios desea modificar");
							System.out.println("1. Servicios del hotel");
							System.out.println("2. Platos del restaurante");
							System.out.println("3. Bebeidas del restaurante");
							int modificar=Integer.parseInt(input("Por favor seleccione una opción"));
							if (modificar==1) {
								System.out.println("Estos son los servicios del hotel");
								
							}
							else if(modificar==2) {
								System.out.println("Estos son las bebidas del hotel");
								int contador = 1;
								
								
							}
							else if(modificar==3) {
								System.out.println("Estos son los platos del hotel");
							}

						}

						else if (opcion_admin == 5) {
							System.out.println("Saliendo de admin ...");
							continuar1 = false;
						}
						
					} catch (NumberFormatException e) {
						System.out.println("Debe seleccionar uno de los números de las opciones.");
					}
					}
					}
				

				else if (opcion_seleccionada == 2) {
					boolean continuar2 = true;
					while (continuar2) {
						try {
							opcionesRecepcionista();

							int opcion_Recepcionosta = Integer.parseInt(input("Por favor seleccione una opción"));

							// AQUÍ VAN LOS REQURIMIENTOS

							if (opcion_Recepcionosta == 1) {

							} else if (opcion_Recepcionosta == 2) {

							} else if (opcion_Recepcionosta == 3) {

							} else if (opcion_Recepcionosta == 4) {

							}

							else if (opcion_Recepcionosta == 5) {
								System.out.println("Saliendo de recepcionista ...");
								continuar2 = false;
							}
						} catch (NumberFormatException e) {
							System.out.println("Debe seleccionar uno de los números de las opciones.");
						}
					}
				}

				else if (opcion_seleccionada == 3) {
					boolean continuar3 = true;
					while (continuar3) {
						try {

							opcionesEmpleado();

							int opcion_empleado = Integer.parseInt(input("Por favor seleccione una opción"));

							// AQUÍ VAN LOS REQURIMIENTOS

							if (opcion_empleado == 1) {
								Factura nuevafactura= new Factura();
								Map<String, Servicio> servicios=hotelito.getServicios();
								Set<String> nombresServicios= servicios.keySet();
								System.out.println("Cual de los siguientes servicios desea agregar a la factura?");
								for (String nombre:nombresServicios) {
									System.out.println(nombre);
								}

							}

							else if (opcion_empleado == 5) {
								System.out.println("Saliendo de empelado ...");
								continuar3 = false;
							}
						} catch (NumberFormatException e) {
							System.out.println("Debe seleccionar uno de los números de las opciones.");
						}
					}
				}

				if (opcion_seleccionada == 4) {
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				} else {
					System.out.println("Por favor seleccione una opción válida.");
				}
			} catch (NumberFormatException e) {
				System.out.println(e);
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}

	public String input(String mensaje) {
		try {
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} catch (IOException e) {
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
}
