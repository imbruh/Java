package aplicacao_swing;

import java.awt.Cursor;
import aplicacao_console.Cadastrar;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import fachada.Fachada;

public class TelaPrincipal {

	private JFrame frame;
	private JMenu mnListar;
	private JMenu mnCadastrar;
	private JMenuItem mntmCadastrarUsuario;
	private JMenuItem mntmVideo;
	private JMenuItem mntmVisualizacao;
	private JMenuItem mntmUsuarios;
	private JMenuItem mntmAssuntos;
	private JMenuItem mntmVideos;
	private JLabel label;
	private ImageIcon imagem;
	private JMenuItem mntmAssunto;
	private JMenuItem mntmVisualizacoes;

	
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
		//new Cadastrar();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				
				Fachada.inicializar();
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				label.setIcon(imagem);
			}
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
				JOptionPane.showMessageDialog(frame, "banco fechado !");
			}
		});
		frame.setTitle("Repositorio de links");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("Inicializando...");
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		imagem = new ImageIcon(getClass().getResource("/imagens/video.jpg"));
		imagem = new ImageIcon(imagem.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));//		label.setIcon(imagem);
		frame.getContentPane().add(label);
		frame.setResizable(false);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);

		mntmCadastrarUsuario = new JMenuItem("Usuario");
		mntmCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarUsuario tela = new TelaCadastrarUsuario();
			}
		});
		mnCadastrar.add(mntmCadastrarUsuario);
		
		mntmAssunto = new JMenuItem("Assunto");
		mntmAssunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarAssunto tela = new TelaCadastrarAssunto();
			}
		});
		mnCadastrar.add(mntmAssunto);

		mntmVideo = new JMenuItem("Video");
		mntmVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarVideo tela = new TelaCadastrarVideo();
			}
		});
		mnCadastrar.add(mntmVideo);
				
		mntmVisualizacao = new JMenuItem("Visualizacao");
		mntmVisualizacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarVisualizacao tela= new TelaCadastrarVisualizacao();
			}
		});
		mnCadastrar.add(mntmVisualizacao);

		
		//-----------------------------------------------------------------
		mnListar = new JMenu("Listar");
		menuBar.add(mnListar);
		
		mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarUsuario tela = new TelaListarUsuario();
			}
		});
		mnListar.add(mntmUsuarios);

		mntmAssuntos = new JMenuItem("Assuntos");
		mntmAssuntos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarAssunto tela = new TelaListarAssunto();
			}
		});
		mnListar.add(mntmAssuntos);
		
		
		mntmVideos = new JMenuItem("Videos");
		mntmVideos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarVideo tela = new TelaListarVideo();
			}
		});
		mnListar.add(mntmVideos);
		
		mntmVisualizacoes = new JMenuItem("Visualizacoes");
		mntmVisualizacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarVisualizacao tela = new TelaListarVisualizacao();
			}
		});
		mnListar.add(mntmVisualizacoes);
		
	}
}
