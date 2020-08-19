package by.itacademy.mhl.service;

import by.itacademy.mhl.bean.UserInfo;

public interface LoginService {

	String logination(String login, String password) throws ServiceException;

	void registration(UserInfo user) throws ServiceException;

}
