package com.demo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

/**
 * The ColumnListener class implements MouseAdapter. It listens for table row
 * header clicks.
 * 
 * @author Sampath
 *
 */
public class ColumnListener extends MouseAdapter {
	JTable patient_details_table;

	/**
	 * This is the constructor method.
	 * 
	 * @param p_patient_details_table This is the method parameter which is type of
	 *                                JTable Parameter p_patient_details_table get
	 *                                assigned to the class variable called
	 *                                patient_details_table in the constructor
	 *                                method.
	 */
	public ColumnListener(JTable p_patient_details_table) {
		patient_details_table = p_patient_details_table;
	}

	/**
	 * This is an overrided method from MouseAdapter and used to handle table header
	 * click events and calls for sortByPhoneType method which is in the
	 * DemoTableModel class.
	 * 
	 * 
	 */
	@Override
	public void mouseClicked(MouseEvent aEvent) {
		// TableColumnModel colModel = patient_details_table.getColumnModel();
		// int columnModelIndex = colModel.getColumnIndexAtX(aEvent.getX());
		// int modelIndex = colModel.getColumn(columnModelIndex).getModelIndex();
		// new DemoTableModel(modelIndex);
		((DemoTableModel) patient_details_table.getModel()).sortByPhoneType();
	}
}