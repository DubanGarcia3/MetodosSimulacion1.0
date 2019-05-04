package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import controller.Action;
import controller.Controller;
import uptc.com.sim.entities.LinealCongruency;

public class JDialogInputLinearCongruency extends JDialog{

	private MyJTextField jTextFieldX0, jTextFieldK, jTextFieldG, jTextFieldC;
	private JButton jButton;
	private Controller controller;
	
	public JDialogInputLinearCongruency(Controller controller) {
		this.controller = controller;
		jTextFieldX0 = new MyJTextField("Valor Xo");
		jTextFieldK = new MyJTextField("valor K");
		jTextFieldG = new MyJTextField("valor G");
		jTextFieldC = new MyJTextField("Valor C");
		jButton = new JButton("Generar");
		
		this.setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()/3)));
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.init();
	}
	
	private void init() {
		JPanel jPanel1 = new JPanel(new GridLayout(2,2,10,10));
//		jPanel1.setPreferredSize(new Dimension((int)this.getWidth()-20, this.getHeight()/2));
		jPanel1.add(jTextFieldX0);
		jPanel1.add(jTextFieldK);
		jPanel1.add(jTextFieldG);
		jPanel1.add(jTextFieldC);
		
		JPanel jPanelBtn = new JPanel();
		
		jButton.setFocusable(false);
		jButton.setBackground(Color.WHITE);
		jButton.setFont(new Font("Arial", Font.PLAIN, 16));
		jButton.addActionListener(controller);
		jButton.setActionCommand(Action.BTN_GENERATE_CONG_LIN.name());
		jPanelBtn.add(jButton);
		
		this.add(jPanel1,BorderLayout.CENTER);
		this.add(jPanelBtn, BorderLayout.SOUTH);
	}

	public LinealCongruency getCongruencyData() {
		return new LinealCongruency(Double.parseDouble(jTextFieldX0.getText()), 
				Double.parseDouble(jTextFieldK.getText()), Double.parseDouble(jTextFieldC.getText()), 
				Double.parseDouble(jTextFieldG.getText()));
	}

	public MyJTextField getjTextFieldX0() {
		return jTextFieldX0;
	}

	public void setjTextFieldX0(MyJTextField jTextFieldX0) {
		this.jTextFieldX0 = jTextFieldX0;
	}

	public MyJTextField getjTextFieldK() {
		return jTextFieldK;
	}

	public void setjTextFieldK(MyJTextField jTextFieldK) {
		this.jTextFieldK = jTextFieldK;
	}

	public MyJTextField getjTextFieldG() {
		return jTextFieldG;
	}

	public void setjTextFieldG(MyJTextField jTextFieldG) {
		this.jTextFieldG = jTextFieldG;
	}

	public MyJTextField getjTextFieldC() {
		return jTextFieldC;
	}

	public void setjTextFieldC(MyJTextField jTextFieldC) {
		this.jTextFieldC = jTextFieldC;
	}
	
}