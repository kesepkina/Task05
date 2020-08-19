package by.itacademy.mhl.controller.impl;

import java.util.List;

import by.itacademy.mhl.bean.Note;
import by.itacademy.mhl.controller.Command;
import by.itacademy.mhl.service.FindService;
import by.itacademy.mhl.service.ServiceException;
import by.itacademy.mhl.service.ServiceFactory;
import by.itacademy.mhl.view.UserView;

public class FindAllByCategoryCommand implements Command {

	@Override
	public String execute(String[] params) {
		ServiceFactory factory = ServiceFactory.getInstance();
		FindService service = factory.getFindService();

		String response;
		String category;
		
		category = params[1].split("=")[1];

		List<Note> notesByCategory;

		try {
			notesByCategory = service.findByCategory(category);
			response = UserView.showNotes("Books by category \"" + category + "\":", notesByCategory);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			response = "ERROR!";
		}

		return response;
	}

}
