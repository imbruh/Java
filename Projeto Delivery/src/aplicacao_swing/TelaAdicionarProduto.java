package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada.Fachada;

import javax.swing.JButton;

public class TelaAdicionarProduto extends JFrame {

	private JFrame frame;
	private JTextField idpedido;
	private JTextField idproduto;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public TelaAdicionarProduto() {
		setTitle("Adicionar Produto");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 281, 195);
		getContentPane().setLayout(null);
		
		JLabel lblIdPed = new JLabel("IdPedido");
		lblIdPed.setBounds(86, 37, 56, 14);
		getContentPane().add(lblIdPed);
		
		idpedido = new JTextField();
		idpedido.setBounds(152, 34, 30, 20);
		getContentPane().add(idpedido);
		idpedido.setColumns(10);
		
		JLabel lblIdproduto = new JLabel("IdProduto");
		lblIdproduto.setBounds(86, 67, 56, 14);
		getContentPane().add(lblIdproduto);
		
		idproduto = new JTextField();
		idproduto.setColumns(10);
		idproduto.setBounds(152, 64, 30, 20);
		getContentPane().add(idproduto);
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setBounds(86, 137, 125, 14);
		getContentPane().add(lblMensagem);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int idPed=0; 
					int idProd=0; 
                    try {
                        idPed = Integer.parseInt(idpedido.getText());
                        idProd = Integer.parseInt(idproduto.getText());
                    }
                    catch (Exception a) {
                        lblMensagem.setText("id invalido");
                    }
					Fachada.adicionarProdutoPedido(idPed, idProd);
					lblMensagem.setText("Produto Adicionado!");
				}
				catch (Exception erro){
					lblMensagem.setText(erro.getMessage());
				}
			}
		});
		btnAdicionar.setBounds(86, 103, 89, 23);
		getContentPane().add(btnAdicionar);
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
