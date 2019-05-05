package uptc.com.sim.entities;

public class Distribution {
	
	private static int no = 0;
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
}