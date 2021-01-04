package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;

import com.twilio.SendSMS;

import io.jsonwebtoken.io.IOException;
import Util.Person;
/*
 * This is a program that sends a text message to anyone who's birthday is this month!
 * @Author Craig Orman
 */
public class Primary implements UserSettings{

	/*
	 * takes our input and determines if the data is valid for processing Date is
	 * handled later, as to not process the string twice
	 * 
	 * @param String[] values this is the broken out set of values
	 */
	private static boolean validateCells(String[] values) {
		if (values.length < 8) // checks for blank rows
			return false;
		if (values[3].length() < 10) // checks if the mobile number is accurate
			return false;
		return true; // if it reaches here, the code is good for processing
	}

	public static void main(String[] args) throws java.io.IOException {
		String line = ""; // will hold all the values
		ArrayList<Person> sending = new ArrayList<Person>(); // collects all Person Objects to send messages to

		try {
			BufferedReader br = new BufferedReader(new FileReader(PATH));
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] values = line.split(","); // breaks the line into strings separated by the commas

				if (validateCells(values)) {
					values[3] = "1" + values[3];
					String[] dmy = values[8].split("/"); // break the dates out
					int month = Integer.parseInt(dmy[0]);
					int day = Integer.parseInt(dmy[1]);
					int year = Integer.parseInt(dmy[2]);

					LocalDate currentDate = LocalDate.now(); // get the current date
					if (month == currentDate.getMonthValue() && day < 32 && year > 1900
							&& year <= currentDate.getYear()) { // all checks needed to verify that the date is in
																// proper form
						LocalDate dob = LocalDate.of(year, month, day);

						Person person = new Person(values[0], values[1], values[2], values[3], values[4], values[5],
								values[6], Integer.parseInt(values[7]), dob);
						sending.add(person); // adds person to the array of people to be sent a text
					} // else nothing
				} // else nothing

			} // end while

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		SendSMS phone = new SendSMS(); // creates a phone object
		for (int i = 0; i < sending.size(); i++) {
			phone.sendMessage(sending.get(i)); // sends the message to the person
		} //end for

	}

}
