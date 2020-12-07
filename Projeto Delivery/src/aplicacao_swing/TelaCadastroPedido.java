package aplicacao_swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Pedido;
import modelo.PedidoExpress;
import modelo.Produto;
import repositorio.Repositorio;

public class TelaCadastroPedido extends JFrame {

	private JPanel contentPane;
	private JTextField telefone;
	private JTextField taxa;
	private JLabel lblTelefone;
	private JLabel lblPreco;
	private JButton btnCadastrar;
	private JLabel lblEntregador;
	private JTextField entregador;
	private JLabel lblMensagem;
	private static Repositorio repositorio = new Repositorio();

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					TelaCadastroProduto frame = new TelaCadastroProduto();
	//					frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroPedido() {
		setTitle("Cadastrar Pedido");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 309, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		telefone = new JTextField();
		telefone.setBounds(133, 43, 86, 20);
		contentPane.add(telefone);
		telefone.setColumns(10);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(56, 46, 52, 14);
		contentPane.add(lblTelefone);

		taxa = new JTextField();
		taxa.setBounds(133, 86, 86, 20);
		contentPane.add(taxa);
		taxa.setColumns(10);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(telefone.getText().isEmpty())
						lblMensagem.setText("campo vazio");
					else {
						if(taxa.getText().isEmpty()) {
							String fone = telefone.getText();
							//String entreg = entregador.getText();
							
							Pedido pe = Fachada.criarPedido(fone);
	
							lblMensagem.setText("Pedido criado! id = "+ pe.getId());
							telefone.setText("");
							taxa.setText("");
							//entregador.setText("");
						}
						else {
							String fone = telefone.getText();
							//String entreg = entregador.getText();
							double taxaExp = Double.parseDouble(taxa.getText());
	
							Pedido pex = Fachada.criarPedidoExpress(fone, taxaExp);
	
							lblMensagem.setText("Pedido criado! id = "+ pex.getId());
							telefone.setText("");
							taxa.setText("");
							//entregador.setText("");
						}
					}
				}
				catch(Exception erro){
					lblMensagem.setText(erro.getMessage());
					JButton btnCadastroCli = new JButton("Cadastrar Cliente");
					btnCadastroCli.setEnabled(false);
					btnCadastroCli.setBounds(86, 201, 135, 23);
					contentPane.add(btnCadastroCli);
					if(erro.getMessage()=="Cliente não cadastrado") {						
						btnCadastroCli.setEnabled(true);
						btnCadastroCli.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								TelaCadastroCliente cadcli = new TelaCadastroCliente();
								cadcli.setVisible(true);
							}
						});
					}					
				}
			}
		});
		btnCadastrar.setBounds(88, 136, 116, 23);
		contentPane.add(btnCadastrar);

		/*lblEntregador = new JLabel("Entregador");
		lblEntregador.setBounds(55, 98, 70, 14);
		contentPane.add(lblEntregador);*/
		
		JLabel lblTaxa = new JLabel("Taxa Express");
		lblTaxa.setBounds(52, 89, 86, 14);
		contentPane.add(lblTaxa);
		
		/*entregador = new JTextField();
		entregador.setColumns(10);
		entregador.setBounds(123, 95, 86, 20);
		contentPane.add(entregador);*/
		
		lblMensagem = new JLabel("");
		lblMensagem.setBounds(91, 170, 143, 20);
		contentPane.add(lblMensagem);
		
		JLabel lblOpcional = new JLabel("*Opcional");
		lblOpcional.setBounds(229, 89, 74, 14);
		contentPane.add(lblOpcional);
		
		
	}
}
