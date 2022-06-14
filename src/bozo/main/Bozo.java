/*PROGRAMAÇÃO ORIENTADA A OBJETOS. PROF. Marcio E. Delamaro.
 * ELABORADO E IMPLEMENTADO POR:
 * Nome: Guilherme Domingos Faria Silva		NUSP: 9361094
 * Nome:
 */

package bozo.main;

import java.io.IOException;
import backend.Placar;
import backend.RolaDados;
import entrada.EntradaTeclado;
import exceção.ETException;

public class Bozo {

	public static void main(String[] args) {
		
		RolaDados rd = new RolaDados(6);
		Placar score = new Placar();
		int[] dados = new int[6];
		
		// Jogar 10 rodadas
		for(int i=0 ; i<10 ; i++){
			// Inicio da Rodada 
			System.out.println("Pressione ENTER para iniciar a rodada:");
			@SuppressWarnings("unused")
			String enter = EntradaTeclado.leString();
			
			// Rolar os dados - 1 rodada
			dados = rd.rolar();
			//for(int k=0;k<5; k++) System.out.printf("[%d]", dados[k]);
			System.out.println(rd.toString());
			
			// 2 e 3 rodadas
			for(int j=0; j<2 ; j++){
				// --- Escolha dos dados a serem rolados ---
				System.out.println("\nEscolha os dados a serem rolados, ou pressione ENTER para manter os dados atuais: ");
				String dados_rolados = new String();
				dados_rolados =  EntradaTeclado.leString();
				
				// --- Rolar dados selecionados ---
				dados = rd.rolar(dados_rolados);
				//for(int k=0;k<5; k++) System.out.printf("[%d]", dados[k]);
				System.out.println(rd.toString());
			}		
			// Placar atual
			System.out.println(score.toString());
			
			// Selecao da posicao ocupada
			int flag = 0;
			while(flag == 0){
				System.out.println("Selecione qual posicao ocupar: ");
				int pos = 0;
				try {
					pos = EntradaTeclado.leInt();
				} catch (ETException ex) {
					ex.getMessage();
				}
				
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(score.placar_pontos[pos-1] == -1){	
					score.add(pos, dados);
					flag = 1;
				}
				else
					System.out.println("Erro. Selecione uma posição válida e não ocupada: ");
			}
			
			//for(int j=0;j<5; j++) System.out.printf("[%d]", dados[j]);
			//System.out.printf("\n");
			
			// Placar atualizado
			System.out.println("\n\n" + score.toString());
		}	
		
		// Pontuacao final
		System.out.println("\nSua pontuação final é: " + score.getScore());
	}
}
