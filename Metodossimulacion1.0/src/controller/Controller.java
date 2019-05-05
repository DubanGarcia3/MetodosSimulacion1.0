package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JOptionPane;

import persistence.FileManager;
import proof.StockingTest;
import runner.Main;
import uptc.com.sim.entities.ChiUni;
import uptc.com.sim.entities.LinealCongruency;
import uptc.com.sim.entities.ManagerDistribution;
import uptc.com.sim.entities.MultiCongruency;
import uptc.com.sim.entities.Register;
import views.JDialogDistriChi;
import views.JDialogDistributionUn;
import views.JDialogInputDistribution;
import views.JDialogLinealCongruency;
import views.JDialogMiddle;
import views.JDialogMultiCongruency;
import views.JDialogStockingTest;
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
	private JDialogStockingTest jDialogStockingTest;
	private FileManager fileManager;
	private StockingTest stockingTest;
	private ManagerDistribution managerDistribution;
	private JDialogDistriChi jDialogDistriChi;
	private double initial;

	public Controller() {
		this.fileManager = new FileManager();
		this.stockingTest = new StockingTest(5, 1, 0.95, 1.95996398);
		this.linealCongruency = new LinealCongruency(1,2,6,3);
		this.multiCongruency = new MultiCongruency(5, 2, 16);
		this.jFramePrincipal = new JFramePrincipal(this);
		this.jDialogMiddle = new JDialogMiddle(this);
		this.jDialogStockingTest = new JDialogStockingTest(this);
		this.jDialogLinealCongruency = new JDialogLinealCongruency(this);
		this.jDialogDistributionUn = new JDialogDistributionUn(this);
		this.jDialogInputDistribution = new JDialogInputDistribution(this);
		this.jDialogMultiCongruency = new JDialogMultiCongruency(this);
		this.jDialogDistriChi = new JDialogDistriChi(this);
		this.managerDistribution = new ManagerDistribution();
		this.initial = 0;
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
			generateStockingTest();
			break;
		case BTN_GENERATE_STACKING:
			manageStockingTest();
			break;
		case GENERATE_VALUES:
			generateValuesForDistribution();
			break;
		case APPLY_CHI:
			applyChi();
			break;
		default:
			break;
		}
	}
	

	private void generateValuesForDistribution() {
		if(jDialogInputDistribution.statusFields() == true) {
			jDialogDistributionUn.setText(jDialogInputDistribution.getTextQuantity(), jDialogInputDistribution.getTextA(), jDialogInputDistribution.getTextB());
			jDialogDistributionUn.clearTable();
			loadDistributionData(Integer.parseInt(jDialogInputDistribution.getTextQuantity()), Double.parseDouble(jDialogInputDistribution.getTextA()), Double.parseDouble(jDialogInputDistribution.getTextB()));
			checandomamadas();
			jDialogInputDistribution.setVisible(false);
			jDialogInputDistribution.clearFields();
			jDialogDistributionUn.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Error!, campos invalidos","Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void checandomamadas() {
		
	}
	
	private void loadDistributionData(int quantity, double min, double max) {
		for (int i = 0; i < quantity; i++) {
			double ri = managerDistribution.createRi();
			double ni = managerDistribution.calculateNi(ri, min, max);
			managerDistribution.addNi(ni);
			jDialogDistributionUn.addRow(managerDistribution.create(ri, ni));			
		}
	}
	
	private void applyChi() {
		Double minAndmax[] = managerDistribution.getMinAndMax(managerDistribution.getNi());
		jDialogDistriChi.setText(String.valueOf(minAndmax[0]), String.valueOf(minAndmax[1]), String.valueOf(14.0), String.valueOf(23.6847913));
		initial = minAndmax[0];
		for (int i = 0; i < 14; i++) {
			calculateFrequency(initial, minAndmax[1], minAndmax[0], 14);
		}
		jDialogDistriChi.setVisible(true);
	}
	
	private void calculateFrequency(double initial, double max, double min, double quanty) {
		double theEnd = initial+(max-min)/quanty;
		jDialogDistriChi.addRow(new ChiUni(initial, theEnd, frequencyObtained(initial, theEnd), (managerDistribution.getNi().size()/14), 1.8));
		this.initial = theEnd;
	}
	
	private int frequencyObtained(double initial, double theEnd) {
		int count = 0;
		for (int i = 0; i < managerDistribution.getNi().size(); i++) {
			if(managerDistribution.getNi().get(i) > initial && managerDistribution.getNi().get(i) < theEnd ) {
				count++;
			}
		}
		return count;
	}
	
	private void validStockingData() {
	}

	private void generateStockingTest() {
		jDialogStockingTest.setVisible(true);
		jDialogStockingTest.cleanAll();
		jDialogStockingTest.getjTableStocking().clearTable();
	}

	private void manageStockingTest() {
		stockingTest.setMedia(Double.parseDouble(jDialogStockingTest.getjTextFieldMedia().getText()));
		stockingTest.setAcceptMargin(Double.parseDouble(jDialogStockingTest.getjTextFieldAcceptmargin().getText()));
		stockingTest.setDesvest(Double.parseDouble(jDialogStockingTest.getjTextFieldDesvest().getText()));
		stockingTest.setZ(Double.parseDouble(jDialogStockingTest.getjTextFieldZ().getText()));
		try {
			for (int i = 0; i < fileManager.readFile().size(); i++) {
				stockingTest.add(((Double.parseDouble(Arrays.toString(FileManager.splitLine(fileManager.readFile().get(i),",")).
				substring(1, Arrays.toString(FileManager.splitLine(fileManager.readFile().get(i),",")).length()-1)))));
			}
			stockingTest.createTableNormalized();
			jDialogStockingTest.getjTableStocking().addListStocking(stockingTest.getListStocking());
			jDialogStockingTest.updateData(""+stockingTest.getAcceptMargin(), ""+stockingTest.getAlpha(), ""+stockingTest.getN(),
					""+stockingTest.getAverage(), ""+stockingTest.getHalfA(), ""+stockingTest.getZ(), ""+stockingTest.getLi(),
					""+stockingTest.getLs(), ""+stockingTest.getMin(), ""+stockingTest.getMax());
		} catch (IOException e) {
			//dddsjshsjhshjsj
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
