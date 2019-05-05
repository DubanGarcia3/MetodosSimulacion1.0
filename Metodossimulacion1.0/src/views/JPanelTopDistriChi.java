package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class JPanelTopDistriChi extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel jLabelMin;
	private JLabel jJLabelMax;
	private JLabel jLabelLibertyGrade;
	private JLabel jLabelTest;
	private GridBagConstraints gbc;
	
	public JPanelTopDistriChi(Controller controller) {
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		this.setBackground(Color.decode("#A2DD2E"));
		init(controller);
	}


	private void init(Controller controller) {
		this.jLabelMin = new JLabel();
		this.jLabelMin.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(jLabelMin, gbc);
		
		this.jJLabelMax = new JLabel();
		this.jJLabelMax.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(jJLabelMax, gbc);
		
		this.jLabelLibertyGrade = new JLabel();
		this.jLabelLibertyGrade.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(jLabelLibertyGrade, gbc);
		
		this.jLabelTest = new JLabel();
		this.jLabelTest.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(jLabelTest, gbc);
	}
	

	public void setText(String min, String max, String libertyGrade, String test) {
		jLabelMin.setText("Min: "+ min);
		jJLabelMax.setText("Max: "+ max);
		jLabelLibertyGrade.setText("Grado de libertad: "+ libertyGrade);
		jLabelTest.setText("Prueba chi: "+ test);
		updateUI();
	}
	
}
