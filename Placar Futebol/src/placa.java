import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class placa {

	private JFrame frmPlacarDeFutebol;
	JLabel brasil;
	JLabel argentina;
	ImageIcon br;
	ImageIcon arg;
	private JLabel lblbra;
	private JLabel lblarg;
	private int contB=0;
	private int contA=0;
	JButton btn1;
	JButton btn2;
	JLabel lbl1;
	JLabel lbl2;
	private JButton btnReiniciar;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					placa window = new placa();
					window.frmPlacarDeFutebol.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public placa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlacarDeFutebol = new JFrame();
		frmPlacarDeFutebol.setTitle("Placar de Futebol");
		frmPlacarDeFutebol.setBounds(100, 100, 450, 300);
		frmPlacarDeFutebol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlacarDeFutebol.getContentPane().setLayout(null);
		
		brasil = new JLabel("");
		brasil.setBounds(44, 52, 62, 28);
		frmPlacarDeFutebol.getContentPane().add(brasil);
		
		br = new ImageIcon(getClass().getResource("/img/br.jpg"));
		
		br.setImage(br.getImage().getScaledInstance(
				brasil.getWidth(), brasil.getHeight(), 100));
		
		brasil.setIcon(br);
		
		argentina = new JLabel("");
		argentina.setBounds(44, 122, 62, 28);
		frmPlacarDeFutebol.getContentPane().add(argentina);
		
		arg = new ImageIcon(getClass().getResource("/img/arg.jpg"));
		
		arg.setImage(arg.getImage().getScaledInstance(
				argentina.getWidth(), argentina.getHeight(), 100));
		
		argentina.setIcon(arg);
		
		lblbra = new JLabel("BRA");
		lblbra.setBounds(136, 52, 46, 28);
		frmPlacarDeFutebol.getContentPane().add(lblbra);
		
		lblarg = new JLabel("ARG");
		lblarg.setBounds(136, 122, 46, 28);
		frmPlacarDeFutebol.getContentPane().add(lblarg);
		
		btn1 = new JButton("GOL");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contB+=1;
				lbl1.setText(Integer.toString(contB));
				if(contB == 5) {
					JOptionPane.showMessageDialog(null, "Brasil ganhou!!!");
					btn1.setEnabled(false);
					btn2.setEnabled(false);
				}
			}
		});
		btn1.setBounds(218, 57, 89, 23);
		frmPlacarDeFutebol.getContentPane().add(btn1);
		
		btn2 = new JButton("GOL");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contA+=1;
				lbl2.setText(Integer.toString(contA));
				if(contA == 5) {
					JOptionPane.showMessageDialog(null, "Argentina ganhou!!!");
					btn1.setEnabled(false);
					btn2.setEnabled(false);
				}
			}
		});
		btn2.setBounds(218, 122, 89, 23);
		frmPlacarDeFutebol.getContentPane().add(btn2);
		
		if(contA == 5 || contB == 5) {
			lblResult.setText("Alguem ganhou!");
		}
		
		lbl1 = new JLabel("0");
		lbl1.setBounds(364, 57, 23, 23);
		frmPlacarDeFutebol.getContentPane().add(lbl1);
		
		lbl2 = new JLabel("0");
		lbl2.setBounds(364, 122, 23, 23);
		frmPlacarDeFutebol.getContentPane().add(lbl2);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contB=0;
				contA=0;
				lbl1.setText("0");
				lbl2.setText("0");
				btn1.setEnabled(true);
				btn2.setEnabled(true);
				lblResult.setText("");
			}
		});
		btnReiniciar.setBounds(158, 200, 89, 23);
		frmPlacarDeFutebol.getContentPane().add(btnReiniciar);
		
		lblResult = new JLabel("");
		lblResult.setBounds(159, 168, 114, 14);
		frmPlacarDeFutebol.getContentPane().add(lblResult);
	}
}
