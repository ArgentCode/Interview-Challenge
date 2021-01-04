package com.twilio;

import com.twilio.Twilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import Util.Person;
import Util.UserSettings;

public class SendSMS implements UserSettings {

	/*
	 * Constructs a phone object and initializes the Twilio account
	 */
	public SendSMS() {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	}

	/*
	 * In state and out of state options so we don't ask people out of state to
	 * lunch
	 * 
	 * @Param Person person gets the person so we can see what state they are in and
	 * their name
	 * 
	 * @Return String returns the needed message
	 */
	private String text(Person person) {

		//In state option
		if (person.getSTATE().equals("IA")) {
			String inState = "Happy Birthday " + person.getFIRST_NAME() + " from " + USER_FIRST + " call me at "
					+ USER_PHONE + " to plan a lunch sometime.";
			return inState;
		}

		//out of state option
		String outState = "Happy Birthday " + person.getFIRST_NAME() + " from " + USER_FIRST + " call me at "
				+ USER_PHONE + " when you get a chance!"; //
		return outState;
	}

	/*
	 * Sends a text message via the inputed Twilio phone number
	 * 
	 * @param Person person This file contains the information needed to send
	 * someone a message.
	 */
	public void sendMessage(Person person) {
		//testing print message to see who is being sent a message
//		System.out.println(text(person));

		Message message = Message.creator(new PhoneNumber("+" + person.getMOBILE_PHONE()), // to
				new PhoneNumber("+1" + TWILIO_PHONE), // from
				text(person)).create(); //message text 
	}

}
