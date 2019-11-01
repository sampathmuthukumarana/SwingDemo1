package com.demo;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * This class extends JFrame This is used to create main frame and add
 * components to the main frame.
 * 
 * @author Sampath
 *
 */
public class DemoMenuBar extends JFrame {

	private static final long serialVersionUID = 1L;
	// static GraphicsConfiguration gc;
	JMenu menu1, menu2, menu3;
	public JFrame frame;

	/**
	 * This is used to create a new frame object, JMenuBar object and JMenu objects.
	 * JMenu objects are added to the JMenuBar and JMenuBar is added to the main
	 * frame.
	 */
	public void createMainFrame() {

		frame = new JFrame();
		frame.setTitle("Java Swing Application");

		JMenuBar menubar = new JMenuBar();

		menu1 = new JMenu("Menu1");
		menubar.add(menu1);
		menu2 = new JMenu("Menu2");
		menubar.add(menu2);
		menu3 = new JMenu("Menu3");
		menubar.add(menu3);

		DemoMenuListener mms = new DemoMenuListener(frame);

		frame.setJMenuBar(menubar);
		menu1.addMenuListener(mms);
		menu2.addMenuListener(mms);
		menu3.addMenuListener(mms);
		frame.pack();
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.revalidate();
		frame.repaint();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
