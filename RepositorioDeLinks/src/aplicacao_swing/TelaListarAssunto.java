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

public class TelaListarAssunto {

	private JFrame frmListarAssuntos;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnListarUsuarios;


	/**
	 * Create the application.
	 */
	public TelaListarAssunto() {
		ListarAssunto();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void ListarAssunto() {
		frmListarAssuntos = new JFrame();
		frmListarAssuntos.setTitle("Listar Assuntos");
		frmListarAssuntos.setBounds(100, 100, 505, 323);
		frmListarAssuntos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmListarAssuntos.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 469, 149);
		frmListarAssuntos.getContentPane().add(scrollPane);

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
				new String[] {"Assunto", "Videos"}
				));
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		btnListarUsuarios = new JButton("Listar Assuntos");
		btnListarUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListarUsuarios.setHorizontalAlignment(SwingConstants.LEFT);
		btnListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Assunto");
					model.addColumn("Videos");
					//					table.getColumnModel().getColumn(0).setPreferredWidth(10);
					//					table.getColumnModel().getColumn(1).setPreferredWidth(10);

					List<Assunto> lista = Fachada.listarAssunto();
					for(Assunto a : lista)
						model.addRow(new Object[]{ a.getPalavra(), a.getNomeVideos() });

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmListarAssuntos,erro.getMessage());
				}
			}
		});
		btnListarUsuarios.setBounds(25, 218, 124, 23);
		frmListarAssuntos.getContentPane().add(btnListarUsuarios);

		frmListarAssuntos.setVisible(true);
	}
}
