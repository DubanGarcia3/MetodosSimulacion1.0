package proof;

import java.util.ArrayList;

import uptc.com.sim.entities.Variance;

public class VarianceTest {
	
	private double accept; 
	private double alpha;
	private double n;
	private double promedio;
	private double aHalf;
	private double oneAHalf;
	private double halfVariance;
	private double variance;
	private double chiAHalf;
	private double chiOneAHalf;
	private double linf;
	private double lsup;
	private ArrayList<Variance> listVariance;
	
	public VarianceTest() {
		this.accept = 0.95;
		this.alpha = 1-accept;
		this.n = this.getN();
		this.promedio = this.getPromedio();
		this.aHalf = this.getaHalf();
		this.oneAHalf = this.getOneAHalf();
		this.halfVariance = halfVariance;
		this.variance = variance;
		this.chiAHalf = chiAHalf;
		this.chiOneAHalf = chiOneAHalf;
		this.linf = linf;
		this.lsup = lsup;
		this.listVariance = new ArrayList<Variance>();
	}

	public double getAccept() {
		return accept;
	}

	public void setAccept(double accept) {
		this.accept = accept;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public double getN() {
		return listVariance.size();
	}

	public void setN(double n) {
		this.n = n;
	}

	public double getPromedio() {
		double  aux=0;
		for (Variance variance : listVariance) {
			aux+= variance.getNormalized();
		}
		return aux/listVariance.size();
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public double getaHalf() {
		return this.getAlpha()/2;
	}

	public void setaHalf(double aHalf) {
		this.aHalf = aHalf;
	}

	public double getOneAHalf() {
		return 1- this.getaHalf();
	}

	public void setOneAHalf(double oneAHalf) {
		this.oneAHalf = oneAHalf;
	}

	public double getHalfVariance() {
		return this.getVariance()/2;
	}

	public void setHalfVariance(double halfVariance) {
		this.halfVariance = halfVariance;
	}

	public double getVariance() {
		return variance;
	}

	public void setVariance(double variance) {
		this.variance = variance;
	}

	public double getChiAHalf() {
		return chiAHalf;
	}

	public void setChiAHalf(double chiAHalf) {
		this.chiAHalf = chiAHalf;
	}

	public double getChiOneAHalf() {
		return chiOneAHalf;
	}

	public void setChiOneAHalf(double chiOneAHalf) {
		this.chiOneAHalf = chiOneAHalf;
	}

	public double getLinf() {
		return linf;
	}

	public void setLinf(double linf) {
		this.linf = linf;
	}

	public double getLsup() {
		return lsup;
	}

	public void setLsup(double lsup) {
		this.lsup = lsup;
	}

	public ArrayList<Variance> getListVariance() {
		return listVariance;
	}

	public void setListVariance(ArrayList<Variance> listVariance) {
		this.listVariance = listVariance;
	}
}
