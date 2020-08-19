package by.itacademy.mhl.controller.impl;

import by.itacademy.mhl.controller.Command;
import by.itacademy.mhl.service.NoteService;
import by.itacademy.mhl.service.ServiceException;
import by.itacademy.mhl.service.ServiceFactory;
import by.itacademy.mhl.view.UserView;

public class DeleteNoteCommand implements Command {

	@Override
	public String execute(String[] params) {

		int id;

		id = Integer.parseInt(params[1].split("=")[1]);

		ServiceFactory factory = ServiceFactory.getInstance();
		NoteService service = factory.getNoteService();

		String response;
		try {

			service.delete(id);
			response = UserView.delitedSuccesfully();

		} catch (ServiceException e) {
			System.out.println(e);
			response = "Error by deleting the note!";
		}

		return response;
	}

}
