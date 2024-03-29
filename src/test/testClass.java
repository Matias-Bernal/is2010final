/**
*@mainpage
*
*<center><b>Proyecto de Ingenieria de Software 2010</b></center>
*<br>
*<center>
*  Relaciones entre clases por medio de un diagrama de lineas de dot:
*  \dot
*	digraph proyectoIS2010 {
*	node [shape=record, fontname=Helvetica, fontsize=10];
*	a [ label="testClass" URL="\ref test.testClass"];
* 	b [ label="utilTest" URL="\ref util.utilTest"];
*	c [ label="Pair" URL="\ref util.Pair"];
*	a -> b [ arrowhead="open", style="dashed" ];
*	a -> c [ arrowhead="open", style="dashed" ];
*	b -> c [ arrowhead="open", style="dashed" ];
*  	}
*  \enddot
*</center>
*<i><center>Nota: para mas informacion click en las clases del grafico</center></i> 
*
*<center>
*<b>AUTORES</b>
*<br>
*<br>
*BERNAL, Matias
*<br>
*BRESSAN, Gonzalo
*<br>
*JAULE, Marcos
*<br>
*ODORIZZI, Eduardo
*</center>
*<br>
*<center><img src="unrc.jpg" alt="UNRC" width="80px" heigth="120px"></center>
*<br>
*<center>
*<a href="http://is2010final.googlecode.com" target="_blank">Repositorio SVN en Google Code</a>
*</center>
*
*
*
*@file testClass.java
*
*@brief Este archivos contiene la implementacion de las pruebas.
*
*@author 	BERNAL, Matias\n
*		  	BRESSAN, Gonzalo\n
*			JAULE, Marcos\n
*			ODORIZZI, Eduardo
*
*@date November, 1st 2010
**/
package test;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import util.Pair;
import util.utilTest;

/**
* @class testClass
* 
* @brief La clase testClass declara una serie de metodos en jUnit<br>
* para verficar el correcto funcionamiento de las funciones de validacion<br>
* de la clase utilTest.<br>
*
*/
public class testClass {

