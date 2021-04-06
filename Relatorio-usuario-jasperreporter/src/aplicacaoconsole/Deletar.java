package aplicacaoconsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;


public class Deletar {

	public Deletar(){
		try {
			Fachada.inicializar();
			
			try {
				Fachada.excluirUsuario("teste");
				System.out.println("deletou teste");
			}
			catch (Exception e) {System.out.println(e.getMessage());}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Fachada.finalizar();
		}

		System.out.println("fim do programa");
	}


	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}

