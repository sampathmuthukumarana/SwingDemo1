package com.demo;

/*
 * This MainApplication class has main method.
 */
public class MainApplication {
	/**
	 * This is the main method which calls for createMainFrame method of DemoMenuBar
	 * class using an object of that class.
	 * 
	 * @param args Unused.
	 */
	public static void main(String[] args) {

		DemoMenuBar mmb = new DemoMenuBar();
		mmb.createMainFrame();

	}

}
