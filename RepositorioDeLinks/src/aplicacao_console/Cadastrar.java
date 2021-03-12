package aplicacao_console;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Assunto;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;


public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();
			
			System.out.println("cadastrando...");
			Usuario u;
			Assunto a;
			Video vid;
			Visualizacao visu;
			
			// Usuario
	        try {
	            u=Fachada.cadastrarUsuario("joao@gmail.com");
	            System.out.println(u);
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }

	        try {
	            u=Fachada.cadastrarUsuario("joaovictor@gmail.com");
	            System.out.println(u);
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }
	        try {
	            u=Fachada.cadastrarUsuario("carlos123@gmail.com");
	            System.out.println(u);
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }
	        try {
	            u=Fachada.cadastrarUsuario("joaovictor@gmail.com");
	            System.out.println(u);
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }
	        try {
	            u=Fachada.cadastrarUsuario("clara00@gmail.com");
	            System.out.println(u);
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }
	        try {
	            u=Fachada.cadastrarUsuario("luiza22@gmail.com");
	            System.out.println(u);
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }
			
	     // ASSUNTOS
	        try {
	            a=Fachada.cadastrarAssunto("javascript");
	            System.out.println(a);
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }

	        try {
	            a=Fachada.cadastrarAssunto("python");
	            System.out.println(a);
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }
	        try {
	            a=Fachada.cadastrarAssunto("java");
	            System.out.println(a);
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }
	        try {
	            a=Fachada.cadastrarAssunto("python");
	            System.out.println(a);
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }
	        try {
	            a=Fachada.cadastrarAssunto("php");
	            System.out.println(a);
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }
	        try {
	            a=Fachada.cadastrarAssunto("programacao");
	            System.out.println(a);
	        }
	        catch (Exception e) {
	            System.out.println("==> "+e.getMessage());
	            System.out.println();
	        }
			
	     // VIDEO
	        try {
	          vid=Fachada.cadastrarVideo("https://www.youtube.com/watch?v=2_FJrmft3uQ&ab_channel=FilipeDeschamps","melhor linguagem", "javascript");
	          System.out.println(vid);
	          System.out.println();
	        }
	        catch (Exception e) {
	        	System.out.println("==> "+e.getMessage());
	        	System.out.println();
	        }
	        try {
	          vid=Fachada.cadastrarVideo("https://www.youtube.com/watch?v=uEEuSYkM9o4&ab_channel=SolydOffensiveSecurity","Aula de introdução a python", "python");
	          System.out.println(vid);
	          System.out.println();
	         }
	         catch (Exception e) {
	          System.out.println("==> "+e.getMessage());
	          System.out.println();
	         }
	        try {
		        vid=Fachada.cadastrarVideo("https://www.youtube.com/watch?v=WWZX8RWLxIk&ab_channel=CursoemV%C3%ADdeo","Introdução ao DOM", "javascript");
		        System.out.println(vid);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
	        try {
		        vid=Fachada.cadastrarVideo("https://www.youtube.com/watch?v=dKwy4rORvgw&ab_channel=Extraclasse","Utilizando DB4O no java", "java");
		        System.out.println(vid);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
	        try {
		        vid=Fachada.cadastrarVideo("https://www.youtube.com/watch?v=cL4YDtFnCt4&ab_channel=CursoemV%C3%ADdeo","Repetição em python", "python");
		        System.out.println(vid);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
	        try {
		        vid=Fachada.cadastrarVideo("https://www.youtube.com/watch?v=Ki1xh9U23r8&ab_channel=ZeroBugs","Como conectar o mysql com o php", "php");
		        System.out.println(vid);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
	        try {
		        vid=Fachada.cadastrarVideo("https://www.youtube.com/watch?v=dKwy4rORvgw&ab_channel=Extraclasse","Utilizando DB4O no java", "java");
		        System.out.println(vid);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
	        try {
		        vid=Fachada.cadastrarVideo("https://www.youtube.com/watch?v=C_3qWjNVbPU&ab_channel=DevMedia","Logica de programação e algoritimos", "programacao");
		        System.out.println(vid);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
			
	        // VISUALIZACAO
	        try {
	        	visu=Fachada.cadastrarVisualizacao(5, "joaovictor@gmail.com", "melhor linguagem");
		        System.out.println(visu);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
	        try {
	            visu=Fachada.cadastrarVisualizacao(4, "joao@gmail.com", "melhor linguagem");
		        System.out.println(visu);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
	        try {
	            visu=Fachada.cadastrarVisualizacao(5, "joao@gmail.com", "Aula de introdução a python");
		        System.out.println(visu);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
	        try {
	            visu=Fachada.cadastrarVisualizacao(5, "joaovictor@gmail.com", "Aula de introdução a python");
		        System.out.println(visu);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
	        try {
	            visu=Fachada.cadastrarVisualizacao(5, "clara00@gmail.com", "Aula de introdução a python");
		        System.out.println(visu);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
	        try {
	            visu=Fachada.cadastrarVisualizacao(3, "joao@gmail.com", "Aula de introdução a python");
		        System.out.println(visu);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
	        try {
	            visu=Fachada.cadastrarVisualizacao(3, "carlos123@gmail.com", "Como conectar o mysql com o php");
		        System.out.println(visu);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
	        try {
	            visu=Fachada.cadastrarVisualizacao(3, "carlos123@gmail.com", "Como conectar o mysql com o php");
		        System.out.println(visu);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
	        try {
	            visu=Fachada.cadastrarVisualizacao(3, "clara00@gmail.com", "Introdução ao DOM");
		        System.out.println(visu);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
	        try {
	            visu=Fachada.cadastrarVisualizacao(3, "joao@gmail.com", "Logica de programação e algoritimos");
		        System.out.println(visu);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
	        try {
	            visu=Fachada.cadastrarVisualizacao(4, "luiza22@gmail.com", "melhor linguagem");
		        System.out.println(visu);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
	        try {
	            visu=Fachada.cadastrarVisualizacao(4, "allan20@gmail.com", "melhor linguagem");
		        System.out.println(visu);
		        System.out.println();
		      }
		      catch (Exception e) {
		       System.out.println("==> "+e.getMessage());
		       System.out.println();
		      }
							
		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
		System.out.println("fim do programa");
	}


	public void cadastrar(){

	}	


	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


