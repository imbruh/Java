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

public class TelaListarVisualizacao {

	private JFrame frmListarVisualizacoes;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnListarVisualizacao;


	/**
	 * Create the application.
	 */
	public TelaListarVisualizacao() {
		ListarVideo();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void ListarVideo() {
		frmListarVisualizacoes = new JFrame();
		frmListarVisualizacoes.setTitle("Listar Visualizacoes");
		frmListarVisualizacoes.setBounds(100, 100, 505, 323);
		frmListarVisualizacoes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmListarVisualizacoes.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 469, 149);
		frmListarVisualizacoes.getContentPane().add(scrollPane);

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
				new String[] {"Link", "Nome", "Data e hora", "Assuntos", "Visualizacoes"}
				));
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		btnListarVisualizacao = new JButton("Listar visualizacoes");
		btnListarVisualizacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListarVisualizacao.setHorizontalAlignment(SwingConstants.LEFT);
		btnListarVisualizacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Id");
					model.addColumn("DataHora");
					model.addColumn("Video");
					model.addColumn("Assunto");
					model.addColumn("Usuario");
					//					table.getColumnModel().getColumn(0).setPreferredWidth(10);
					//					table.getColumnModel().getColumn(1).setPreferredWidth(10);

					List<Visualizacao> lista = Fachada.listarVisualizacao();
					for(Visualizacao vis : lista)
						model.addRow(new Object[]{ vis.getId(), vis.getDatahora(), vis.getVideo().getNome(), vis.getVideo().getAssunto(), vis.getUsuario().getEmail() });

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmListarVisualizacoes,erro.getMessage());
				}
			}
		});
		btnListarVisualizacao.setBounds(25, 218, 124, 23);
		frmListarVisualizacoes.getContentPane().add(btnListarVisualizacao);

		frmListarVisualizacoes.setVisible(true);
	}
}
