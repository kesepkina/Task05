package by.itacademy.mhl.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDataValidator {

	public static boolean checkAuthData(String login, String password) {
		Pattern pattern1 = Pattern.compile("[a-zA-Z]{1}[\\w\\_\\.]+");
		Matcher matcher1 = pattern1.matcher(login);
		Pattern pattern2 = Pattern.compile("[^\\?\\!\\*]+");
		Matcher matcher2 = pattern2.matcher(password);
		return (matcher1.matches() && matcher2.matches());
	}

	public static boolean checkName(String name, String surname) {
		Pattern pattern = Pattern.compile("[a-zA-Z\s]+");
		Matcher matcher1 = pattern.matcher(name);
		Matcher matcher2 = pattern.matcher(surname);
		return (matcher1.matches() && matcher2.matches());
	}

	public static boolean checkEmail(String email) {
		Pattern pattern = Pattern
				.compile("[a-zA-Z]{1}[a-zA-Z\\d\\.\\_]+@([a-zA-Z]+\u002E){1,2}((net)|(com)|(org)|(ru)|(by))");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
