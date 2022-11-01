package school.database.util;

import org.apache.commons.lang3.StringUtils;

public class EmailValidation {

    public static void main(String[] args) {

    }

    public static boolean isValidEmail(String email) {
	// 1) string has an @ in it
	// 2) string has only letters or numbers before the @ sign
	// 3) string ends with a '.' and then 3 characters with no numbers
	// 4) string is not empty and is not null
	// return true if all 3 conditions are good, otherwise false
	// check negative things first
	String before = email.substring(0, email.indexOf("@"));
	String end = email.substring(email.lastIndexOf(".") + 1);

	if (StringUtils.isBlank(email)) {
	    return false;
	} else if (!StringUtils.contains(email, "@")) {
	    return false;
	} else if (!StringUtils.isAlphanumeric(before)) {
	    return false;
	} else if (!StringUtils.isAlpha(end)) {
	    return false;
	}
	return true;
    }

    public static boolean isValidPhoneNumber(String phone) {
	// create a new method for validating a phone number and return true or false
	// a phone number must have 9 numbers, any more or less is an error
	// a phone number is allowed to have '-' '.' or ' ' in the phone number any
	// number of times at any location
	// a phone number must not be null or empty
	// a phone number must not begin with 555
	//
	// create a test in the EmailValidationTest class .. that will test with at
	// least 5 negative cases
	// create a test that will validate 5 or more positive cases

	if (StringUtils.isAllEmpty(phone)) {
	    return false;
	} else if (phone.length() < 9 || phone.length() > 9) {
	    if(!StringUtils.isNumeric(phone)) {
		if (!phone.contains("-") || !phone.contains(".") ) {
			return false;
		}
	    } else if (!StringUtils.isNumericSpace(phone)) {
		return false;
	    }
	} else if (phone.startsWith("555")) {
	    return false;
	}
	return true;
    }
}
