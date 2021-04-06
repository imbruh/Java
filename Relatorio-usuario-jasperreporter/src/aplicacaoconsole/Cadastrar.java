package aplicacaoconsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Usuario;


public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();
			
			System.out.println("cadastrando...");
			Usuario u;
			
			u=Fachada.cadastrarUsuario("teste", "teste@gmail.com", "teste123");
			u=Fachada.cadastrarUsuario("joao", "joao@gmail.com", "joazinho15");
			u=Fachada.cadastrarUsuario("maria", "maria@gmail.com", "maria2000");
			u=Fachada.cadastrarUsuario("jose", "jose@gmail.com", "jose_silva1");
			u=Fachada.cadastrarUsuario("paulo", "paulo@gmail.com", "123456");
			
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


