package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Pedido;

public class TelaCadastroCliente extends JFrame {

	private JFrame frame;
	private JTextField telefone;
	private JTextField nome;
	private JTextField endereco;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public TelaCadastroCliente() {
		setTitle("Cadastrar Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 260);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(71, 36, 59, 14);
		contentPane.add(lblTelefone);
		
		telefone = new JTextField();
		telefone.setBounds(140, 33, 76, 20);
		contentPane.add(telefone);
		telefone.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(92, 75, 38, 14);
		contentPane.add(lblNome);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(71, 114, 59, 14);
		contentPane.add(lblEndereco);
		
		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(140, 72, 76, 20);
		contentPane.add(nome);
		
		endereco = new JTextField();
		endereco.setColumns(10);
		endereco.setBounds(140, 111, 139, 20);
		contentPane.add(endereco);
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setBounds(71, 192, 197, 14);
		contentPane.add(lblMensagem);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String fone = telefone.getText();
					String n = nome.getText();
					String end = endereco.getText();
					if(n.isEmpty() || end.isEmpty()) {
						lblMensagem.setText("Campo vazio");
					}
					else if(fone.length()!=9) {
						lblMensagem.setText("Numero invalido");
					}
					else {
						Fachada.cadastrarCliente(fone, n, end);
						lblMensagem.setText("Cadastro feito com sucesso!");
					}					
				}
				catch(Exception erro){
					lblMensagem.setText(erro.getMessage());			
				}
			}
		});
		btnCadastrar.setBounds(97, 158, 104, 23);
		contentPane.add(btnCadastrar);
		
		
		
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
