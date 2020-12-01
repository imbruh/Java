package fachada;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Cliente;
import modelo.Pedido;
import modelo.PedidoExpress;
import modelo.Produto;
import repositorio.Repositorio;

public class Fachada {
	private static Repositorio repositorio = new Repositorio();
	static Scanner teclado = new Scanner(System.in);

//-----------------------------------------------------------------------------------	
	
	//LISTAR
	public static String listarCliente() throws Exception {
		String clientes=repositorio.listarCli();
		if (clientes.equals("")) {
			throw new Exception("Nenhum cliente cadastrado");
		}
        return clientes;
	}
	
	public static String listarProduto(String prod) throws Exception {
		String produtos = repositorio.listarProd(prod);
		if (produtos.equals("")) {
			throw new Exception("Nenhum produto encontrado");
		}
		return produtos;
	}
	
	public static String listarPedido() throws Exception{
		String pedidos = repositorio.listarPed();
		if (pedidos.equals("")) {
			throw new Exception("Nenhum pedido cadastrado");
		}
		return pedidos;
	}
	
	public static String listarPedido(String telefone, int tipo) throws Exception {
        if(tipo!= 1 && tipo!=2 && tipo!=3) {
        	throw new Exception("Tipo invalido");
        }
		String lista = repositorio.listarPedido(telefone, tipo);
        return lista;
    }
	
//-----------------------------------------------------------------------------------
	
	//CADASTRAR
	public static Produto cadastrarProduto(String nome, double preco) throws  Exception{
		Produto p = repositorio.localizarProduto(nome);
		if (p!=null)
			throw new Exception("cadastrar produto - produto ja cadastrado: " + nome);
		p = new Produto(nome, preco);
		repositorio.adicionar(p);
		return p;
	}
	
	public static Cliente cadastrarCliente(String telefone, String nome, String endereco) throws  Exception{
		Cliente c = repositorio.localizarCliente(telefone);
		if (c!=null)
			throw new Exception("cadastrar cliente - cliente ja cadastrado: " + nome);
		c = new Cliente(telefone, nome, endereco);
		repositorio.adicionar(c);
		return c;
	}
	
	public static Pedido criarPedido(String telefone, String entregador) throws  Exception{
		Cliente c = repositorio.localizarCliente(telefone);
		if (c==null) {
			System.out.println("\n==Cadastrar Novo Cliente==");
			Scanner teclado = new Scanner(System.in);
			System.out.print("nome: ");			
			String nome = teclado.nextLine();		
			System.out.print("endereco: ");
			String endereco = teclado.nextLine();
			c = cadastrarCliente(telefone, nome, endereco);
			System.out.println("Cliente cadastrado");
		}
		Pedido pe = repositorio.localizarPedido(telefone);
		pe = new Pedido(c, entregador);
		repositorio.adicionar(pe);
		return pe;
	}
	
	public static Pedido criarPedidoExpress(String telefone, String entregador, double taxa) throws  Exception{
		Cliente c = repositorio.localizarCliente(telefone);
		if (c==null) {
			System.out.println("\n==Cadastrar Novo Cliente==");
			Scanner teclado = new Scanner(System.in);
			System.out.print("nome: ");			
			String nome = teclado.nextLine();		
			System.out.print("endereco: ");
			String endereco = teclado.nextLine();
			c = cadastrarCliente(telefone, nome, endereco);
			System.out.println("Cliente cadastrado");
		}
		Pedido pex = repositorio.localizarPedido(telefone);
		pex = new PedidoExpress(c, entregador, taxa);
		repositorio.adicionar(pex);
		return pex;
	}
	
//-----------------------------------------------------------------------------------
	
	//ADICIONAR E REMOVER PRODUTO	
	public static void adicionarProdutoPedido(int idpedido, int idproduto) throws Exception {
        Pedido pedido = repositorio.localizarPedido(idpedido);
        if(pedido==null) {
        	throw new Exception("pedido " + idpedido + " inexistente");
        }     
        Produto produto = repositorio.localizarProduto(idproduto);
        if(produto==null) {
        	throw new Exception("produto inexistente");
        }        
        repositorio.adicionarProdutoPedido(idpedido, idproduto);
    }
	
	public static void removerProdutoPedido(int idpedido, int idproduto) throws Exception {
        Pedido pedido = repositorio.localizarPedido(idpedido);
        if(pedido==null) {
        	throw new Exception("Pedido " + idpedido + " inexistente");
        }     
        Produto produto = repositorio.localizarProduto(idproduto);
        if(produto==null) {
        	throw new Exception("Produto inexistente");
        }
        repositorio.removerProdutoPedido(idpedido, idproduto);
    }
	
//-----------------------------------------------------------------------------------
	
	//CONSULTAR PEDIDO
	public static Pedido consultarPedido(int idpedido) throws Exception{
		Pedido pedido = repositorio.localizarPedido(idpedido);
		if(pedido==null) {
			throw new Exception("Pedido n�o encontrado");
		}
		return pedido;
	}
	
//-----------------------------------------------------------------------------------
	
	//PAGAR PEDIDO
	public static void pagarPedido(int idpedido, String entregador) throws Exception{
		Pedido pedido = repositorio.localizarPedido(idpedido);
		if(pedido==null) {
			throw new Exception("Pedido n�o encontrado");
		}
		if(!entregador.equals(pedido.getEntregador())) {
			throw new Exception("Entregador invalido");
		}
		if(pedido.isPago()) {
			throw new Exception("Pedido ja foi pago!");
		}	
		pedido.setPago(true);
	}

//-----------------------------------------------------------------------------------
	
	//CANCELAR PEDIDO
	public static void cancelarPedido(int id_pedido) throws Exception{
        Pedido pedido=repositorio.localizarPedido(id_pedido);
        if (pedido==null) {
            throw new Exception("Pedido n�o encontrado.");
        }
        //repositorio.removerProdutoPedido(id_pedido, idproduto);
        repositorio.apagarPedido(pedido);
    }
	
//-----------------------------------------------------------------------------------
	
	//CONSULTAR ARRECADA�AO
	public static double consultarArrecadacao(int dia) throws Exception{
		double valor = repositorio.consultarArrecadacao(dia);		
		if(valor==0) {
			throw new Exception("N�o houve pedidos nesse dia");
		}
		return valor;
	}
	
//-----------------------------------------------------------------------------------
	
	//CONSULTAR PRODUTO TOP
	public static Produto consultarProdutoTop() {
		return repositorio.produtoTop();
	}
}