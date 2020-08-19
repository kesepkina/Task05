package by.itacademy.mhl.view;

import java.util.List;

import by.itacademy.mhl.bean.Note;

public class UserView {

	public static String welcome(String role) {
		return "Вы успешло авторизовались. Ваш статус " + role;
	}

	public static String registratedSuccessfully() {
		return "Пользователь успешно зарегистрирован.";
	}

	public static String editedSuccesfully() {
		return "Запись успешно редактирована.";
	}

	public static String errorByEditing() {
		return "Возникли ошибки при редактировании.";
	}

	public static String addedSuccesfully() {
		return "Запись успешно добавлена.";

	}

	public static String showNotes(String message, List<Note> notes) {
		if (notes==null) {
			return "Ups, your request doesn't much any book in our library.";
		}
		String response = message + "\n";
		response += String.format("%-10s %-20s %-20s %-20s\n", "-ID-", "-CATEGORIES-", "-NAME OF BOOK-", "-AUTHORS-");
		for (Note note : notes) {
			response += String.format("%-10s %-20s %-20s %-20s\n", note.getId(), arrayToString(note.getCategories()),
					note.getName(), arrayToString(note.getAuthors()));
		}

		return response;
	}

	private static String arrayToString(String[] array) {
		String arToString = array[0];
		for (int i = 1; i < array.length; i++) {
			if (arToString != null) {
				arToString += ", ";
			}
			arToString += array[i];
		}

		return arToString;
	}

	public static String delitedSuccesfully() {
		return "Запись успешно удалена.";
	}

}
