/*PROGRAMAÇÃO ORIENTADA A OBJETOS. Prof. Marcio E. Delamaro.
 * ELABORADO E IMPLEMENTADO POR:
 * Nome: Guilherme Domingos Faria Silva		NUSP: 9361094
 * Nome:
 */

package backend;

import java.util.Calendar;
import entrada.Random;

public class RolaDados {
	private int num;
	Dado[] dados;
	Random rand = new Random();
	private long p = 2147483648l;
	
	public RolaDados(int n) {
		num = n;
		dados = new Dado[n];
		for (int i = 0; i < n; i++) {
			dados[i] = new Dado();
			try {
				Thread.sleep((i+1)*13);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			rand.setSemente((int) ((Calendar.getInstance().getTimeInMillis() % p)));
			dados[i].rolar();
		}
	}

	public int[] rolar() {
		int[] dadosRolados = new int[num];
		for (int i = 0; i < num; i++) {
			try {
				Thread.sleep((i+1)*13);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			rand.setSemente((int) ((Calendar.getInstance().getTimeInMillis() % p)));
			dados[i].rolar();
			dadosRolados[i] = dados[i].getLado();
		}
		return dadosRolados;
	}

	public int[] rolar(boolean[] quais) {
		int[] dadosRolados = new int[num];
		for (int i = 0; i < num; i++) {
			rand.setSemente((int) ((Calendar.getInstance().getTimeInMillis() % p)));
			if (quais[i])
			{
				try {
					Thread.sleep((i+1)*13);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				dados[i].rolar();
			}
		}
		
		for(int i=0; i<5 ; i++){
			dadosRolados[i] = dados[i].getLado();
		}
		
		return dadosRolados;
	}

	public int[] rolar(String s) {
		int x;
		int[] dadosRolados = new int[num];
		for (int i = 0; i < s.length(); i++) {
			x = Character.getNumericValue(s.charAt(i)) - 1;
			rand.setSemente((int) ((Calendar.getInstance().getTimeInMillis() % p)));
			
			/*O erro estava aqui na condição do if que antes era if (x < 6 && x > 0), x > 0 exclui o primeiro dado que é o x = 0*/
			if (x < 6 && x >= 0)
			{
				try {
					Thread.sleep((i+1)*13);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				dados[x].rolar();
			}
		}
		for(int i=0; i<5 ; i++){
			dadosRolados[i] = dados[i].getLado();
		}
		
		return dadosRolados;
	}

	public String toString() {
		System.out.println(" 1\t 2\t 3\t 4\t 5\n");
		String mat = new String();

		String tipo1 = "|     |";
		String tipo2 = "|*    |";
		String tipo3 = "|*   *|";
		String tipo4 = "|  *  |";
		String tipo5 = "|    *|";
		String tipo6 = "+-----+";

		for (int j = 0; j < 5; j++)
			mat = mat.concat(tipo6).concat("\t");
		mat = mat.concat("\n");
		for (int j = 0; j < 5; j++) {
			switch (dados[j].getLado())
			{
				case 1:
					mat = mat.concat(tipo1).concat("\t"); break;
				case 2:
					mat = mat.concat(tipo2).concat("\t"); break;
				case 3:
					mat = mat.concat(tipo2).concat("\t"); break;
				case 4:
					mat = mat.concat(tipo3).concat("\t"); break;
				case 5:
					mat = mat.concat(tipo3).concat("\t"); break;
				case 6:
					mat = mat.concat(tipo3).concat("\t"); break;
				default:
					System.out.println("Numero muito grande para ser representado, a função só funcionará com dados de até seis lados.");
				}

		}
		mat = mat.concat("\n");
		for (int j = 0; j < 5; j++) {
			switch (dados[j].getLado())
			{
				case 1:
					mat = mat.concat(tipo4).concat("\t"); break;
				case 2:
					mat = mat.concat(tipo1).concat("\t"); break;
				case 3:
					mat = mat.concat(tipo4).concat("\t"); break;
				case 4:
					mat = mat.concat(tipo1).concat("\t"); break;
				case 5:
					mat = mat.concat(tipo4).concat("\t"); break;
				case 6:
					mat = mat.concat(tipo3).concat("\t"); break;
				default:
					System.out.println("Numero muito grande para ser representado, a função só funcionará com dados de até seis lados.");
			}
		}
		mat = mat.concat("\n");
		for (int j = 0; j < 5; j++) {
			switch (dados[j].getLado())
			{
				case 1:
					mat = mat.concat(tipo1).concat("\t"); break;
				case 2:
					mat = mat.concat(tipo5).concat("\t"); break;
				case 3:
					mat = mat.concat(tipo5).concat("\t"); break;
				case 4:
					mat = mat.concat(tipo3).concat("\t"); break;
				case 5:
					mat = mat.concat(tipo3).concat("\t"); break;
				case 6:
					mat = mat.concat(tipo3).concat("\t"); break;
				default:
					System.out.println("Numero muito grande para ser representado, a função só funcionará com dados de até seis lados.");
			}
		}
		mat = mat.concat("\n");
		for (int j = 0; j < 5; j++)
			mat = mat.concat(tipo6).concat("\t");

		return mat;
	}
}
