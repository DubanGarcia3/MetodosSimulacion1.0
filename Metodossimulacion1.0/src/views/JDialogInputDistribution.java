package views;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Controller;

public class JDialogInputDistribution extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private JLabel jLabelQuantity;
	private JTextField jTextFieldQuantity;
	private JLabel jLabelA;
	private JTextField jTextFieldA;
	private JLabel jLabelB;
	private JTextField jTextFieldB;
	
	
	public JDialogInputDistribution(Controller controller) {
		setIconImage(new ImageIcon(getClass().getResource(ConstansUI.PATH_IMAGE_PERFIL)).getImage());
		setSize(ConstansUI.SIZE_WINDOW_DIALOG_INPUT_X, ConstansUI.SIZE_WINDOW_DIALOG_INPUT_Y);
		setTitle(ConstansUI.MESSAGE_TITTLE_DIALOG_INPUT_VALUES);
		setLocationRelativeTo(null);
		setModal(true);
		init(controller);
	}
	
	private void init(Controller controller){
		
	}
		
}