	/**
	 * Valida el funcionamiento de la funcion checkString dentro de la clase utilTest.<br>
	 * Se usa clases de equivalencia con testing fuerte.
	 */
	@Test
	public void checkStringTest (){
		assertFalse("String incorrecto. Es vac�o",utilTest.checkString(""));
		assertTrue("String correcto",utilTest.checkString("aaa"));
		assertFalse("String incorrecto. Longitud correcta pero con n�meros en el contenido",utilTest.checkString("2aa"));
		assertFalse("String incorrecto. Longitud invalida",utilTest.checkString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}

	/**
	 * Valida el funcionamiento de la funcion checkDni dentro de la clase utilTest.<br>
	 * Se usa clases de equivalencia con testing fuerte.
	 */
	@Test
	public void checkDniTest (){
		assertTrue("Dni correcto",utilTest.checkDni("10.234.456"));
		assertFalse("Dni incorrecto. Tiene 10 caracteres correctos pero mal distribuidos",utilTest.checkDni("123.45.678"));
		assertFalse("Dni incorrecto. Tiene algunas letras",utilTest.checkDni("A2.345.678"));
		assertFalse("Dni incorrecto. Longitud invalida",utilTest.checkDni("12.345.6788"));
	}

	/**
	 * Valida el funcionamiento de la funcion checkDate dentro de la clase utilTest.<br>
	 * Se usa tablas de desici�n.
	 */
	@Test
	public void checkDateTest(){
		assertFalse("Dia negativo",utilTest.checkDate(-1, 12, 2010));
		assertFalse("Dia mayor que 31",utilTest.checkDate(45, 12, 2010));
		assertFalse("Mes negativo",utilTest.checkDate(12, -1, 2010));
		assertFalse("Mes mayor que 12",utilTest.checkDate(1, 20, 2010));
		assertFalse("A�o negativo",utilTest.checkDate(1, 1, -2010));
		assertFalse("A�o no bisiesto y febrero tiene 29",utilTest.checkDate(29, 2, 1999));	
		assertTrue("La fecha es correcta",utilTest.checkDate(30, 3, 2010));
		assertFalse("febrero tiene mas de 30 dias",utilTest.checkDate(30, 2, 2010));
		assertFalse("El mes 4 no tiene 31 dias",utilTest.checkDate(31, 4,2010));
		//assertFalse("El mes 3 no tiene 30 dias",utilTest.checkDate(31, 3, 2010));
		assertTrue("La fecha es correcta",utilTest.checkDate(28, 5, 2010));
		assertTrue("El a�o 2000 es bisiesto, fecha correcta",utilTest.checkDate(29, 2, 2000));
	}

	/**
	 * Valida el funcionamiento de la funcion hourDiff dentro de la clase utilTest.<br>
	 * Se usa tablas de desici�n.
	 */
	@Test
	public void hourDiffTest(){
		// controlar fecha y horas
		assertEquals("Fecha de Entrada mayor que Fecha de salida",-1, utilTest.hourDiff(10,1,2010,13,00,1,1,2010,16,00));
		assertEquals("Salida Correcta", 122, utilTest.hourDiff(20,10,2010,10,00,25,10,2010,12,00));
		assertEquals("Salida Correcta ",1, utilTest.hourDiff(10,1,2010,9,00,10,1,2010,10,00));
		assertEquals("Fechas iguales y hora de Entrada mayor que la hora de salida",-1, utilTest.hourDiff(10,1,2010,14,00,10,1,2010,10,00));
	}

	/**
	 * Valida el funcionamiento de la funcion daysDiff dentro de la clase utilTest.<br>
	 * Se usa clases de equivalencia con testing fuerte.
	 */
	@Test
	public void daysDiff () {                         
		assertEquals (3,utilTest.daysDiff(12,11,1987,9,0,15,11,1987,8,0));
		assertEquals (5,utilTest.daysDiff(12,11,1987,9,0,15,11,1987,12,0));
		assertEquals (2,utilTest.daysDiff(12,11,1987,11,0,15,11,1987,8,0));
		assertEquals (4,utilTest.daysDiff(12,11,1987,11,0,15,11,1987,12,0));
		assertEquals (-1,utilTest.daysDiff(15,11,1987,9,0,12,11,1987,8,0));
		assertEquals (-1,utilTest.daysDiff(15,11,1987,9,0,12,11,1987,12,0));
		assertEquals (-1,utilTest.daysDiff(15,11,1987,11,0,12,11,1987,8,0));
		assertEquals (-1,utilTest.daysDiff(15,11,1987,11,0,12,11,1987,12,0));
		assertEquals (-1,utilTest.daysDiff(12,11,1987,9,0,12,11,1987,8,0));//correccion la hora de entrada debe ser menor que la de salida
		assertEquals (2,utilTest.daysDiff(12,11,1987,9,0,12,11,1987,12,0));
		assertEquals (-1,utilTest.daysDiff(12,11,1987,11,0,12,11,1987,8,0));
		assertEquals (1,utilTest.daysDiff(12,11,1987,11,0,12,11,1987,12,0));
	 }

	/**
	 * Valida el funcionamiento de la funcion daysDiff dentro de la clase utilTest.<br>
	 * Se usa testing de robustez (valor limite).
	 */
	@Test
	public void checkHour () {
	   assertTrue("Hora correcta",utilTest.checkHour(12,0));
	   assertTrue("Hora correcta",utilTest.checkHour(12,1));
	   assertTrue("Hora correcta",utilTest.checkHour(12,30));
	   assertTrue("Hora correcta",utilTest.checkHour(12,58));
	   assertTrue("Hora correcta",utilTest.checkHour(12,59));
	   assertTrue("Hora correcta",utilTest.checkHour(0,30));
	   assertTrue("Hora correcta",utilTest.checkHour(1,30));
	   assertTrue("Hora correcta",utilTest.checkHour(22,30));
	   assertTrue("Hora correcta",utilTest.checkHour(23,30));
	   assertFalse("Hora incorrecta",utilTest.checkHour(12,-1));
	   assertFalse("Hora incorrecta",utilTest.checkHour(12,60));
	   assertFalse("Hora incorrecta",utilTest.checkHour(-1,30));
	   assertFalse("Hora incorrecta",utilTest.checkHour(24,30));
	}

//	@Test 
//	public void consydescTest(){
//		assertEquals("Consultas correcta",1,9, utilTest. consydesc(2,5));
//		assertEquals("Consultas incorrect, cantida de consultas negativo",1,9, utilTest. consydesc(2,-5));
//		assertEquals("Consultas incorrect, descuento negativo",1,9, utilTest. consydesc(-2,5));
//		assertEquals("Consultas incorrect, cantida de consultas negativo y descuento negativo",1,9, utilTest. consydesc(-2,-5));
//	}

	/**
	 * Valida el funcionamiento de la funcion medicPay dentro de la clase utilTest.<br>
	 * Se usa clases de equivalencia con testing fuerte.
	 */
	@Test
	public void medicPayTest(){
		// controlar fecha y horas
		Vector<Pair> consultas = new Vector<Pair>();
		Vector<Pair> consultasVacia = new Vector<Pair>();
		Pair par1 = new Pair(1,10);
		Pair par2 = new Pair(1,20);
		consultas.add(par1);
		consultas.add(par2);
		assertEquals("Salida Incorrecta",-1,utilTest.medicPay(consultasVacia,-1,-1,-1),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.medicPay(consultasVacia,-1,-1,2),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.medicPay(consultasVacia,-1,2,-1),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.medicPay(consultasVacia,-1,2,2),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.medicPay(consultasVacia,2,-1,-1),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.medicPay(consultasVacia,2,-1,2),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.medicPay(consultasVacia,2,2,-1),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.medicPay(consultasVacia,2,2,2),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.medicPay(consultas,-1,-1,-1),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.medicPay(consultas,-1,-1,2),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.medicPay(consultas,-1,2,-1),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.medicPay(consultas,-1,2,2),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.medicPay(consultas,2,-1,-1),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.medicPay(consultas,2,-1,2),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.medicPay(consultas,2,2,-1),1e-2);
		assertEquals("Salida Correcta",1.1,utilTest.medicPay(consultas,3,2,2),1e-2);
	}

	/**
	 * Valida el funcionamiento de la funcion totalPay dentro de la clase utilTest.<br>
	 * Se usa clases de equivalencia con testing fuerte.
	 */
	@Test
	public void totalPayTest(){
		Pair[]comidas = new Pair[4];
		Pair[]comidasVacias = new Pair[4];
		Vector<Pair> medicamentos = new Vector<Pair>();
		Vector<Pair> medicamentosVacia = new Vector<Pair>();
		Pair par1 = new Pair(0,0);
		Pair par2 = new Pair(1,1);
		Pair par3 = new Pair(1,2);
		comidasVacias[0] = par1;
		comidasVacias[0] = par1;
		comidasVacias[0] = par1;
		comidasVacias[0] = par1;
		comidas[0] = par2;
		comidas[0] = par2;
		comidas[0] = par2;
		comidas[0] = par2;
		medicamentos.add(par3);
		assertEquals("Salida Incorrecta",-1,utilTest.totalPay(-1f, comidasVacias,medicamentosVacia,-1,1f),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.totalPay(-1f, comidasVacias,medicamentosVacia,10,1f),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.totalPay(-1f, comidasVacias,medicamentos,-1,1f),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.totalPay(-1f, comidasVacias,medicamentos,10,1f),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.totalPay(-1f, comidas,medicamentosVacia,-1,1f),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.totalPay(-1f, comidas,medicamentosVacia,10,1f),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.totalPay(-1f, 	comidas,medicamentos,-1,1f),1e-2);
		assertEquals("Salida Incorrecta",-1,utilTest.totalPay(-1f, comidas,medicamentos,10,1f),1e-2);
		assertEquals("Salida Incorrecta",-1, utilTest.totalPay(2f,comidasVacias,medicamentosVacia,-1,1f),1e-2);
		assertEquals("Salida Correcta", 19.8, utilTest.totalPay(2f,comidasVacias,medicamentosVacia,10,1f),1e-2);
		assertEquals("Salida Incorrecta",-1, utilTest.totalPay(2f,comidasVacias,medicamentos,-1,1f),1e-2);
		assertEquals("Salida Correcta", 39.6, utilTest.totalPay(2f,comidasVacias,medicamentos,10,1f),1e-2);
		assertEquals("Salida Incorrecta",-1, utilTest.totalPay(2f,comidas,medicamentosVacia,-1,1f),1e-2);
		assertEquals("Salida Correcta",19.8, utilTest.totalPay(2f,comidas,medicamentosVacia,10,1f),1e-2);
		assertEquals("Salida Incorrecta",-1, utilTest.totalPay(2f,comidas,medicamentos,-1,1f),1e-2);
		assertEquals("Salida Correcta", 39.6, utilTest.totalPay(2f,comidas,medicamentos,10,1f),1e-2);
	}

}
