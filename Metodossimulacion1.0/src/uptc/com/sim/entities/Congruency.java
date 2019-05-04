package uptc.com.sim.entities;

import java.util.ArrayList;

public class Congruency {
	
	public static int ID_BASE=0;
	private double xi, ri;
	private int id;
	
	public Congruency(double xi, double ri) {
		this.id = ID_BASE++;
		this.xi = xi;
		this.ri = ri;
	}

	//ri.add(xi.get(i)/(m-1))
	
	
//	public Object[] getData() {
//		return new Object[]{id, xi, ri};
//	}

	public double getXi() {
		return xi;
	}

	public void setXi(double xi) {
		this.xi = xi;
	}

	public double getRi() {
		return ri;
	}

	public void setRi(double ri) {
		this.ri = ri;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "id=" + id + "	xi=" + xi + "	 ri=" + ri ;
	}
}
