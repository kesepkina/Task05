package by.itacademy.mhl.controller.impl;

import java.util.List;

import by.itacademy.mhl.bean.Note;
import by.itacademy.mhl.controller.Command;
import by.itacademy.mhl.service.FindService;
import by.itacademy.mhl.service.ServiceException;
import by.itacademy.mhl.service.ServiceFactory;
import by.itacademy.mhl.view.UserView;

public class FindAllByAuthorCommand implements Command {

	@Override
	public String execute(String[] params) {
		ServiceFactory factory = ServiceFactory.getInstance();
		FindService service = factory.getFindService();

		String response;
		String author;
		
		author = params[1].split("=")[1];
		author = author.trim().replaceAll("[\\s]{2,}", " ");

		List<Note> notesByAuthor;

		try {
			notesByAuthor = service.findByAuthor(author);
			response = UserView.showNotes(author + "'s books:", notesByAuthor);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			response = "ERROR!";
		}

		return response;
	}

}
