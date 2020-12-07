package modelo;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Pedido {
	private int id;
	private static LocalDateTime datahora;
	private double valortotal = 0;
	private String entregador;
	private boolean pago;
	private ArrayList<Produto> produtos = new ArrayList<>();
	private Cliente cliente;
	DecimalFormat valor = new DecimalFormat("#.00");
	
	public Pedido(Cliente cliente) {
		this.id = 0;
		this.cliente = cliente;
		this.pago = false;
		//this.entregador = entregador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id2) {
		id = id2;
	}

	public String getDatahora() {
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = formatterData.format(this.datahora);
        return dataFormatada;
    }
	
	public LocalDateTime getData() {
		return datahora;
	}

	public static void setDatahora(LocalDateTime datahora2) {
		datahora = datahora2;
	}

	public double getValortotal() {
		return valortotal;
	}

	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}

	public void calcularValortotal() {
		double sum = 0;
		for(Produto p: produtos) {
			sum += p.getPreco();
		}
		this.setValortotal(sum);
	}
	
	public String getEntregador() {
		return entregador;
	}

	public void setEntregador(String entregador) {
		this.entregador = entregador;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}
	
	public ArrayList<Produto> getProdutos() {
		ArrayList<Produto> prods = new ArrayList<>();
		for(Produto p : produtos){
				prods.add(p);
		}
		return prods;
	}

	public ArrayList<Integer> getProdutosId() {
		ArrayList<Integer> prods = new ArrayList<>();
		for(Produto pe : produtos){
				prods.add(pe.getId());
		}
		return prods;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void addProdutos(Produto p) {
		produtos.add(p);
	}
	
	public void removeProduto(Produto p) {
		produtos.remove(p);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", datahora=" + this.getDatahora() + ", valortotal=" + valor.format(valortotal) + ", entregador=" + entregador + ", pago=" + pago
				+ ", produtos=" + getProdutosId() + ", cliente= " + getCliente().getTelefone() + ", " + getCliente().getNome() + ", " + getCliente().getEndereco() + "]" ;
	}
		
}
