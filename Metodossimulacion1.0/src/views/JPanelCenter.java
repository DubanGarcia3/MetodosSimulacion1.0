package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Action;
import controller.Controller;

public class JPanelCenter  extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButton jButtonMiddle;
	private JButton jButtonCongruency, jButtonCongruencyMulti;
	private JButton jButtonDistribution;
	private GridBagConstraints gbc;
	
	public JPanelCenter(Controller controller) {
		this.setBackground((ConstansUI.COLOR_PANEL_LEFT));
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		jButtonMiddle = new JButton("Cuadrados medios");
		jButtonMiddle.setFocusable(false);
		jButtonMiddle.setBackground(Color.WHITE);
		jButtonMiddle.setFont(new Font("Arial", Font.PLAIN, 16));
		jButtonMiddle.addActionListener(controller);
		jButtonMiddle.setActionCommand(Action.MIDDLE.toString());
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(jButtonMiddle, gbc);
		
		jButtonCongruency = new JButton("Congruencia lineal");
		jButtonCongruency.setFocusable(false);
		jButtonCongruency.setBackground(Color.WHITE);
		jButtonCongruency.setFont(new Font("Arial", Font.PLAIN, 16));
		jButtonCongruency.addActionListener(controller);
		jButtonCongruency.setActionCommand(Action.CONG_LIN.toString());
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(jButtonCongruency,gbc);
		
		jButtonCongruencyMulti = new JButton("Congruencia Multi.");
		jButtonCongruencyMulti.setFocusable(false);
		jButtonCongruencyMulti.setBackground(Color.WHITE);
		jButtonCongruencyMulti.setFont(new Font("Arial", Font.PLAIN, 16));
		jButtonCongruencyMulti.addActionListener(controller);
		jButtonCongruencyMulti.setActionCommand(Action.CONG_MUL.toString());
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(jButtonCongruencyMulti,gbc);
		
		jButtonDistribution = new JButton("Distribucion uniforme");
		jButtonDistribution.setFocusable(false);
		jButtonDistribution.setBackground(Color.WHITE);
		jButtonDistribution.setFont(new Font("Arial", Font.PLAIN, 16));
		jButtonDistribution.addActionListener(controller);
		jButtonDistribution.setActionCommand(Action.DISTRIBUTION.toString());
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(jButtonDistribution, gbc);
		
		
	}
}
