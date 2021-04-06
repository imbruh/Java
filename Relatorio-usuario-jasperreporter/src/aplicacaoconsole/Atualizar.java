package aplicacaoconsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;


public class Atualizar {

	public Atualizar(){
		Fachada.inicializar();
		
		try {
			Fachada.alterarNomeUsuario("paulo", "paula");
			System.out.println("alterando paulo para paula");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.alterarEmailUsuario("maria", "marialuiza@gmail.com");
			System.out.println("alterando maria@gmail.com para marialuiza@gmail.com");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fachada.alterarSenhaUsuario("maria", "mari@2000");
			System.out.println("alterando senha");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		Fachada.finalizar();
		System.out.println("fim do programa");
	}


	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}

