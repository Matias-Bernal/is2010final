package util;
import java.util.Iterator;
import java.util.Vector;

//probando
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
	public static float medicPay (Vector<Pair> consultas, float valor, int horasAlquiler, float alquilerxhs) {
		float sueldo = 0;
		for (int i=0;i<consultas.size();i++) {
			sueldo += (valor - ((consultas.get(i).getY()*valor)/100)) * consultas.get(i).getX();
		}
		sueldo -= (horasAlquiler*alquilerxhs);
		return sueldo;
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
	private static boolean m(int diaE,int mesE,int anioE,int hsE,int minE,int diaS,int mesS,int anioS,int hsS,int minS){
		
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
	* daysDiff metodo que calcula la cantidad de horas que hay de diferencia entre dos fechas dadas.
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
	* @return float representando la cantidad de horas que hay de diferencia entre dos fechas dadas.
	*/
	public static float daysDiff(int diaE,int mesE,int anioE,int hsE,int minE,int diaS,int mesS,int anioS,int hsS,int minS){
		int auxhsS = hsS;
		
		int acum = 0;
		int acum2 = 0;
		
		if (m(diaE,mesE,anioE,hsE,minE,diaS,mesS,anioS,hsS,minS)) {
		
		while (!(anioE== anioS &&  mesE==mesS && diaE==diaS && hsE==hsS && minE==minS)){
			acum = acum +1;
			minE = minE+1;
			
			if (minE == 60) {
				minE = 0;
				hsE = hsE + 1;
				if (hsE == 10) {
					acum2 = acum2 + 1;
					}
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
								System.out.println(diaE + "/"+mesE +"/"+anioE+" "+ hsE+":"+ minE );
				
		}
		if (auxhsS > 10){ 
			acum2 = acum2 +1;
		}
		}else{
			acum2= -1;
			
		}
			return acum2 ;
		
	}
	
	
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
	public static float consydesc(int cant, int descuento){
		return 0;
	}

	////////////////////////////////////////
	public static boolean checkHour(int hs, int min) {
		return true;
	}

	public static void main(String[] args){
		/*Vector<Pair> consultas = new Vector<Pair>();
		consultas.add(new Pair(1,10));
		consultas.add(new Pair(2,20));
		System.out.println("el total es: "+medicPay(consultas,100 ,10,1));*/
//		Pair[]comidasVacias = new Pair[4];
//		Vector<Pair> medicamentos = new Vector<Pair>();
//		Vector<Pair> medicamentosVacia = new Vector<Pair>();
//
//		System.out.println(utilTest.totalPay(2f,comidasVacias,medicamentosVacia,10,1f));
		//System.out.println(daysDiff(12,11,1987,8,0,15,11,1987,,0));
		
		
		System.out.println(daysDiff(12,11,1987,9,0,15,11,1987,8,0));
	}

}