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

	/**
	 * 
	 */
	private static final long serialVersionUID = 6303358847758635428L;
	private MyJTextField jTextFieldX0, jTextFieldK, jTextFieldG, jTextFieldC;
	private JButton jButton, jButton2;
	private Controller controller;
	
	public JDialogInputLinearCongruency(Controller controller) {
		this.controller = controller;
		
		this.setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()/3)));
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
//		this.initLinear();
	}
	
	public void initLinear() {
		
	}
	
	public void initMulti() {
		jTextFieldX0 = new MyJTextField("Valor Xo");
		jTextFieldK = new MyJTextField("valor t");
		jTextFieldG = new MyJTextField("valor d");
		
		jTextFieldX0.setFocusable(false);
		jTextFieldK.setFocusable(false);
		jTextFieldG.setFocusable(false);
		
		jButton2 = new JButton("Generar");

		
		JPanel jPanel1 = new JPanel(new GridLayout(2,2,10,10));
		jPanel1.setPreferredSize(new Dimension((int)this.getWidth()-40, this.getHeight()/2));
		jPanel1.add(jTextFieldX0);
		jPanel1.add(jTextFieldK);
		jPanel1.add(jTextFieldG);
		
		JPanel jPanelBtn = new JPanel();
		
		jButton2.setFocusable(false);
		jButton2.setBackground(Color.WHITE);
		jButton2.setFont(new Font("Arial", Font.PLAIN, 16));
		jButton2.addActionListener(controller);
		jButton2.setActionCommand(Action.BTN_GENERATE_CONG_MULTI.name());
		jPanelBtn.add(jButton);
		
		this.add(jPanel1,BorderLayout.CENTER);
		this.add(jPanelBtn, BorderLayout.SOUTH);
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

	public JButton getjButton() {
		return jButton;
	}

	public void setjButton(JButton jButton) {
		this.jButton = jButton;
	}

	public JButton getjButton2() {
		return jButton2;
	}

	public void setjButton2(JButton jButton2) {
		this.jButton2 = jButton2;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
}