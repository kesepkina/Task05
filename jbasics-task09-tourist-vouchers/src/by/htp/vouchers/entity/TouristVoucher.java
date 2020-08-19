package by.htp.vouchers.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TouristVoucher {

	private int pricePerDay;
	private int price;
	private Type type;
	private Transport transport;
	private String country;
	private Meals numberOfMealsPerDay;
	private int numberOfDays;
	private GregorianCalendar dateOfDeparture;
	private GregorianCalendar dateOfArriving;

	public TouristVoucher(int pricePerDay, Type type, String country, GregorianCalendar dateOfDeparture) {
		super();
		this.pricePerDay = pricePerDay;
		this.type = type;
		this.country = country;
		this.dateOfDeparture = dateOfDeparture;
	}

	@Override
	public String toString() {
		if (this.transport != null)
			return "TouristVoucher [type=" + type + ", transport=" + transport + ", country=" + country
					+ ", numberOfMealsPerDay=" + numberOfMealsPerDay + ", numberOfDays=" + numberOfDays
					+ ", dateOfDeparture=" + dateOfDeparture.get(Calendar.DATE) + "."
					+ dateOfDeparture.get(Calendar.MONTH) + "." + dateOfDeparture.get(Calendar.YEAR)
					+ ", dateOfArriving=" + dateOfArriving.get(Calendar.DATE) + "." + dateOfArriving.get(Calendar.MONTH)
					+ "." + dateOfArriving.get(Calendar.YEAR) + ", price=" + price + "euro]";
		else
			return "TouristVoucher [type=" + type + ", country=" + country + ", dateOfDeparture="
					+ dateOfDeparture.get(Calendar.DATE) + "." + dateOfDeparture.get(Calendar.MONTH) + "."
					+ dateOfDeparture.get(Calendar.YEAR) + ", pricePerDay=" + pricePerDay + " euro]";
	}

	public void add(Meals numberOfMealsPerDay, int numberOfDays, Transport transport) {
		this.numberOfMealsPerDay = numberOfMealsPerDay;
		this.numberOfDays = numberOfDays;
		price = pricePerDay * numberOfDays;
		this.dateOfArriving = (GregorianCalendar) this.dateOfDeparture.clone();
		this.dateOfArriving.add(Calendar.DAY_OF_MONTH, numberOfDays);
		this.transport = transport;
	}

	public int getPrice() {
		return price;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
		price = pricePerDay * numberOfDays;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Meals getNumberOfMealsPerDay() {
		return numberOfMealsPerDay;
	}

	public void setNumberOfMealsPerDay(Meals numberOfMealsPerDay) {
		this.numberOfMealsPerDay = numberOfMealsPerDay;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
		this.dateOfArriving.add(Calendar.DAY_OF_MONTH, numberOfDays);
	}

	public Calendar getDateOfArriving() {
		return dateOfArriving;
	}

	public void setDateOfArriving(GregorianCalendar dateOfArriving) {
		this.dateOfArriving = dateOfArriving;
	}

	public Calendar getDateOfDeparture() {
		return dateOfDeparture;
	}

}
