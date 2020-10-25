import java.awt.Color;
import java.util.Random;

public class JogoMemoria {
	private String[][] marcadores = new String[4][4];
	private int maxTentativas = 0;
	private int acertos = 0;
	public Color[] paleta = {Color.RED, Color.BLUE,Color.YELLOW,Color.CYAN,Color.BLACK,Color.GRAY,Color.GREEN,Color.PINK};
	public Color[][] cores = new Color[4][4];
	
	public JogoMemoria ( Color[] paleta){
		this.paleta = paleta;
		Random random = new Random();
		int linhaRandom, colunaRandom;
		
		for(int i=0; i<8; i++) {
			for(int col=0; col<2; col++) {
				do {
					linhaRandom = random.nextInt(4);
					colunaRandom = random.nextInt(4);
				}
				while(cores[linhaRandom][colunaRandom] != null); 
					
				cores[linhaRandom][colunaRandom] = paleta[i];
			}
		}
		
		for(int lin=0; lin<4; lin++) {
			for(int col=0; col<4; col++) {
				marcadores[lin][col] = "-";
			}
		}	
	}	

	public boolean adivinhar(int linha1, int coluna1, int linha2, int coluna2) throws Exception {
			while( (linha1>=0 && linha1<4 && coluna1>=0 && coluna1<4) && (linha2>=0 && linha2<4 && coluna2>=0 && coluna2<4) ) {
				if(cores[linha1][coluna1] == cores[linha2][coluna2]) {
					marcadores[linha1][coluna1] = "X";
					marcadores[linha2][coluna2] = "X";
					maxTentativas++;
					acertos++;
					return true;
				}
				else {
					maxTentativas++;
					return false;
				}
			}
			throw new Exception("posição invalida");
		};				
	
	public boolean terminou() {
		if(acertos==8 || maxTentativas==30) {
			return true;
		}
		return false;
	}
	
	public Color getCor (int linha, int coluna) {	
			return cores[linha][coluna];		
	}	
	
	public String getResultadoFinal() {
		if(maxTentativas==30) {
			return "Terminou com " + maxTentativas + " tentativas";
		}
		else {
			return "Você ganhou com " + maxTentativas + " tentativas";
		}
	}
	
	public int getAcertos() {
		return acertos;
	}
	
	public int getTentativas() {
		return maxTentativas;
	}
	
	public String toString() {
		String nova_matriz = new String();
		for(int lin=0; lin<4; lin++) {
			for(int col=0; col<4; col++) {
				nova_matriz = marcadores[lin][col] + "   ";
			}
		}
		return nova_matriz;
	}
}
	
	
