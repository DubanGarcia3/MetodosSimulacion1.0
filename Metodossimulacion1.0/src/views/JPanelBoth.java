package views;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelBoth extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel jLabelDescription;
	
	public JPanelBoth() {
		this.setBackground(Color.decode("#A2DD2E"));
		this.jLabelDescription = new JLabel("Elaborado por: Duban Garcia, Miller Uchamocha\n Facultad de ingenieria en sistemas y computacion");
		add(jLabelDescription);
	}
}
