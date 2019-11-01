package com.demo;

import java.util.Comparator;

/**
 * This class Represents a patient in the hospital.
 */
public class Patient implements Comparator<Patient> {

	/**
	 * This is the default constructor of this class
	 */
	public Patient() {

	}

	private int id;
	private String patientName;
	private String dateOfBirth;
	private String address1;
	private String address2;
	private String address3;
	private String gender;
	private String phoneNo;
	private PhoneNoType PhoneNoType;
	private int hiddenId;
	boolean isSortAsc;

	/**
	 * This is the overloaded constructor method of this class
	 * 
	 * @param id          This is the first parameter of type int
	 * @param patientName This is the second parameter of type String
	 * @param dateOfBirth This is the third parameter of type String
	 * @param address1    This is the fourth parameter of type String
	 * @param address2    This is the fifth parameter of type String
	 * @param address3    This is the sixth parameter of type String
	 * @param gender      This is the seventh parameter of type String
	 * @param phoneNo     This is the eighth parameter of type String
	 * @param phoneNoType This is the nineth parameter of type PhoneNoType
	 * @param hiddenId    This is the tenth parameter of type int
	 */

	public Patient(int id, String patientName, String dateOfBirth, String address1, String address2, String address3,
			String gender, String phoneNo, PhoneNoType phoneNoType, int hiddenId) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.dateOfBirth = dateOfBirth;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.gender = gender;
		this.phoneNo = phoneNo;
		this.PhoneNoType = phoneNoType;
		this.hiddenId = hiddenId;
	}

	public Patient(boolean p_isSortAsc) {
		isSortAsc = p_isSortAsc;
	}

	/**
	 * This method is used to get Patient id
	 * 
	 * @return int This returns patient's id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method is used to set patient's id
	 * 
	 * @param p_id This is the parameter to setId method
	 */
	public void setId(int p_id) {
		this.id = p_id;
	}

	/**
	 * This method is used to get Patient's name
	 * 
	 * @return String This returns patient's name.
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * This method is used to set patient's name
	 * 
	 * @param p_patientName This is the parameter to setPatientName method
	 */
	public void setPatientName(String p_patientName) {
		this.patientName = p_patientName;
	}

	/**
	 * This method is used to get Patient's date of birth
	 * 
	 * @return String This returns patient's date of birth.
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * This method is used to set patient's date of birth
	 * 
	 * @param p_dateOfBirth This is the parameter to setDateOfBirth method
	 */
	public void setDateOfBirth(String p_dateOfBirth) {
		this.dateOfBirth = p_dateOfBirth;
	}

	/**
	 * This method is used to get Patient's address line 1
	 * 
	 * @return String This returns patient's address line 1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * This method is used to set patient's address line 1
	 * 
	 * @param p_address1 This is the parameter to setAddress1 method
	 */
	public void setAddress1(String p_address1) {
		this.address1 = p_address1;
	}

	/**
	 * This method is used to get Patient's address line 2
	 * 
	 * @return String This returns patient's address line 2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * This method is used to set patient's address line 2
	 * 
	 * @param p_address2 This is the parameter to setAddress2 method
	 */
	public void setAddress2(String p_address2) {
		this.address2 = p_address2;
	}

	/**
	 * This method is used to get Patient's address line 3
	 * 
	 * @return String This returns patient's address line 3
	 */
	public String getAddress3() {
		return address3;
	}

	/**
	 * This method is used to set patient's address line 3
	 * 
	 * @param p_address3 This is the parameter to setAddress3 method
	 */
	public void setAddress3(String p_address3) {
		this.address3 = p_address3;
	}

	/**
	 * This method is used to get Patient's gender
	 * 
	 * @return String This returns patient's gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * This method is used to set patient's gender
	 * 
	 * @param p_gender This is the parameter to setGender method
	 */
	public void setGender(String p_gender) {
		this.gender = p_gender;
	}

	/**
	 * This method is used to get Patient's phone no:
	 * 
	 * @return String This returns patient's phone no:
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * This method is used to set patient's phone no:
	 * 
	 * @param p_phoneNo This is the parameter to setPhoneNo method
	 */
	public void setPhoneNo(String p_phoneNo) {
		this.phoneNo = p_phoneNo;
	}

	/**
	 * This method is used to get Patient's phone no: type
	 * 
	 * @return String This returns patient's phone no: type
	 */
	public PhoneNoType getPhoneNoType() {
		return PhoneNoType;
	}

	/**
	 * This method is used to set patient's phone no: type
	 * 
	 * @param p_phoneNoType This is the parameter to setPhoneNoType method
	 */
	public void setPhoneNoType(PhoneNoType p_phoneNoType) {
		this.PhoneNoType = p_phoneNoType;
	}

	/**
	 * This method is used to get hidden id
	 * 
	 * @return String This returns patient's hidden id
	 */
	public int getHiddenId() {
		return hiddenId;
	}

	/**
	 * This method is used to set patient's hidden id
	 * 
	 * @param hiddenId This is the parameter to setHiddenId method
	 */
	public void setHiddenId(int hiddenId) {
		this.hiddenId = hiddenId;
	}

	// int i=0;
	/**
	 * This is an overrided method of the Comparator interface
	 * 
	 * @param objPatient1 This is first parameter to the compare method
	 * @param objPatient2 This is second parameter to the compare method
	 * @return int This is the return type of this method.
	 */
	@Override
	public int compare(Patient objPatient1, Patient objPatient2) {

		// System.out.println(i++);
		if (objPatient1.PhoneNoType.getTypeName() == objPatient2.getPhoneNoType().getTypeName()) {
			return 0;
		} else if (objPatient1.PhoneNoType.getTypeName().equals("Mobile")
				&& objPatient2.PhoneNoType.getTypeName().equals("Home")) {
			return -1;
		} else if (objPatient1.PhoneNoType.getTypeName().equals("Home")
				&& objPatient2.PhoneNoType.getTypeName().equals("Mobile")) {
			return 1;
		} else if (objPatient1.PhoneNoType.getTypeName().equals("Home")
				&& objPatient2.PhoneNoType.getTypeName().equals("Office")) {
			return -1;
		} else if (objPatient1.PhoneNoType.getTypeName().equals("Office")
				&& objPatient2.PhoneNoType.getTypeName().equals("Home")) {
			return 1;
		} else if (objPatient1.PhoneNoType.getTypeName().equals("Mobile")
				&& objPatient2.PhoneNoType.getTypeName().equals("Office")) {
			return -1;
		} else if (objPatient1.PhoneNoType.getTypeName().equals("Office")
				&& objPatient2.PhoneNoType.getTypeName().equals("Mobile")) {
			return 1;
		} else if (objPatient1.PhoneNoType.getTypeName().equals("Office")
				&& objPatient2.PhoneNoType.getTypeName().isEmpty()) {
			return -1;
		} else if (objPatient1.PhoneNoType.getTypeName().isEmpty()
				&& objPatient2.PhoneNoType.getTypeName().equals("Office")) {
			return 1;
		} else if (objPatient1.PhoneNoType.getTypeName().equals("Home")
				&& objPatient2.PhoneNoType.getTypeName().isEmpty()) {
			return -1;
		} else if (objPatient1.PhoneNoType.getTypeName().isEmpty()
				&& objPatient2.PhoneNoType.getTypeName().equals("Home")) {
			return 1;
		} else if (objPatient1.PhoneNoType.getTypeName().equals("Mobile")
				&& objPatient2.PhoneNoType.getTypeName().isEmpty()) {
			return -1;
		} else {
			return 1;
		}

	}

}
