package by.itacademy.mhl.dao;

import by.itacademy.mhl.bean.UserInfo;

public interface AuthDao {
	
	String authorization(String login, String password) throws DaoException;
	void registration(UserInfo newUser) throws DaoException;

}
