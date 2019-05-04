package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import uptc.com.sim.entities.Congruency;

public class JTableLinealCongruency extends JPanel{
	
	/**
	 * @author Duban
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable jTable;
	private DefaultTableModel dtm;
	private JScrollPane jsp;
	
	public JTableLinealCongruency(){
		initComponents();
	}
	
	public void initComponents(){		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Color.decode("#E0F8E6"));
		
		dtm = new DefaultTableModel();
		upDate();
		
		Font fontHeader = new Font("Franklin Ghotic Demi" , Font.ITALIC ,20);
		Font font = new Font("Arial" , Font.PLAIN ,17);
		jTable = new JTable(){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){  
				return false;  
			}
		};;
		jTable.setModel(dtm);
		jTable.getTableHeader().setReorderingAllowed(false);
		jTable.getTableHeader().setBackground(Color.decode("#282E33"));
		jTable.getTableHeader().setForeground(Color.white);
		jTable.getTableHeader().setFont(fontHeader);
		jTable.setFont(font);
		jTable.setBackground(Color.white);
		jTable.setBorder(null);
		
		jsp = new JScrollPane(jTable);
		jsp.setForeground(Color.white);
		jsp.setBorder(null);
		jsp.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(jsp, BorderLayout.PAGE_END);
		this.setBorder(null);
	}
	
	public void upDate(){
		String [] head = { "ID", "Xi", "Ri"};
		dtm.setColumnIdentifiers(head);
	}
	
	public void addCongruency(Congruency congruency) {
		String[] c = { "" + congruency.getId(), ""+ congruency.getXi(), "" + congruency.getRi()};
		dtm.addRow(c);
	}
	
	public void addListCongruency(ArrayList<Congruency> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null) {
				String[] c = { "" + list.get(i).getId(), ""+ list.get(i).getXi(), "" + list.get(i).getRi()};
				dtm.addRow(c);
			}
		}
	}
	
	public void clearTable(){
        try {
        	dtm =(DefaultTableModel) jTable.getModel();
            for (int i = 0;jTable.getRowCount()>i; i++) {
            	dtm.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla");
        }
    }

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

//	public JScrollPane getJsp() {
//		return jsp;
//	}
//
//	public void setJsp(JScrollPane jsp) {
//		this.jsp = jsp;
//	}

	public JTable getjTable() {
		return jTable;
	}

	public void setjTable(JTable jTable) {
		this.jTable = jTable;
	}
	
	
//
//	public void refresh() {
//		propertiesTitle = controllerGUI.getPropertiesTitle();
//		String [] head = {propertiesTitle.getProperty(Constans.CODE),
//				propertiesTitle.getProperty(Constans.NAME),
//				propertiesTitle.getProperty(Constans.LAST_NAME),
//				propertiesTitle.getProperty(Constans.GENRE),
//				propertiesTitle.getProperty(Constans.BIRTH_DATE),
//				propertiesTitle.getProperty(Constans.CITY)};
//		dtm.setColumnIdentifiers(head);
//	}
//	
//	
//	public void refreshAll(){
//	}

}
