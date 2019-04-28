package views;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelNorth extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel jLabelTittle;
	
	public JPanelNorth() {
		this.setBackground((ConstansUI.COLOR_PANEL_CENTER));
		this.jLabelTittle = new JLabel("METODOS");
		this.jLabelTittle.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 26));
		add(jLabelTittle);
	}
}
