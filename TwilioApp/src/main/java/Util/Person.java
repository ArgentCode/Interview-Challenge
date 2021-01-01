package Util;

import java.time.LocalDate;

public class Person {

	private final String FIRST_NAME;
	private final String LAST_NAME;
	private final String HOME_PHONE;
	private final String MOBILE_PHONE;
	private final String STREET_ADDRESS;
	private final String CITY;
	private final String STATE;
	private final int ZIP;
	private final LocalDate DOB;
	
	public Person(String first, String last, String home, String mobile, String street, String city, String state, int zip, LocalDate DOB) {
		FIRST_NAME = first;
		LAST_NAME = last;
		HOME_PHONE = home;
		MOBILE_PHONE = mobile;
		STREET_ADDRESS = street;
		this.CITY = city;
		this.STATE = state;
		this.ZIP = zip;
		this.DOB = DOB;
	}

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public String getHOME_PHONE() {
		return HOME_PHONE;
	}

	public String getMOBILE_PHONE() {
		return MOBILE_PHONE;
	}

	public String getSTREET_ADDRESS() {
		return STREET_ADDRESS;
	}

	public String getCITY() {
		return CITY;
	}

	public String getSTATE() {
		return STATE;
	}

	public int getZip() {
		return ZIP;
	}

	public LocalDate getDOB() {
		return DOB;
	}
	
	
}

