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

public class JDialogStockingTest extends JDialog{

	/**
	 * @author Duban
	 */
	private static final long serialVersionUID = 1L;
	
	private JTableStocking jTableStocking;
	private MyJTextField jTextFieldMedia, jTextFieldDesvest, jTextFieldAcceptmargin, jTextFieldZ;
	private JButton jButton, jButton2;
	private Controller controller;
	private JLabel jLabelAccept, jLabel2Alpha,jLabelN, jLabelAverage, jLabelHalfAlpha, jLabelz, jLabelLi,
	jLabelLs, jLabelMax, jLabelMin, jLabelPass;  

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
		
		Font font = new Font("Arial", 1, 14);
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
		jButton.setFont(new Font("Arial", Font.PLAIN, 14));
		jButton.addActionListener(controller);
		jButton.setActionCommand(Action.BTN_GENERATE_STACKING.name());
		jPanelBtn.add(jButton);
		
		
		jPanel.add(jPanel1,BorderLayout.CENTER);
		jPanel.add(jPanelBtn, BorderLayout.SOUTH);
		
		
		jTableStocking = new JTableStocking();
		
		jTableStocking.setPreferredSize(new Dimension((int)this.getWidth()-40, ( (this.getHeight()/2))));
		this.add(jPanel);
		this.add(jTableStocking);
		
		JPanel jPanel2 = new JPanel(new GridLayout(6,2));
		jPanel2.setPreferredSize(new Dimension((int)this.getWidth()-40, ( (this.getHeight()/4))-40));
		jLabelAccept = new JLabel("Aceptación");
		jLabel2Alpha = new JLabel("α");
		jLabelN = new JLabel("n");
		jLabelAverage  = new JLabel("promedio ");
		jLabelHalfAlpha  = new JLabel("1-(α/2)");
		jLabelz = new JLabel("Z");
		jLabelLi = new JLabel("Li");
		jLabelLs = new JLabel("Ls");
		jLabelMax = new JLabel("Max");
		jLabelMin = new JLabel("Min");
		jLabelPass = new JLabel();
		jLabelAccept.setFont(font);
		jLabel2Alpha.setFont(font);
		jLabelN.setFont(font);
		jLabelAverage.setFont(font);
		jLabelHalfAlpha.setFont(font);
		jLabelz.setFont(font);
		jLabelLi.setFont(font);
		jLabelLs.setFont(font);
		jLabelMax.setFont(font);
		jLabelMin.setFont(font);
		jLabelPass.setFont(font);
		jPanel2.add(jLabelAccept);
		jPanel2.add(jLabel2Alpha);
		jPanel2.add(jLabelN);
		jPanel2.add(jLabelAverage);
		jPanel2.add(jLabelHalfAlpha);
		jPanel2.add(jLabelz);
		jPanel2.add(jLabelLi);
		jPanel2.add(jLabelLs);
		jPanel2.add(jLabelMax);
		jPanel2.add(jLabelMin);
		jPanel2.add(jLabelPass);
		this.add(jPanel2);
	}
	
	
	public void cleanAll() {
		jTextFieldMedia.setText(""); 
		jTextFieldDesvest.setText("");
		jTextFieldAcceptmargin.setText(""); 
		jTextFieldZ.setText("");
		jLabelAccept.setText("Aceptación");
		jLabel2Alpha.setText("α");
		jLabelN.setText("n");
		jLabelAverage.setText("promedio ");
		jLabelHalfAlpha.setText("1-(α/2)");
		jLabelz.setText("Z");
		jLabelLi.setText("Li");
		jLabelLs.setText("Ls");
		jLabelMax.setText("Max");
		jLabelMin.setText("Min");
		jLabelPass.setText("");
	}
	
	public void updateData(String accept, String alpha, String n, String promedio, String alphaMedios, String Z,
			String li, String ls, String min, String max) {
		jLabelAccept.setText("Aceptación: "+ accept);
		jLabel2Alpha.setText("α: " + alpha);
		jLabelN.setText("n: " + n);
		jLabelAverage.setText("promedio: " + promedio);
		jLabelHalfAlpha.setText("1-(α/2):  " + alphaMedios);
		jLabelz.setText("Z: " + Z);
		jLabelLi.setText("Li: "+li);
		jLabelLs.setText("Ls: "+ls);
		jLabelMax.setText("Max: "+min);
		jLabelMin.setText("Min: "+max);
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

	public JLabel getjLabelPass() {
		return jLabelPass;
	}

	public void setjLabelPass(JLabel jLabelPass) {
		this.jLabelPass = jLabelPass;
	}
}
