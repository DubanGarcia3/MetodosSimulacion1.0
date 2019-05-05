package uptc.com.sim.entities;

import java.security.SecureRandom;

public class Distribution {
	
	private static int no = 0;
	private double min;
	private double max;
	private double xi;
	private double ni; 
	
	public Distribution(double xi, double ni) {
		Distribution.no++;
		this.xi = xi;
		this.ni = ni;
	}

	public static int getNo() {
		return no;
	}

	public double getXi() {
		return xi;
	}

	public double getNi() {
		return ni;
	}

	public void setXi(double xi) {
		this.xi = xi;
	}

	public void setNi(double ni) {
		this.ni = ni;
	}
	
	public Object[] getData() {
		return new Object[]{no, xi, ni};
	}
	
	public double createRi() {
		SecureRandom rnd = new SecureRandom();
		return 	rnd.nextDouble();
	}
	
	public double calculateNi(double random) {
		double ni = min+((max-min)*random);
		return ni;
	}
}