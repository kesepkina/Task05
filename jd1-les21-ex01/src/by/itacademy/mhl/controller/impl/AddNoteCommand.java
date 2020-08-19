package by.itacademy.mhl.controller.impl;

import by.itacademy.mhl.bean.Note;
import by.itacademy.mhl.controller.Command;
import by.itacademy.mhl.service.NoteService;
import by.itacademy.mhl.service.ServiceException;
import by.itacademy.mhl.service.ServiceFactory;
import by.itacademy.mhl.view.UserView;

public class AddNoteCommand implements Command {

	@Override
	public String execute(String[] params) {
		int id;
		Note addingNote;
		String[] categories;
		String name;
		String[] authors;

		id = Integer.parseInt(params[1].split("=")[1]);
		categories = params[2].split("=")[1].split(",");
		name = params[3].split("=")[1];
		authors = params[4].split("=")[1].split(",");

		addingNote = new Note(id, categories, name, authors);

		ServiceFactory factory = ServiceFactory.getInstance();
		NoteService service = factory.getNoteService();

		String response;

		try {

			service.add(addingNote);
			response = UserView.addedSuccesfully();
		} catch (ServiceException e) {
			System.out.println(e);
			response = "Error by adding the Note!";
		}

		return response;
	}

}
