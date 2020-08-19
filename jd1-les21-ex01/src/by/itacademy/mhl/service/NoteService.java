package by.itacademy.mhl.service;

import by.itacademy.mhl.bean.Note;

public interface NoteService {

	void add(Note note) throws ServiceException;

	void edit(int id, Note editNote) throws ServiceException;

	void delete(int id) throws ServiceException;
}
