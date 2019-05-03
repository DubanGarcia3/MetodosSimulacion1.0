package uptc.com.sim.entities;

import java.util.ArrayList;

public class LinealCongruency {
	
	private double xo, k, c, g, a, m;
	private ArrayList<Congruency> listData;

	public LinealCongruency(double xo, double k, double c, double g) {
		this.xo = xo;
		this.k = k;
		this.c = c;
		this.g = g;
		this.a = this.getA();
		this.m = this.getM();
		this.listData = new ArrayList<Congruency>();
	}

	public void calculateLinealCong(double x0) {
		double auxXi=x0;
		double auxRi=(x0/(m-1));
		addFirst(x0);
		for (int i = 1 ; i < 50; i++) {
			auxXi = ((a*listData.get(i-1).getXi()+c) % m);
			auxRi = (listData.get(i-1).getXi()/(m-1));
			listData.add(new Congruency(auxXi,auxRi));
		}
	}
	
	public void print() {
		for (int i = 0; i < listData.size(); i++) {
			if (listData.get(i) != null) {
				System.out.println(listData.get(i).toString());
			}
		}
	}

	private void addFirst(double x0) {
		listData.add(new Congruency(x0, calculateRi(x0)));
	}

	private double calculateRi(double xi) {
		return (xi/(m-1));
	}
	
	public double getA() {
		return 1+(2*k);
	}

	public double getM() {
		return Math.pow(2, g);
	}
	
	public ArrayList<Congruency> getListData() {
		return listData;
	}

	public void setListData(ArrayList<Congruency> listData) {
		this.listData = listData;
	}
	
	
}
