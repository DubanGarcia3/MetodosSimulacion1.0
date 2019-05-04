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
import uptc.com.sim.entities.LinealCongruency;

public class JDialogLinealCongruency extends JDialog{
	
	
	
	private JTableLinealCongruency jTableLinealCongruency;
	
	public JDialogLinealCongruency() {
		this.setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()- 
						Toolkit.getDefaultToolkit().getScreenSize().getHeight()/4)));
		this.setLocationRelativeTo(null);
		init();
	}

	private void init() {
		JPanel jPanelMain = new JPanel();
		
		jTableLinealCongruency = new JTableLinealCongruency();
		jTableLinealCongruency.setPreferredSize(new Dimension((int)this.getWidth()-40, this.getHeight()*3-this.getHeight()/4));
		
		jPanelMain.add(jTableLinealCongruency);
		this.add(jPanelMain);
	}
	
	public JTableLinealCongruency getjTableLinealCongruency() {
		return jTableLinealCongruency;
	}

	public void setjTableLinealCongruency(JTableLinealCongruency jTableLinealCongruency) {
		this.jTableLinealCongruency = jTableLinealCongruency;
	}
}