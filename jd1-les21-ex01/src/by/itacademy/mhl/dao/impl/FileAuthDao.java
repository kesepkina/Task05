package by.itacademy.mhl.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import by.itacademy.mhl.bean.UserInfo;
import by.itacademy.mhl.dao.AuthDao;
import by.itacademy.mhl.dao.DaoException;

public class FileAuthDao implements AuthDao {

	@Override
	public String authorization(String login, String password) throws DaoException {
		FileReader reader = null;
		BufferedReader bufReader = null;

		String[] params = null;
		String role = null;

		try {

			reader = new FileReader("resources/users.txt");
			bufReader = new BufferedReader(reader);

			String nextLine;

			try {
				while ((nextLine = bufReader.readLine()) != null) {
					params = nextLine.split("\\s+");
					if (params[0].equals(login) && params[1].equals(password)) {
						role = params[5];
						break;
					}
				}
			} catch (IOException e) {
				throw new DaoException("Error by reading a line!", e);
			}

		} catch (FileNotFoundException e) {
			throw new DaoException(e);
		} finally {
			if (bufReader != null) {
				try {
					bufReader.close();
				} catch (IOException e) {
					// log - error
					System.err.println(e);
				}
			}
		}

		return role;
	}

	@Override
	public void registration(UserInfo newUser) throws DaoException {

		if (ifLoginAlreadyExists(newUser.getLogin())) {
			throw new DaoException("The inputed login already exists.");
		}

		FileWriter writer = null;

		try {
			writer = new FileWriter("resources/users.txt", true);

			String nextLine;

			nextLine = newUser.getLogin() + " " + newUser.getPassword() + " " + newUser.getName() + " "
					+ newUser.getSurname() + " " + newUser.getEmail() + " " + newUser.getRole() + "\n";

			writer.write(nextLine);

		} catch (IOException e) {
			throw new DaoException("File writing ERROR", e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					// log - error
					System.err.println(e);
				}
			}
		}

	}

	private boolean ifLoginAlreadyExists(String login) throws DaoException {
		FileReader reader = null;
		BufferedReader bufReader = null;

		String[] params = null;
		boolean loginExists = false;

		try {
			reader = new FileReader("resources/users.txt");
			bufReader = new BufferedReader(reader);

			String nextLine;

			try {
				while ((nextLine = bufReader.readLine()) != null) {
					params = nextLine.split("\\s+");
					if (params[0].equals(login)) {
						loginExists = true;
						break;
					}
				}
			} catch (IOException e) {
				// log
				throw new DaoException("File reading ERROR", e);
			}

		} catch (FileNotFoundException e) {
			throw new DaoException(e);
		} finally {
			if (bufReader != null) {
				try {
					bufReader.close();
				} catch (IOException e) {
					// log - error
					System.err.println(e);
				}
			}
		}
		return loginExists;
	}

}
