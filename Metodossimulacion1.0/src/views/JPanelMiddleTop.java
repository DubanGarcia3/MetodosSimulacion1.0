package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	
	public Boolean statusSeed() {
		if(jTextField.getText().isEmpty() || jTextField.getText().length() <4) {
			return false;
		}else {
			return true;
		}
	}
	
	public int getSeed() {
		return Integer.parseInt(jTextField.getText());
	}
	
	public void messagge(Boolean value) {
		if(value == false) {
			JOptionPane.showMessageDialog(null, "Debe ingresar una semilla valida", "Aviso!", JOptionPane.QUESTION_MESSAGE);
		}
	}
}
