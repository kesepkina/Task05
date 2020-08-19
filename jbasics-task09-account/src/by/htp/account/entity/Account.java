package by.htp.account.entity;

import java.util.Date;

public class Account implements Comparable<Account> {

	private String number;
	private String clientName;
	private String name;
	private long balance;
	private Date dateOfOpening;
	private boolean isBlocked = false;

	public Account() {
	}

	public Account(String number, String clientName, String name, long balance) {
		super();
		this.number = number;
		this.clientName = clientName;
		this.name = name;
		this.balance = balance;
		this.dateOfOpening = new Date();
	}

	String getNumber() {
		return number;
	}

	void setNumber(String number) {
		this.number = number;
	}

	String getClientName() {
		return clientName;
	}

	void setClientName(String clientName) {
		this.clientName = clientName;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	long getBalance() {
		return balance;
	}

	void setBalance(long balance) {
		this.balance = balance;
	}

	Date getDateOfOpening() {
		return dateOfOpening;
	}

	void setDateOfOpening(Date dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}

	boolean isBlocked() {
		return isBlocked;
	}

	void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (balance ^ (balance >>> 32));
		result = prime * result + ((clientName == null) ? 0 : clientName.hashCode());
		result = prime * result + ((dateOfOpening == null) ? 0 : dateOfOpening.hashCode());
		result = prime * result + (isBlocked ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (balance != other.balance)
			return false;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		if (dateOfOpening == null) {
			if (other.dateOfOpening != null)
				return false;
		} else if (!dateOfOpening.equals(other.dateOfOpening))
			return false;
		if (isBlocked != other.isBlocked)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	public int compareTo(Account compareAccount) {
		String compareNumber = ((Account) compareAccount).getNumber();

		return this.number.compareTo(compareNumber);
	}

	@Override
	public String toString() {
		String blocked;
		if (isBlocked) {
			blocked = "is blocked";
		} else {
			blocked = "isn't blocked";
		}
		return number + ", \"" + name + "\", clientName=" + clientName + ", balance=" + balance
				+ " euro, dateOfOpening=" + dateOfOpening + ", " + blocked;
	}

}
