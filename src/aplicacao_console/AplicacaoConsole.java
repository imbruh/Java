package aplicacao_console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Pedido;
import modelo.PedidoExpress;
import modelo.Produto;

public class AplicacaoConsole {
	public static void main(String[] args){
		try {	
			Produto p;
			Cliente c;
			Pedido pe;
			Pedido pex;
			
			// CRIANDO PRODUTOS, CLIENTES E PEDIDOS
			p = Fachada.cadastrarProduto("arroz", 3.0); 	
			p = Fachada.cadastrarProduto("feijao", 5.0); 	
			p = Fachada.cadastrarProduto("leite", 2.0); 	
			p = Fachada.cadastrarProduto("carne", 30.0); 	
			p = Fachada.cadastrarProduto("oleo", 10.0); 
			
			c = Fachada.cadastrarCliente("477506885","Maria", "rua a"); 	
			c = Fachada.cadastrarCliente("378442213","Pedro", "rua b"); 	
			c = Fachada.cadastrarCliente("273100456","Carla", "rua c"); 	
			c = Fachada.cadastrarCliente("137636897","Gabriel", "rua d"); 	
			c = Fachada.cadastrarCliente("291583663","Camila", "rua e"); 	
			
			pe = Fachada.criarPedido("477506885","João"); 	
			pe = Fachada.criarPedido("378442213","José"); 	
			pe = Fachada.criarPedido("273100456","Marcos"); 	
			pe = Fachada.criarPedido("137636897","João");
			pex = Fachada.criarPedidoExpress("477506885","João", 10);  

	        //ADICIONANDO PRODUTOS
	        try {
	        	System.out.println("\n------------Adicionar Produtos-----------------");
	            Fachada.adicionarProdutoPedido(1,2);
	            Fachada.adicionarProdutoPedido(1,1);
	            Fachada.adicionarProdutoPedido(1,5);
	            Fachada.adicionarProdutoPedido(1,3);
	            Fachada.adicionarProdutoPedido(1,5);
	            Fachada.adicionarProdutoPedido(2,2);
	            Fachada.adicionarProdutoPedido(2,4);
	            Fachada.adicionarProdutoPedido(2,5);
	            Fachada.adicionarProdutoPedido(3,1);
	            Fachada.adicionarProdutoPedido(3,2);
	            Fachada.adicionarProdutoPedido(3,5);
	            Fachada.adicionarProdutoPedido(4,1);
	            Fachada.adicionarProdutoPedido(4,2);
	            Fachada.adicionarProdutoPedido(4,5);
	            Fachada.adicionarProdutoPedido(4,3);
	            Fachada.adicionarProdutoPedido(5,1);
	            Fachada.adicionarProdutoPedido(5,2);
	            Fachada.adicionarProdutoPedido(5,3);
	            Fachada.adicionarProdutoPedido(5,4);
	            Fachada.adicionarProdutoPedido(5,5);
	            System.out.println("Produtos adicionados com sucesso!\n");
	        }catch (Exception e){
	            System.out.println("==> "+e.getMessage());
	        }
	        System.out.println(Fachada.listarPedido());

	        //REMOVER PRODUTO EM PEDIDO
	        try {
	        	System.out.println("\n------------Remover Produtos-----------------");
	            Fachada.removerProdutoPedido(1,2);
	            Fachada.removerProdutoPedido(2,4);
	            Fachada.removerProdutoPedido(3,2);
	            Fachada.removerProdutoPedido(1,5);
	            Fachada.removerProdutoPedido(4,3);
	            System.out.println("Produtos removidos com sucesso!\n");
	        }catch (Exception e){
	            System.out.println("==> "+e.getMessage());
	        }
	        System.out.println(Fachada.listarPedido());
		}
		catch (Exception e) {
			System.out.println("==> "+ e.getMessage());
		}
		
		//PAGAR PEDIDO
		try{
			System.out.println("------------Pagar Pedido-----------------");
			Fachada.pagarPedido(1, "João");
			Fachada.adicionarProdutoPedido(1,5);
			System.out.println(Fachada.consultarPedido(1));
			Fachada.pagarPedido(2, "José");
			System.out.println(Fachada.consultarPedido(2));
		}
		catch (Exception e){
			System.out.println("==> "+ e.getMessage());
		}
		
		//CANCELAR PEDIDO
		try{
			System.out.println("------------Cancelando Pedido-----------------");
			Fachada.cancelarPedido(3);
		}
		catch (Exception e) {
			
		}
		
		//PESQUISAR PRODUTOS POR NOME
        try { 
        	System.out.println("\n------------Consultar Produtos-----------------");
            System.out.println(Fachada.listarProduto("ar"));
        }catch (Exception e){
            System.out.println("==> "+ e.getMessage());
        }
		
		//LISTAR CLIENTES
		try {
			System.out.println("\n------------Listando Clientes-----------------");
			System.out.println(Fachada.listarCliente());
		}
		catch (Exception e) {
			System.out.println("==> "+ e.getMessage());
		}
		
		//LISTAR PEDIDOS
        try {
        	System.out.println("------------Listando Pedidos-----------------");
			System.out.println(Fachada.listarPedido());
			System.out.println("Pedidos Pagos");
			System.out.println(Fachada.listarPedido("477506885",1));
			System.out.println("Pedidos Não Pagos");
			System.out.println(Fachada.listarPedido("477506885",2));
			System.out.println("Todos os pedidos");
			System.out.println(Fachada.listarPedido("477506885",3)); 
		}
		catch (Exception e) {
			System.out.println("==> "+ e.getMessage());
		}
        
        //CONSULTAR ARRECADACAO
        try {
        	System.out.println("\n------------Consultando arrecadações do dia-----------------");
			System.out.println("Valor Total: " + Fachada.consultarArrecadacao(01));
		
        }
        catch (Exception e){
        	System.out.println("==> "+ e.getMessage());
        }
        
        System.out.println("\n------------Produto TOP-----------------");
        System.out.println(Fachada.consultarProdutoTop());
        
	}
}
