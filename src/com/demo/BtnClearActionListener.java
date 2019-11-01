package com.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The BtnClearActionListener class implements ActionListener interface. This
 * class holds an class variable of PatientInternalFrame class.
 * 
 * @author Sampath
 *
 */
public class BtnClearActionListener implements ActionListener {
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
	public BtnClearActionListener(PatientInternalFrame p_patientInternalFrame) {
		objPatientInternalFrame = p_patientInternalFrame;
	}

	/**
	 * This is an overrided method from ActionListener interface and used to clear
	 * patient details JTable.
	 * 
	 * It updates the Jtable so that display all patients' data.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		DemoTableModel newTableModel = (DemoTableModel) objPatientInternalFrame.patient_details_table.getModel();
		newTableModel.addPatientData();
		newTableModel.fireTableDataChanged();
		objPatientInternalFrame.patient_details_table.setModel(newTableModel);
		objPatientInternalFrame.tfSearch.setText("");
		objPatientInternalFrame.tfPatientName.setText("");
		objPatientInternalFrame.tfDob.setText("");
		objPatientInternalFrame.tfAddress1.setText("");
		objPatientInternalFrame.tfAddress2.setText("");
		objPatientInternalFrame.tfAddress3.setText("");
		objPatientInternalFrame.tfPhoneNo.setText("");
		objPatientInternalFrame.tfHiddenId.setText("");
		objPatientInternalFrame.btnGroup.clearSelection();


	}

}
