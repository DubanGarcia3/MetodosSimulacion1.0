package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import uptc.com.sim.entities.LinealCongruency;
import uptc.com.sim.entities.Register;
import views.JDialogInputLinearCongruency;
import views.JDialogLinealCongruency;
import views.JDialogMiddle;
import views.JFramePrincipal;

public class Controller implements ActionListener {

	private JFramePrincipal jFramePrincipal;
	private JDialogMiddle jDialogMiddle;
	private JDialogLinealCongruency jDialogLinealCongruency;
	private LinealCongruency linealCongruency;

	public Controller() {
		this.linealCongruency = new LinealCongruency(1,2,6,3);
		this.jFramePrincipal = new JFramePrincipal(this);
		this.jDialogMiddle = new JDialogMiddle(this);
		this.jDialogLinealCongruency = new JDialogLinealCongruency(this);
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
		case CONG_LIN:
			manageCongLin();
			break;
		case BTN_GENERATE_CONG_LIN:
			generateListCongLin();
			break;
		case CONG_MUL:
			manageCongMulti();
			break;
		default:
			break;
		}
	}
	
	private void manageCongMulti() {
		
	}

	private void generateListCongLin() {
		jDialogLinealCongruency.setVisible(true);
		linealCongruency.setXo(Double.parseDouble(jDialogLinealCongruency.getjTextFieldX0().getText()));
		linealCongruency.setK(Double.parseDouble(jDialogLinealCongruency.getjTextFieldK().getText()));
		linealCongruency.setC(Double.parseDouble(jDialogLinealCongruency.getjTextFieldC().getText()));
		linealCongruency.setG(Double.parseDouble(jDialogLinealCongruency.getjTextFieldG().getText()));
		linealCongruency.calculateLinealCong(linealCongruency.getXo());
		jDialogLinealCongruency.getjTableLinealCongruency().addListCongruency(linealCongruency.getListData());
	}

	private void manageCongLin() {
		jDialogLinealCongruency.setVisible(true);
		jDialogLinealCongruency.cleanAll();
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
			 completeChain= "0" + completeChain;
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
