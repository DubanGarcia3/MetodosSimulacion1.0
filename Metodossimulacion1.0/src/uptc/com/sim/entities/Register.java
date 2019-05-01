package uptc.com.sim.entities;

public class Register {
	
	private static int no = 0;
	private int xi;
	private int potency; 
	private int extension;
	private int extraction;
	private int ri;
	
	public Register(int xi, int potency, int extension, int extraction, int ri) {
		Register.no++;
		this.xi = xi;
		this.potency = potency;
		this.extension = extension;
		this.extraction = extraction;
		this.ri = ri;
	}
	
	public int getNo() {
		return no;
	}

	public int getXi() {
		return xi;
	}

	public void setXi(int xi) {
		this.xi = xi;
	}

	public int getPotency() {
		return potency;
	}

	public void setPotency(int potency) {
		this.potency = potency;
	}

	public int getExtension() {
		return extension;
	}

	public void setExtension(int extension) {
		this.extension = extension;
	}

	public int getExtraction() {
		return extraction;
	}

	public void setExtraction(int extraction) {
		this.extraction = extraction;
	}

	public int getRi() {
		return ri;
	}

	public void setRi(int ri) {
		this.ri = ri;
	}
	
	public Object[] getData() {
		return new Object[]{no, xi, potency, extension, extraction, ri};
	}
}
