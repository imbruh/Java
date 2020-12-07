package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada.Fachada;

import javax.swing.JButton;

public class TelaPagamento extends JFrame{

	private JFrame frame;
	private JTextField id;
	private JTextField entregador;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public TelaPagamento() {
		setTitle("Pagar Pedido");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 242);
		getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("Id do pedido");
		lblId.setBounds(53, 31, 68, 14);
		getContentPane().add(lblId);
		
		id = new JTextField();
		id.setBounds(142, 28, 27, 20);
		getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblEntreg = new JLabel("Entregador");
		lblEntreg.setBounds(63, 66, 68, 14);
		getContentPane().add(lblEntreg);
		
		entregador = new JTextField();
		entregador.setColumns(10);
		entregador.setBounds(142, 63, 68, 20);
		getContentPane().add(entregador);
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setBounds(58, 149, 224, 41);
		getContentPane().add(lblMensagem);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    int idPag=0; 
                    try {
                        idPag = Integer.parseInt(id.getText());
                    }
                    catch (Exception a) {
                        lblMensagem.setText("id invalido");
                    }
                    String entreg = entregador.getText();
                    if (id.getText().isEmpty() && entregador.getText().isEmpty()) {
                        lblMensagem.setText("Preencha todos os campos.");
                    }
                    else if (id.getText().isEmpty()) {
                        lblMensagem.setText("Preencha o campo id.");
                    }
                    else if (entregador.getText().isEmpty()){
                        lblMensagem.setText("Preencha o campo entregador.");
                    }
                    else {
                        Fachada.pagarPedido(idPag, entreg);
                        lblMensagem.setText("Pedido pago com sucesso.");
                    }
                }
                catch (Exception erro) {
                    lblMensagem.setText(erro.getMessage());
                }
			}
		});
		btnPagar.setBounds(90, 115, 89, 23);
		getContentPane().add(btnPagar);
		
		
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
