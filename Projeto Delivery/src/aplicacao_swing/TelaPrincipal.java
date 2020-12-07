package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import aplicacao_console.AplicacaoConsole;
import fachada.Fachada;
import modelo.Produto;

public class TelaPrincipal {

	private JFrame frame;
	private JLabel label;
	private JMenu mnPedido;
	private JMenuItem mntmCriar;
	private JMenuItem mntmListar_1;
	private JMenuItem mntmInserirProduto;
	private JMenuItem mntmRemoverProduto;
	private JMenuItem menuItem_2;
	private JMenu mnProduto;
	private JMenuItem mnpeCadastrar;
	private JMenuItem mntmApagar;
	private JMenuItem mntmListar;
	private JMenu mnpeAlterar;
	private JMenuItem mnAltAdd;
	private JMenuItem mnAltRmv;
	private JMenuItem mnpePagar;
	private JMenuItem mnpeCancelar;
	private JMenu mnListagem;
	private JMenuBar menuBar_1;
	private JMenuItem mnListCliente;
	private JMenuItem mnListArrecadacao;
	private JMenu mnListPedidos;
	private JMenuBar menuBar_2;
	private JMenu mnListProdutos;
	private JMenuItem mnListProdTodos;
	private JMenuItem mnListProdTop;
	private JMenuItem mnListPedTodos;
	private JMenuItem mnListPedTodosCli;
	private JMenuItem mnListPedPagosCli;
	private JMenuItem mnListPedNPagoCli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Delivery");

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try{
					//  pre-cadastro
					new AplicacaoConsole().cadastrar();
					
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(frame, "Até breve!");
			}
		});
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//imagem de fundo
		label = new JLabel("");
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight()); //fundo da janela

		ImageIcon imagem = new ImageIcon(getClass().getResource("/imagens/delivery.png"));
		imagem = new ImageIcon(imagem.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(imagem);
		frame.getContentPane().add(label);
		frame.setResizable(false);
			

		//-------------BARRA DE MENU-----------------------------------
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		//-------------MENU DO PEDIDO-----------------------------------
		mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);

		mnpeCadastrar = new JMenuItem("Criar");
		mnpeCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroPedido cadped = new TelaCadastroPedido();
				cadped.setVisible(true);
			}
		});
		mnPedido.add(mnpeCadastrar);
		
		mnpeAlterar = new JMenu("Alterar");
		mnPedido.add(mnpeAlterar);
		
		mnAltAdd = new JMenuItem("Adicionar Produto");
		mnAltAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAdicionarProduto addprod = new TelaAdicionarProduto();
				addprod.setVisible(true);
			}
		});
		mnpeAlterar.add(mnAltAdd);
		
		mnAltRmv = new JMenuItem("Remover Produto");
		mnAltRmv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverProduto rmvprod = new TelaRemoverProduto();
				rmvprod.setVisible(true);
			}
		});
		mnpeAlterar.add(mnAltRmv);
		
		mnpePagar = new JMenuItem("Pagar");
		mnpePagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPagamento pagamento = new TelaPagamento();
				pagamento.setVisible(true);
			}
		});
		mnPedido.add(mnpePagar);
		
		mnpeCancelar = new JMenuItem("Cancelar");
		mnpeCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCancelarPedido cancelamento = new TelaCancelarPedido();
				cancelamento.setVisible(true);
			}
		});
		mnPedido.add(mnpeCancelar);
		
		//-------------MENU DE LISTAGEM-----------------------------------
		
		mnListagem = new JMenu("Listagem");
		menuBar.add(mnListagem);
		
		mnListProdutos = new JMenu("Produtos");
		mnListagem.add(mnListProdutos);
		
		mnListProdTodos = new JMenuItem("Todos");
		mnListProdTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String texto;
					texto = "Listagem de produtos: \n";
												
					texto += Fachada.listarProduto("");
					
					TelaListagem listprod = new TelaListagem(texto);
					listprod.setVisible(true);
				}
				catch (Exception erro){
					TelaListagem listprod = new TelaListagem(erro.getMessage());
				}
				
			}
		});
		mnListProdutos.add(mnListProdTodos);
		
		mnListProdTop = new JMenuItem("Top");
		mnListProdTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String texto;
					texto = "Listagem do Produto Top: \n";
												
					texto += Fachada.consultarProdutoTop();
					
					TelaListagem listprod = new TelaListagem(texto);
					listprod.setVisible(true);
				}
				catch (Exception erro){
					TelaListagem listprod = new TelaListagem(erro.getMessage());
				}
				
			}
		});
		mnListProdutos.add(mnListProdTop);
		
		mnListCliente = new JMenuItem("Clientes");
		mnListCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String texto;
					texto = "Listagem de Clientes: \n";
												
					texto += Fachada.listarCliente();
					
					TelaListagem listprod = new TelaListagem(texto);
					listprod.setVisible(true);
				}
				catch (Exception erro){
					TelaListagem listprod = new TelaListagem(erro.getMessage());
				}
				
			}
		});
		mnListagem.add(mnListCliente);
		
		mnListPedidos = new JMenu("Pedidos");
		mnListagem.add(mnListPedidos);
		
		mnListPedTodos = new JMenuItem("Todos");
		mnListPedTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String texto;
					texto = "Listagem de Todos Pedidos: \n";
												
					texto += Fachada.listarPedido();
					
					TelaListagem listprod = new TelaListagem(texto);
					listprod.setVisible(true);
				}
				catch (Exception erro){
					TelaListagem listprod = new TelaListagem(erro.getMessage());
				}
				
			}
		});
		mnListPedidos.add(mnListPedTodos);
		
		mnListPedTodosCli = new JMenuItem("Pedidos do Cliente");
		mnListPedTodosCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String telefone = JOptionPane.showInputDialog(null, "Telefone do Cliente");
					String texto;
					texto = "Listagem de Pedidos do Cliente: \n";
												
					texto += Fachada.listarPedido(telefone, 3);
					
					TelaListagem listprod = new TelaListagem(texto);
					listprod.setVisible(true);
				}
				catch (Exception erro){
					TelaListagem listprod = new TelaListagem(erro.getMessage());
				}
				
			}
		});
		mnListPedidos.add(mnListPedTodosCli);
		
		mnListPedPagosCli = new JMenuItem("Pagos do Cliente");
		mnListPedPagosCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String telefone = JOptionPane.showInputDialog(null, "Telefone do Cliente");
					String texto;
					texto = "Listagem de Pedidos pagos do cliente: \n";
												
					texto += Fachada.listarPedido(telefone, 1);
					
					TelaListagem listprod = new TelaListagem(texto);
					listprod.setVisible(true);
				}
				catch (Exception erro){
					TelaListagem listprod = new TelaListagem(erro.getMessage());
				}
				
			}
		});
		mnListPedidos.add(mnListPedPagosCli);
		
		mnListPedNPagoCli = new JMenuItem("Não Pagos do Cliente");
		mnListPedNPagoCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String telefone = JOptionPane.showInputDialog(null, "Telefone do Cliente");
					String texto;
					texto = "Listagem de Pedidos não pagos do cliente: \n";
												
					texto += Fachada.listarPedido(telefone, 2);
					
					TelaListagem listprod = new TelaListagem(texto);
					listprod.setVisible(true);
				}
				catch (Exception erro){
					TelaListagem listprod = new TelaListagem(erro.getMessage());
				}
				
			}
		});
		mnListPedidos.add(mnListPedNPagoCli);
		
		mnListArrecadacao = new JMenuItem("Arrecadação");
		mnListArrecadacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String texto;
					LocalDate hoje = LocalDate.now();
					texto = "Arrecadação do dia " + hoje.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ":\n" ;
					texto +="R$ ";	
					DecimalFormat valor = new DecimalFormat("#.00");
                    texto+=valor.format(Fachada.consultarArrecadacao(hoje.getDayOfMonth()));
					//texto += Fachada.consultarArrecadacao(hoje.getDayOfMonth());
					
					TelaListagem listprod = new TelaListagem(texto);
					listprod.setVisible(true);
				}
				catch (Exception erro){
					TelaListagem listprod = new TelaListagem(erro.getMessage());
				}
				
			}
		});
		mnListagem.add(mnListArrecadacao);
		
	}
}

