package uptc.com.sim.entities;

import java.util.ArrayList;

public class ManagerRegisterPoker {
	
	private ArrayList<String> registerPokerList;
	
	public ManagerRegisterPoker() {
		registerPokerList = new ArrayList<String>();
	}
	
	public void addRegister(String register) {
		registerPokerList.add(register);
	}
	
	public Type valueType() {
		
		return Type.P;
	}
}
