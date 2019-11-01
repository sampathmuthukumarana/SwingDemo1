package com.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The BtnSaveActionListener class implements ActionListener interface. This
 * class holds an class variable of PatientInternalFrame class.
 * 
 * @author Sampath
 *
 */
public class BtnSaveActionListener implements ActionListener {

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

	public BtnSaveActionListener(PatientInternalFrame p_objPatientInternalFrame) {
		objPatientInternalFrame = p_objPatientInternalFrame;
	}

	/**
	 * This is an overrided method from ActionListener interface and used to save
	 * new patient's details. It gets new patient's data using class variable
	 * objPatientInternalFrame and calls to the database saving method of
	 * saveNewPatientData of PatientDataProvider class. It clears all input fields
	 * after saving data to the database.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		Patient newPatientObj = objPatientInternalFrame.getNewPatientData();
		PatientDataProvider objPatientDataProvider = new PatientDataProvider();
		// Calling to patient's data update method
		if (newPatientObj.getHiddenId() > 0) {
			boolean isUpdated = objPatientDataProvider.updateNewPatientData(newPatientObj);
			if (isUpdated) {
				objPatientInternalFrame.tfPatientName.setText("");
				objPatientInternalFrame.tfDob.setText("");
				objPatientInternalFrame.tfAddress1.setText("");
				objPatientInternalFrame.tfAddress2.setText("");
				objPatientInternalFrame.tfAddress3.setText("");
				objPatientInternalFrame.tfPhoneNo.setText("");
				objPatientInternalFrame.tfHiddenId.setText("");
				objPatientInternalFrame.btnGroup.clearSelection();

				// updating the Jtable

				DemoTableModel newTableModel = (DemoTableModel) objPatientInternalFrame.patient_details_table
						.getModel();
				newTableModel.addPatientData();
				newTableModel.fireTableDataChanged();
				objPatientInternalFrame.patient_details_table.setModel(newTableModel);
			}
		} // calling to new patient's data saving method
		else {
			boolean isSaved = objPatientDataProvider.saveNewPatientData(newPatientObj);

			// clearing input data fields
			if (isSaved) {
				objPatientInternalFrame.tfPatientName.setText("");
				objPatientInternalFrame.tfDob.setText("");
				objPatientInternalFrame.tfAddress1.setText("");
				objPatientInternalFrame.tfAddress2.setText("");
				objPatientInternalFrame.tfAddress3.setText("");
				objPatientInternalFrame.tfPhoneNo.setText("");
				objPatientInternalFrame.btnGroup.clearSelection();

				// updating the Jtable

				DemoTableModel newTableModel = (DemoTableModel) objPatientInternalFrame.patient_details_table
						.getModel();
				newTableModel.addPatientData();
				newTableModel.fireTableDataChanged();
				objPatientInternalFrame.patient_details_table.setModel(newTableModel);

			}
		}

	}

}
