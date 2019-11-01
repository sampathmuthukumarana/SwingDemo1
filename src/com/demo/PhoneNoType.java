package com.demo;

/*
 * This class Represents a phone number type of the patient.
 */
public class PhoneNoType {
	private int typeId;
	private String typeName;

	/**
	 * This is the overloaded constructor method of this class
	 * 
	 * @param P_typeId   This is the first parameter of type int
	 * @param p_typeName This is the second parameter of type String
	 */
	public PhoneNoType(int P_typeId, String p_typeName) {
		super();
		this.typeId = P_typeId;
		this.typeName = p_typeName;
	}

	/**
	 * This method is used to get phone number type id
	 * 
	 * @return int This returns phone number type id.
	 */
	public int getTypeId() {
		return typeId;
	}

	/**
	 * This method is used to set phone number type id
	 * 
	 * @param typeId This is the parameter to setTypeId method
	 */
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	/**
	 * This method is used to get phone number's type name
	 * 
	 * @return String This returns phone number's type name
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * This method is used to set phone number's type name
	 * 
	 * @param typeName This is the parameter to setTypeName method
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * This is the overrided toString()method of this class.
	 * 
	 * @return String This returns phone number's type name
	 */
	@Override
	public String toString() {
		// return "PhoneNoType [typeId=" + typeId + ", typeName=" + typeName + "]";
		return typeName;
	}

}
