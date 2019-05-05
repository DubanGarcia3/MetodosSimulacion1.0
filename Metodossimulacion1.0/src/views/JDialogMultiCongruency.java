package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import controller.Action;
import controller.Controller;

public class JDialogMultiCongruency extends JDialog{

	/**
	 * @author Duban
	 * @author Miller
	 */
	private static final long serialVersionUID = 1L;

	private JTableLinealCongruency jTableLinealCongruency;
	private MyJTextField jTextFieldX0, jTextFieldT, jTextFieldD;
	private JButton jButton;
	private Controller controller;

	public JDialogMultiCongruency(Controller controller) {
		this.controller = controller;
		this.setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()- 
						Toolkit.getDefaultToolkit().getScreenSize().getHeight()/4)));
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
				this.setResizable(false);
		init();
	}

	private void init() {
		JPanel jPanel = new JPanel();
		jPanel.setPreferredSize(new Dimension((int)this.getWidth()-40, this.getHeight()/5));

		Font font = new Font("Century Gothic", 1, 14);
		jTextFieldX0 = new MyJTextField("Valor Xo");
		jTextFieldT = new MyJTextField("valor T");
		jTextFieldD = new MyJTextField("valor D");

		jTextFieldX0.setFont(font);
		jTextFieldT.setFont(font);
		jTextFieldD.setFont(font);

		jButton = new JButton("Generar");
		JPanel jPanel1 = new JPanel(new GridLayout(2,2,5,5));
		jPanel1.setPreferredSize(new Dimension((int)this.getWidth()-40, this.getHeight()/8));

		jPanel1.add(jTextFieldX0);
		jPanel1.add(jTextFieldT);
		jPanel1.add(jTextFieldD);

		JPanel jPanelBtn = new JPanel();

		jButton.setFocusable(false);
		jButton.setBackground(Color.WHITE);
		jButton.setFont(new Font("Arial", Font.PLAIN, 16));
		jButton.addActionListener(controller);
		jButton.setActionCommand(Action.BTN_GENERATE_CONG_MULTI.name());
		jPanelBtn.add(jButton);

		jPanel.add(jPanel1,BorderLayout.CENTER);
		jPanel.add(jPanelBtn, BorderLayout.SOUTH);

		jTableLinealCongruency = new JTableLinealCongruency();

		jTableLinealCongruency.setPreferredSize(new Dimension((int)this.getWidth()-40, (this.getHeight()- (this.getHeight()/4))));
		this.add(jPanel);
		this.add(jTableLinealCongruency);
	}
	
	public JTableLinealCongruency getjTableLinealCongruency() {
		return jTableLinealCongruency;
	}

	public void setjTableLinealCongruency(JTableLinealCongruency jTableLinealCongruency) {
		this.jTableLinealCongruency = jTableLinealCongruency;
	}

	public MyJTextField getjTextFieldX0() {
		return jTextFieldX0;
	}

	public void setjTextFieldX0(MyJTextField jTextFieldX0) {
		this.jTextFieldX0 = jTextFieldX0;
	}

	public MyJTextField getjTextFieldT() {
		return jTextFieldT;
	}

	public void setjTextFieldT(MyJTextField jTextFieldT) {
		this.jTextFieldT = jTextFieldT;
	}

	public MyJTextField getjTextFieldD() {
		return jTextFieldD;
	}

	public void setjTextFieldD(MyJTextField jTextFieldD) {
		this.jTextFieldD = jTextFieldD;
	}

	public void cleanAll() {
		jTextFieldX0.setText(""); 
		jTextFieldT.setText("");
		jTextFieldD.setText(""); 

	}
}
