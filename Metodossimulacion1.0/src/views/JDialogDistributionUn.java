package views;


import javax.swing.ImageIcon;
import javax.swing.JDialog;

import controller.Controller;

public class JDialogDistributionUn extends JDialog{

	private static final long serialVersionUID = 1L;
	
	
	public JDialogDistributionUn(Controller controller) {
		setIconImage(new ImageIcon(getClass().getResource(ConstansUI.PATH_IMAGE_PERFIL)).getImage());
		setSize(ConstansUI.SIZE_WINDOW_X, ConstansUI.SIZE_WINDOW_SEED_Y);
		setTitle(ConstansUI.MESSAGE_TITTLE_DIALOG_DISTRIBUTION);
		setLocationRelativeTo(null);
		setModal(true);
		init(controller);
	}
	
	
	private void init(Controller controller) {
		
	}
}
