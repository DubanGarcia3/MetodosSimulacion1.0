package proof;

import java.util.ArrayList;

import uptc.com.sim.entities.Stocking;

public class StockingTest {
	
	@SuppressWarnings("unused")
	private double media, desvest, acceptMargin, alpha, n, average, halfA, z,
	li, ls, min, max;
	
	private ArrayList<Stocking> listStocking;

	public StockingTest(double media, double desvest, double acceptMargin, double z) {
		this.listStocking = new ArrayList<Stocking>();
		this.media = media;
		this.desvest = desvest;
		this.acceptMargin = acceptMargin;
		this.alpha = 1-acceptMargin;
		this.n = getN();
		this.average = getAverage();
		this.halfA = getHalfA();
		this.z = z;
		this.li = this.getLi();
		this.ls = this.getLs();
		this.min = getMin();
		this.max = getMax();
	}
	
	public void add(double ni) {
		listStocking.add(new Stocking(ni, 0));
	}
	
	public void createTableNormalized() {
		for (Stocking stocking : listStocking) {
			stocking.setNormalized((stocking.getNi() - this.getMin())/(this.getMax()-this.getMin()));
		}
	}
	
	public boolean validateData() {
		return this.getAverage() > this.getLi() && this.getAverage() < this.getLs();
	}
	

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public double getDesvest() {
		return desvest;
	}

	public void setDesvest(double desvest) {
		this.desvest = desvest;
	}

	public double getAcceptMargin() {
		return acceptMargin;
	}

	public void setAcceptMargin(double acceptMargin) {
		this.acceptMargin = acceptMargin;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public double getN() {
		return listStocking.size();
	}

	public void setN(double n) {
		this.n = n;
	}

	public double getAverage() {
		double aux =0;
		for (Stocking stocking : listStocking) {
			aux += stocking.getNormalized();
		}
		return aux/listStocking.size();
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public double getHalfA() {
		return 1-(alpha/2);
	}

	public void setHalfA(double halfA) {
		this.halfA = halfA;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getLi() {
		return (1/2)-getZ()*(1/(Math.sqrt(12*getN())));
	}

	public void setLi(double li) {
		this.li = li;
	}

	public double getLs() {
		return (1/2)+getZ()*(1/(Math.sqrt(12*getN())));
	}

	public void setLs(double ls) {
		this.ls = ls;
	}

	public double getMin() {
		double min = this.getMax();
		for (int i = 0; i < listStocking.size(); i++) {
			if (listStocking.get(i).getNi() < min) {
				min = listStocking.get(i).getNi();
			}
		}
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		double max = 0;
		for (int i = 0; i < listStocking.size(); i++) {
			if (listStocking.get(i).getNi() > max) {
				max = listStocking.get(i).getNi();
			}
		}
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public ArrayList<Stocking> getListStocking() {
		return listStocking;
	}

	public void setListStocking(ArrayList<Stocking> listStocking) {
		this.listStocking = listStocking;
	}
}