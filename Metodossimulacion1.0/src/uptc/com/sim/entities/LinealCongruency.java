package uptc.com.sim.entities;

import java.util.ArrayList;

public class LinealCongruency {
	
	private double xo, k, c, g, a, m;
	
	private ArrayList<Double> ri;
	private ArrayList<Double> xi;
	
	public LinealCongruency(double xo, double k, double c, double g) {
		xi = new ArrayList<Double>();
		ri = new ArrayList<Double>();
		this.xo = xo;
		this.k = k;
		this.c = c;
		this.g = g;
		this.a = this.getA();
		this.m = this.getM();
	}
//	
//	public LinealCongruency() {
//	}

	public ArrayList<Double> builtXiList(double seed){
		double total = 0;
		xi.add(seed);
		for (int i = 0; i < 50; i++) {
			if (xi.get(i) != null) {
				total = ((a*(xi.get(i)))+c)% m;
				xi.add(total);
			}
		}
		return xi;
	}
	
	public ArrayList<Double> builtRiList(){
		for (int i = 0; i < xi.size(); i++) {
			ri.add(xi.get(i)/(m-1));
		}
		return ri;
	}
	
	public void print() {
		for (int i = 0; i < ri.size(); i++) {
			if (ri.get(i)!= null) {
				System.out.println(i + "	" + ri.get(i).toString());
			}
		}
	}

	public ArrayList<Double> getRi() {
		return ri;
	}

	public void setRi(ArrayList<Double> ri) {
		this.ri = ri;
	}

	public ArrayList<Double> getXi() {
		return xi;
	}

	public void setXi(ArrayList<Double> xi) {
		this.xi = xi;
	}
	
	public double getA() {
		return 1+(2*k);
	}

	public double getM() {
		return Math.pow(2, g);
	}

	public double getXo() {
		return xo;
	}

	public void setXo(double xo) {
		this.xo = xo;
	}

	public double getK() {
		return k;
	}

	public void setK(double k) {
		this.k = k;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public void setA(double a) {
		this.a = a;
	}

	public void setM(double m) {
		this.m = m;
	}
	
}
