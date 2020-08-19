package by.itacademy.mhl.dao;

import by.itacademy.mhl.dao.impl.FileAuthDao;
import by.itacademy.mhl.dao.impl.FileLibraryDao;

public class DaoFactory {
	private static final DaoFactory instance = new DaoFactory();
	
	private final AuthDao authDao = new FileAuthDao();
	private final LibraryDao libraryDao = new FileLibraryDao();
	
	
	private DaoFactory() {}
	
	public static DaoFactory getInstance() {
		return instance;
	}

	public AuthDao getAuthDao() {
		return authDao;
	}

	public LibraryDao getLibraryDao() {
		return libraryDao;
	}
	
	

}
