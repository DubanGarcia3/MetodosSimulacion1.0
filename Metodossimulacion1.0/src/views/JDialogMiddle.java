package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import uptc.com.sim.entities.Register;

public class JDialogMiddle extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanelMiddleTop jPanelMiddleTop;
	private DefaultTableModel model;
	private static final String[] COLUMS = {"No","Xi","Potencia","Extension", "Extraccion","Ri"}; 
	private JTable table;
	private JScrollPane jsp;
	
	
	public JDialogMiddle(Controller controller) {
		getContentPane().setBackground(Color.decode("#A2DD2E"));
		setIconImage(new ImageIcon(getClass().getResource(ConstansUI.PATH_IMAGE_PERFIL)).getImage());
		setSize(ConstansUI.SIZE_WINDOW_X, ConstansUI.SIZE_WINDOW_SEED_Y);
		setTitle(ConstansUI.MESSAGE_TITTLE_DIALOG_MIDDLE);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		init(controller);
	}
	
	private void init(Controller controller) {
		jPanelMiddleTop = new JPanelMiddleTop(controller);
		add(jPanelMiddleTop, BorderLayout.NORTH);
		
		Font fontHeader = new Font("Franklin Ghotic Demi" , Font.ITALIC ,20);
		Font font = new Font("Arial" , Font.PLAIN ,17);
		table = new JTable(){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){  
				return false;  
			}
		};;
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setBackground(Color.decode("#282E33"));
		table.getTableHeader().setForeground(Color.white);
		table.getTableHeader().setFont(fontHeader);
		table.setFont(font);
		table.setBackground(Color.white);
		table.setBorder(null);

		model = new DefaultTableModel();
		this.model.setColumnIdentifiers(COLUMS);
		table.setModel(model);
		
		jsp = new JScrollPane(table);
		jsp.setForeground(Color.white);
		jsp.setBorder(null);
		jsp.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(jsp, BorderLayout.CENTER);
	}
	
	public void addRow(Register register){
		model.addRow(register.getData());
	}
	
	public void test(int i) {
		Object [] fila = new Object[1];
		fila[0] = i;
		model.addRow ( fila ); 
	}
	
	public int getSeed() {
		return jPanelMiddleTop.getSeed();
	}
	
	public Boolean statusSeed() {
		return jPanelMiddleTop.statusSeed();
	}
	
	public void messagge(Boolean value) {
		jPanelMiddleTop.messagge(value);
	}
	
	public void clearTable(){
        try {
           model=(DefaultTableModel) table.getModel();
            int filas=table.getRowCount();
            for (int i = 0;filas>i; i++) {
            	model.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
}
