package by.itacademy.mhl.controller.impl;

import by.itacademy.mhl.bean.UserStatus;
import by.itacademy.mhl.controller.Command;
import by.itacademy.mhl.service.LoginService;
import by.itacademy.mhl.service.ServiceException;
import by.itacademy.mhl.service.ServiceFactory;
import by.itacademy.mhl.view.UserView;

public class LoginationCommand implements Command{

	@Override
	public String execute(String[] params) {
		String login;
		String password;
		
		login = params[1].split("=")[1];
		password = params[2].split("=")[1];
		
		ServiceFactory factory = ServiceFactory.getInstance();
		LoginService service = factory.getLoginService();

		String response;
		try {
			UserStatus.role = service.logination(login, password);
			response = UserView.welcome(UserStatus.role);
		} catch (ServiceException e) {
			System.out.println(e);
			response = "Error!";
		}
		return response;
	}

}
