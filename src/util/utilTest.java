package util;
import java.util.Vector;


public class utilTest {
	
	///////////////////////////////////////

	/**
	* checkString Metodo que verifica si un String pasado como parametro es valido o no.
	* Un string es valido si solo contiene caracteres de a-z o de A-Z y ademas si su longitid
	* esta entre 1 y 60.
	* @param String s es el string a verificar.
	* @return boolean true si es valido y false en caso contrario.
	*/
	public static boolean checkString (String s){
		return validStrChar(s)&&validStrLength(s); //Un string valido debe tener longitud menor a 90 y caracteres de a-z o A-Z
	}

	/**
	* validStrLength metodo que verifica si la logitud de un String pasado como parametro es valida o no.
	* Un string es valido si su longitid esta entre 1 y 60.
	* @param String s es el string a verificar.
	* @return boolean true si es valido y false en caso contrario.
	*/
	public static boolean validStrLength(String s){
		return (s.length()<=60 && s.length()>0); //Un string tiene que tener entre 1 y 60 caracteres
	}

	/**
	* validStrChar metodo que verifica si todos los caracteres de un String pasado como parametro son validos o no.
	* Un string es valido si todos sus caracteres estan entre la a-z o entre la A-Z
	* @param String s es el string a verificar.
	* @return boolean true si es valido y false en caso contrario.
	*/
	public static boolean validStrChar(String s){
        boolean valido = true; //Idem al de checkDni se podria verificar la longitud
        char c;
        for (int i = 0; i < s.length() && valido; i++) {
            c = s.charAt(i);
            if (((int)c < 65) || (((int)c)>90 && ((int)c<97)) || ((int)c>122)) {
            	valido = false; //No esta entre a-z o A-Z del codigo asiic, aunque no dice nada que el nombre deba contener espacios en blancos
            }
        }
        return valido;
	}
	////////////////////////////////////////

	/**
	* checkDni metodo que verifica si un String pasado como parametro representando un dni es valido o no.
	* Un dni es valido si cumple con la mascara XX.XXX.XXX donde X debe ser un numero de 0-9
	* @param String s es el string a verificar.
	* @return boolean true si es valido y false en caso contrario.
	*/
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
	private static float medicPay (Vector<Pair> consultas, float valor, int horasAlquiler, float alquilerxhs) {
		float sueldo = 0;
		for (int i=0;i<consultas.size();i++) {
			sueldo += (valor - ((consultas.get(i).getY()*valor)/100)) * consultas.get(i).getX();
		}
		sueldo -= (horasAlquiler*alquilerxhs);
		return sueldo;
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
		Vector<Pair> consultas = new Vector<Pair>();
		consultas.add(new Pair(1,10));
		consultas.add(new Pair(2,20));
		System.out.println("el total es: "+medicPay(consultas,100 ,10,1));
	}

}