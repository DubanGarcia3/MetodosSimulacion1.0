package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class JPanelTopDistriChi extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel jLabelMin;
	private JLabel jJLabelMax;
	private JLabel jLabelLibertyGrade;
	private JLabel jLabelTest;
	
	public JPanelTopDistriChi(Controller controller) {
		setLayout(new FlowLayout());
		this.setBackground(Color.decode("#A2DD2E"));
		init(controller);
	}


	private void init(Controller controller) {
		this.jLabelMin = new JLabel();
		this.jLabelMin.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		add(jLabelMin);
		
		this.jJLabelMax = new JLabel();
		this.jJLabelMax.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		add(jJLabelMax);
		
		this.jLabelLibertyGrade = new JLabel();
		this.jLabelLibertyGrade.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		add(jLabelLibertyGrade);
		
		this.jLabelTest = new JLabel();
		this.jLabelTest.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		add(jLabelTest);
	}
	

	public void setText(String min, String max, String libertyGrade, String test) {
		jLabelMin.setText("Min: "+min);
		jJLabelMax.setText("Max: "+max);
		jLabelLibertyGrade.setText("Grado de libertad: "+libertyGrade);
		jLabelTest.setText("Prueba chi: "+test);
		updateUI();
	}
	
}
