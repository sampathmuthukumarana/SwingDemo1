package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * This class is responsible for retrieving patients' data from the database and
 * saving new patients' data to the database.
 */
public class PatientDataProvider {
	Connection con;
	String err_msg = "";
	ResultSet rs;
	int ai_patient_id;
	PhoneNoType phoneType;
	String search_err_msg = "";

	/**
	 * This method is used to retrieve patients' data from the database.
	 * 
	 * @return ArrayList This returns ArrayList of patients.
	 */
	public ArrayList<Patient> getPatientData() {

		ArrayList<Patient> patientData = new ArrayList<Patient>();
		try {
			MySqlConnection sqlcon = new MySqlConnection();
			con = sqlcon.connectDb();
			// SQL SELECT query.
			// String query = "SELECT patientdetails.*,patientphoneno.* FROM patientdetails
			// INNER JOIN patientphoneno ON patientdetails.patientId =
			// patientphoneno.ref_patient_id";
			String query = "SELECT p.*,pp.* FROM patientdetails p INNER JOIN patientphoneno pp ON p.patientId = pp.ref_patient_id";
			// create the java statement
			Statement st = con.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset

			while (rs.next()) {
				Patient patient = new Patient();
				patient.setId(rs.getInt("patientId"));
				patient.setPatientName(rs.getString("patientName"));
				patient.setDateOfBirth(rs.getString("dob"));
				patient.setAddress1(rs.getString("address1"));
				patient.setAddress2(rs.getString("address2"));
				patient.setAddress3(rs.getString("address3"));
				patient.setGender(rs.getString("gender"));
				patient.setPhoneNo(rs.getString("phoneNo"));
				int phone_type = rs.getInt("type");

				if (phone_type == 0) {
					phoneType = new PhoneNoType(0, "");
				}
				if (phone_type == 1) {
					phoneType = new PhoneNoType(1, "Home");
				}
				if (phone_type == 2) {
					phoneType = new PhoneNoType(2, "Mobile");
				}
				if (phone_type == 3) {
					phoneType = new PhoneNoType(3, "Office");
				}
				patient.setPhoneNoType(phoneType);
				patientData.add(patient);

			}
			st.close();
			con.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		return patientData;

	}

	/**
	 * This method is used to save new patien's data and before saving it calls for
	 * validateInputFields method to check the validity of data.
	 * 
	 * @param newPatientObj This is the parameter to saveNewPatientData method.
	 * @return boolean This returns true or false.
	 */

	public boolean saveNewPatientData(Patient newPatientObj) {
		boolean is_saved = false;
		boolean is_valid = validateMandatoryInputFields(newPatientObj);
		if (is_valid) {
			boolean isPhoneValid = validatePhoneNumber(newPatientObj);
			if (isPhoneValid) {
				try {

					MySqlConnection sqlcon = new MySqlConnection();
					con = sqlcon.connectDb();
					// SQL insert query.
					String query = "INSERT INTO patientdetails (patientName, dob, address1, address2, address3, gender) VALUES (?, ?, ?, ?, ?, ?)";

					// create the java statement
					PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

					preparedStmt.setString(1, newPatientObj.getPatientName());
					preparedStmt.setString(2, newPatientObj.getDateOfBirth());
					preparedStmt.setString(3, newPatientObj.getAddress1());
					preparedStmt.setString(4, newPatientObj.getAddress2());
					preparedStmt.setString(5, newPatientObj.getAddress3());
					preparedStmt.setString(6, newPatientObj.getGender());

					// execute the preparedstatement

					preparedStmt.execute();
					rs = preparedStmt.getGeneratedKeys();
					rs.next();
					ai_patient_id = rs.getInt(1);
					// System.out.println(ai_patient_id);
					saveNewPatientPhoneNo(newPatientObj, ai_patient_id);
					preparedStmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Data inserted");
					is_saved = true;

				} catch (Exception e) {
					System.err.println("Got an exception! ");
					e.printStackTrace();
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, err_msg + " can not be empty.");
		}
		return is_saved;

	}

	/**
	 * This method is used to validate patient's data.
	 * 
	 * @param newPatientObj This is the parameter to validateInputFields method.
	 * @return boolean This returns true or false.
	 */

	public boolean validateMandatoryInputFields(Patient newPatientObj) {
		boolean isValid = true;
		StringBuilder error_fields = new StringBuilder();

		if (newPatientObj.getPatientName().isEmpty() || newPatientObj.getPatientName() == null) {
			error_fields.append("Patient name,");
			isValid = false;
		}

		if (newPatientObj.getDateOfBirth().isEmpty() || newPatientObj.getDateOfBirth() == null) {
			error_fields.append("Date of birth,");
			isValid = false;
		}
		if (newPatientObj.getAddress1().isEmpty() || newPatientObj.getAddress1() == null) {
			error_fields.append("Address1,");
			isValid = false;
		}
		if (newPatientObj.getAddress2().isEmpty() || newPatientObj.getAddress2() == null) {
			error_fields.append("Address2,");
			isValid = false;
		}
		if (newPatientObj.getAddress3().isEmpty() || newPatientObj.getAddress3() == null) {
			error_fields.append("Address3,");
			isValid = false;
		}
		if (newPatientObj.getGender().equals("Not selected")) {
			error_fields.append("Gender,");
			isValid = false;
		}

		if (error_fields.length() > 0) {
			err_msg = error_fields.substring(0, error_fields.length() - 1);
		}

		return isValid;
	}

	/**
	 * This method is used to validate patient's phone number.
	 * 
	 * @param newPatientObj This is the parameter to validateInputFields method.
	 * @return boolean This returns true or false.
	 */

	public boolean validatePhoneNumber(Patient newPatientObj) {
		boolean is_PhoneValid = true;
		if (newPatientObj.getPhoneNo().isEmpty() || newPatientObj.getPhoneNo() == null) {
			int a = JOptionPane.showConfirmDialog(null,
					"You are going to save without phone number.Do you want to proceed?", "Select an Option...",
					JOptionPane.YES_NO_OPTION);
			if (a == JOptionPane.YES_OPTION) {
				is_PhoneValid = true;
			}
			if (a == JOptionPane.NO_OPTION) {
				is_PhoneValid = false;
			}

		}
		return is_PhoneValid;

	}

	/**
	 * This method is used to save patient's phone number details.
	 * 
	 * @param newPatientObj This is the first parameter to saveNewPatientPhoneNo
	 *                      method.
	 * @param P_patient_id  This is the second parameter to saveNewPatientPhoneNo
	 *                      method.
	 */

	public void saveNewPatientPhoneNo(Patient newPatientObj, int P_patient_id) {
		int phoneNoType;
		try {

			// SQL insert query.
			String query = "INSERT INTO patientphoneno (phoneNo, type, ref_patient_id) VALUES (?, ?, ?)";

			// create the java statement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			if (newPatientObj.getPhoneNo().isEmpty() || newPatientObj.getPhoneNo() == null) {
				phoneNoType = 0;
			} else {
				phoneNoType = newPatientObj.getPhoneNoType().getTypeId();
			}
			preparedStmt.setString(1, newPatientObj.getPhoneNo());
			preparedStmt.setInt(2, phoneNoType);
			preparedStmt.setInt(3, P_patient_id);

			// execute the preparedstatement

			preparedStmt.execute();
			preparedStmt.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to update patien's data and before updating it calls for
	 * validateInputFields method to check the validity of data.
	 * 
	 * @param newPatientObj This is the parameter to updateNewPatientData method.
	 * @return boolean This returns true or false.
	 */
	public boolean updateNewPatientData(Patient newPatientObj) {
		boolean is_updated = false;
		boolean is_valid = validateMandatoryInputFields(newPatientObj);
		if (is_valid) {
			boolean isPhoneValid = validatePhoneNumber(newPatientObj);
			if (isPhoneValid) {
				try {

					MySqlConnection sqlcon = new MySqlConnection();
					con = sqlcon.connectDb();
					// SQL update query.
					String query = "update patientdetails set patientName = ?,dob = ?,address1 = ?,address2 = ?,address3 = ?,gender = ? WHERE patientId = ?";
					// create the java statement
					PreparedStatement preparedStmt = con.prepareStatement(query);

					preparedStmt.setString(1, newPatientObj.getPatientName());
					preparedStmt.setString(2, newPatientObj.getDateOfBirth());
					preparedStmt.setString(3, newPatientObj.getAddress1());
					preparedStmt.setString(4, newPatientObj.getAddress2());
					preparedStmt.setString(5, newPatientObj.getAddress3());
					preparedStmt.setString(6, newPatientObj.getGender());
					preparedStmt.setInt(7, newPatientObj.getHiddenId());

					// execute the preparedstatement

					preparedStmt.execute();
					updateNewPatientPhoneNo(newPatientObj);
					preparedStmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Successfully updated!.");
					is_updated = true;

				} catch (Exception e) {
					System.err.println("Got an exception! ");
					e.printStackTrace();
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, err_msg + " can not be empty!");
		}
		return is_updated;
	}

	/**
	 * This method is used to update patient's phone number details.
	 * 
	 * @param newPatientObj This is the first parameter to saveNewPatientPhoneNo
	 *                      method.
	 */
	public void updateNewPatientPhoneNo(Patient newPatientObj) {
		int phoneNoType;
		try {

			// SQL update query.
			String query = "update patientphoneno set phoneNo = ?,type = ? WHERE ref_patient_id = ?";
			// create the java statement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			if (newPatientObj.getPhoneNo().isEmpty() || newPatientObj.getPhoneNo() == null) {
				phoneNoType = 0;
			} else {
				phoneNoType = newPatientObj.getPhoneNoType().getTypeId();
			}

			preparedStmt.setString(1, newPatientObj.getPhoneNo());
			preparedStmt.setInt(2, phoneNoType);
			preparedStmt.setInt(3, newPatientObj.getHiddenId());

			// execute the preparedstatement

			preparedStmt.execute();
			preparedStmt.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to retrieve searched patients' data from the database.
	 * 
	 * @return ArrayList This returns ArrayList of patients.
	 */
	public ArrayList<Patient> searchPatientByName(Patient patientObj) {
		ArrayList<Patient> resultPatientData = new ArrayList<Patient>();
		boolean is_valid = validateSearchInputField(patientObj);
		if (is_valid) {
			try {
				MySqlConnection sqlcon = new MySqlConnection();
				con = sqlcon.connectDb();
				// SQL select query.
				String query = "SELECT p.*,pp.* FROM patientdetails p INNER JOIN patientphoneno pp ON p.patientId = pp.ref_patient_id WHERE p.patientName like ? ";
				// create the java statement
				PreparedStatement preparedStmt = con.prepareStatement(query);

				preparedStmt.setString(1, patientObj.getPatientName() + "%");

				// execute the preparedstatement

				ResultSet rs = preparedStmt.executeQuery();
				while (rs.next()) {
					Patient patient = new Patient();
					patient.setId(rs.getInt("patientId"));
					patient.setPatientName(rs.getString("patientName"));
					patient.setDateOfBirth(rs.getString("dob"));
					patient.setAddress1(rs.getString("address1"));
					patient.setAddress2(rs.getString("address2"));
					patient.setAddress3(rs.getString("address3"));
					patient.setGender(rs.getString("gender"));
					patient.setPhoneNo(rs.getString("phoneNo"));
					int phone_type = rs.getInt("type");

					if (phone_type == 0) {
						phoneType = new PhoneNoType(0, "");
					}
					if (phone_type == 1) {
						phoneType = new PhoneNoType(1, "Home");
					}
					if (phone_type == 2) {
						phoneType = new PhoneNoType(2, "Mobile");
					}
					if (phone_type == 3) {
						phoneType = new PhoneNoType(3, "Office");
					}
					patient.setPhoneNoType(phoneType);
					resultPatientData.add(patient);

				}
				preparedStmt.close();
				con.close();

			} catch (Exception e) {
				System.err.println("Got an exception! ");
				e.printStackTrace();
			}
			if (resultPatientData.size() <= 0) {
			JOptionPane.showMessageDialog(null, "No records found!");
			
		}
		}else {
			JOptionPane.showMessageDialog(null, search_err_msg);
			
		}

		return resultPatientData;

	}

	/**
	 * This method is used to validate input field of search box.
	 * 
	 * @param patientObj This is the parameter to validateSearchInputField method.
	 * @return boolean This returns true or false.
	 */

	public boolean validateSearchInputField(Patient patientObj) {
		boolean isValid = true;
		StringBuilder error_fields = new StringBuilder();

		if (patientObj.getPatientName().isEmpty() || patientObj.getPatientName() == null) {
			error_fields.append("Please enter patient's name,");
			isValid = false;
		}

		if (error_fields.length() > 0) {
			search_err_msg = error_fields.substring(0, error_fields.length() - 1);
			
		}

		return isValid;
	}

}
