package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.print.attribute.standard.JobName;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Action;
import controller.Controller;

public class JPanelMiddleTop extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelTittle;
	private JTextField jTextField;
	private JButton jButtonSend;

	public JPanelMiddleTop(Controller controller) {
		setLayout(new FlowLayout());
		this.setBackground(Color.decode("#A2DD2E"));
		this.jLabelTittle = new JLabel("Semilla");
		this.jLabelTittle.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 14));
		add(jLabelTittle);

		this.jTextField = new JTextField(6);
		this.jTextField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();

				if (jTextField.getText().length() == 4) {
					e.consume();
				}
				if(((caracter < '0') ||
						(caracter > '9')) &&
						(caracter != '\b' ))
				{
					e.consume();  
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		add(jTextField);

		this.jButtonSend = new JButton("Cargar semilla");
		jButtonSend.setFocusable(false);
		jButtonSend.setBackground(Color.WHITE);
		jButtonSend.setFont(new Font("Arial", Font.PLAIN, 12));
		jButtonSend.addActionListener(controller);
		jButtonSend.setActionCommand(Action.LOAD_SEED.toString());
		add(jButtonSend);
	}
	
	public int getSeed() {
		if(jTextField.getText().isEmpty() || jTextField.getText().length() <4) {
			return 0;
		}else {
			return Integer.parseInt(jTextField.getText());
		}
		
	}
	
	public void messagge(int value) {
		if(value ==0) {
			JOptionPane.showMessageDialog(null, "Debe ingresar una semilla valida");
		}
	}
}
