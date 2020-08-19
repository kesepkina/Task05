package by.itacademy.mhl.service;

import java.util.List;

import by.itacademy.mhl.bean.Note;

public interface FindService {

	List<Note> findByAuthor(String author) throws ServiceException;
	
	List<Note> getAllCatalogue() throws ServiceException;

	List<Note> findByCategory(String category) throws ServiceException;

}
