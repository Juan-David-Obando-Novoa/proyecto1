package bin.modelo;

public class Servicio {
	//Atributos//
	private String nombre;
	private double precio;
	private String horario;
	private TipoCobro tipoCobro;
	private String ubicacion;
	private String[] dias;
	
	//Constructor//
	public Servicio(String nombre,String ubicacion, double precio, String[] dias, String horario, TipoCobro tipoCobro) {
	this.nombre=nombre;
	this.precio=precio;
	this.horario=horario;
	this.tipoCobro=tipoCobro;
	this.ubicacion=ubicacion;
	this.dias=dias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public TipoCobro getTipoCobro() {
		return tipoCobro;
	}

	public void setTipoCobro(TipoCobro tipoCobro) {
		this.tipoCobro = tipoCobro;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String[] getDias() {
		return dias;
	}

	public void setDias(String[] dias) {
		this.dias = dias;
	}
	

}
