package com.demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LayOutInternalFrame extends JInternalFrame {
	JLabel lbl1, lbl2;
	JTextField tf1;
	String country[] = { "India", "Aus", "U.S.A", "England", "Newzealand" };
	JComboBox<Object> combo1;
	JCheckBox checkBox1, checkBox2, checkBox3;
	JTable jt1,jt2;
	JTextArea txtArea1, txtArea2, txtArea3;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JInternalFrame createLayOutInternalFrame() {
		JInternalFrame if2 = new JInternalFrame("Frame 2", true, true, true, true);
		JPanel LayOutDemoPanel = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		LayOutDemoPanel.setLayout(gbl);
		GridBagConstraints gbcMain = new GridBagConstraints();
		gbcMain.fill = GridBagConstraints.HORIZONTAL;

		// Label1
		lbl1 = new JLabel("Label1");
		 //GridBagConstraints gbclbl1 = new GridBagConstraints();
		gbcMain.gridx = 0;
		gbcMain.gridy = 0;
		gbcMain.weightx = 0.01;
		gbcMain.insets = new Insets(3, 3, 3, 3);
		LayOutDemoPanel.add(lbl1, gbcMain);

		// TextField1
		tf1 = new JTextField(15);
		GridBagConstraints gbctf1 = new GridBagConstraints();
		gbctf1.fill = GridBagConstraints.HORIZONTAL;
		gbctf1.gridx = 1;
		gbctf1.gridy = 0;
		gbctf1.weightx = 0.5;
		gbctf1.insets = new Insets(3, 3, 3, 3);
		LayOutDemoPanel.add(tf1, gbctf1);

		// Label2
		lbl2 = new JLabel("Label2");
		GridBagConstraints gbclbl2 = new GridBagConstraints();
		gbclbl2.fill = GridBagConstraints.HORIZONTAL;
		gbclbl2.gridx = 2;
		gbclbl2.gridy = 0;
		gbclbl2.weightx = 0.1;
		gbclbl2.insets = new Insets(3, 43, 3, 3);
		LayOutDemoPanel.add(lbl2, gbclbl2);

		// Combo box1
		combo1 = new JComboBox<Object>(country);
		GridBagConstraints gbcCombo1 = new GridBagConstraints();
		gbcCombo1.fill = GridBagConstraints.HORIZONTAL;
		gbcCombo1.gridx = 3;
		gbcCombo1.gridy = 0;
		gbcCombo1.weightx = 0.6;
		gbcCombo1.insets = new Insets(3, 3, 3, 3);
		LayOutDemoPanel.add(combo1, gbcCombo1);

		// Check box1
		JCheckBox checkBox1 = new JCheckBox("1");
		GridBagConstraints gbcCheckBox1 = new GridBagConstraints();
		gbcCheckBox1.fill = GridBagConstraints.HORIZONTAL;
		gbcCheckBox1.gridx = 4;
		gbcCheckBox1.gridy = 0;
		gbcCheckBox1.insets = new Insets(3, 3, 3, 3);
		LayOutDemoPanel.add(checkBox1, gbcCheckBox1);

		// Check box2
		JCheckBox checkBox2 = new JCheckBox("2");
		//GridBagConstraints gbcCheckBox2 = new GridBagConstraints();
		gbcCheckBox1.fill = GridBagConstraints.HORIZONTAL;
		gbcCheckBox1.gridx = 5;
		gbcCheckBox1.gridy = 0;
		gbcCheckBox1.insets = new Insets(3, 3, 3, 3);
		LayOutDemoPanel.add(checkBox2, gbcCheckBox1);

		// Check box3
		JCheckBox checkBox3 = new JCheckBox("3");
		//GridBagConstraints gbcCheckBox3 = new GridBagConstraints();
		gbcCheckBox1.fill = GridBagConstraints.HORIZONTAL;
		gbcCheckBox1.gridx = 6;
		gbcCheckBox1.gridy = 0;
		gbcCheckBox1.insets = new Insets(3, 3, 3, 3);
		LayOutDemoPanel.add(checkBox3, gbcCheckBox1);

		// Table 1
		String data[][] = { { "101", "Amit", "670000" }, { "102", "Jai", "780000" }, { "101", "Sachin", "700000" } };
		String column[] = { "ID", "NAME", "SALARY" };
		jt1 = new JTable(data, column);
		// jt1.setBounds(30,40,200,300);
		JScrollPane scrollPane1 = new JScrollPane(jt1);
		scrollPane1.setPreferredSize(new Dimension(200, 700));
		GridBagConstraints gbcJt1 = new GridBagConstraints();
		gbcJt1.fill = GridBagConstraints.HORIZONTAL;
		gbcJt1.gridx = 0;
		gbcJt1.gridy = 1;
		gbcJt1.gridwidth = 2;
		// gbcJt1.weightx = 0.4;
		gbcJt1.insets = new Insets(30, 3, 3, 3);
		LayOutDemoPanel.add(scrollPane1, gbcJt1);

		// Text Area 1
		txtArea1 = new JTextArea("Text Area 1");
		// txtArea1.setBounds(10,30, 200,200);
		GridBagConstraints gbctxtArea1 = new GridBagConstraints();
	    gbctxtArea1.fill = GridBagConstraints.HORIZONTAL;
		gbctxtArea1.gridx = 2;
		gbctxtArea1.gridy = 1;
		gbctxtArea1.ipady = 200;
		gbctxtArea1.ipadx = 150;
		gbctxtArea1.gridwidth = 2;
		gbctxtArea1.weightx = 0;
		gbctxtArea1.insets = new Insets(-450, 3, 3, 3);
		LayOutDemoPanel.add(txtArea1, gbctxtArea1);

		// Text Area 2
		txtArea2 = new JTextArea("Text Area 2");
		// txtArea1.setBounds(10,30, 200,200);
		GridBagConstraints gbctxtArea2 = new GridBagConstraints();
		gbctxtArea2.fill = GridBagConstraints.HORIZONTAL;
		gbctxtArea2.gridx = 4;
		gbctxtArea2.gridy = 1;
		gbctxtArea2.ipady = 150;
		gbctxtArea2.ipadx = 200;
		gbctxtArea2.gridwidth = 5;
		//gbctxtArea2.weightx = 0.4;
		gbctxtArea2.insets = new Insets(-450, 3, 3, 80);
		LayOutDemoPanel.add(txtArea2, gbctxtArea2);
		
		// Text Area 3
		txtArea3 = new JTextArea("Text Area 3");
		// txtArea1.setBounds(10,30, 200,200);
		GridBagConstraints gbctxtArea3 = new GridBagConstraints();
		gbctxtArea3.fill = GridBagConstraints.HORIZONTAL;
		gbctxtArea3.gridx = 2;
		gbctxtArea3.gridy = 2;
		gbctxtArea3.ipady = 430;
		gbctxtArea3.ipadx = 200;
		gbctxtArea3.gridwidth = 4;
		//gbctxtArea3.weightx = 0.4;
		gbctxtArea3.insets = new Insets(-450, 3, 3, 80);
		LayOutDemoPanel.add(txtArea3, gbctxtArea3);
		
		// Table 2
		String data2[][] = { { "101", "Amit", "670000" }, { "102", "Jai", "780000" }, { "101", "Sachin", "700000" } };
		String column2[] = { "ID", "NAME", "SALARY" };
		jt2 = new JTable(data2, column2);
		// jt2.setBounds(30,40,200,300);
		JScrollPane scrollPane2 = new JScrollPane(jt2);
		scrollPane2.setPreferredSize(new Dimension(300, 400));
		GridBagConstraints gbcJt2 = new GridBagConstraints();
		//gbcJt2.fill = GridBagConstraints.HORIZONTAL;
		gbcJt2.gridx = 5;
		gbcJt2.gridy = 2;
		gbcJt2.gridwidth = 2;
		// gbcJt1.weightx = 0.4;
		gbcJt2.insets = new Insets(-460, 3, 3, 3);
		LayOutDemoPanel.add(scrollPane2, gbcJt2);

		if2.add(LayOutDemoPanel, BorderLayout.NORTH);
		if2.setVisible(true);
		return if2;
	}

}
