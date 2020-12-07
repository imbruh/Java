package modelo;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Produto {
	private int id = 0;
	private String nome;
	private double preco;
	private ArrayList<Pedido> pedidos = new ArrayList<>();
	DecimalFormat valor = new DecimalFormat("#.00");
	
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id2) {
		id = id2;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public ArrayList<Integer> getPedidos() {
		ArrayList<Integer> peds = new ArrayList<>();
		for(Pedido pe : pedidos){
			peds.add(pe.getId());
		}
		return peds;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void addPedido(Pedido pe) {
		pedidos.add(pe);
	}
	
	public void removePedido(Pedido pe) {
		pedidos.remove(pe);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + valor.format(preco) + ", idpedido=" + getPedidos();
	}
	
	
}
