package projeto_final;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class TicTacToe_JOGO {
	
	public static int [][] tabela = new int[3][3];
	public static int vez_jogador = 1; //  1 = JOGADOR X
	                                   //  2 = JOGADOR O
	
	public static String jogador = "X";	   		//letra do jogador a jogar
	public static boolean winner = false;  		//variavel que verifica se alguem ganhou ou empatou
	public static String jogadorX, jogadorO;	//variável para guardar o nome dos jogadores
	public static int n_jogadas_validas = 9;    //variavel a contar o numero de jogadas feitas (máx = 9)
	public static int pontosX = 0, pontosO = 0;
	
	public static boolean type_of_game; //false = player vs player
	 									//true = player vs computer
	
	public static Scanner sc = new Scanner(System.in);
	
	//funcao que retorna 0 caso nao tiver ganho
	public static boolean verificaSeGanhou() {
		

	    //Verificar linhas e colunas
	    for (int i = 0; i < 3; i++) {
	    	
	    	//verifica cada linha procurando se alguem ganhou
	        if (tabela[i][0] != 0 && tabela[i][0] == tabela[i][1] && tabela[i][0] == tabela[i][2]) {
	            winner = true;
	            break;
	        }
	      //verifica cada coluna procurando se alguem ganhou
	        if (tabela[0][i] != 0 && tabela[0][i] == tabela[1][i] && tabela[0][i] == tabela[2][i]) {
	            winner = true;
	            break;
	        }
	    }

	    // verifica diagonais
	    if (tabela[1][1] != 0) {
	        if (tabela[0][0] == tabela[1][1] && tabela[0][0] == tabela[2][2]) {
	            winner = true;
	        } else if (tabela[0][2] == tabela[1][1] && tabela[0][2] == tabela[2][0]) {
	            winner = true;
	        }
	    }

	    return winner;
	}
	
	public static int jogada(int posX, int posY) {
		
			//while loop a verificar o numero de jogadas validas possiveis
			//se n_jogadas_validas 
			while(n_jogadas_validas > 0 && !winner) {
				
				//verificar se a jogada é válida
				if(tabela[posX][posY] == 0) {
					tabela[posX][posY] = vez_jogador;
					n_jogadas_validas--;
				
				//verificar se alguem ganhou
				//break é necessário para guardar a vez_do_jogador que ganhou a jogada
				if(verificaSeGanhou()) {
					if(vez_jogador == 1) {
						pontosX++;
					}else {
						pontosO++;
					}
					break;
				}
			
				if(vez_jogador == 1) {
					vez_jogador = 2;
					jogador = "O";
					return vez_jogador;
					
				}else {
					vez_jogador = 1;
					jogador = "X";
					return vez_jogador;
				}				
				}else {
			
					//System.out.println("Selecionou uma posição ocupada!.");
			
				}
			}
			
			if(winner) {
				System.out.println("Jogo acabou! O jogador " + vez_jogador + " ganhou!");
			} else if(n_jogadas_validas == 0){
				System.out.println("O jogo empatou!");
			}
			
			
			return vez_jogador;
			
	}
	
	//mantem os nomes do jogadores
		//reset a todas as outras variáveis para o estado inicial
		public static void novo_jogo() {
			
			vez_jogador = 1;
			jogador = "X";	   		//letra do jogador a jogar
			winner = false;  		//variavel que verifica se alguem ganhou ou empatou
			n_jogadas_validas = 9; 
			
		}
	
	//mantem os nomes do jogadores
	//reset a todas as outras variáveis para o estado inicial
	public static void jogar_novamente() {
		
		vez_jogador = 1;
		jogador = "X";	   		//letra do jogador a jogar
		winner = false;  		//variavel que verifica se alguem ganhou ou empatou
		n_jogadas_validas = 9; 
		
	}
			
	
	public static void print_jogo() {
		
		
		System.out.println();
		System.out.println();
		for(int x = 0; x <= 2; x++) {
			for(int y = 0; y <= 2; y++) {
				//System.out.println("x = " + x);
				//System.out.println("y = " + y);
				System.out.print(tabela[x][y] + " ");
				if(y == 2) {
					System.out.println();
					
				}
			}
		}
	}
	
	public static void jogar() {
		
		print_jogo();
		System.out.println("Digite a posicao x:");
		int x = sc.nextInt();
		System.out.println("Digite a posicao y:");
		int y = sc.nextInt();
		jogada(x, y);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JdbcExer jogo_db = new JdbcExer();
		jogo_db.conectar();
				
		if(jogo_db.estaconectado()){
					
			
		    String nome[] = jogo_db.retorna_nome(1);
		    System.out.println(nome[0] + " e " + nome[1]);
			//jogo_db.inserirDataJogo(nomeX, nomeO , pontosX, pontosO);//colocar aqui o NOME DOS CAMPOS DA SUA bd
			jogo_db.logout();
					
			}else {
				System.out.println("Nao foi possivel ligar a BD");
				return; //para o evento caso nao seja possivel ligar a BD
					
			}
		
		
		/*while( winner == false) {
			jogar();
		}
		
		if(winner == true) print_jogo(); */
		
	}
}

