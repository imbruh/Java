package aplicacao_console;

import fachada.Fachada;
import modelo.Assunto;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

public class Atualizar {
	public Atualizar() {
		try {
			Fachada.inicializar();
			
			// Usuario
			try {
	            System.out.println(Fachada.atualizarUsuario("luiza22@gmail.com", "luiza20@gmail.com"));
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }
			
			//Assunto
			try {
	            System.out.println(Fachada.atualizarAssunto("python", "python iniciante"));
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }
			
			//Nome do video
			try {
	            System.out.println(Fachada.atualizarVideoNome("melhor linguagem", "Melhor linguagem"));
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }
			
			//Link do Video
			try {
	            System.out.println(Fachada.atualizarLink("Aula de introdução a python", "https://www.youtube.com/watch?v=Q8eajxcS6dQ"));
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }
			
			//Adicionar mais assuntos no video
			try {
	            System.out.println(Fachada.adicionarAssunto("banco java", "Utilizando DB4O no java"));
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
	}
	

	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}
