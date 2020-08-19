package by.itacademy.mhl.main;

import by.itacademy.mhl.controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();

		String userRequest;
		String response;

		userRequest = "logination\tlogin=bbb\tpassword=ccc";
		response = controller.doAction(userRequest);
		System.out.println(response);

		System.out.println();

		userRequest = "registration\tlogin=rbr\tpassword=ccc\tname=Anton\tsurname=Kalinin\temail=kalinin@gmail.com\trole=USER";
		response = controller.doAction(userRequest);
		System.out.println(response);

		System.out.println();

		userRequest = "editing\tid=1\tcategories=Java\tname=Effective Java\tauthor=Ekkel";
		response = controller.doAction(userRequest);
		System.out.println(response);

		System.out.println();

		userRequest = "adding\tid=12\tcategories=Roman,Classic\tname=The Human Bondage\tauthor=Sommerset Moem";
		response = controller.doAction(userRequest);
		System.out.println(response);

		System.out.println();

		userRequest = "allcatalogue";
		response = controller.doAction(userRequest);
		System.out.println(response);

		System.out.println();

		userRequest = "findbyauthor\tauthor=Sierra";
		response = controller.doAction(userRequest);
		System.out.println(response);

		System.out.println();

		userRequest = "findbycategory\tcategory=java";
		response = controller.doAction(userRequest);
		System.out.println(response);

		System.out.println();

		userRequest = "deletenote\tid=12";
		response = controller.doAction(userRequest);
		System.out.println(response);

		System.out.println();

	}

}
