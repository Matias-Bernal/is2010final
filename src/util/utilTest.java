/**
* @file utilTest.java
*
* @brief This file contains the DoxygenExample class with the main() function.
*
* @author Philipp Bank, www.cypax.net\n
*
* @date June, 18th 2006 - first version
* @date June, 19th 2006 - some modifications, multi-threading
*
**/


package util;
import java.util.Iterator;
import java.util.Vector;

/**
* @class utilTest
* 
* @brief The DoxygenExample class extends the Frame class, provides a graphical user interface (GUI) and includes main().
*
* This class, extending the Frame class, contains the main() function, which will create a new DoxygenExample frame instance.<br>
* The program will sort integer arrays with:
* <ul> 
*   <li> a <a href="http://en.wikipedia.org/wiki/Selection_sort">selectionsort</a> algorithm</li>
*   <li> a <a href="http://en.wikipedia.org/wiki/Insertion_sort">insertionsort</a> algorithm</li>
*   <li> a <a href="http://en.wikipedia.org/wiki/Bubblesort">bubblesort</a> algorithm</li>
* </ul>
* The algorithms are executed as threads and can be started simultaneously or separately.<br>
* To visualize the processes, the integer arrays will be shown as colored lines.
*/
public class utilTest {
	
	/**
	* @brief checkString Metodo que verifica si un String pasado como parametro es valido o no.
	* Un string es valido si solo contiene caracteres de a-z o de A-Z y ademas si su longitid
	* esta entre 1 y 60.
	* @param String s es el string a verificar.
	* @return boolean true si es valido y false en caso contrario.
	*/
	public static boolean checkString (String s){
        boolean valido = (s.length()<=60 && s.length()>0);
        char c;
        for (int i = 0; i < s.length() && valido; i++) {
            c = s.charAt(i);
            if (((int)c < 65) || (((int)c)>90 && ((int)c<97)) || ((int)c>122)) {
            	valido = false; //No esta entre a-z o A-Z del codigo asiic, aunque no dice nada que el nombre deba contener espacios en blancos
            }
        }
        return valido;
	}

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


	public static boolean checkDate (int diaA,int mes,int anio){
		boolean res;
		if(anio>=0){
			if (esBiciesto(anio)){
				if (mes==2){
					res = (diaA>0&&diaA<30);
				}else{
					if((mes==1)||(mes==3)||(mes==5)||(mes==7)||(mes==8)||(mes==10)||(mes==12)){
						res=(diaA>0&&diaA<=31);
					}else{
						if((mes==4)||(mes==6)||(mes==9)||(mes==11)){
							res=(diaA>0&&diaA<31);
						}else
							res=false;
					}
				}
			}else{ //anio no bicisto
				if (mes==2){
					res = (diaA>0&&diaA<29);
				}else{
					if((mes==1)||(mes==3)||(mes==5)||(mes==7)||(mes==8)||(mes==10)||(mes==12)){
						res=(diaA>0&&diaA<=31);
					}else{
						if((mes==4)||(mes==6)||(mes==9)||(mes==11)){
							res=(diaA>0&&diaA<31);
						}else
							res=false;
					}
				}
			}
		}else{
			res=false;
		}
		return res;
	}

	/**
	* hourDiff indica la cantidad de horas de diferencia que hay entre dos fechas.
	* @param int diaE representa al dia de inicio.
	* @param int mesE representa al mes de inicio.
	* @param int anioE representa al anio de inicio.
	* @param int hsE representa a la hs de inicio.
	* @param int minS representa a los minutos de fin.
	* @param int diaS representa al dia de fin.
	* @param int mesS representa al mes de fin.
	* @param int anioS representa al anio de fin.
	* @param int hsS representa a la hs de fin.
	* @param int minS representa a los minutos de fin.
	* @param int anio representa el anio a chequear.
	* @return int que representa la cantidad de horas que hay entre 2 fechas.
	*/
	public static int hourDiff(int diaE,int mesE,int anioE,int hsE,int minE,int diaS,int mesS,int anioS,int hsS,int minS){
		int acum = 0;
		if (fechaMenorQueOtra(diaE,mesE,anioE,hsE,minE,diaS,mesS,anioS,hsS,minS)) {
		while (!(anioE== anioS &&  mesE==mesS && diaE==diaS && hsE==hsS && minE==minS)){
			acum = acum +1;
			minE = minE+1;
			if (minE == 60) {
				minE = 0;
				hsE = hsE + 1;
				if (hsE == 24){
					hsE = 0;
					diaE = diaE +1;
					if (diaE == 29 && mesE == 2 && !esBiciesto(anioE)){
						diaE = 1;
						mesE = mesE +1;
					} else if(diaE == 30 && mesE == 2 && esBiciesto(anioE)){ 
						diaE = 1;
						mesE = mesE +1;
					} else if (diaE == 30 && (mesE == 4 || mesE == 6 || mesE == 9 || mesE == 11)){
						diaE = 1;
						mesE = mesE +1;
					} else if (diaE == 31 && (mesE == 1 || mesE == 3 || mesE == 5 || mesE == 7 || mesE == 8 || mesE == 10 || mesE == 12)){
						diaE = 1;
						mesE = mesE +1;
					}else if (mesE == 13){
								mesE = 1;
								anioE = anioE +1;
							
					}
				}
			}
		}
		}else{
			return -1;
		}
		return (acum/60) ;
	}
	
