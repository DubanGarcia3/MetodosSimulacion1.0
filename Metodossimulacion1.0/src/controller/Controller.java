package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JOptionPane;

import persistence.FileManager;
import proof.StockingTest;
import uptc.com.sim.entities.LinealCongruency;
import uptc.com.sim.entities.MultiCongruency;
import uptc.com.sim.entities.Register;
import views.JDialogDistributionUn;
import views.JDialogInputDistribution;
import views.JDialogLinealCongruency;
import views.JDialogMiddle;
import views.JDialogMultiCongruency;
import views.JFramePrincipal;

public class Controller implements ActionListener {

	private JFramePrincipal jFramePrincipal;
	private JDialogMiddle jDialogMiddle;
	private JDialogLinealCongruency jDialogLinealCongruency;
	private JDialogMultiCongruency jDialogMultiCongruency;
	private LinealCongruency linealCongruency;
	private MultiCongruency multiCongruency;
	private JDialogInputDistribution jDialogInputDistribution;
	private JDialogDistributionUn jDialogDistributionUn;
	private FileManager fileManager;
	private StockingTest stockingTest;

	public Controller() {
		this.fileManager = new FileManager();
		this.stockingTest = new StockingTest(5, 1, 0.95, 1.95996398);
		this.linealCongruency = new LinealCongruency(1,2,6,3);
		this.multiCongruency = new MultiCongruency(5, 2, 16);
		this.jFramePrincipal = new JFramePrincipal(this);
		this.jDialogMiddle = new JDialogMiddle(this);
		this.jDialogLinealCongruency = new JDialogLinealCongruency(this);
		this.jDialogDistributionUn = new JDialogDistributionUn(this);
		this.jDialogInputDistribution = new JDialogInputDistribution(this);
		this.jDialogMultiCongruency = new JDialogMultiCongruency(this);
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
		case BTN_GENERATE_CONG_MULTI:
			generateListCongMulti();
			break;
		case DISTRIBUTION:
			executeDistribution();
			break;
		case STOCKING_TEST:
			manageStockingTest();
			break;
		case GENERATE_VALUES:
			generateValuesForDistribution();
			break;
		default:
			break;
		}
	}
	
	private void generateValuesForDistribution() {
		if(jDialogInputDistribution.statusFields() == true) {
			jDialogDistributionUn.setText(jDialogInputDistribution.getTextQuantity(), jDialogInputDistribution.getTextA(), jDialogInputDistribution.getTextB());
			jDialogInputDistribution.setVisible(false);
			jDialogInputDistribution.clearFields();
			jDialogDistributionUn.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Error!, campos invalidos","Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void loadDistributionData() {
		
	}

	@SuppressWarnings("unused")
	private void manageStockingTest() {
		try {
			for (int i = 0; i < fileManager.readFile().size(); i++) {
				stockingTest.getListNi().add(Double.parseDouble(Arrays.toString(FileManager.splitLine(fileManager.readFile().get(i),",")).
				substring(1, Arrays.toString(FileManager.splitLine(fileManager.readFile().get(i),",")).length()-1)));
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private void executeDistribution() {
		jDialogInputDistribution.setVisible(true);
	}

	private void manageCongMulti() {
		jDialogMultiCongruency.setVisible(true);
		jDialogMultiCongruency.cleanAll();
		jDialogMultiCongruency.getjTableLinealCongruency().clearTable();
	}
	
	private void generateListCongMulti() {
		jDialogMultiCongruency.getjTableLinealCongruency().clearTable();
		if (jDialogMultiCongruency.getjTextFieldX0().getText().isEmpty() ||  
				jDialogMultiCongruency.getjTextFieldT().getText().isEmpty() ||
				jDialogMultiCongruency.getjTextFieldD().getText().isEmpty() ) {
			JOptionPane.showMessageDialog(null, "por favor ingresar todos los datos numericos  ;)");
		}else {
			jDialogMultiCongruency.setVisible(true);
			multiCongruency.setX0(Double.parseDouble(jDialogMultiCongruency.getjTextFieldX0().getText()));
			multiCongruency.setT(Double.parseDouble(jDialogMultiCongruency.getjTextFieldT().getText()));
			multiCongruency.setD(Double.parseDouble(jDialogMultiCongruency.getjTextFieldD().getText()));
			multiCongruency.calculateLinealCong(multiCongruency.getX0());
			jDialogMultiCongruency.getjTableLinealCongruency().addListCongruency(multiCongruency.getListCongruencies());
		}
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
					JOptionPane.showMessageDialog(null, "Error");
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
