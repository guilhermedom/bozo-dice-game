/*PROGRAMAÇÃO ORIENTADA A OBJETOS. PROF. Marcio E. Delamaro.
 * ELABORADO E IMPLEMENTADO POR:
 * Nome: Guilherme Domingos Faria Silva		NUSP: 9361094
 * Nome:
 */

/*	Esta classe foi criada para calcular
 *  e imprimir na tela o resultado da pontuacao
 *  de um jogador no jogo Bozo
 */

package backend;

public class Placar {
	public int[] placar_pontos = new int[10];
	private int sum;
	
	/* Adiciona uma sequencia de dados a uma posicao do placar
	 * verificando e calculando a pontuacao feita com base
	 * nos dados do jogador e a posicao escolhida
	 */
	public void add(int posicao, int[] dados) throws java.lang.IllegalArgumentException {
				sum = 0;
				
				
				// Calcula a pontuacao de dados iguais para as posicoes de 1 a 6 no placar
				if(posicao < 7){
					for(int i=0; i< 5; i++){
						if(dados[i] == posicao)
							sum += posicao;
					}
				
				// Full Hand
				}else if(posicao == 7){
					
					// Ordena os dados
					int[] sdados = new int[5];
					sdados = sorting(dados,5);
					
					int flag = 0;
					// Verifica quem esta primeiro, trinca ou dupla
					if(sdados[1] == sdados[2]){ // possivelmente Trinca primeiro ou tds iguais
						if(!(sdados[0] == sdados[1] && sdados[3] == sdados[4])){
							flag = 1;
						}
					}else{	// possivelmente dupla primeiro
						if(!(sdados[0] == sdados[1] && sdados[2] == sdados[3] &&
								sdados[3] == sdados[4])){
							flag = 1;
						}
					}
					if(flag != 1)
						sum = 15;
				
				// Sequencia	
				}else if(posicao == 8){
				
					// Ordena os dados
					int[] sdados = new int[5];
					sdados = sorting(dados,5);
					
					int flag = 0;
					
					// Verifica se estao em sequencia
					for(int i=0; i<4; i++){
						if(sdados[i]+1 != sdados[i+1]){
							flag = 1;
						}
					}
					
					if(flag != 1){
						sum = 20;
					}
				
				// Quadra	
				}else if(posicao == 9){
					
					// Ordena os dados
					int[] sdados = new int[5];
					sdados = sorting(dados,5);
					
					int start = 0,end = 5,flag = 0;
					if(sdados[0] == sdados[1])
						end--;
					else
						start++;
					
					for(int i = start; i< end-1; i++){
						if(sdados[i] != sdados[i+1])
							flag = 1;
					}
					
					if(flag != 1)
						sum = 30;
				// Quina	
				}else if(posicao == 10){
					// Verifica se todos os dados sao iguais
					int counter = 0,flag = 0;
					while(flag == 0 && counter < 4){
						if(dados[counter++] != dados[counter]){
							flag = 1;
						}
					}
					if(flag != 1)
						sum = 40; // se tds os dados forem iguais
				}
				
				// Atribui o valor final ao placar
				placar_pontos[posicao-1] = sum;
	}
	
	/* Realiza a soma dos valores 
	 * das posicoes dos placares
	 */
	public int getScore() {
		sum = 0;
		for(int i=0; i < 10; i++){
			if(placar_pontos[i] > -1){
				sum += placar_pontos[i]; 
			}
		}
		
		for(int i=0;i<10;i++){
			System.out.printf("(%d)%d ", i+1, placar_pontos[i]);
		}
		return sum;
	}
	
	/* Representacao do placar
	 * com posicoes ja preenchidas e
	 * nao preenchidas
	 */
	public java.lang.String toString() {
		String score = new String();
		
		// Salvando as 3 primeiras partes do placar
		for(int i=0; i < 3; i++){
			// escrevendo cada parte do placar	
			if(placar_pontos[i] != -1)
				score += placar_pontos[i];
			else
				score += "(" + (i+1) + ")";
			score += "\t|\t";
			if(placar_pontos[i+6] != -1)
				score += placar_pontos[i+6];
			else
				score += "(" + (i+7) + ")";
			score += "\t|\t";
			if(placar_pontos[i+3] != -1)
				score += placar_pontos[i+3];
			else
				score += "(" + (i+4) + ")";
			
			score += " \n--------------------------------------\n";
		}
		
		
		score += "\t|\t";
		
		if(placar_pontos[9] != -1)
			score += placar_pontos[9];
		else
			score += "(" + 10 + ")";
	
		score += "\t|\n";
		score += "\t+---------------+ \n"; 
		
		return score;
	}
	
	/*
	 * Ordena os valores dos dados
	 */
	private int[] sorting(int[] d,int n){
		int[] sd = new int[n];
			
		for(int i=0; i < n; i++){
			sd[i] = d[i];
		}
		
		for(int i=0; i< 5; i++){
			for(int j=i ; j< 4 ;j++){
				if(sd[j] > sd[j+1]){
					// swap
					int aux = sd[j];
					sd[j] = sd[j+1];
					sd[j+1]  = aux;
				}
			}
		}
		
		return sd;
	}
	
	// construtor
	public Placar(){
		for(int i=0;i<10;i++){
			placar_pontos[i] = -1;
		}	
	}
	
}