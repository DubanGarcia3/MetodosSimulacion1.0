package views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class JDialogLinealCongruency extends JDialog{
	
	private MyJTextField jTextFieldX0, jTextFieldK, jTextFieldG, jTextFieldC;
	
	public JDialogLinealCongruency() {
		this.setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()- 
						Toolkit.getDefaultToolkit().getScreenSize().getHeight()/4)));
		this.setLocationRelativeTo(null);
		
		init();
	}

	private void init() {
		jTextFieldX0 = new MyJTextField("Xo");
		jTextFieldK = new MyJTextField("K");
		jTextFieldG = new MyJTextField("G");
		jTextFieldC = new MyJTextField("C");
		
		JPanel jPanelMain = new JPanel();
		JPanel jPanel1 = new JPanel(new GridLayout(2,2,10,10));
		jPanel1.setPreferredSize(new Dimension((int)this.getWidth(), this.getHeight()/4));
		
		jPanel1.add(jTextFieldX0);
		jPanel1.add(jTextFieldK);
		jPanel1.add(jTextFieldG);
		jPanel1.add(jTextFieldC);
		
		JPanel jPanel2 = new JPanel();
		
		jPanelMain.add(jPanel1);
		this.add(jPanelMain);
		
		
		
	}
	
	
	
	

}
