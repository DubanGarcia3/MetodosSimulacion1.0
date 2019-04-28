package views;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JPanelLeft extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextArea jLabelInformation;
	private JLabel jLabelIcon;
	
	public JPanelLeft() {
		setLayout(new BorderLayout());
		this.setBackground((ConstansUI.COLOR_PANEL_LEFT));
		this.jLabelInformation = new JTextArea("Este software contiene metodos\n de congruencia para el inicio\n del desarrollo de simulaciones.\n Fines totalmente academicos");
		this.jLabelInformation.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		this.jLabelInformation.setEditable(false);
		this.jLabelInformation.setBackground((ConstansUI.COLOR_PANEL_LEFT));
		add(jLabelInformation, BorderLayout.NORTH);
		
		this.jLabelIcon = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource(ConstansUI.PATH_IMAGE_UPTC)).getImage().getScaledInstance(200, 200, 100)));
		add(jLabelIcon, BorderLayout.CENTER);
	}
}
