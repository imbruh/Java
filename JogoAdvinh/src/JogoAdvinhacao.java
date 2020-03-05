import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JogoAdvinhacao {

	private JFrame frmJogoDaAdvinhao;
	private JTextField txtNum;
	private int sorteio;
	private JLabel label1;
	private JButton btnAdv;
	private int dif;
	private JLabel label2;
	private int cont;
	private JLabel txtTent;
	private int tent;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogoAdvinhacao window = new JogoAdvinhacao();
					window.frmJogoDaAdvinhao.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JogoAdvinhacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJogoDaAdvinhao = new JFrame();
		frmJogoDaAdvinhao.getContentPane().setForeground(Color.BLACK);
		frmJogoDaAdvinhao.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
		frmJogoDaAdvinhao.setTitle("Jogo da Advinha\u00E7\u00E3o");
		frmJogoDaAdvinhao.setBounds(100, 100, 450, 300);
		frmJogoDaAdvinhao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJogoDaAdvinhao.getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("INICIAR");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random ();
				sorteio = rand.nextInt(100);
				//System.out.println(sorteio);
				btnAdv.setEnabled(true);
				label1.setText("");
				txtNum.setText("");
				label2.setText("Seus chutes: ");
				//txtTent.setText("Você tem apenas 6 tentativas para acertar o numero sorteado.");
				txtTent.setText("<html>Você tem apenas <b>6</b> tentativas para acertar o numero sorteado.</html>");
				cont = 1;
				tent = 6;
			}
		});
		btnStart.setBackground(Color.GREEN);
		btnStart.setForeground(Color.BLACK);
		btnStart.setBounds(158, 27, 107, 34);
		frmJogoDaAdvinhao.getContentPane().add(btnStart);
		
		
		JLabel LabelNum = new JLabel("Digite um numero:");
		LabelNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelNum.setBounds(99, 104, 135, 22);
		frmJogoDaAdvinhao.getContentPane().add(LabelNum);
		
		txtNum = new JTextField();
		txtNum.setBounds(228, 107, 86, 20);
		frmJogoDaAdvinhao.getContentPane().add(txtNum);
		txtNum.setColumns(10);
		
		btnAdv = new JButton("Advinhar");
		btnAdv.setEnabled(false);
		btnAdv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = Integer.parseInt(txtNum.getText());
				dif = Math.abs(num - sorteio);
				if (txtNum.getText().equals("")) {
					label1.setForeground(Color.RED);
					label1.setText("Campo vazio, digite um numero!");
				}
				else {
					try {		
						if(num == sorteio) {
							label1.setForeground(Color.GREEN);
							txtTent.setText("");
							if (cont==1) {
								label1.setText("Parabéns, você acertou com 1 tentativa!");
							}
							else {
								label1.setText("Parabéns, você acertou com "+cont+" tentativas!");
							}
							btnAdv.setEnabled(false);
						}
						else {
							String difer;
							if (dif > 5) {
								//label.setForeground(Color.CYAN);
								label1.setForeground(Color.BLUE);
								difer = "FRIO. ";
							}
							else {
								label1.setForeground(Color.RED);
								difer = "QUENTE. ";
							}
							if (num > sorteio) {
								label1.setText(difer+"Tente um numero menor!");
							}
							else {
								label1.setText(difer+"Tente um numero maior!");
							}
							tent--;
							if(tent==0) {
								btnAdv.setEnabled(false);
								txtTent.setText("<html><b>Game over. Você esgotou todas as suas tentativas!</b></html>");
								label1.setForeground(Color.RED);
								label1.setText("O numero sorteado foi " + sorteio);
							}
							else {
								txtTent.setText("<html>Você tem apenas <b>"+ tent + "</b> tentativas para acertar o numero sorteado.</html>");
							}
							
						}
						cont++;
						label2.setText(label2.getText()+txtNum.getText()+" ");
					}
					catch(NumberFormatException e2) {
						label1.setText("Utilize somente digitos!");
					}
					
				}
			}
		});
		btnAdv.setBackground(SystemColor.controlHighlight);
		btnAdv.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 12));
		btnAdv.setBounds(165, 150, 89, 23);
		frmJogoDaAdvinhao.getContentPane().add(btnAdv);
		
		
		
		label1 = new JLabel("");
		label1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		label1.setBounds(50, 184, 341, 34);
		frmJogoDaAdvinhao.getContentPane().add(label1);
		
		label2 = new JLabel("Seus chutes: ");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label2.setBounds(50, 218, 341, 21);
		frmJogoDaAdvinhao.getContentPane().add(label2);
		
		frmJogoDaAdvinhao.getRootPane().setDefaultButton(btnAdv);
		
		txtTent = new JLabel("");
		txtTent.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTent.setBounds(83, 67, 341, 29);
		frmJogoDaAdvinhao.getContentPane().add(txtTent);
	}
}
