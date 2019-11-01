package com.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The BtnSearchActionListener class implements ActionListener interface. This
 * class holds an class variable of PatientInternalFrame class.
 * 
 * @author Sampath
 *
 */
public class BtnSearchActionListener implements ActionListener {
	PatientInternalFrame objPatientInternalFrame;

	/**
	 * This is the constructor method.
	 * 
	 * @param p_objPatientInternalFrame This is the method parameter which is type
	 *                                  of object from PatientInternalFrame class.
	 *                                  Parameter p_objPatientInternalFrame get
	 *                                  assigned to the class variable called
	 *                                  objPatientInternalFrame in the constructor
	 *                                  method.
	 */
	public BtnSearchActionListener(PatientInternalFrame p_patientInternalFrame) {
		objPatientInternalFrame = p_patientInternalFrame;
	}

	/**
	 * This is an overrided method from ActionListener interface and used to search
	 * patients' details. It gets search box value using class variable
	 * objPatientInternalFrame and calls to the database searching method of
	 * searchPatientByName of PatientDataProvider class. It updates the Jtable
	 * according to the search result.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Patient patientObj = objPatientInternalFrame.getSearchBoxValue();
		PatientDataProvider objPatientDataProvider = new PatientDataProvider();

		// updating the Jtable
		DemoTableModel newTableModel = (DemoTableModel) objPatientInternalFrame.patient_details_table.getModel();
		newTableModel.patientData = objPatientDataProvider.searchPatientByName(patientObj);
	//	if (newTableModel.patientData.size() > 0) {
		newTableModel.fireTableDataChanged();
		objPatientInternalFrame.patient_details_table.setModel(newTableModel);
	//}
	}

}
