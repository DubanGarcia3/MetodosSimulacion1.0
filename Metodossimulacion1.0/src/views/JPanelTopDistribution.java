package views;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;


public class JPanelTopDistribution extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel jLabelTittle;
	private JLabel jLabelMin;
	private JLabel jJLabelMax;
	private JButton jButtonChiSquare;

	public JPanelTopDistribution(Controller controller) {
		setLayout(new FlowLayout());
		this.setBackground(Color.decode("#A2DD2E"));
		init();
	}
	
	private void init() {
		this.jLabelTittle = new JLabel();
		this.jLabelTittle.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		add(jLabelTittle);
		
		this.jLabelMin = new JLabel();
		this.jLabelMin.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		add(jLabelMin);
		
		this.jJLabelMax = new JLabel();
		this.jJLabelMax.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		add(jJLabelMax);
		
		this.jButtonChiSquare = new JButton("Aplicar Chi2");
		this.jButtonChiSquare.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		this.jButtonChiSquare.setFocusable(false);
		this.jButtonChiSquare.setBackground(Color.WHITE);
		add(jButtonChiSquare);
	}
	
	public void setText(String tittle, String min, String max) {
		jLabelTittle.setText("Cantidad de elementos: "+tittle);
		jLabelMin.setText("Min: "+min);
		jJLabelMax.setText("Max: "+max);
		updateUI();
	}
}
