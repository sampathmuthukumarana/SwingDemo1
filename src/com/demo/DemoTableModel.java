package com.demo;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.table.AbstractTableModel;

/**
 * This DemoTableModel class extends AbstractTableModel class and it has four overrided methods.
 * This class has string array variable called columnNames which holds column names 
 * of the table and ArrayList variable called patientData holds data for table rows. 
 * 
 */
public class DemoTableModel extends AbstractTableModel {
	int modelIindex;
	int sortCol = 0;
	boolean isSortAsc = true;
	PatientInternalFrame objPatientInternalFrame;

	/**
	 * This is the constructor method and it calls for addPatientData method of this
	 * class.
	 */
	public DemoTableModel(PatientInternalFrame p_objPatientInternalFrame) {
		super();
		objPatientInternalFrame = p_objPatientInternalFrame;

		addPatientData();

	}

	public DemoTableModel(int p_modelIindex) {
		this.modelIindex = p_modelIindex;
		// addPatientData();

	}

	private static final long serialVersionUID = 1L;

	private String[] columnNames = { "Id", "Name", "Date of birth", "Address 1", "Address2", "Address 3", "Gender",
			"Phone no", "Phone no type" };

	ArrayList<Patient> patientData = new ArrayList<>();

	/**
	 * This is an overrided method of AbstractTableModel class and it returns the
	 * number of columns of the table.
	 * 
	 * @return return type of int.
	 */
	@Override
	public int getColumnCount() {

		return columnNames.length;
	}

	/**
	 * This is an overrided method of AbstractTableModel class and it returns the
	 * number of rows of the table.
	 * 
	 * @return return type of int.
	 */
	@Override
	public int getRowCount() {
		return patientData.size();
	}

	/**
	 * This is an overrided method of AbstractTableModel class and it returns a
	 * column name of the table.
	 * 
	 * @param column name A variable of type int.
	 * 
	 * @return return type of String .
	 */
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	/**
	 * This addPatientData method gets all patient data from the database using
	 * objPatientdata object of PatientDataProvider class.It calls for
	 * getPatientData method of PatientDataProvider class.
	 */
	public void addPatientData() {

		PatientDataProvider objPatientdata = new PatientDataProvider();
		patientData = objPatientdata.getPatientData();
	}
	/**
	 * This method is used to sort patient data by name of the phone type.
	 */
	public void sortByPhoneType(){
		Collections.sort(patientData, new Patient(isSortAsc));
	}

	

	/**
	 * This is an overrided method of AbstractTableModel class and it returns
	 * patients data for each row.
	 * 
	 * @param variable row of type int and variable col of type int.
	 * 
	 * @return return type of Patient object .
	 */
	@Override
	public Object getValueAt(int row, int col) {
		if (col == 0) {
			return patientData.get(row).getId();
		} else if (col == 1) {
			return patientData.get(row).getPatientName();
		} else if (col == 2) {
			return patientData.get(row).getDateOfBirth();
		} else if (col == 3) {
			return patientData.get(row).getAddress1();
		} else if (col == 4) {
			return patientData.get(row).getAddress2();
		} else if (col == 5) {
			return patientData.get(row).getAddress3();
		} else if (col == 6) {
			return patientData.get(row).getGender();
		} else if (col == 7) {
			return patientData.get(row).getPhoneNo();
		} else {

			return patientData.get(row).getPhoneNoType();
		}

	}

}
