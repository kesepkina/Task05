package by.itacademy.mhl.controller.impl;

import by.itacademy.mhl.controller.Command;

public class NoSuchCommand implements Command{

	@Override
	public String execute(String[] params) {
		return "Such command doesn't exist.";
	}

}
