package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Action;
import controller.Controller;
import uptc.com.sim.entities.LinealCongruency;

public class JDialogStockingTest extends JDialog{

	/**
	 * @author Duban
	 */
	private static final long serialVersionUID = 1L;
	
	private JTableStocking jTableStocking;
	private MyJTextField jTextFieldMedia, jTextFieldDesvest, jTextFieldAcceptmargin, jTextFieldZ;
	private JButton jButton, jButton2;
	private Controller controller;
	private JLabel jLabelN, jLabelAverage, jLabelHalfAlpha, jLabelz, jLabelLi, jLabelLs, jLabel, jLabelMin;  

	public JDialogStockingTest(Controller controller) {
		this.controller = controller;
		this.setIconImage(new ImageIcon(getClass().getResource(ConstansUI.PATH_IMAGE_PERFIL)).getImage());
		this.setTitle(ConstansUI.MESSAGE_TITTLE_DIALOG_CONGRUENCY);
		this.setModal(true);
		this.setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()- 
						Toolkit.getDefaultToolkit().getScreenSize().getHeight()/4)));
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		init();
	}

	public void init() {
		JPanel jPanel = new JPanel();
		jPanel.setPreferredSize(new Dimension((int)this.getWidth()-40, this.getHeight()/5));
		
		Font font = new Font("Century Gothic", 1, 14);
		jTextFieldMedia = new MyJTextField("Media");
		jTextFieldDesvest = new MyJTextField("Desviacion estandar");
		jTextFieldAcceptmargin = new MyJTextField("Margen de aceptación");
		jTextFieldZ = new MyJTextField("Z");
		
		jTextFieldMedia.setFont(font);
		jTextFieldDesvest.setFont(font);
		jTextFieldAcceptmargin.setFont(font);
		jTextFieldZ.setFont(font);
		
		jButton = new JButton("   Generar   ");
		jButton2 = new JButton("Validar datos");
		JPanel jPanel1 = new JPanel(new GridLayout(2,2,5,5));
		jPanel1.setPreferredSize(new Dimension((int)this.getWidth()-40, this.getHeight()/8));
		
		jPanel1.add(jTextFieldMedia);
		jPanel1.add(jTextFieldDesvest);
		jPanel1.add(jTextFieldAcceptmargin);
		jPanel1.add(jTextFieldZ);
		
		JPanel jPanelBtn = new JPanel(new FlowLayout());
		
		jButton.setFocusable(false);
		jButton.setBackground(Color.WHITE);
		jButton.setFont(new Font("Arial", Font.PLAIN, 16));
		jButton.addActionListener(controller);
		jButton.setActionCommand(Action.BTN_GENERATE_STACKING.name());
		jPanelBtn.add(jButton);
		
		jButton2.setFocusable(false);
		jButton2.setBackground(Color.WHITE);
		jButton2.setFont(new Font("Arial", Font.PLAIN, 16));
		jButton2.setVisible(false);
		jButton2.addActionListener(controller);
		jButton2.setActionCommand(Action.BTN_VALID_DATA.name());
		jPanelBtn.add(jButton2);
		
		jPanel.add(jPanel1,BorderLayout.CENTER);
		jPanel.add(jPanelBtn, BorderLayout.SOUTH);
		
		
		jTableStocking = new JTableStocking();
		
		jTableStocking.setPreferredSize(new Dimension((int)this.getWidth()-40, (this.getHeight()- (this.getHeight()/4))));
		this.add(jPanel);
		this.add(jTableStocking);
		
		JPanel jPanel2 = new JPanel();
		
	}
	
	public LinealCongruency getCongruencyData() {
		return new LinealCongruency(Double.parseDouble(jTextFieldMedia.getText()), 
				Double.parseDouble(jTextFieldDesvest.getText()), Double.parseDouble(jTextFieldAcceptmargin.getText()), 
				Double.parseDouble(jTextFieldZ.getText()));
	}
	
	public void cleanAll() {
		jTextFieldMedia.setText(""); 
		jTextFieldDesvest.setText("");
		jTextFieldAcceptmargin.setText(""); 
		jTextFieldZ.setText("");
	}

	public JTableStocking getjTableStocking() {
		return jTableStocking;
	}

	public void setjTableStocking(JTableStocking jTableStocking) {
		this.jTableStocking = jTableStocking;
	}

	public MyJTextField getjTextFieldMedia() {
		return jTextFieldMedia;
	}

	public void setjTextFieldMedia(MyJTextField jTextFieldMedia) {
		this.jTextFieldMedia = jTextFieldMedia;
	}

	public MyJTextField getjTextFieldDesvest() {
		return jTextFieldDesvest;
	}

	public JButton getjButton() {
		return jButton;
	}

	public void setjButton(JButton jButton) {
		this.jButton = jButton;
	}

	public JButton getjButton2() {
		return jButton2;
	}

	public void setjButton2(JButton jButton2) {
		this.jButton2 = jButton2;
	}

	public void setjTextFieldDesvest(MyJTextField jTextFieldDesvest) {
		this.jTextFieldDesvest = jTextFieldDesvest;
	}

	public MyJTextField getjTextFieldAcceptmargin() {
		return jTextFieldAcceptmargin;
	}

	public void setjTextFieldAcceptmargin(MyJTextField jTextFieldAcceptmargin) {
		this.jTextFieldAcceptmargin = jTextFieldAcceptmargin;
	}

	public MyJTextField getjTextFieldZ() {
		return jTextFieldZ;
	}

	public void setjTextFieldZ(MyJTextField jTextFieldZ) {
		this.jTextFieldZ = jTextFieldZ;
	}
}
