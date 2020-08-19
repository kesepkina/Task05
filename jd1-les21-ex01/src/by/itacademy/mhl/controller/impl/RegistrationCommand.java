package by.itacademy.mhl.controller.impl;

import by.itacademy.mhl.bean.Role;
import by.itacademy.mhl.bean.UserInfo;
import by.itacademy.mhl.controller.Command;
import by.itacademy.mhl.service.LoginService;
import by.itacademy.mhl.service.ServiceException;
import by.itacademy.mhl.service.ServiceFactory;
import by.itacademy.mhl.view.UserView;

public class RegistrationCommand implements Command {

	@Override
	public String execute(String[] params) {
		String login;
		String password;
		String name;
		String surname;
		String email;
		String roleStr;
		Role role;

		login = params[1].split("=")[1];
		password = params[2].split("=")[1];
		name = params[3].split("=")[1];
		surname = params[4].split("=")[1];
		email = params[5].split("=")[1];
		roleStr = params[6].split("=")[1];
		if(!Role.contains(roleStr)){
			return "Error by registration. Such role doesn't exist."; 
		}
		role = Role.valueOf(roleStr);

		UserInfo newUser = new UserInfo(login, password, name, surname, email, role);

		ServiceFactory factory = ServiceFactory.getInstance();
		LoginService service = factory.getLoginService();

		String response;
		try {
			service.registration(newUser);
			response = UserView.registratedSuccessfully();
		} catch (ServiceException e) {
			System.out.println(e);
			response = "Error by registration!";
		}
		return response;
	}

}
