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
		int count0 = 0;
		for (int i = 0; i < registerPokerList.size(); i++) {
			for (int j = 0; j < 9; j++) {
				String value = String.valueOf(i);
				for (int k = 0; k < registerPokerList.get(i).length(); k++) {
					if(value.equals(0)) {
					if(value.equals(registerPokerList.get(i).charAt(k))) {
						count0++;
						System.out.println(count0);
					}
				}
				}
				
			}
		}
		return Type.P;
	}
}
