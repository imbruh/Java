package aplicacao_swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import fachada.Fachada;
import modelo.Assunto;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;


import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class TelaListarVideo {

	private JFrame frmListarVideos;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnListarVideos;
	private JButton btnAbrirVideo;


	/**
	 * Create the application.
	 */
	public TelaListarVideo() {
		ListarVideo();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void ListarVideo() {
		frmListarVideos = new JFrame();
		frmListarVideos.setTitle("Listar Videos");
		frmListarVideos.setBounds(100, 100, 522, 323);
		frmListarVideos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmListarVideos.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 469, 149);
		frmListarVideos.getContentPane().add(scrollPane);

		table = new JTable();
		table.setGridColor(Color.BLACK);
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setBackground(Color.YELLOW);
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"Link", "Nome", "Classificacao", "Data e hora", "Assuntos", "IdVisualizacoes"}
				));
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		btnListarVideos = new JButton("Listar videos");
		btnListarVideos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListarVideos.setHorizontalAlignment(SwingConstants.LEFT);
		btnListarVideos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Link");
					model.addColumn("Nome");
					model.addColumn("Classificacao");
					model.addColumn("Data e hora");
					model.addColumn("Assuntos");
					model.addColumn("IdVisualizacoes");
					//					table.getColumnModel().getColumn(0).setPreferredWidth(10);
					//					table.getColumnModel().getColumn(1).setPreferredWidth(10);

					List<Video> lista = Fachada.listarVideo();
					for(Video v : lista)
						model.addRow(new Object[]{ v.getLink(), v.getNome(), v.getMedia(), v.getDatahora(), v.getAssunto(), v.getIdVisualizacao() });

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmListarVideos,erro.getMessage());
				}
			}
		});
		btnListarVideos.setBounds(25, 218, 124, 23);
		frmListarVideos.getContentPane().add(btnListarVideos);
		
		btnAbrirVideo = new JButton("Abrir video");
		btnAbrirVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeVideo = JOptionPane.showInputDialog("Digite o nome do video:");
				try {
					Fachada.abrirLink(nomeVideo);
				}
				catch(Exception erro) {
					JOptionPane.showMessageDialog(frmListarVideos,erro.getMessage());
				}
			}
		});
		btnAbrirVideo.setBounds(195, 219, 109, 23);
		frmListarVideos.getContentPane().add(btnAbrirVideo);
		frmListarVideos.setVisible(true);
	}
}
