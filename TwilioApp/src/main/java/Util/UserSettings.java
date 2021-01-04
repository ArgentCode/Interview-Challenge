package Util;

public interface UserSettings {
	/*
	 * settings component for Primary class
	 * place the location of the addressBook here
	 */
	public final static String PATH = "";

	/*
	 * This is the settings component for Twilio
	 * please uncomment these lines if hard coding of the API is needed
	 */
//	public final static String ACCOUNT_SID = "";
//	public final static String AUTH_TOKEN = "";

	public final static String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
	public final static String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
	public final static String TWILIO_PHONE = "5153254937";
	public final static String USER_FIRST = "Craig";
	public final static String USER_PHONE = "(515)290-9363";

}
