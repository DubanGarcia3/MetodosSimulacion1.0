package uptc.com.sim.entities;

public class Variance {
	
	private int id;
	private double normalized;
	public static int ID_BASE=0;
	

	public Variance(int id, double normalized) {
		this.id = ID_BASE++;
		this.normalized = normalized;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public double getNormalized() {
		return normalized;
	}


	public void setNormalized(double normalized) {
		this.normalized = normalized;
	}


	@Override
	public String toString() {
		return "Variance [id=" + id + ", normalized=" + normalized + "]";
	}
}
