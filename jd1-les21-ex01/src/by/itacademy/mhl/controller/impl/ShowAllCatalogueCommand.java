package by.itacademy.mhl.controller.impl;

import java.util.List;

import by.itacademy.mhl.bean.Note;
import by.itacademy.mhl.controller.Command;
import by.itacademy.mhl.service.FindService;
import by.itacademy.mhl.service.ServiceException;
import by.itacademy.mhl.service.ServiceFactory;
import by.itacademy.mhl.view.UserView;

public class ShowAllCatalogueCommand implements Command {

	@Override
	public String execute(String[] params) {

		ServiceFactory factory = ServiceFactory.getInstance();
		FindService service = factory.getFindService();

		String response;

		List<Note> fullCatalogue;

		try {
			fullCatalogue = service.getAllCatalogue();
			response = UserView.showNotes("Full catalogue:", fullCatalogue);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			response = "ERROR!";
		}

		return response;
	}

}
