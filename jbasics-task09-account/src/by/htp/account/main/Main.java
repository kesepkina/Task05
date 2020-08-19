package by.htp.account.main;

import by.htp.account.entity.*;

public class Main {

	public static void main(String[] args) {

		DataBase accounts = new DataBase()
				.add(new Account("40817810099910004312", "Alebekov", "Basic acc", 980_000_000l))
				.add(new Account("40817810099910004112", "Alebekov", "For Children", 500_000l))
				.add(new Account("40817810099910003242", "Gurinovich", "Business", -2_000_000l));

		accounts.blockAccount("40817810099910003242");
		System.out.println();

		accounts.showList();
		System.out.println();

		accounts.reblockAccount("40817810099910003242");
		System.out.println();

		accounts.sort();
		accounts.showList();
		System.out.println();

		System.out.println(accounts.printAccount("40817810099910003242"));
		System.out.println();

		System.out.println("Alebekov's accounts:\n" + accounts.printAllAccountsOfClient("Alebekov"));

		System.out.println("Sum of accounts' balance = " + accounts.calcWhoolSum() + " euro");
		System.out.println("Sum of positiv accounts' balance = " + accounts.calcWhoolPositivSum() + " euro");
		System.out.println("Sum of negativ accounts' balance = " + accounts.calcWhoolNegativSum() + " euro");

		System.out.println("Sum of Alebekov's balance = " + accounts.calcSumByClient("Alebekov") + " euro");
		System.out.println("Sum of positiv Alebekov's accounts' balance = "
				+ accounts.calcPositivSumByClient("Alebekov") + " euro");
		System.out.println("Sum of negativ Alebekov's accounts' balance = "
				+ accounts.calcNegativSumByClient("Alebekov") + " euro");
	}

}
