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
		calculate(jDialogMiddle.getSeed());
	}
	
	private void calculate(int initial) {
			int seed = initial;
			int potency = (int) Math.pow(seed, 2);
			String extent = String.valueOf(potency);
			int length = extent.length();
			String addZero = addZero(length, extent);
			System.out.println(calculateRi(addZero));
			Register register = new Register(seed, potency, length, getChain(addZero), calculateRi(addZero));
			jDialogMiddle.addRow(register);
			calculate(getChain(addZero));
	}
	
	private String addZero(int length, String extent) {
		int value = (8-length);
		String completeChain =extent;
		for (int i = 0; i < value; i++) {
			 completeChain= "0"+completeChain;
		}
		return  completeChain;
	}
	
	private int getChain(String chain) {
		String value = chain.substring(2, 6);
		int extract = Integer.parseInt(value);
		return extract;
	}
	
	private double calculateRi(String chain) {
		return (double)getChain(chain)/10000;
	}
}
