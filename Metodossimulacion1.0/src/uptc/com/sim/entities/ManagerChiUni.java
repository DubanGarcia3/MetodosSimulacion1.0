package uptc.com.sim.entities;

import java.util.ArrayList;

public class ManagerChiUni {
	
	private ArrayList<Double> oFList;
	private ArrayList<Double> eFList;
	private ArrayList<Double> chiList;
	
	public ManagerChiUni() {
		oFList = new ArrayList<Double>();
		eFList = new ArrayList<Double>();
		chiList = new ArrayList<Double>();
	}
	
	public void addOF(double oF) {
		oFList.add(oF);
	}
	
	public void addEF(double eF) {
		eFList.add(eF);
	}
	
	public void addChi(double chi) {
		chiList.add(chi);
	}
	
	public double oF() {
		double count = 0;
		for (int i = 0; i < oFList.size(); i++) {
			count = count + oFList.get(i);
		}
		return count;
	}
	
	public double eF() {
		double count = 0;
		for (int i = 0; i < eFList.size(); i++) {
			count = count + eFList.get(i);
		}
		return count;
	}
	
	public double chi() {
		double count = 0;
		for (int i = 0; i < chiList.size(); i++) {
			count = count + chiList.get(i);
		}
		return count;
	}
	
}
