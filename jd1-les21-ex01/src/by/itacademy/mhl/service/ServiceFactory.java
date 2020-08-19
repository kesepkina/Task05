package by.itacademy.mhl.service;

import by.itacademy.mhl.service.impl.FindServiceImpl;
import by.itacademy.mhl.service.impl.LoginServiceImpl;
import by.itacademy.mhl.service.impl.NoteServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final LoginService loginService = new LoginServiceImpl();
	private final NoteService noteService = new NoteServiceImpl();
	private final FindService findService = new FindServiceImpl();
	
	private ServiceFactory() {}
	
	public static ServiceFactory getInstance() {
		return instance;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public NoteService getNoteService() {
		return noteService;
	}

	public FindService getFindService() {
		return findService;
	}

	
}
