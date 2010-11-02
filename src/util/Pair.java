/**
* @file Pair.java
*
* @brief Este archivo contiene la impementaci&oacute;n del tipo Par.
*
* @author 	BERNAL, Matias\n
*		  	BRESSAN, Gonzalo\n
*			JAULE, Marcos\n
*			ODORIZZI, Eduardo
*
* @date November, 1st 2010
* 
**/

package util;
/**
*@class Pair
* 
* @brief La clase pair implementa el tipo Par
*
* El tipo par representa dos números escritos en un cierto orden.<br>
* Usualmente están escritos entre paréntesis, así: (4,5) 
*/
public class Pair {
	
	private int x;
	private int y;
	
	
	/**
	 * @brief constructor sin parametros <br>
	 * crea el par (0,0).
	 */
	public Pair() {
		x = 0;
		y = 0;
	}


	/**
	 * @brief constructor con parametros <br>
	 * crea el par (x,y).
	 * @param x primer valor del par.
	 * @param y segungo valor del par.
	 */
	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	/**
	 * @brief devuelve la primer componente del par.
	 * @return x
	 */
	public int getX() {
		return x;
	}


	/**
	 * setea la primer componente del par.
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}


	/**
	 * @brief devuelve la segunda componente del par.
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * setea la segunda componente del par.
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	

}
