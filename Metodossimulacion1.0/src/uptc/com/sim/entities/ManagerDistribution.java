package uptc.com.sim.entities;

import java.security.SecureRandom;

public class ManagerDistribution {
	
	private Distribution distribution;
	
	public ManagerDistribution() {
		
	}
	
	public Distribution getDistribution() {
		return distribution;
	}

	public Distribution create(double xi, double ni) {
		return distribution = new Distribution(xi, ni);
	}
	
	public double createRi() {
		SecureRandom rnd = new SecureRandom();
		return 	rnd.nextDouble();
	}
	
	public double calculateNi(double random, double min, double max) {
		double ni = min+((max-min)*random);
		return ni;
	}
}	
