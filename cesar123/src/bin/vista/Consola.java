package bin.vista;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.*;
import java.util.Scanner;
import java.util.Set;

import bin.modelo.Acompañante;
import bin.modelo.Bebida;
import bin.modelo.Plato;
import bin.modelo.Reserva;
import bin.modelo.Factura;
import bin.modelo.Habitacion;
import bin.modelo.Hotel;
import bin.modelo.Huesped;
import bin.modelo.Restaurante;
import bin.modelo.Servicio;

import bin.controlador.ControlDatos;
import bin.controlador.TipoUsuario;
import bin.controlador.Usuario;

public class Consola {
	
	private ControlDatos controlador=new ControlDatos();
	private Hotel hotelito = new Hotel();


	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Consola consola = new Consola();
		consola.ejecutarAplicacion();

	}

	public void mostrarMenu() {
		System.out.println("Indique el tipo de usuario\n");
		System.out.println("1. Administrador");
		System.out.println("2. Recepcionista");
		System.out.println("3. Empleado");

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
		System.out.println("1. CrearReservas");
		System.out.println("2. CheckIn");
		System.out.println("3. CheckOut");
		System.out.println("4. VerificarDisponibilidad");
		System.out.println("5. Salir de funciones de recepcionista");

	}

	public void ejecutarAplicacion() throws FileNotFoundException {

		boolean continuar = true;
		while (continuar) {
			try {
				mostrarMenu();
				Usuario usuario;
				boolean registrado=false;
				Restaurante restaurantico = hotelito.getRestaurante();
				
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));

				if (opcion_seleccionada == 1) {
					//Registrarse como admin//
					while (!registrado) {
						Map<String,String> administradores= hotelito.getAdministradores();
						String login= input("Digite su login de admin:");
						String password= input("Digite su contraseña de admin:");
						if(administradores.get(login).equals(password)) {
							registrado=true;
							usuario= new Usuario(login, password, TipoUsuario.Administrador);				
						}
					}
					boolean continuar1 = true;
					while (continuar1 && registrado) {
					
						try {

						opcionesAdmin();

						int opcion_admin = Integer.parseInt(input("Por favor seleccione una opción"));

						// AQUÍ VAN LOS REQURIMIENTOS

						if (opcion_admin == 1) {
							Map<String,Habitacion> habitaciones=controlador.loadhabitaciones("data\\Habitaciones.txt");
							hotelito.setHabitaciones(habitaciones);
							System.out.println(hotelito.getHabitaciones());
							for (String identificador : habitaciones.keySet()) {
								System.out.println(identificador.toString());
							ArrayList<Integer> capacidades=controlador.calcularCapacidadHotel(hotelito.getHabitaciones());
							hotelito.setCapacidadMaxAdultos(capacidades.get(0));
							hotelito.setCapacidadMaxNiños(capacidades.get(1));
							
							System.out.println(hotelito.getCapacidadMaxAdultos());
							}
						} 
						else if (opcion_admin == 2) {
							
						boolean error = true;
						while(error) {
						String tipohabitacion = input("Por favor ingrese el tipo de habitacion que desea cambiar(Ej:suit,estandar,doubleSuite)");
						int tarifa = Integer.parseInt(input("Por favor ingrese la tarifa(Ej: un numero)"));
						String fecha_inicial = input("Por favor ingrese la fecha inicial en la que aplicar la factura (Ej: 29/03/2023)");
						String fecha_final = input("Por favor ingrese la fecha final en la que aplicar la factura(Ej: 30/03/2023)");
						try {
						controlador.cambiarTarifasHabitaciones(tipohabitacion, tarifa, fecha_inicial, fecha_final);
						error = false;

						}catch(IllegalArgumentException e) {
						System.out.println("Asegurese de poner todo en el formato adecuado");
						}
						}
						
						} else if (opcion_admin == 3) {
							Map<String,Plato> platos=controlador.cargarplatos("data\\platos.txt");
							Map<String,Bebida> bebidas=controlador.cargarbebidas("data\\bebidas.txt");
							Map<String,Servicio> servicios=controlador.cargarservicios("data\\servicios.txt");
							restaurantico.setBebidas(bebidas);
							restaurantico.setPlatos(platos);
							hotelito.setServicios(servicios);
							
							
						} else if (opcion_admin == 4) {
							System.out.println("Eliga cual de los siguientes servicios desea modificar");
							System.out.println("1. Servicios del hotel");
							System.out.println("2. Bebeidas del restaurante");
							System.out.println("3. Platos del restaurante");
							int modificar=Integer.parseInt(input("Por favor seleccione una opción"));
							if (modificar==1) {
								System.out.println("Estos son los servicios del hotel");
								Map<String,Servicio> servicios = hotelito.getServicios();
								ArrayList<Servicio> listaServicios= new ArrayList<Servicio>();
								int contador= 0;
								for(String servicio: servicios.keySet()) {
									String numerito= String.valueOf(contador);
									System.out.println(numerito + ". "+ servicio);
									listaServicios.add(servicios.get(servicio));
									contador += 1;	
								}
							int servicioModificar = Integer.parseInt(input("Por favor seleccione una opción"));	
							Servicio instancia = listaServicios.get(servicioModificar);
							System.out.println(instancia);
							double nuevoPrecio = Double.parseDouble(input("por favor agrege una nueva tarifa"));	
							instancia.setPrecio(nuevoPrecio);
							System.out.println(instancia.getPrecio());
							Map<String,Servicio> servicios2 = hotelito.getServicios();
							
							}
							else if(modificar==2) {
								System.out.println("Estos son las bebidas del hotel");
								Map<String, Bebida> bebidas = restaurantico.getBebidas();
								ArrayList<Bebida> listaBebidas= new ArrayList<Bebida>();
								int contador= 0;
								for(String bebida: bebidas.keySet()) {
									String numerito= String.valueOf(contador);
									System.out.println(numerito + ". "+ bebida);
									listaBebidas.add(bebidas.get(bebida));
									contador += 1;	
								}
							int bebidaModificar = Integer.parseInt(input("Por favor seleccione una opción"));	
							Bebida instancia = listaBebidas.get(bebidaModificar);
							System.out.println(instancia);
							int nuevoPrecio = Integer.parseInt(input("por favor agrege una nueva tarifa"));	
							instancia.setPrecio(nuevoPrecio);
							System.out.print(instancia.getPrecio()); 
								
								
							}
							else if(modificar==3) {
								System.out.println("Estos son los platos del hotel");
								Map<String, Plato> platos = restaurantico.getPlatos();
								ArrayList<Plato> listaPlatos= new ArrayList<Plato>();
								int contador= 0;
								for(String plato: platos.keySet()) {
									String numerito= String.valueOf(contador);
									System.out.println(numerito + ". "+ plato);
									listaPlatos.add(platos.get(plato));
									contador += 1;	
								}
							int bebidaModificar = Integer.parseInt(input("Por favor seleccione una opción"));	
							Plato instancia = listaPlatos.get(bebidaModificar);
							System.out.println(instancia);
							int nuevoPrecio = Integer.parseInt(input("por favor agrege una nueva tarifa"));	
							instancia.setPrecio(nuevoPrecio);
							System.out.print(instancia.getPrecio()); 
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
					while (!registrado) {
						Map<String,String> recepcionistas= hotelito.getRecepcionistas();
						String login= input("Digite su login de recepcionista:");
						String password= input("Digite su contraseña de recepcionista:");
						if(recepcionistas.get(login).equals(password)) {
							registrado=true;
							usuario= new Usuario(login, password, TipoUsuario.Recepcionista);				
						}
					}
					boolean continuar2 = true;
					while (continuar2) {
						try {
							opcionesRecepcionista();

							int opcion_Recepcionosta = Integer.parseInt(input("Por favor seleccione una opción"));

							// AQUÍ VAN LOS REQURIMIENTOS

							if (opcion_Recepcionosta == 1) {
								System.out.println(hotelito.getCapacidadMaxAdultos());
								String nombre= input("Digite el nombre del anfitrión: ");
								int edad= Integer.parseInt(input("Digite la edad del anfitrión: "));
								int numeroIdentidad= Integer.parseInt(input("Digite el numero de identidad del anfitrión :"));
								String correo= input("Digite el correo del anfitrión:");
								int celular= Integer.parseInt(input("Digite el numero de celular delanfitrión:"));
								Huesped huesped=new Huesped(nombre, edad, numeroIdentidad, correo, celular);
								ArrayList<Acompañante> acompañantesHuesped= huesped.getAcompañantes();
								int pedirAcompañantes=Integer.parseInt(input("Desea agregar un acompañante? \n 1. Si \n 2. No "));
								
								while (pedirAcompañantes==1) {
									String nombreA= input("Digite el nombre del acompañate: ");
									String niño= input("Digite si el acompañante es un infante: \n si \n no");
									boolean infante;
									if (niño.equals("si")) {
										infante = true;
									}
									else {
										infante=false;
									}
									int numeroIdentidadA= Integer.parseInt(input("Digite el numero de identidad del acompañante :"));
									Acompañante nuevoAcompañate= new Acompañante(nombreA, numeroIdentidadA, infante, nombre);
									acompañantesHuesped.add(nuevoAcompañate);
									if (infante) {
										int InfantesActuales=huesped.getCantidadInfantes();
										huesped.setCantidadInfantes(InfantesActuales+1);
									}
									else {
										int AdultosActuales=huesped.getCantidadAdultos();
										huesped.setCantidadAdultos(AdultosActuales+1);
									}
									pedirAcompañantes=Integer.parseInt(input("Desea agregar otro acompañante? \n 1. Si \n 2. No "));
								}
								System.out.println(hotelito.getCapacidadMaxAdultos());
								
								if(hotelito.getCapacidadMaxAdultos()>(hotelito.getCapacidadActualAdultos()+huesped.getCantidadAdultos())&&hotelito.getCapacidadMaxNiños()>(hotelito.getCapacidadActualNiños()+huesped.getCantidadInfantes())){
									System.out.print("estas son las habitaciones" +hotelito.getHabitaciones()+ "\n");
									ArrayList<String> habitacionesHuesped= controlador.llenarHabitaciones(huesped.getCantidadAdultos(), huesped.getCantidadInfantes(), hotelito.getHabitaciones());
									huesped.setIdentificadoresHabitaciones(habitacionesHuesped);
								}
								else {
									System.out.println("no hay habitaciones disponibles para todo su grupo");
								}
								SimpleDateFormat llegada= new SimpleDateFormat((input("Fecha de llegada del grupo:(Ej: 29/03/2023 ")));
								SimpleDateFormat max= new SimpleDateFormat((input("Fecha 2 dias antes de la de llegada: (Ej: 29/03/2023)")));
								SimpleDateFormat salida= new SimpleDateFormat(input("Fecha de salida del grupo"));
								Reserva reserva= new Reserva(huesped, llegada, salida, max);
								System.out.println(reserva);
								hotelito.getReservas().put(nombre, reserva);	
								System.out.println(hotelito.getReservas());
								System.out.println(hotelito.getReservas().get(nombre).getGrupo());
								
							} else if (opcion_Recepcionosta == 2) {
							System.out.println(hotelito.getReservas());
							String nombreanf= input("Digite el nombre del anfitrión:");
							Map<String, Reserva> reservas = hotelito.getReservas();
							System.out.println(reservas.get(nombreanf));
							Reserva reserva = reservas.get(nombreanf);
							Huesped grupo = reserva.getGrupo();
							Map<String,Huesped> grupos = hotelito.getGrupos();
							grupos.put(nombreanf, grupo);
							System.out.print(hotelito.getGrupos().keySet());
							

							} else if (opcion_Recepcionosta == 3) {

							} else if (opcion_Recepcionosta == 4) {
							String numero_de_habitacion = input("ingrese el id del numero de habitacion para saber su disponibilidad\n");
							boolean ocupada = hotelito.getHabitaciones().get(numero_de_habitacion).isOcupada();
							if(!ocupada) {
								System.out.print("Habitacion disponible\n");
							

							}else {System.out.print("Habitacion ocupada\n");
							
							}
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
					while (!registrado) {
						Map<String,String> empleados= hotelito.getEmpleados();
						String login= input("Digite su login de empleado:");
						String password= input("Digite su contraseña de empleado:");
						if(empleados.get(login).equals(password)) {
							registrado=true;
							usuario= new Usuario(login, password, TipoUsuario.Empleado);				
						}
					}
					boolean continuar3 = true;
					while (continuar3) {
						try {

							opcionesEmpleado();

							int opcion_empleado = Integer.parseInt(input("Por favor seleccione una opción"));

							// AQUÍ VAN LOS REQURIMIENTOS

							if (opcion_empleado == 1) {
								Factura nuevafactura= new Factura();
								ArrayList<Servicio> listaservicios = new ArrayList<Servicio>();
								Map<String, Servicio> mapaservicios =hotelito.getServicios();
								Set<String> nombresServicios= mapaservicios.keySet();
								System.out.println("Cual de los siguientes servicios desea agregar a la factura?");
								int contador = 0;
								for (String nombre:nombresServicios) {
									String numerito = String.valueOf(contador);
									System.out.println(numerito + ". " + nombre);
									listaservicios.add(mapaservicios.get(nombre));
									contador+=1;
								}
								
							int opcion = Integer.parseInt(input("Por favor seleccione una opción"));
							Servicio servicioSeleccionado = mapaservicios.get(listaservicios.get(opcion));
							double total = nuevafactura.getTotal();
							double precioServicio = servicioSeleccionado.getPrecio();
							total += precioServicio;
							ArrayList<Servicio> listaFactura = nuevafactura.getServicios();
							listaFactura.add(servicioSeleccionado);
							nuevafactura.setServicios(listaFactura);
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
