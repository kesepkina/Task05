package by.itacademy.mhl.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteDataValidator {

	public static boolean checkNoteData(int id, String[] categories, String name, String[] authors) {
		boolean allRight = true;
		
		if (!checkNoteData(id)) {
			allRight = false;
		}
		
		for(String category: categories) {
			if(!checkCategory(category)) {
				allRight = false;
			}
		}
		
		if (!checkName(name)) {
			allRight = false;
		}
		
		for(String author: authors) {
			if(!checkName(author)) {
				allRight = false;
			}
		}
		
		return allRight;
	}

	public static boolean checkNoteData(int id) {

		return id < 100;
	}

	public static boolean checkName(String name) {
		Pattern pattern = Pattern.compile("[a-zA-Z\s]+");
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

	public static boolean checkCategory(String category) {
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		Matcher matcher = pattern.matcher(category);
		return matcher.matches();
	}

}
