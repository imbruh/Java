package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada.Fachada;

import javax.swing.JButton;

public class TelaCancelarPedido extends JFrame{

	private JFrame frame;
	private JTextField id;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public TelaCancelarPedido() {
		setTitle("Cadastrar Pedido");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 281, 177);
		getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("Id do pedido");
		lblId.setBounds(75, 55, 70, 14);
		getContentPane().add(lblId);
		
		id = new JTextField();
		id.setBounds(155, 52, 34, 20);
		getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setBounds(75, 30, 148, 14);
		getContentPane().add(lblMensagem);
		
		JButton btnCancelar = new JButton("Cancelar Pedido");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    int idPed=0; 
                    try {
                        idPed = Integer.parseInt(id.getText());
                    }
                    catch (Exception a) {
                        lblMensagem.setText("id invalido!");
                    }
                    Fachada.cancelarPedido(idPed);
                    lblMensagem.setText("Pedido cancelado!");
				}
				catch (Exception erro){
					lblMensagem.setText(erro.getMessage());
				}
			}
		});
		btnCancelar.setBounds(64, 96, 137, 23);
		getContentPane().add(btnCancelar);
		
		
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
