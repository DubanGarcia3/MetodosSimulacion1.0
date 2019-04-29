package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uptc.com.sim.entities.Register;
import views.JDialogMiddle;
import views.JFramePrincipal;

public class Controller implements ActionListener {

	private JFramePrincipal jFramePrincipal;
	private JDialogMiddle jDialogMiddle;

	public Controller() {
		this.jFramePrincipal = new JFramePrincipal(this);
		this.jDialogMiddle = new JDialogMiddle(this);
	}

	public void run() {
		jFramePrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Action.valueOf(e.getActionCommand())) {
		case MIDDLE:
			jDialogMiddle.setVisible(true);
			break;
		case LOAD_SEED:
			loadSeed();
			break;
		default:
			break;
		}
		
	}
	
	private void loadSeed() {
//		jDialogMiddle.test(jDialogMiddle.getSeed());
		calculate();
	}
	
	private int calculate() {
		for (int i = 0; i < 5; i++) {
			String a = "asd";
			int seed = jDialogMiddle.getSeed();
			int potency = (int) Math.pow(seed, 2);
			
			Register register = new Register(seed, potency, 0, 0, 0);
			jDialogMiddle.addRow(register);
		}
		return 0;
	}
	
}
