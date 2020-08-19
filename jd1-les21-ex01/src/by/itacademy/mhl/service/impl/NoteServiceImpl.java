package by.itacademy.mhl.service.impl;

import by.itacademy.mhl.bean.Note;
import by.itacademy.mhl.bean.Role;
import by.itacademy.mhl.bean.UserStatus;
import by.itacademy.mhl.dao.DaoException;
import by.itacademy.mhl.dao.DaoFactory;
import by.itacademy.mhl.dao.LibraryDao;
import by.itacademy.mhl.service.NoteService;
import by.itacademy.mhl.service.ServiceException;
import by.itacademy.mhl.service.validation.NoteDataValidator;

public class NoteServiceImpl implements NoteService {

	@Override
	public void add(Note note) throws ServiceException {

		if (!Role.ADMIN.toString().equals(UserStatus.role)) {
			throw new ServiceException("Only for ADMINs!!!");
		}

		if (!NoteDataValidator.checkNoteData(note.getId(), note.getCategories(), note.getName(), note.getAuthors())) {
			throw new ServiceException("Wrong Note Data!!!");
		}

		DaoFactory daoFactory;
		LibraryDao libraryDao;

		try {
			daoFactory = DaoFactory.getInstance();
			libraryDao = daoFactory.getLibraryDao();
			libraryDao.add(note);
		} catch (DaoException e) {
			throw new ServiceException("Error by adding", e);
		}
	}

	@Override
	public void edit(int id, Note editNote) throws ServiceException {

		if (!Role.ADMIN.toString().equals(UserStatus.role)) {
			throw new ServiceException("Only for ADMINs!!!");
		}

		if (!NoteDataValidator.checkNoteData(editNote.getId(), editNote.getCategories(), editNote.getName(),
				editNote.getAuthors())) {
			throw new ServiceException("Wrong Note Data!!!");
		}

		DaoFactory daoFactory;
		LibraryDao libraryDao;

		try {
			daoFactory = DaoFactory.getInstance();
			libraryDao = daoFactory.getLibraryDao();
			libraryDao.edit(id, editNote);
		} catch (DaoException e) {
			throw new ServiceException("Error by editing", e);
		}
	}

	@Override
	public void delete(int id) throws ServiceException {

		if (!Role.ADMIN.toString().equals(UserStatus.role)) {
			throw new ServiceException("Only for ADMINs!!!");
		}

		DaoFactory daoFactory;
		LibraryDao libraryDao;

		try {
			daoFactory = DaoFactory.getInstance();
			libraryDao = daoFactory.getLibraryDao();
			libraryDao.deleteNote(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

}
