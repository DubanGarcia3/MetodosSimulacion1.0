package uptc.com.sim.entities;

import java.util.ArrayList;

public class MultiCongruency {
	
	private double x0, t, d, a, m;
	private ArrayList<Congruency> listCongruencies;
	
	public MultiCongruency(double x0, double t, double d) {
		this.x0 = x0;
		this.t = t;
		this.d = d;
		this.a = this.getA();
		this.m = this.getM();
		this.listCongruencies = new ArrayList<Congruency>();
	}
	
	public void calculateLinealCong(double x0) {
		double auxXi=x0;
		double auxRi=(x0/(m-1));
		this.addFirst(x0);
		for (int i = 1 ; i < 50; i++) {
			auxXi = ((a*listCongruencies.get(i-1).getXi()) % m);
			auxRi = (listCongruencies.get(i-1).getXi()/(m-1));
			listCongruencies.add(new Congruency(auxXi,auxRi));
		}
	}
	
	public void print() {
		for (int i = 0; i < listCongruencies.size(); i++) {
			if (listCongruencies.get(i) != null) {
				System.out.println(listCongruencies.get(i).toString());
			}
		}
	}

	private void addFirst(double x0) {
		listCongruencies.add(new Congruency(x0, calculateRi(x0)));
	}

	private double calculateRi(double xi) {
		return (xi/(m-1));
	}

	public double getX0() {
		return x0;
	}

	public void setX0(double x0) {
		this.x0 = x0;
	}

	public double getT() {
		return t;
	}

	public void setT(double t) {
		this.t = t;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	public double getA() {
		return (8*t)+3;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getM() {
		return 2*d;
	}

	public void setM(double m) {
		this.m = m;
	}

	public ArrayList<Congruency> getListCongruencies() {
		return listCongruencies;
	}

	public void setListCongruencies(ArrayList<Congruency> listCongruencies) {
		this.listCongruencies = listCongruencies;
	}

}
