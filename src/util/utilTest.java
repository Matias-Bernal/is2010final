package util;
import java.util.Vector;


public class utilTest {
	
	////////////////////////////////////////	
	public static boolean checkString (String s){
		return validStrChar(s)&&validStrLength(s);
	}
	public static boolean validStrLength(String s){
		return (s.length()<=60);
	}
	public static boolean validStrChar(String s){
        boolean valido = true;
        char c;
        for (int i = 0; i < s.length() && valido; i++) {
            c = s.charAt(i);
            if (((int)c < 65) || (((int)c)>90 && ((int)c<97)) || ((int)c>122)) {
            	valido = false;
            }
        }
        return valido;
	}
	////////////////////////////////////////
	public static boolean checkDni (String dni){
        boolean valido = (dni.length()==10); //Debe tener 10 digitos como la mascara "XX.XXX.XXX"
        char c;
        for (int i = 0; i < dni.length() && valido; i++) {
            c = dni.charAt(i);
            if ((i==2)||(i==6)){ //El tercer y sexto digito debe ser un .
            	valido = (int)c==46;
            }else{
            	valido = ((int)c >= 48 && (int)c<=57); //Los demas digitos deben ser numeros
            }
        }
        return valido;
	}
	////////////////////////////////////////
	public static boolean checkDate (int diaA,int mes,int anio){
		return true;
	}
	////////////////////////////////////////  
	public static int hourDiff(int diaE,int mesE,int anioE,int hsE,int minE,int diaS,int mesS,int anioS,int hsS,int minS){
		return 0;
	}
	////////////////////////////////////////
	public static float medicPay(Vector<Pair> consultas, float valor, int horasAlquiler, float alquilerxhs){	
		return 0;
	}
	////////////////////////////////////////
	public static float totalPay (Float costoDia, Pair[] comidas, Vector<Pair> medicamentos, int dias, Float valorDia ) {
		return 0;
	}
	////////////////////////////////////////
	public static float daysDiff(int diaE,int mesE,int anioE,int hsE,int minE,int diaS,int mesS,int anioS,int hsS,int minS){
		return 0;
	}
	////////////////////////////////////////
	public static float consydesc(int cant, int descuento){
		return 0;
	}
	////////////////////////////////////////
	public static boolean checkHour(int hs, int min) {
		return true;
	}
	public static void main(String[] args){
	   utilTest test = new utilTest();
	   System.out.println(test.checkDni("32.0.7.476"));
	}
}