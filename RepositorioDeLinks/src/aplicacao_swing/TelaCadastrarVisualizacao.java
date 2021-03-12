package aplicacao_swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fachada.Fachada;

public class TelaCadastrarVisualizacao {
	private JFrame frame;
	private JLabel label;
	private JLabel label_2;
	private JTextField textField_3;
	private JButton button;
	private JLabel label_1;
	private JTextField textField_1;
	private JLabel label_3;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastrar window = new TelaCadastrar();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TelaCadastrarVisualizacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setTitle("Cadastro");
		frame.setBounds(100, 100, 263, 211);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("nome:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(-15, 76, 71, 14);
		frame.getContentPane().add(label);
		
		label_2 = new JLabel("");
		label_2.setBounds(10, 147, 227, 14);
		frame.getContentPane().add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(69, 74, 121, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		button = new JButton("Cadastrar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nota= textField_1.getText();
					int notaint;
					if (nota.isEmpty()){
						throw new Exception("Digite uma nota entre 0 e 5.");
					}
					try {
						notaint = Integer.parseInt(nota);
					}catch (Exception e){
						notaint = 0;
					}
					
					if (notaint > 5 || notaint<=0) {
						textField_1.setText("");
						label_2.setText("Digita uma nota entre 0 e 5.");
					}
					else{
						String email= textField_2.getText();
						String nome= textField_3.getText();
						if (email.isEmpty() || nome.isEmpty()) {
							label_2.setText("preencha todos os campos");
						}else{
						Fachada.cadastrarVisualizacao(notaint,email,nome);
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						label_2.setText("cadastro realizado");
						}
					}
				}
				catch(Exception e) {
					label_2.setText(e.getMessage());
				}
			}
		});
		button.setBounds(69, 105, 108, 23);
		frame.getContentPane().add(button);
		
		label_1 = new JLabel("nota:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(-15, 23, 71, 14);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(69, 21, 121, 20);
		frame.getContentPane().add(textField_1);
		
		label_3 = new JLabel("email:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(-15, 48, 71, 14);
		frame.getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(69, 46, 121, 20);
		frame.getContentPane().add(textField_2);
		
		
		frame.setVisible(true);
	}
}
