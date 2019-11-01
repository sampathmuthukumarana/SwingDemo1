package com.demo;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;;

/**
 * This DemoMenuListener class implements MenuListener interface. It has three
 * overrided methods. It listens for mouse clicks on Jmenu.
 * 
 * @author Sampath
 *
 */
public class DemoMenuListener implements MenuListener {

	JFrame frame = null;

	/**
	 * This is the constructor method and class variable frame get assigned to a
	 * JFrame object which is passed as a method parameter called p_frame.
	 * 
	 * @param p_frame This is the constructor method parameter of JFrame.
	 */
	public DemoMenuListener(JFrame p_frame) {
		frame = p_frame;

	}

	/*
	 * This is an overrided method of MenuListener interface it listens for
	 * menuCancelling events.
	 */
	@Override
	public void menuCanceled(MenuEvent e) {

	}

	/*
	 * This is an overrided method of MenuListener interface it listens for menu
	 * deselecting events.
	 * 
	 */
	@Override
	public void menuDeselected(MenuEvent e) {

	}

	/*
	 * This is an overrided method of MenuListener interface it listens for menu
	 * selecting events. It takes the selected menu and creates a JInternalFrame
	 * object and it is added to the main frame.
	 */
	@Override
	public void menuSelected(MenuEvent e) {
		// System.out.println("----"+e.getSource().getClass());
		if (((JMenu) e.getSource()).getText().equalsIgnoreCase("Menu1")) {
			PatientInternalFrame objPatientInternalFrame = new PatientInternalFrame();
			JInternalFrame if1 = objPatientInternalFrame.createPatientDataInternalFrame();
			frame.add(if1);

		} else if (((JMenu) e.getSource()).getText().equalsIgnoreCase("Menu2")) {
			
			LayOutInternalFrame objLayOutInternalFrame = new LayOutInternalFrame();
			JInternalFrame if2 = objLayOutInternalFrame.createLayOutInternalFrame();
			frame.add(if2);
//			JInternalFrame if2 = new JInternalFrame("frame 2", true, true, true, true);
//			if2.setVisible(true);
//			frame.add(if2);
		}

		else if (((JMenu) e.getSource()).getText().equalsIgnoreCase("Menu3")) {
			JInternalFrame if3 = new JInternalFrame("frame 3", true, true, true, true);
			// JLabel l2 = new JLabel("Menu2");
			// if2.add(l2);
			if3.setVisible(true);
			frame.add(if3);
		}

	}

}
