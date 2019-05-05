package views;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


import controller.Controller;

public class JFramePrincipal  extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanelBoth jPanelBoth;
	private JPanelCenter jPanelCenter;
	private JPanelNorth jPanelNorth;
	private JPanelLeft jPanelLeft;
	private JPanelRight jPanelRight;
	
	public JFramePrincipal(Controller controller) {
		getContentPane().setBackground(ConstansUI.COLOR_FRAME);
		setIconImage(new ImageIcon(getClass().getResource(ConstansUI.PATH_IMAGE_PERFIL)).getImage());
		setResizable(false);
		setTitle(ConstansUI.MESSAGE_TITTLE_FRAME);
		setSize(ConstansUI.SIZE_WINDOW_X, ConstansUI.SIZE_WINDOW_Y);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init(controller);
	}
	
	private void init(Controller controller) {
		jPanelRight = new JPanelRight(controller);
		add(jPanelRight, BorderLayout.EAST);
		
		jPanelLeft = new JPanelLeft();
		add(jPanelLeft, BorderLayout.WEST);
		
		jPanelNorth = new JPanelNorth();
		add(jPanelNorth, BorderLayout.NORTH);
		
		jPanelCenter = new JPanelCenter(controller);
		add(jPanelCenter, BorderLayout.CENTER);
		
		jPanelBoth = new JPanelBoth();
		add(jPanelBoth, BorderLayout.SOUTH);
	}
}
