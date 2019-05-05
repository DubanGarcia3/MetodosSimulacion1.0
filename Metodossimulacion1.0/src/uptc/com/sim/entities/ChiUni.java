package uptc.com.sim.entities;

public class ChiUni {
	
	private static int no = 0;
	private double initial;
	private double end; 
	private double frequencyObtained;
	private double expecetedFrequency;
	private double chi;
	
	
	public ChiUni(double initial, double end, double frequencyObtained, double expecetedFrequency, double chi) {
		ChiUni.no++;
		this.initial = initial;
		this.end = end;
		this.frequencyObtained = frequencyObtained;
		this.expecetedFrequency = expecetedFrequency;
		this.chi = chi;
	}
	
	public static int getNo() {
		return no;
	}

	public double getInitial() {
		return initial;
	}


	public double getEnd() {
		return end;
	}

	public double getFrequencyObtained() {
		return frequencyObtained;
	}

	public double getExpecetedFrequency() {
		return expecetedFrequency;
	}

	public double getChi() {
		return chi;
	}
	
	public Object[] getData() {
		return new Object[]{no, initial, end, frequencyObtained, expecetedFrequency, chi};
	}
}
