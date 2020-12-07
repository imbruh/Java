package repositorio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Produto;
import modelo.Pedido;
import modelo.PedidoExpress;

public class Repositorio {
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Produto> produtos = new ArrayList<>();
	private static ArrayList<Pedido> pedidos = new ArrayList<>();
	private static ArrayList<PedidoExpress> pedidosExpress = new ArrayList<>();
	
	public String listarCli() {
			String nomes="";
	        for (Cliente c : clientes) {
	            nomes+=c + "\n";
	        }
	        return nomes + "\n";
	 }
	
	public void adicionar(Cliente c){
		clientes.add(c);
	}
	
	public void remover(Cliente c){
		clientes.remove(c);
	}
	
	public Cliente localizarCliente(String telefone){
		for(Cliente c : clientes){
			if(c.getTelefone().equals(telefone))
				return c;
		}
		return null;
	}
	
	public String listarProd(String texto) {
		String prods = "";
		for(Produto p : produtos) {
			if(p.getNome().contains(texto)) {
				prods += p + "\n";
			}
		}
		return prods;
	}
	
	public void adicionar(Produto prod){
		 int id=0;
	        for (Produto p : produtos) {
	            id=p.getId();
	        }
	        id++;
	        prod.setId(id);  
	        produtos.add(prod);
	}
	
	public void remover(Produto p){
		produtos.remove(p);
	}
	
	public Produto localizarProduto(String nome){
		for(Produto p : produtos){
			if(p.getNome().equals(nome))
				return p;
		}
		return null;
	}
	
	public String listarPed() {
		String peds = "";
		for(Pedido pe : pedidos) {
			peds += pe + "\n";			
		}
		return peds + "\n";
	}
	
	public void adicionar(Pedido pedido) {
        int id=0;
        for (Pedido pe : pedidos) {
            id=pe.getId();
        }
        id++;
        pedido.setId(id);
        LocalDateTime agora = LocalDateTime.now();
        pedido.setDatahora(agora);
        pedidos.add(pedido);
    }
	
	public void remover(Pedido pe){
		pedidos.remove(pe);
	}
	
	public Pedido localizarPedido(String telefone){
		for(Pedido pe : pedidos){
			if(pe.getCliente().getTelefone().equals(telefone))
				return pe;
		}
		return null;
	}
	
	public Pedido localizarPedido(int id){
		for(Pedido pe : pedidos){
			if(pe.getId() == id)
				return pe;
		}
		return null;
	}
	
	public Produto localizarProduto(int id){
		for(Produto p : produtos){
			if(p.getId() == id)
				return p;
		}
		return null;
	}
	
	public void adicionarProdutoPedido(int idpedido, int idproduto) {
		Pedido pedido = localizarPedido(idpedido);
		Produto produto = localizarProduto(idproduto);
		Cliente cliente = localizarCliente(pedido.getCliente().getTelefone());
		if(!(cliente.getPedidosId().contains(idpedido))) {
			cliente.addPedido(pedido);
		}
		if(!pedido.isPago()) {
			pedido.addProdutos(produto);
			produto.addPedido(pedido);
			pedido.calcularValortotal();
		}		
	}
	
	
	public void removerProdutoPedido(int idpedido, int idproduto) {
		Pedido pedido = localizarPedido(idpedido);
		Produto produto = localizarProduto(idproduto);	
		if(!pedido.isPago()) {
			pedido.removeProduto(produto);
			produto.removePedido(pedido);
			pedido.calcularValortotal();
		}	
	}
	
	public void apagarPedido(Pedido pedido) {
		if(!pedido.isPago()) {
			Cliente cliente = pedido.getCliente();
			ArrayList<Produto> produtos = pedido.getProdutos();
			for(Produto p: produtos) {
				p.removePedido(pedido);
			}
			int index=pedidos.indexOf(pedido);
			pedidos.remove(index);
			cliente.removePedido(pedido);			
		}	
    }
	
	
	public static double consultarArrecadacao(int dia) {
		double sum = 0;
		for(Pedido pe: pedidos) {
			if(pe.getData().getDayOfMonth() == dia && pe.isPago()) {
				sum += pe.getValortotal();
			}
		}
		return sum;
	}
	
	public String listarPedido(String telefone,int tipo) {
        boolean pago=true;
        String ped="";
        if (tipo==1) {
            pago=true;
        }
        else if (tipo==2) {
            pago=false;
        }
        if (tipo==1 || tipo==2) {
            for (Pedido p : pedidos) {
                if (p.getCliente().getTelefone().equals(telefone) && p.isPago()==pago) {
                    ped+=p+"\n";
                }
            }
        }
        else {
            for (Pedido p : pedidos) {
                if (p.getCliente().getTelefone().equals(telefone)) {
                    ped+=p+"\n";
                }
            }
        }
        if(ped.equals("")) {
        	ped = "Nenhum pedido encontrado!";
        }
        return ped;
    }
	
	public Produto produtoTop() {
		int maior = 0;
		Produto prod=null;
		for(Produto p: produtos) {
			if (p.getPedidos().size()>maior) {
				maior = p.getPedidos().size();
				prod = p;
			}
		}
		return prod;
	}
}
