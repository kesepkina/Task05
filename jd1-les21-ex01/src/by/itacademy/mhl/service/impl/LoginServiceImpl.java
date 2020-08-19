package by.itacademy.mhl.service.impl;

import by.itacademy.mhl.bean.Role;
import by.itacademy.mhl.bean.UserInfo;
import by.itacademy.mhl.bean.UserStatus;
import by.itacademy.mhl.dao.AuthDao;
import by.itacademy.mhl.dao.DaoException;
import by.itacademy.mhl.dao.DaoFactory;
import by.itacademy.mhl.service.LoginService;
import by.itacademy.mhl.service.ServiceException;
import by.itacademy.mhl.service.validation.UserDataValidator;

public class LoginServiceImpl implements LoginService {

	@Override
	public String logination(String login, String password) throws ServiceException {
		if (!UserDataValidator.checkAuthData(login, password)) {
			throw new ServiceException("Wrong login or password!!!");
		}

		DaoFactory daoFactory;
		AuthDao authDao;
		String role = null;

		try {
			daoFactory = DaoFactory.getInstance();
			authDao = daoFactory.getAuthDao();
			role = authDao.authorization(login, password);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

		if (role == null) {
			throw new ServiceException("Wrong login or password!!!");
		}

		return role;
	}

	@Override
	public void registration(UserInfo user) throws ServiceException {
		if (!Role.ADMIN.toString().equals(UserStatus.role)) {
			throw new ServiceException("Only for ADMINs!!!");
		}
		
		if (!UserDataValidator.checkAuthData(user.getLogin(), user.getPassword())) {
			throw new ServiceException("Wrong login or password!!!");
		}
		
		if (!UserDataValidator.checkName(user.getName(), user.getSurname())) {
			throw new ServiceException("Wrong name or surname!!!");
		}
		
		if (!UserDataValidator.checkEmail(user.getEmail())) {
			throw new ServiceException("Wrong email!!!");
		}
		
		DaoFactory daoFactory;
		AuthDao authDao;

		try {
			daoFactory = DaoFactory.getInstance();
			authDao = daoFactory.getAuthDao();
			authDao.registration(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

}
