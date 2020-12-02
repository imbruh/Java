package modelo;

import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String endereco;
	private String telefone;
	private ArrayList<Pedido> pedidos = new ArrayList<>();
	
	public Cliente(String telefone, String nome, String endereco) {
		this.telefone = telefone;
		this.nome = nome;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public ArrayList<Pedido> pedidos () {
		return this.pedidos();
	}
	
	public ArrayList<Pedido> getPedidos() {
		ArrayList<Pedido> peds = new ArrayList<>();
		for(Pedido pe : pedidos){
				peds.add(pe);
		}
		return peds;
	}
	
	public ArrayList<Integer> getPedidosId() {
		ArrayList<Integer> peds = new ArrayList<>();
		for(Pedido pe : pedidos){
				peds.add(pe.getId());
		}
		return peds;
	}
	
	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void addPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public void removePedido(Pedido pedido) {
		pedidos.remove(pedido);
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", idpedido=" + getPedidosId()
				+ "]";
	}
	
	
}
