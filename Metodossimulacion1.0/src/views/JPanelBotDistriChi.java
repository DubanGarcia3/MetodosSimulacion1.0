package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelBotDistriChi extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel jLabelTotal;
	private JLabel jLabelObtainedFrequency;
	private JLabel jLabelExpectedFrequency;
	private JLabel jLabelTotalChi;
	private GridBagConstraints gbc;
	
	public JPanelBotDistriChi() {
		setLayout(new FlowLayout());
		gbc = new GridBagConstraints();
		this.setBackground(Color.decode("#A2DD2E"));
		init();
	}

	private void init() {
		jLabelTotal = new JLabel("Totales: ");
		add(jLabelTotal);
		
		jLabelObtainedFrequency = new JLabel();
		add(jLabelObtainedFrequency);
		
		jLabelExpectedFrequency = new JLabel();
		add(jLabelExpectedFrequency);
		
		jLabelTotalChi = new JLabel();
		add(jLabelTotalChi);
	}
	
	public void setText(String oF, String eF, String totalChi) {
		jLabelObtainedFrequency.setText("Fre Ob.: "+oF);
		jLabelExpectedFrequency.setText("Fre Es.: "+eF);
		jLabelTotalChi.setText("Sumatoria Chi2: "+totalChi);
	}
}
