package uptc.com.sim.entities;

import java.security.SecureRandom;
import java.util.ArrayList;

public class ManagerDistribution {
	
	private Distribution distribution;
	private ArrayList<Double> ni;
	
	public ManagerDistribution() {
		ni = new ArrayList<Double>();
	}
	
	public ArrayList<Double> getNi() {
		return ni;
	}

	public void setNi(ArrayList<Double> ni) {
		this.ni = ni;
	}

	public void addNi(double value) {
		ni.add(value);
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
	
	public Double[] getMinAndMax(ArrayList<Double> niList) {
		Double[] list = new Double[2] ;
		double min, max;
		min = max = niList.get(0);
		for(int i = 0; i < niList.size(); i++)
		{
			if(min>niList.get(i))
			{
				min=niList.get(i);
			}
			if(max<niList.get(i))
			{
				max=niList.get(i);
			}
		}
		list[0] = min;
		list[1] = max;
		return list;
	}
}	
