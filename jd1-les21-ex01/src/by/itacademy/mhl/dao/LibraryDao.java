package by.itacademy.mhl.dao;

import java.util.List;

import by.itacademy.mhl.bean.Note;

public interface LibraryDao {

	List<Note> allCatalog() throws DaoException;
	List<Note> findAllInCategory(String categoryName) throws DaoException;
	List<Note> findAllByAuthor(String author) throws DaoException;
	void add(Note newNote) throws DaoException;
	boolean edit(int id, Note editNote) throws DaoException;
	void deleteNote(int id) throws DaoException;
	boolean idExists(int id) throws DaoException;
}
