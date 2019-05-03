package test;

import uptc.com.sim.entities.LinealCongruency;
import views.JDialogLinealCongruency;

public class TestLinearCongruency {
	
	public static void main(String[] args) {
//		JDialogLinealCongruency dialogLinealCongruency = new JDialogLinealCongruency();
//		dialogLinealCongruency.setVisible(true);
		LinealCongruency congruency = new LinealCongruency(3, 2, 6, 3);
		congruency.calculateLinealCong(3);
		congruency.print();
	}
}
