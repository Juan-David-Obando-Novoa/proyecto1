package bin.controlador;

//Clase abstracta para definir los atributos de los usuarios//


public class Usuario {
	//Atributos//
	private String Login;
	private String Password;
	private  TipoUsuario tipoUsuario;
	//Constructor//
	public Usuario(String login, String password, TipoUsuario tipoUsuario) {
		this.Login=login;
		this.Password=password;
		this.tipoUsuario=tipoUsuario;
	}
}
