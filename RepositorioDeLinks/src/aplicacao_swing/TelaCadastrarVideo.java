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

public class TelaCadastrarVideo {
	private JFrame frame;
	private JLabel lblAssunto;
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
	public TelaCadastrarVideo() {
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
		
		lblAssunto = new JLabel("assunto:");
		lblAssunto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAssunto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAssunto.setBounds(-15, 76, 71, 14);
		frame.getContentPane().add(lblAssunto);
		
		label_2 = new JLabel("");
		label_2.setBounds(10, 139, 227, 22);
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
					String link= textField_1.getText();
					String nome= textField_2.getText();
					String assunto= textField_3.getText();
					if(link.isEmpty() || nome.isEmpty() || assunto.isEmpty()) {
						label_2.setText("preencha os campos em branco");
					}
					else {
						Fachada.cadastrarVideo(link,nome,assunto);
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						label_2.setText("cadastro realizado");
					}				
				}
				catch(Exception e) {
					label_2.setText(e.getMessage());
				}
			}
		});
		button.setBounds(69, 105, 108, 23);
		frame.getContentPane().add(button);
		
		label_1 = new JLabel("link:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(-15, 23, 71, 14);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(69, 21, 121, 20);
		frame.getContentPane().add(textField_1);
		
		label_3 = new JLabel("nome:");
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

