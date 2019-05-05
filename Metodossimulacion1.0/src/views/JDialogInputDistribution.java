package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Action;
import controller.Controller;

public class JDialogInputDistribution extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private JLabel jLabelQuantity;
	private JTextField jTextFieldQuantity;
	private JLabel jLabelA;
	private JTextField jTextFieldA;
	private JLabel jLabelB;
	private JTextField jTextFieldB;
	private JButton jButtonInput;
	private GridBagConstraints gbc;
	
	
	public JDialogInputDistribution(Controller controller) {
		setIconImage(new ImageIcon(getClass().getResource(ConstansUI.PATH_IMAGE_PERFIL)).getImage());
		setSize(ConstansUI.SIZE_WINDOW_DIALOG_INPUT_X, ConstansUI.SIZE_WINDOW_DIALOG_INPUT_Y);
		setTitle(ConstansUI.MESSAGE_TITTLE_DIALOG_INPUT_VALUES);
		setLocationRelativeTo(null);
		setModal(true);
		setResizable(false);
		init(controller);
	}
	
	private void init(Controller controller){
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		jLabelQuantity = new JLabel("Cantidad de elementos: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(jLabelQuantity, gbc);
		
		jTextFieldQuantity = new JTextField(5);
		jTextFieldQuantity.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();

				if (jTextFieldQuantity.getText().length() == 4) {
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
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(jTextFieldQuantity, gbc);
		
		jLabelA = new JLabel("Cota inferior: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(jLabelA, gbc);
		
		jTextFieldA = new JTextField(4);
		jTextFieldA.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();

				if (jTextFieldA.getText().length() == 4) {
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
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(jTextFieldA, gbc);
		
		jLabelB = new JLabel("Cota superior: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(jLabelB, gbc);
		
		jTextFieldB = new JTextField(4);
		jTextFieldB.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();

				if (jTextFieldB.getText().length() == 4) {
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
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(jTextFieldB, gbc);
		
		jButtonInput = new JButton("Generar datos");
		jButtonInput.setFocusable(false);
		jButtonInput.setBackground(Color.WHITE);
		jButtonInput.setFont(new Font("Arial", Font.PLAIN, 12));
		jButtonInput.addActionListener(controller);
		jButtonInput.setActionCommand(Action.GENERATE_VALUES.toString());
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 3;
		gbc.weighty = 3;
		add(jButtonInput, gbc);
	}
}
