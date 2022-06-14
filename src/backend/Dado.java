/*PROGRAMAÇÃO ORIENTADA A OBJETOS. PROF. Marcio E. Delamaro.
 * ELABORADO E IMPLEMENTADO POR:
 * Nome: Guilherme Domingos Faria Silva		NUSP: 9361094
 * Nome:
 */

package backend;

import entrada.Random;

public class Dado {
	private int nlados;
	private int ladoatual;
	
	public Dado() {
		nlados = 6;
	}
	
	public Dado(int n) {
		nlados = n;
	}
	
	public int getLado() {
		return ladoatual;
	}
	
	public void rolar() {
		Random r = new Random();
		ladoatual = r.getIntRand(nlados) + 1;
	}
	
	public String toString() {
		if (ladoatual == 1)
			return ("+-----+\n|     |\n|  *  |\n|     |\n+-----+\n");
		if (ladoatual == 2)
			return ("+-----+\n|*    |\n|     |\n|    *|\n+-----+\n");
		if (ladoatual == 3)
			return ("+-----+\n|*    |\n|  *  |\n|    *|\n+-----+\n");
		if (ladoatual == 4)
			return ("+-----+\n|*   *|\n|     |\n|*   *|\n+-----+\n");
		if (ladoatual == 5) 
			return ("+-----+\n|*   *|\n|  *  |\n|*   *|\n+-----+\n");
		if (ladoatual == 6)
			return ("+-----+\n|*   *|\n|*   *|\n|*   *|\n+-----+\n");
		return ("Numero muito grande para ser representado, a função só funcionará com dados de até seis lados.");
	}
}
