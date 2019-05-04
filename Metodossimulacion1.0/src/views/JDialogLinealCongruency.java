package views;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JScrollPane;


public class JDialogLinealCongruency extends JDialog{

	private static final long serialVersionUID = 1L;
	private JTableLinealCongruency jTableLinealCongruency;

	public JDialogLinealCongruency() {
		this.setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()- 
						Toolkit.getDefaultToolkit().getScreenSize().getHeight()/4)));
		this.setLocationRelativeTo(null);
		init();
	}

	private void init() {
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		jTableLinealCongruency = new JTableLinealCongruency();
		jTableLinealCongruency.setPreferredSize(new Dimension((int)this.getWidth()-40, this.getHeight()*3-this.getHeight()/4));
		scrollPane.setViewportView(jTableLinealCongruency);
	}

	public JTableLinealCongruency getjTableLinealCongruency() {
		return jTableLinealCongruency;
	}

	public void setjTableLinealCongruency(JTableLinealCongruency jTableLinealCongruency) {
		this.jTableLinealCongruency = jTableLinealCongruency;
	}
}