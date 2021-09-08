package in.co.sunrays.util;

import java.util.Date;

public class DataValidator {

	public static boolean isNull(String val) {

		if (val == null || val.trim().length() == 0) {

			return true;

		} else {
			return false;
		}

	}

	public static boolean isNotNull(String val) {

		return !isNull(val);
	}

	public static boolean isInteger(String val) {

		if (isNotNull(val)) {
			try {
				int i = Integer.parseInt(val);
				return true;
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isLong(String val) {
		if (isNotNull(val)) {
			try {
				long i = Long.parseLong(val);
				return true;
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
				return false;
			}
		} else {
			return false;
		}

	}

	public static boolean isEmail(String val) {

		String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		if (isNotNull(val)) {
			try {
				return val.matches(emailreg);
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}
	public static boolean isDate(String val) {
		Date d= null;
		if(isNotNull(val)) {
		d = DataUtility.getDate(val);	
		}
		return d!=null;
	}
	
}
