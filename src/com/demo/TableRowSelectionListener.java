package com.demo;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 
 * This TableRowSelectionListener class implements ListSelectionListener and it
 * has an overrided method. This class is responsible for listening table row
 * clicks.
 * 
 * @author Sampath
 *
 */
public class TableRowSelectionListener implements ListSelectionListener {
	PatientInternalFrame obj_patientInternalFrame;
	PhoneNoType phoneType;

	/**
	 * This is the overloaded constructor method of this class.
	 * 
	 * @param p_patientInternalFrame This is the parameter type of
	 *                               PatientInternalFrame to this method. parameter
	 *                               p_patientInternalFrame get assigned to the
	 *                               class variable obj_patientInternalFrame in the
	 *                               constructor.
	 */
	public TableRowSelectionListener(PatientInternalFrame p_patientInternalFrame) {
		obj_patientInternalFrame = p_patientInternalFrame;
	}

	/*
	 * This is an overrided method of ListSelectionListener and it gets values from
	 * the selected row and fills the input fields accordingly so that it is
	 * editable.
	 */
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		if (obj_patientInternalFrame.patient_details_table.getSelectedRow() > -1) {

			String patient_id = obj_patientInternalFrame.patient_details_table
					.getValueAt(obj_patientInternalFrame.patient_details_table.getSelectedRow(), 0).toString();
			String patientNameVal = obj_patientInternalFrame.patient_details_table
					.getValueAt(obj_patientInternalFrame.patient_details_table.getSelectedRow(), 1).toString();
			String dobVal = obj_patientInternalFrame.patient_details_table
					.getValueAt(obj_patientInternalFrame.patient_details_table.getSelectedRow(), 2).toString();
			String address1Val = obj_patientInternalFrame.patient_details_table
					.getValueAt(obj_patientInternalFrame.patient_details_table.getSelectedRow(), 3).toString();
			String address2Val = obj_patientInternalFrame.patient_details_table
					.getValueAt(obj_patientInternalFrame.patient_details_table.getSelectedRow(), 4).toString();
			String address3Val = obj_patientInternalFrame.patient_details_table
					.getValueAt(obj_patientInternalFrame.patient_details_table.getSelectedRow(), 5).toString();
			String genderVal = obj_patientInternalFrame.patient_details_table
					.getValueAt(obj_patientInternalFrame.patient_details_table.getSelectedRow(), 6).toString();
			String phoneNoVal = obj_patientInternalFrame.patient_details_table
					.getValueAt(obj_patientInternalFrame.patient_details_table.getSelectedRow(), 7).toString();
			String phoneTypeVal = obj_patientInternalFrame.patient_details_table
					.getValueAt(obj_patientInternalFrame.patient_details_table.getSelectedRow(), 8).toString();

			obj_patientInternalFrame.tfPatientName.setText(patientNameVal);
			obj_patientInternalFrame.tfDob.setText(dobVal);
			obj_patientInternalFrame.tfAddress1.setText(address1Val);
			obj_patientInternalFrame.tfAddress2.setText(address2Val);
			obj_patientInternalFrame.tfAddress3.setText(address3Val);
			obj_patientInternalFrame.tfPhoneNo.setText(phoneNoVal);

			if (genderVal.equals("Male")) {
				obj_patientInternalFrame.jRadioButtonMale.setSelected(true);
			} else {
				obj_patientInternalFrame.jRadioButtonFemale.setSelected(true);
			}

			if (phoneTypeVal.equals("Home")) {
				// phoneType = new PhoneNoType(1,"Home");
				obj_patientInternalFrame.phoneNoType.setSelectedIndex(0);
			}
			if (phoneTypeVal.equals("Mobile")) {
				// phoneType = new PhoneNoType(2,"Mobile");
				obj_patientInternalFrame.phoneNoType.setSelectedIndex(1);
			}
			if (phoneTypeVal.equals("Office")) {
				// phoneType = new PhoneNoType(3,"Office");
				obj_patientInternalFrame.phoneNoType.setSelectedIndex(2);
			}

			obj_patientInternalFrame.tfHiddenId.setText(patient_id);
		}

	}

}
