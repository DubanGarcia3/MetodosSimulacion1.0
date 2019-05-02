package views;

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

public class JDialogLinealCongruency extends JDialog{
	
	private MyJTextField jTextFieldX0, jTextFieldK, jTextFieldG, jTextFieldC;
	private JButton jButton;
	private JTableLinealCongruency jTableLinealCongruency;
	
	public JDialogLinealCongruency(Controller controller) {
		this.setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()- 
						Toolkit.getDefaultToolkit().getScreenSize().getHeight()/4)));
		this.setLocationRelativeTo(null);
		
		init(controller);
	}

	private void init(Controller controller) {
		jTextFieldX0 = new MyJTextField("Xo");
		jTextFieldK = new MyJTextField("K");
		jTextFieldG = new MyJTextField("G");
		jTextFieldC = new MyJTextField("C");
		jButton = new JButton("Generar");
		
		JPanel jPanelMain = new JPanel();
		
		JPanel jPanel1 = new JPanel(new GridLayout(2,2,10,10));
		jPanel1.setPreferredSize(new Dimension((int)this.getWidth()-20, this.getHeight()/5));
		jPanel1.add(jTextFieldX0);
		jPanel1.add(jTextFieldK);
		jPanel1.add(jTextFieldG);
		jPanel1.add(jTextFieldC);
		
		JPanel jPanelBtn = new JPanel();
		jPanelBtn.setPreferredSize(new Dimension((int)this.getWidth()-20, this.getHeight()/15));
		
		jButton.setFocusable(false);
		jButton.setBackground(Color.WHITE);
		jButton.setFont(new Font("Arial", Font.PLAIN, 16));
		jButton.addActionListener(controller);
		jButton.setActionCommand(Action.BTN_CONG_LIN.name());
		
		jPanelBtn.add(jButton);
		
		jTableLinealCongruency = new JTableLinealCongruency();
		jTableLinealCongruency.setPreferredSize(new Dimension((int)this.getWidth()-40, this.getHeight()*3-this.getHeight()/4));
		
		
		
		jPanelMain.add(jPanel1);
		jPanelMain.add(jPanelBtn);
		jPanelMain.add(jTableLinealCongruency);
		this.add(jPanelMain);
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

	public JTableLinealCongruency getjTableLinealCongruency() {
		return jTableLinealCongruency;
	}

	public void setjTableLinealCongruency(JTableLinealCongruency jTableLinealCongruency) {
		this.jTableLinealCongruency = jTableLinealCongruency;
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
	
	
}