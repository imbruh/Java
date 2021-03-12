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

public class TelaListarUsuario {

	private JFrame frmListarUsuarios;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnListarUsuarios;


	/**
	 * Create the application.
	 */
	public TelaListarUsuario() {
		ListarUsuario();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void ListarUsuario() {
		frmListarUsuarios = new JFrame();
		frmListarUsuarios.setTitle("Listar Usuarios");
		frmListarUsuarios.setBounds(100, 100, 505, 323);
		frmListarUsuarios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmListarUsuarios.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 469, 149);
		frmListarUsuarios.getContentPane().add(scrollPane);

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
				new String[] {"Email", "IdVisualizacoes"}
				));
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		btnListarUsuarios = new JButton("Listar Usuarios");
		btnListarUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListarUsuarios.setHorizontalAlignment(SwingConstants.LEFT);
		btnListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Email");
					model.addColumn("IdVisualizacoes");
					//					table.getColumnModel().getColumn(0).setPreferredWidth(10);
					//					table.getColumnModel().getColumn(1).setPreferredWidth(10);

					List<Usuario> lista = Fachada.listarUsuario();
					for(Usuario u : lista)
						model.addRow(new Object[]{ u.getEmail(), u.getIdVisualizacao() });

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmListarUsuarios,erro.getMessage());
				}
			}
		});
		btnListarUsuarios.setBounds(25, 218, 124, 23);
		frmListarUsuarios.getContentPane().add(btnListarUsuarios);

		frmListarUsuarios.setVisible(true);
	}
}
