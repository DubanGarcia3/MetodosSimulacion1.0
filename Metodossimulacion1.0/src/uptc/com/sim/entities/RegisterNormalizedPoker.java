package uptc.com.sim.entities;

public class RegisterNormalizedPoker {
	private static int no = 0;
	private String xi;
	private Type type; 
	
	public RegisterNormalizedPoker(String xi, Type type) {
		RegisterNormalizedPoker.no++;
		this.xi = xi;
		this.type = type;
	}

	public static int getNo() {
		return no;
	}

	public static void setNo(int no) {
		RegisterNormalizedPoker.no = no;
	}

	public String getXi() {
		return xi;
	}

	public void setXi(String xi) {
		this.xi = xi;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public Object[] getData() {
		return new Object[]{no, xi, type};
	}
}
