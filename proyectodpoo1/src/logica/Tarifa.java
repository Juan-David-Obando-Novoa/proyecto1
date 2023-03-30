package logica;
import java.text.SimpleDateFormat;
import java.util.Date; 

public class Tarifa { 
private static int suit;
private static SimpleDateFormat fechainicialsuit;
private static SimpleDateFormat fechafinalsuit;
private static int estandar;
private static SimpleDateFormat fechainicialestandar;
private static SimpleDateFormat fechafinalestandar;
private static int DoubleSuite;
private static SimpleDateFormat fechainicialDoubleSuite;
private static SimpleDateFormat fechafinalDoubleSuite;





public Tarifa() {
this.suit= 0;
this.fechainicialsuit= new SimpleDateFormat("11/12/2021");
this.fechainicialsuit= new SimpleDateFormat("11/12/2022");

this.estandar=0;
this.fechainicialestandar= new SimpleDateFormat("11/1/2022");
this.fechafinalestandar= new SimpleDateFormat("11/12/2022");

this.DoubleSuite=0;
this.fechainicialestandar= new SimpleDateFormat("11/5/2022");
this.fechafinalestandar= new SimpleDateFormat("11/6/2023");

}





public static int getSuit() {
	return suit;
}





public static void setSuit(int suit) {
	Tarifa.suit = suit;
}





public static SimpleDateFormat getFechainicialsuit() {
	return fechainicialsuit;
}





public static void setFechainicialsuit(SimpleDateFormat fechainicialsuit) {
	Tarifa.fechainicialsuit = fechainicialsuit;
}





public static SimpleDateFormat getFechafinalsuit() {
	return fechafinalsuit;
}





public static void setFechafinalsuit(SimpleDateFormat fechafinalsuit) {
	Tarifa.fechafinalsuit = fechafinalsuit;
}





public static int getEstandar() {
	return estandar;
}





public static void setEstandar(int estandar) {
	Tarifa.estandar = estandar;
}





public static SimpleDateFormat getFechainicialestandar() {
	return fechainicialestandar;
}





public static void setFechainicialestandar(SimpleDateFormat fechainicialestandar) {
	Tarifa.fechainicialestandar = fechainicialestandar;
}





public static SimpleDateFormat getFechafinalestandar() {
	return fechafinalestandar;
}





public static void setFechafinalestandar(SimpleDateFormat fechafinalestandar) {
	Tarifa.fechafinalestandar = fechafinalestandar;
}





public static int getDoubleSuite() {
	return DoubleSuite;
}





public static void setDoubleSuite(int doubleSuite) {
	DoubleSuite = doubleSuite;
}





public static SimpleDateFormat getFechainicialDoubleSuite() {
	return fechainicialDoubleSuite;
}





public static void setFechainicialDoubleSuite(SimpleDateFormat fechainicialDoubleSuite) {
	Tarifa.fechainicialDoubleSuite = fechainicialDoubleSuite;
}





public static SimpleDateFormat getFechafinalDoubleSuite() {
	return fechafinalDoubleSuite;
}





public static void setFechafinalDoubleSuite(SimpleDateFormat fechafinalDoubleSuite) {
	Tarifa.fechafinalDoubleSuite = fechafinalDoubleSuite;
}




}