	public static float medicPay (Vector<Pair> consultas, float valor, int horasAlquiler, float alquilerxhs) {
		float sueldo = 0;
		if ((valor>=0)&&(horasAlquiler>=0)&&(alquilerxhs>=0)&&(!consultas.isEmpty())){
			for (int i=0;i<consultas.size();i++) {
				sueldo += (valor - ((consultas.get(i).getY()*valor)/100)) * consultas.get(i).getX();
			}
			sueldo -= (horasAlquiler*alquilerxhs);
			return sueldo;
		}else{
			return -1;
		}
	}


	public static float totalPay (Float costoDia, Pair[] comidas, Vector<Pair> medicamentos, int dias, Float descuento ) {
		if(costoDia <= 0  || dias <= 0 || descuento <= 0)
			return -1;
		float valorSinDesc = (costoDia + calcComidas(comidas) + calcMedicamentos(medicamentos)) * dias;
		return valorSinDesc *  ((100-descuento)/100);
	}
	
	private static float calcComidas(Pair[] comidas) {
		try {
			return (comidas[0].getX() * comidas[0].getY()) +
			       (comidas[1].getX() * comidas[1].getY()) +
			       (comidas[2].getX() * comidas[2].getY()) +
			       (comidas[3].getX() * comidas[3].getY());
		} catch (NullPointerException npe) {
			return 0;
		}
	}
	
	private static float calcMedicamentos(Vector<Pair> medicamentos) {
		float res = 0f;
		for (Iterator iterator = medicamentos.iterator(); iterator.hasNext();) {
			Pair medicamento = (Pair) iterator.next();
			res += medicamento.getX() * medicamento.getY();
		}
		return res;
	}
	
	/**
	* fechaMenorQueOtra indica si una fecha es menor que la otra.
	* @param int diaE representa al dia de inicio.
	* @param int mesE representa al mes de inicio.
	* @param int anioE representa al anio de inicio.
	* @param int hsE representa a la hs de inicio.
	* @param int minS representa a los minutos de fin.
	* @param int diaS representa al dia de fin.
	* @param int mesS representa al mes de fin.
	* @param int anioS representa al anio de fin.
	* @param int hsS representa a la hs de fin.
	* @param int minS representa a los minutos de fin.
	* @return True si la primera fecha es menor que la segunda o de lo contrario False.
	*/
	private static boolean fechaMenorQueOtra(int diaE,int mesE,int anioE,int hsE,int minE,int diaS,int mesS,int anioS,int hsS,int minS){
		if (anioE == anioS){
			if (mesE == mesS){
				if (diaE == diaS){
					if (hsE == hsS){
						if (minS <= minS){
							return true;
						}else{
							return false;
						}
					}else if (hsE < hsS){
						return true; 
					}else{
						return false;
					}
				}else if (diaE < diaS){
					return true;
				}else{
					return false;
				}
			}else if(mesE < mesS){
				return true;
			}else{
				return false;
			}
		}else if (anioE < anioS){
			return true;
		}else {
			return false;
		}
	}
	
	/**
	* daysDiff permite calcular la cantidad de días que un paciente ha estado internado.
	* A partir de las 10:00 de la mañana ya se considera un nuevo día, es decir, si el paciente
	* es dado de alta a las 10:01 ya se le cobra un nuevo día.
	* @param int diaE representa al dia de inicio.
	* @param int mesE representa al mes de inicio.
	* @param int anioE representa al anio de inicio.
	* @param int hsE representa a la hs de inicio.
	* @param int minS representa a los minutos de fin.
	* @param int diaS representa al dia de fin.
	* @param int mesS representa al mes de fin.
	* @param int anioS representa al anio de fin.
	* @param int hsS representa a la hs de fin.
	* @param int minS representa a los minutos de fin.
	* @return float representando la cantidad de dias de internacion que se le deben cobrar al paciente.
	*/
	public static int daysDiff(int diaE,int mesE,int anioE,int hsE,int minE,int diaS,int mesS,int anioS,int hsS,int minS){
		int hs = hourDiff(diaE,mesE,anioE,hsE, minE, diaS, mesS, anioS, hsS, minS);
		int res = -1;
		if (hs != -1){
				res = hs / 24;
				if (hsS > 10){
					res = res + 1;
				}
				if (hsE < 10) {
					res = res + 1;
				}
		}
		return res;
	}
	
	/**
	* esBiciesto indica si un anio es biciesto.
	* @param int anio representa el anio a chequear.
	* @return True si el anio es biciesto o de lo contrario False.
	*/
	private static boolean esBiciesto(int anio){
		boolean res = true;
		if (anio % 400 == 0){
	       res = true;
		} else if (anio % 100 == 0){
	       res = false;
		}else if (anio % 4 == 0){
	       res = true;
		}else{
			res= false;
		}
		return res;
	}
	

	////////////////////////////////////////
//	public static float consydesc(int cant, int descuento){
//		return 0;
//	}

	////////////////////////////////////////
	public static boolean checkHour(int hs, int min){
		return ((min>=0&&min<=59)&&(hs>=0&&hs<=23));
	}

}