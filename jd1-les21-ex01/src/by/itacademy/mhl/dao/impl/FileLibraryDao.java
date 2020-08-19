package by.itacademy.mhl.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.itacademy.mhl.bean.Note;
import by.itacademy.mhl.dao.DaoException;
import by.itacademy.mhl.dao.LibraryDao;

public class FileLibraryDao implements LibraryDao {

	@Override
	public List<Note> allCatalog() throws DaoException {
		FileReader reader = null;
		BufferedReader bufReader = null;

		List<Note> catalog = new ArrayList<Note>();

		try {
			reader = new FileReader("resources/library.txt");
			bufReader = new BufferedReader(reader);

			String nextLine;

			String[] params = null;
			String[] authors = null;
			String[] categories = null;

			try {
				while ((nextLine = bufReader.readLine()) != null) {
					params = nextLine.split(" _\\|_ ");
					categories = params[1].split(", ");
					authors = params[3].split(", ");
					catalog.add(new Note(Integer.parseInt(params[0].trim()), categories, params[2], authors));
				}
			} catch (IOException e) {
				throw new DaoException("Error by reading a line", e);
			}

		} catch (FileNotFoundException e) {
			throw new DaoException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// log - error
					System.err.println(e);
				}
			}
		}

		return catalog;
	}

	@Override
	public List<Note> findAllInCategory(String categoryName) throws DaoException {
		FileReader reader = null;
		BufferedReader bufReader = null;

		List<Note> catalogByCategory = new ArrayList<Note>();

		try {
			reader = new FileReader("resources/library.txt");
			bufReader = new BufferedReader(reader);

			String nextLine;

			String[] params = null;
			String[] authors = null;
			String[] categories = null;

			try {
				while ((nextLine = bufReader.readLine()) != null) {
					params = nextLine.split(" _\\|_ ");
					categories = params[1].split(", ");
					for (String category : categories) {
						if (category.toLowerCase().contains(categoryName)) {
							authors = params[3].split(", ");
							catalogByCategory
									.add(new Note(Integer.parseInt(params[0].trim()), categories, params[2], authors));
							break;
						}
					}

				}
			} catch (IOException e) {
				throw new DaoException("Error by reading the file!", e);
			}

		} catch (FileNotFoundException e) {
			throw new DaoException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// log - error
					System.err.println(e);
				}
			}
		}

		return catalogByCategory;
	}

	@Override
	public void add(Note newNote) throws DaoException {
		
		if(idExists(newNote.getId())) {
			throw new DaoException("This id already exists!");
		}
		
		FileWriter writer = null;
		try {
			writer = new FileWriter("resources/library.txt", true);

			String addingNote = Integer.toString(newNote.getId()) + " _|_ " + arrayToString(newNote.getCategories()) + " _|_ "
					+ newNote.getName() + " _|_ " + arrayToString(newNote.getAuthors()) + "\n";

			writer.write(addingNote);

		} catch (IOException e) {
			throw new DaoException("Error by writing!!!", e);

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

	@Override
	public boolean edit(int id, Note editNote) throws DaoException {
		
		if(!idExists(id)) {
			throw new DaoException("This id doesn't exist!");
		}
		
		FileReader reader = null;
		FileWriter writer = null;
		BufferedReader bufReader = null;
		
		List<String> allNotes = new ArrayList<String>();
		
		try {
			reader = new FileReader("resources/library.txt");
			bufReader = new BufferedReader(reader);

			try {
				String note;
				while ((note = bufReader.readLine()) != null) {
					allNotes.add(note);
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

		String stringId = Integer.toString(id);
		boolean idExists = false;

		for (int i = 0; i < allNotes.size(); i++) {
			if (allNotes.get(i).substring(0, 1).equals(stringId)) {
				allNotes.set(i, stringId + " _|_ " + arrayToString(editNote.getCategories()) + " _|_ "
						+ editNote.getName() + " _|_ " + arrayToString(editNote.getAuthors()));
				idExists = true;
				break;
			}
		}

		if (!idExists) {
			return false;
		}

		try {
			writer = new FileWriter("resources/library.txt");
			for (String note : allNotes) {
				writer.write(note + "\n");
			}
		} catch (IOException e) {
			throw new DaoException("Error by writing in the file!", e);
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

		return true;
	}

	private String arrayToString(String[] array) {
		String arToString = array[0];
		for (int i = 1; i < array.length; i++) {
			if (arToString != null) {
				arToString += ", ";
			}
			arToString += array[i];
		}

		return arToString;
	}

	@Override
	public List<Note> findAllByAuthor(String author) throws DaoException {
		FileReader reader = null;
		BufferedReader bufReader = null;

		List<Note> catalogByAuthor = new ArrayList<Note>();

		try {
			reader = new FileReader("resources/library.txt");
			bufReader = new BufferedReader(reader);

			String nextLine;

			String[] params = null;
			String[] authors;
			String[] categories;

			try {
				while ((nextLine = bufReader.readLine()) != null) {
					authors = null;
					params = nextLine.split(" _\\|_ ");
					authors = params[3].split(", ");
					for (String bookAuthor : authors) {
						if (bookAuthor.toLowerCase().contains(author)) {
							categories = params[1].split(", ");
							catalogByAuthor
									.add(new Note(Integer.parseInt(params[0].trim()), categories, params[2], authors));
							break;
						}
					}

				}
			} catch (IOException e) {
				// log
				throw new DaoException("Error by reading the file!", e);
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

		if (catalogByAuthor.isEmpty()) {
			return null;
		}

		return catalogByAuthor;
	}

	@Override
	public void deleteNote(int id) throws DaoException {
		
		if(!idExists(id)) {
			throw new DaoException("This id doesn't exist!");
		}
		
		FileReader reader = null;
		FileWriter writer = null;
		BufferedReader bufReader = null;

		List<String> allNotes = new ArrayList<String>();

		try {
			reader = new FileReader("resources/library.txt");
			bufReader = new BufferedReader(reader);

			try {
				String note;
				while ((note = bufReader.readLine()) != null) {
					allNotes.add(note);
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

		String stringId = Integer.toString(id);
		

		for (int i = 0; i < allNotes.size(); i++) {
			if (allNotes.get(i).split(" _\\|_ ")[0].equals(stringId)) {
				allNotes.remove(i);
				break;
			}
		}

		try {
			writer = new FileWriter("resources/library.txt");
			for (String note : allNotes) {
				writer.write(note + "\n");
			}

		} catch (IOException e) {
			throw new DaoException("Error by writing!!!", e);
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

	@Override
	public boolean idExists(int id) throws DaoException {
		FileReader reader = null;
		BufferedReader bufReader = null;

		boolean idExists = false;

		String stringId = Integer.toString(id);

		try {
			reader = new FileReader("resources/library.txt");
			bufReader = new BufferedReader(reader);

			try {
				String note;
				while ((note = bufReader.readLine()) != null) {
					if (note.split(" _\\|_ ")[0].equals(stringId)) {
						idExists = true;
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
		return idExists;
	}

}
