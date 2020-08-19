package by.htp.account.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBase {

	private List<Account> accounts = new ArrayList<Account>();

	public DataBase() {
	}

	public DataBase(List<Account> accounts) {
		super();
		this.accounts.addAll(accounts);
	}

	public void showList() {
		System.out.println("The list of accounts:");
		for (Account account : accounts) {
			System.out.println(account.toString());
		}
	}

	public DataBase add(Account newAccount) {
		accounts.add(newAccount);
		return this;
	}

	public void blockAccount(String accountNumber) {
		searchAccountByNumber(accountNumber).setBlocked(true);
		System.out.println("Account is blocked.");
	}

	public void reblockAccount(String accountNumber) {
		searchAccountByNumber(accountNumber).setBlocked(false);
		System.out.println("Account is reblocked.");
	}

	private Account searchAccountByNumber(String accountNumber) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getNumber() == accountNumber) {
				return accounts.get(i);
			}
		}
		return null;
	}

	private List<Account> searchAccountsByClient(String clientName) {
		List<Account> clientsAccounts = new ArrayList<Account>();
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getClientName() == clientName) {
				clientsAccounts.add(accounts.get(i));
			}
		}
		return clientsAccounts;
	}

	public String printAccount(String accountNumber) {
		return "Required account: " + searchAccountByNumber(accountNumber).toString();
	}

	public String printAllAccountsOfClient(String clientName) {
		String accountsByClient = "";
		for (Account account : searchAccountsByClient(clientName)) {
			accountsByClient += account.toString() + "\n";
		}
		return accountsByClient;
	}

	public void sort() {
		Collections.sort(accounts);
		System.out.println("Accounts are sorted.");
	}

	public long calcWhoolSum() {

		return calcSum(this.accounts);
	}

	private long calcSum(List<Account> accountsList) {
		long sum = 0;
		for (Account account : accountsList) {
			sum += account.getBalance();
		}
		return sum;
	}

	public long calcSumByClient(String clientName) {
		List<Account> accountsList = new ArrayList<Account>();
		for (Account account : accounts) {
			if (account.getClientName().equals(clientName)) {
				accountsList.add(account);
			}
		}
		return calcSum(accountsList);
	}

	public long calcWhoolPositivSum() {

		return calcPositivSum(accounts);
	}

	private long calcPositivSum(List<Account> accountsList) {
		long sum = 0;
		for (Account account : accountsList) {
			if (account.getBalance() > 0)
				sum += account.getBalance();
		}
		return sum;
	}

	public long calcPositivSumByClient(String clientName) {
		List<Account> accountsList = new ArrayList<Account>();
		for (Account account : accounts) {
			if (account.getClientName().equals(clientName)) {
				accountsList.add(account);
			}
		}
		return calcPositivSum(accountsList);
	}

	public long calcWhoolNegativSum() {
		return calcNegativSum(accounts);
	}

	public long calcNegativSumByClient(String clientName) {
		List<Account> accountsList = new ArrayList<Account>();
		for (Account account : accounts) {
			if (account.getClientName().equals(clientName)) {
				accountsList.add(account);
			}
		}
		return calcNegativSum(accountsList);
	}

	private long calcNegativSum(List<Account> accountsList) {
		long sum = 0;
		for (Account account : accountsList) {
			if (account.getBalance() < 0)
				sum += account.getBalance();
		}
		return sum;
	}

}
