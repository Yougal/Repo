package com.yougal.serialization.obj;

public class NonSerializedChild {


	public NonSerializedChild() {
		System.out.println("NonSerializedChild constructor");
	}

	private int schoolId;
	
	private String schoolName;

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
		return "NonSerializedChild [schoolId=" + schoolId + ", schoolName=" + schoolName+ " , "+ super.toString() + "]";
	}
	
	
	
}
