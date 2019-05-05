package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import uptc.com.sim.entities.LinealCongruency;
import uptc.com.sim.entities.Register;
import views.JDialogDistributionUn;
import views.JDialogLinealCongruency;
import views.JDialogMiddle;
import views.JFramePrincipal;

public class Controller implements ActionListener {

	private JFramePrincipal jFramePrincipal;
	private JDialogMiddle jDialogMiddle;
	private JDialogLinealCongruency jDialogLinealCongruency;
	private LinealCongruency linealCongruency;
	private JDialogDistributionUn jDialogDistributionUn;

	public Controller() {
		this.linealCongruency = new LinealCongruency(1,2,6,3);
		this.jFramePrincipal = new JFramePrincipal(this);
		this.jDialogMiddle = new JDialogMiddle(this);
		this.jDialogLinealCongruency = new JDialogLinealCongruency(this);
		this.jDialogDistributionUn = new JDialogDistributionUn(this);
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
		case DISTRIBUTION:
			executeDistribution();
			break;
		default:
			break;
		}
	}
	
	private void executeDistribution() {
		String value = JOptionPane.showInputDialog(null, "Digite la cantidad de Ri a generar", "Dato de entrada", JOptionPane.INFORMATION_MESSAGE);
		if(!value.isEmpty()) {
		jDialogDistributionUn.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "El campo es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void manageCongMulti() {
	}

	private void generateListCongLin() {
		jDialogLinealCongruency.getjTableLinealCongruency().clearTable();
		if (jDialogLinealCongruency.getjTextFieldX0().getText().isEmpty() ||  
			jDialogLinealCongruency.getjTextFieldK().getText().isEmpty() ||
			jDialogLinealCongruency.getjTextFieldC().getText().isEmpty() ||
			jDialogLinealCongruency.getjTextFieldG().getText().isEmpty() ) {
			JOptionPane.showMessageDialog(null, "por favor ingresar todos los datos numericos  ;)");
		}else {
			jDialogLinealCongruency.setVisible(true);
			linealCongruency.setXo(Double.parseDouble(jDialogLinealCongruency.getjTextFieldX0().getText()));
			linealCongruency.setK(Double.parseDouble(jDialogLinealCongruency.getjTextFieldK().getText()));
			linealCongruency.setC(Double.parseDouble(jDialogLinealCongruency.getjTextFieldC().getText()));
			linealCongruency.setG(Double.parseDouble(jDialogLinealCongruency.getjTextFieldG().getText()));
			linealCongruency.calculateLinealCong(linealCongruency.getXo());
			jDialogLinealCongruency.getjTableLinealCongruency().addListCongruency(linealCongruency.getListData());
		}
	}

	private void manageCongLin() {
		jDialogLinealCongruency.setVisible(true);
		jDialogLinealCongruency.cleanAll();
		jDialogLinealCongruency.getjTableLinealCongruency().clearTable();
	}

	private void loadSeed() {
		if(jDialogMiddle.statusSeed() == true) {
				try {
					jDialogMiddle.clearTable();
					calculate(jDialogMiddle.getSeed());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Se totie");
				}
		}else {
			jDialogMiddle.messagge(jDialogMiddle.statusSeed());
		}
	}
	
	private void calculate(int initial) throws Exception{
		try {
			int seed = initial;
			int potency = (int) Math.pow(seed, 2);
			String extent = String.valueOf(potency);
			int length = extent.length();
			String addZero = addZero(length, extent);
			Register register = new Register(seed, potency, length, getChain(addZero), calculateRi(addZero));
			jDialogMiddle.addRow(register);
			calculate(getChain(addZero));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
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
