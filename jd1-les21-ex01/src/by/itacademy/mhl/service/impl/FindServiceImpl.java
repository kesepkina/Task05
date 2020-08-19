package by.itacademy.mhl.service.impl;

import java.util.List;

import by.itacademy.mhl.bean.Note;
import by.itacademy.mhl.bean.Role;
import by.itacademy.mhl.bean.UserStatus;
import by.itacademy.mhl.dao.DaoException;
import by.itacademy.mhl.dao.DaoFactory;
import by.itacademy.mhl.dao.LibraryDao;
import by.itacademy.mhl.service.FindService;
import by.itacademy.mhl.service.ServiceException;
import by.itacademy.mhl.service.validation.NoteDataValidator;

public class FindServiceImpl implements FindService{

	@Override
	public List<Note> findByAuthor(String author) throws ServiceException {
		
		if (!Role.contains(UserStatus.role)) {
			throw new ServiceException("Not authorizated user!!!");
		}
		
		if (!NoteDataValidator.checkName(author)) {
			throw new ServiceException("Wrong author name!!!");
		}
		
		DaoFactory daoFactory;
		LibraryDao libraryDao;
		
		List<Note> notesByAuthor;

		try {
			daoFactory = DaoFactory.getInstance();
			libraryDao = daoFactory.getLibraryDao();
			notesByAuthor = libraryDao.findAllByAuthor(author.toLowerCase());
		} catch (DaoException e) {
			throw new ServiceException("Error!", e);
		}
		
		return notesByAuthor;
	}

	@Override
	public List<Note> getAllCatalogue() throws ServiceException  {
		

		if (!Role.contains(UserStatus.role)) {
			throw new ServiceException("Not authorizated user!!!");
		}

		DaoFactory daoFactory;
		LibraryDao libraryDao;
		
		List<Note> catalogue;

		try {
			daoFactory = DaoFactory.getInstance();
			libraryDao = daoFactory.getLibraryDao();
			catalogue = libraryDao.allCatalog();
		} catch (DaoException e) {
			throw new ServiceException("Error!", e);
		}
		
		return catalogue;
	}

	@Override
	public List<Note> findByCategory(String category) throws ServiceException {

		if (!Role.contains(UserStatus.role)) {
			throw new ServiceException("Not authorizated user!!!");
		}
		
		if (!NoteDataValidator.checkCategory(category)) {
			throw new ServiceException("Wrong category name!!!");
		}
		
		
		
		DaoFactory daoFactory;
		LibraryDao libraryDao;
		
		List<Note> notesByCategory;

		try {
			daoFactory = DaoFactory.getInstance();
			libraryDao = daoFactory.getLibraryDao();
			notesByCategory = libraryDao.findAllInCategory(category.toLowerCase());
		} catch (DaoException e) {
			throw new ServiceException("Error!", e);
		}
		
		return notesByCategory;
	}

}
