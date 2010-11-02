/**
* @file utilTest.java
*
* @brief This file contains the DoxygenExample class with the main() function.
*
* @author 	BERNAL, Matias\n
*		  	BRESSAN, Gonzalo\n
*			JAULE, Marcos\n
*			ODORIZZI, Eduardo
*
* @date November, 1st 2010
**/
package util;
import java.util.Iterator;
import java.util.Vector;

/**
* @class utilTest
* 
* @brief La clase utilTest declara una serie de metodos para realizar validaciones de, entre otros,<br>
* Cadenas, Fechas, Tiempo transcurrido.
*
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

	/**
	 * checkDate valida que la fecha ingresada sea correcta.<br>
	 * una fecha es correcta si el dia es menor que 28 para el mes 2 o 29 en caso de que el año sea bisiesto.<br>
	 * el dia es menor o igual que 30 para los meses: 1, 3, 5, 7, 8, 10 y 12<br>
	 * o el dia es menor o igual que 31 para los meses: 4, 6, 9 y 11.
	 * @param diaA
	 * @param mes
	 * @param anio
	 * @return true si es valido, false si no lo es
	 */
	public static boolean checkDate (int diaA,int mes,int anio){
		boolean res;
		if(anio>=0){
			if (esBisiesto(anio)){
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
	* hourDiff indica la cantidad de horas la cantidad de horas transcurridas entre dos fechas (fecha y hora).
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
					if (diaE == 29 && mesE == 2 && !esBisiesto(anioE)){
						diaE = 1;
						mesE = mesE +1;
					} else if(diaE == 30 && mesE == 2 && esBisiesto(anioE)){ 
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
	
	/**
	 * Una función que permita calcular el sueldo de un m dico en función de la cantidad de<br>
	 * consultas  atendidas  al  mes,  las  obras  sociales  y  el  valor  de  la  consulta. A este<br>
	 * resultado se le deberá descontar la cantidad de horas que el profesional<br>
	 * ha utilizado la clínica(en concepto de alquiler).
	 * @param consultas
	 * @param valor
	 * @param horasAlquiler
	 * @param alquilerxhs
	 * @return pago
	 */
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

	/**
	 * Una  función  que  permita  calcular  el  monto  total  que  debe  abonar  un  paciente<br>
	 * internado en función del costo del día de internación, cantidad y costos de comidas<br>
	 * recibidas, cantidad y costo de medicamentos recibidos. A todo esto debe calcularse un<br>
	 * descuento correspondiente al monto que cubre la mutual.
	 * @param costoDia
	 * @param comidas
	 * @param medicamentos
	 * @param dias
	 * @param descuento
	 * @return monto
	 */
	public static float totalPay (Float costoDia, Pair[] comidas, Vector<Pair> medicamentos, int dias, Float descuento ) {
		if(costoDia <= 0  || dias <= 0 || descuento <= 0)
			return -1;
		float valorSinDesc = (costoDia + calcComidas(comidas) + calcMedicamentos(medicamentos)) * dias;
		return valorSinDesc *  ((100-descuento)/100);
	}
	
	/**
	 * Calcula el costo de las cuatro comidas.
	 * Suma la cantidad cada uno de las comidad (desayuno, almuerzo, merienda, cena)<br>
	 * por su valor unitario. 
	 * @param comidas
	 * @return res
	 */
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
	
	/**
	 * Calcula el costo de los medicamentos<br>
	 * Suma la cantidad cada uno de los medicamentos por su valor unitario. 
	 * @param medicamentos
	 * @return res
	 */
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
	* esBisiesto indica si un anio es biciesto.
	* @param int anio representa el anio a chequear.
	* @return True si el anio es biciesto o de lo contrario False.
	*/
	private static boolean esBisiesto(int anio){
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
	
	/**
	 * checkHour comprueba que la hora pasada como parametro es correcta<br>
	 * @param hs hora
	 * @param min minutos
	 */
	public static boolean checkHour(int hs, int min){
		return ((min>=0&&min<=59)&&(hs>=0&&hs<=23));
	}

}