package uptc.com.sim.entities;

import java.util.ArrayList;

public class Stocking {
	
//	private double media, desvest, acceptMargin, alpha, n, average, halfA, z,
//	li, ls, min, max;
	
	private double ni;
	private double normalized;
	private int id;
	public static int ID_BASE =1;


	public Stocking(double ni, double normalized) {
		this.id = ID_BASE++;
		this.ni = ni;
		this.normalized = normalized;
	}

	public double getNi() {
		return ni;
	}

	public void setNi(double ni) {
		this.ni = ni;
	}

	public double getNormalized() {
		return normalized;
	}

	public void setNormalized(double normalized) {
		this.normalized = normalized;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
