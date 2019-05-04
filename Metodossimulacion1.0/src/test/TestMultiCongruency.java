package test;

import uptc.com.sim.entities.MultiCongruency;

public class TestMultiCongruency {
	
	public static void main(String[] args) {
		MultiCongruency congruency = new MultiCongruency(5, 2, 16);
		congruency.calculateLinealCong(3);
		congruency.print();
	}

}
