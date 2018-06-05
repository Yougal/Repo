package com.yougal.serialization.obj;

import java.io.Serializable;

public class SerializedChildSerializedParent extends SerializedParent implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int schoolId;
	
	private String schoolName;
	
	public SerializedChildSerializedParent() {
		System.out.println("SerializedChild constructor");
	}


	/**
	 * @return the schoolId
	 */
	public int getSchoolId() {
		return schoolId;
	}

	/**
	 * @param schoolId the schoolId to set
	 */
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	/**
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SerializedChild [schoolId=" + schoolId + ", schoolName=" + schoolName+ " , "+ super.toString() + "]";
	}
	
	
}
