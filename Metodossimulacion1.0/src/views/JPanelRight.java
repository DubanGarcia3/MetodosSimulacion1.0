package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Action;
import controller.Controller;

public class JPanelRight extends JPanel{

	/**
	 * @author Duban
	 * @author Miller
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton jButtonStokingTest;
	private JButton jButtonVariance;
	private GridBagConstraints gbc;
	
	public JPanelRight(Controller controller) {
		this.setBackground((ConstansUI.COLOR_PANEL_LEFT));
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		jButtonStokingTest = new JButton("Prueba de medias");
		jButtonStokingTest.setFocusable(false);
		jButtonStokingTest.setBackground(Color.WHITE);
		jButtonStokingTest.setFont(new Font("Arial", Font.PLAIN, 16));
		jButtonStokingTest.addActionListener(controller);
		jButtonStokingTest.setActionCommand(Action.STOCKING_TEST.name());
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(jButtonStokingTest, gbc);
		
		jButtonVariance = new JButton("Prueba de varianzas");
		jButtonVariance.setFocusable(false);
		jButtonVariance.setBackground(Color.WHITE);
		jButtonVariance.setFont(new Font("Arial", Font.PLAIN, 16));
		jButtonVariance.addActionListener(controller);
		jButtonVariance.setActionCommand(Action.VARIANCE.name());
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(jButtonVariance,gbc);
		
	}
	
	

}
