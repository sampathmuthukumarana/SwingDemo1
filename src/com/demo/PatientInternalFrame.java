package com.demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 * This class extends JInternalFrame and responsible for creating JInternalFrame
 * to add new patient's data .
 */
public class PatientInternalFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	JMenu menu1, menu2, menu3;
	JTextField tfPatientName, tfDob, tfAddress1, tfAddress2, tfAddress3, tfPhoneNo, tfHiddenId, tfSearch;
	JLabel lblPatientName, lblDob, lblAddress1, lblAddress2, lblAddress3, lblGender, lblPhoneNo, lblSearch;
	JButton btnCancel, btnSave, btnSearch, btnClear;
	JRadioButton jRadioButtonMale, jRadioButtonFemale;
	ButtonGroup btnGroup;
	JTable patient_details_table;
	JScrollPane scrollPane;
	JComboBox<PhoneNoType> phoneNoType;
	private String tfPatientName_val, tfDob_val, tfAddress1_val, tfAddress2_val, tfAddress3_val, gender_val = "", tfPhoneNo_val,
			tfSearch_val;
	PhoneNoType selectedPhoneType_val;
	int tfHiddenId_val;
	RowSorter<TableModel> fSorter;
	// String phoneNoTypeVal[] = { "Home", "Mobile", "Office" };

	/**
	 * This method is used to create a new JIntrnal frame and text fields and radio
	 * buttons are added to that JInternal frame called if1
	 * 
	 * @return JInternalFrame This returns JInternalframe.
	 */
	public JInternalFrame createPatientDataInternalFrame() {
		JInternalFrame if1 = new JInternalFrame("Frame 1", true, true, true, true);
		JPanel panel = new JPanel();

		tfPatientName = new JTextField(20);
		tfDob = new JTextField(20);
		tfAddress1 = new JTextField(20);
		tfAddress2 = new JTextField(20);
		tfAddress3 = new JTextField(20);
		jRadioButtonMale = new JRadioButton("Male");
		jRadioButtonFemale = new JRadioButton("Female");
		tfPhoneNo = new JTextField(20);
		tfHiddenId = new JTextField(5);
		tfSearch = new JTextField(13);

		phoneNoType = new JComboBox<PhoneNoType>();
		PhoneNoType typeHome = new PhoneNoType(1, "Home");
		PhoneNoType typeMobile = new PhoneNoType(2, "Mobile");
		PhoneNoType typeOffice = new PhoneNoType(3, "Office");
		phoneNoType.addItem(typeHome);
		phoneNoType.addItem(typeMobile);
		phoneNoType.addItem(typeOffice);

		btnCancel = new JButton("Cancel");
		btnSave = new JButton("Save");
		btnSearch = new JButton("Search");
		btnClear = new JButton("Clear");

		lblPatientName = new JLabel("Patient Name");
		lblDob = new JLabel("DOB");
		lblAddress1 = new JLabel("Address 1");
		lblAddress2 = new JLabel("Address 2");
		lblAddress3 = new JLabel("Address 3");
		lblGender = new JLabel("Gender");
		lblPhoneNo = new JLabel("Phone No:");
		lblSearch = new JLabel("Search");

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		panel.setLayout(gbl);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(20, 0, 0, 0);
		panel.add(lblPatientName, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipady = 20;
		gbc.insets = new Insets(20, 10, 0, 40);
		panel.add(tfPatientName, gbc);

		gbc.gridy = 0;
		gbc.gridx = 2;
		gbc.insets = new Insets(20, 0, 0, 0);
		panel.add(lblAddress1, gbc);

		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.ipady = 20;
		gbc.insets = new Insets(20, 10, 0, 40);
		panel.add(tfAddress1, gbc);

		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.insets = new Insets(20, 0, 0, 0);
		panel.add(lblDob, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.ipady = 20;
		gbc.insets = new Insets(20, 10, 0, 40);
		panel.add(tfDob, gbc);

		gbc.gridy = 1;
		gbc.gridx = 2;
		// gbc.insets = new Insets(0, 100, 1, 1);
		gbc.insets = new Insets(20, 0, 0, 0);
		panel.add(lblAddress2, gbc);

		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.ipady = 20;
		// gbc.insets = new Insets(1, 1, 1, 40);
		gbc.insets = new Insets(20, 10, 0, 40);
		panel.add(tfAddress2, gbc);

		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.ipady = 20;
		gbc.insets = new Insets(20, 0, 0, 0);
		panel.add(tfHiddenId, gbc);
		tfHiddenId.setVisible(false);

		gbc.gridy = 2;
		gbc.gridx = 2;
		gbc.insets = new Insets(20, 0, 0, 0);
		panel.add(lblAddress3, gbc);

		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.ipady = 20;
		gbc.insets = new Insets(20, 10, 0, 40);
		panel.add(tfAddress3, gbc);

		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.insets = new Insets(20, 0, 0, 0);
		panel.add(lblGender, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		// gbc.insets = new Insets(1, 1, 1, 40);
		gbc.insets = new Insets(20, 10, 0, 40);
		panel.add(jRadioButtonMale, gbc);

		gbc.gridx = 2;
		gbc.gridy = 3;
		// gbc.insets = new Insets(1, 1, 1, 40);
		gbc.insets = new Insets(20, 10, 0, 40);
		panel.add(jRadioButtonFemale, gbc);

		btnGroup = new ButtonGroup();
		btnGroup.add(jRadioButtonMale);
		btnGroup.add(jRadioButtonFemale);
		jRadioButtonMale.setActionCommand("Male");
		jRadioButtonFemale.setActionCommand("Female");

		gbc.gridy = 4;
		gbc.gridx = 0;
		gbc.insets = new Insets(20, 0, 0, 0);
		panel.add(lblPhoneNo, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.ipady = 20;
		gbc.insets = new Insets(20, 10, 0, 40);
		panel.add(tfPhoneNo, gbc);

		gbc.gridx = 2;
		gbc.gridy = 4;
		// gbc.insets = new Insets(1, 1, 1, 40);
		gbc.insets = new Insets(20, 10, 0, 40);
		panel.add(phoneNoType, gbc);

		gbc.gridx = 2;
		gbc.gridy = 7;
		// gbc.insets = new Insets(1, 1, 1, 40);
		gbc.insets = new Insets(20, 0, 0, 0);
		panel.add(btnCancel, gbc);

		gbc.gridx = 3;
		gbc.gridy = 7;
		// gbc.insets = new Insets(1, 1, 1, 40);
		gbc.insets = new Insets(20, 10, 0, 150);
		panel.add(btnSave, gbc);

		// Table creation
		JPanel tablePanel = new JPanel();
		// tablePanel.setBackground(Color.red);;
		GridBagLayout gblTable = new GridBagLayout();
		tablePanel.setLayout(gblTable);

		patient_details_table = new JTable(new DemoTableModel(this));

		// Table sorting
		// patient_details_table.setAutoCreateRowSorter(true);

		// fSorter = new TableRowSorter<>(patient_details_table.getModel());
		// patient_details_table.setRowSorter(fSorter);
		patient_details_table.getTableHeader().addMouseListener(new ColumnListener(patient_details_table));

		// Changing the width of table Columns
		// patient_details_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumnModel columnModel = patient_details_table.getColumnModel();
		columnModel.getColumn(1).setPreferredWidth(200);
		columnModel.getColumn(2).setPreferredWidth(200);
		columnModel.getColumn(3).setPreferredWidth(200);
		columnModel.getColumn(4).setPreferredWidth(200);
		columnModel.getColumn(5).setPreferredWidth(200);
		columnModel.getColumn(6).setPreferredWidth(200);
		columnModel.getColumn(7).setPreferredWidth(200);
		columnModel.getColumn(8).setPreferredWidth(200);

		// Changing the height of table rows.
		patient_details_table.setRowHeight(30);

		// Changing the height of table column headers.
		patient_details_table.getTableHeader().setPreferredSize(new Dimension(60, 60));

		// patient_details_table.setPreferredScrollableViewportSize(new Dimension(500,
		// 150));

		// Create the scroll pane and add the table to it.
		scrollPane = new JScrollPane(patient_details_table);
		scrollPane.setPreferredSize(new Dimension(480, 360));

//		JPanel searchPanel = new JPanel();
//		//tablePanel.setBackground(Color.red);;
//		GridBagLayout gblSearch = new GridBagLayout();
//		searchPanel.setLayout(gblSearch);

		GridBagConstraints gbclblSearch = new GridBagConstraints();
		// gbclblSearch.fill = GridBagConstraints.HORIZONTAL;
		gbclblSearch.gridx = 0;
		gbclblSearch.gridy = 0;
		// gbclblSearch.gridwidth = 2;
		gbclblSearch.insets = new Insets(0, 0, 0, 10);
		tablePanel.add(lblSearch, gbclblSearch);

		GridBagConstraints gbctfSearch = new GridBagConstraints();
		//gbctfSearch.fill = GridBagConstraints.HORIZONTAL;
		gbctfSearch.gridx = 1;
		//gbctfSearch.gridwidth = 2;
		gbctfSearch.gridy = 0;
		gbctfSearch.ipadx = 100;
		gbctfSearch.ipady = 15;
		//gbctfSearch.insets = new Insets(0, 0, 0, 40);
		// gbctfSearch.insets = new Insets(0,0,0,0);
		tablePanel.add(tfSearch, gbctfSearch);

		GridBagConstraints gbcbtnSearch = new GridBagConstraints();
		// gbcbtnSearch.fill = GridBagConstraints.HORIZONTAL;
		gbcbtnSearch.gridx = 2;
		gbcbtnSearch.gridy = 0;
		// gbc.insets = new Insets(1, 1, 1, 40);
		//gbcbtnSearch.insets = new Insets(0, 0, 0, 40);
		tablePanel.add(btnSearch, gbcbtnSearch);

		GridBagConstraints gbcbtnClear = new GridBagConstraints();
		//gbcbtnClear.fill = GridBagConstraints.HORIZONTAL;
		gbcbtnClear.gridx = 3;
		gbcbtnClear.gridy = 0;
		// gbc.insets = new Insets(1, 1, 1, 40);
		//gbcbtnClear.insets = new Insets(0, 0, 0, 80);
		tablePanel.add(btnClear, gbcbtnClear);

		GridBagConstraints gbcTable = new GridBagConstraints();
		//gbcTable.fill = GridBagConstraints.HORIZONTAL;
		gbcTable.ipadx = 250;// increase the full width of the table
		gbcTable.gridx = 1;
		gbcTable.gridy = 1;
		gbcTable.gridwidth = 4;
		gbcTable.gridheight = 3;
		// gbcTable.ipady = 2;
		gbcTable.insets = new Insets(10, 4, 0, 0);
		tablePanel.add(scrollPane, gbcTable);

		if1.add(panel, BorderLayout.NORTH);
		if1.add(tablePanel, BorderLayout.CENTER);
		// if1.pack();
		if1.setVisible(true);
		// frame.add(if1);

		// Save button click event
		BtnSaveActionListener objBtnSaveListener = new BtnSaveActionListener(this);
		btnSave.addActionListener(objBtnSaveListener);

		// Patient details Table row click event
		TableRowSelectionListener objRowSelectionListener = new TableRowSelectionListener(this);
		patient_details_table.getSelectionModel().addListSelectionListener(objRowSelectionListener);

		// Search button click event
		BtnSearchActionListener objBtnSearchListener = new BtnSearchActionListener(this);
		btnSearch.addActionListener(objBtnSearchListener);

		// Clear button click event
		BtnClearActionListener objBtnClearListener = new BtnClearActionListener(this);
		btnClear.addActionListener(objBtnClearListener);

		return if1;

	}

	/*
	 * if (jRadioButtonMale.isSelected()) { gender_val = "Male"; } else if
	 * (jRadioButtonFemale.isSelected()) { gender_val = "Female"; }
	 */

	/**
	 * This getNewPatientData method is used to get data from the input fields
	 * 
	 * @return Patient object This returns Patient object.
	 */
	public Patient getNewPatientData() {
		tfPatientName_val = tfPatientName.getText();
		tfDob_val = tfDob.getText();
		tfAddress1_val = tfAddress1.getText();
		tfAddress2_val = tfAddress2.getText();
		tfAddress3_val = tfAddress3.getText();
		// tfHiddenId_val = Integer.parseInt(tfHiddenId.getText()) ;
		String tfHiddenId_val_string = tfHiddenId.getText();
		if (tfHiddenId_val_string.isEmpty() || tfHiddenId_val_string == null) {
			tfHiddenId_val = 0;
		} else {
			tfHiddenId_val = Integer.parseInt(tfHiddenId_val_string);
		}

		ButtonModel bModel = btnGroup.getSelection();
		gender_val = "Not selected";
		if (bModel != null) {
			gender_val = bModel.getActionCommand();
		}

		tfPhoneNo_val = tfPhoneNo.getText();
		selectedPhoneType_val = (PhoneNoType) (phoneNoType.getSelectedItem());

		Patient objNewPatient = new Patient();
		objNewPatient.setPatientName(tfPatientName_val);
		objNewPatient.setDateOfBirth(tfDob_val);
		objNewPatient.setAddress1(tfAddress1_val);
		objNewPatient.setAddress2(tfAddress2_val);
		objNewPatient.setAddress3(tfAddress3_val);
		objNewPatient.setGender(gender_val);
		objNewPatient.setPhoneNo(tfPhoneNo_val);
		objNewPatient.setPhoneNoType(selectedPhoneType_val);
		objNewPatient.setHiddenId(tfHiddenId_val);

		return objNewPatient;

	}

	public Patient getSearchBoxValue() {
		tfSearch_val = tfSearch.getText();
		Patient objPatient = new Patient();
		objPatient.setPatientName(tfSearch_val);
		return objPatient;

	}

}
