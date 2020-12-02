package modelo;

public class PedidoExpress extends Pedido {
	private double taxa;

	public PedidoExpress(Cliente cliente, String entregador, double taxa) {
		super(cliente, entregador);
		this.taxa = taxa;
	}
	
	@Override
	public void calcularValortotal() {		
		double sum = 0;
		for(Produto p: super.getProdutos()) {
			sum += p.getPreco();
		}
		this.setValortotal(sum + taxa);
	}

}
