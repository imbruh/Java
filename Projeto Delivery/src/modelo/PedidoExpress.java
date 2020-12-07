package modelo;

public class PedidoExpress extends Pedido {
	private double taxa;

	public PedidoExpress(Cliente cliente,  double taxa) {
		super(cliente);
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
