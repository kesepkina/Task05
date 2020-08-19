package by.htp.vouchers.main;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import by.htp.vouchers.entity.*;

public class Main {

	public static void main(String[] args) {

		DataBase database = new DataBase();

		GregorianCalendar date = new GregorianCalendar();
		date.set(2020, 9, 12);

		database.add(new TouristVoucher(100 , Type.RELAXATION, "Turkey", (GregorianCalendar) date.clone()));

		date.set(2020, 10, 18);
		database.add(new TouristVoucher(89, Type.EXCURSIONS, "Turkey", (GregorianCalendar) date.clone()));

		date.set(2021, 2, 28);
		database.add(new TouristVoucher(219, Type.CRUISE, "Italy", (GregorianCalendar) date.clone()));

		date.set(2021, 2, 20);
		database.add(new TouristVoucher(67, Type.MEDICAL, "Belarus", (GregorianCalendar) date.clone()));

		date.set(2020, 11, 28);
		database.add(new TouristVoucher(80, Type.SHOPPING, "Poland", (GregorianCalendar) date.clone()));

		database.printAll();
		
		database.sortByCountry();
		database.printAll();
		
		database.sortByPrice();
		database.printAll();
		
		database.sortByDate();
		database.printAll();

		List<TouristVoucher> requiredVouchers = new ArrayList<TouristVoucher>();
		
		requiredVouchers.addAll(database.getVouchersByOptions(Type.SHOPPING));
		database.print("Shopping-vouchers", requiredVouchers);
		
		requiredVouchers.clear();

		requiredVouchers.addAll(database.getVouchersByOptions("Turkey"));
		database.print("Vouchers to Turkey", requiredVouchers);

		System.out.println("Input the number of voucher:\n1");

		int i = 1;
		System.out.println();

		Transport transport;
		Meals numberOfMealsPerDay;
		int numberOfDays;

		System.out.println("Choose transport, number of meals per day and number of days abroad:\ncar\none_daily\n14");

		transport = Transport.valueOf("car".toUpperCase());
		numberOfMealsPerDay = Meals.valueOf("one_daily".toUpperCase());
		numberOfDays = 14;
		System.out.println();

		requiredVouchers.get(i - 1).add(numberOfMealsPerDay, numberOfDays, transport);
		System.out.println("Your voucher:\n" + requiredVouchers.get(i - 1).toString());

	}

}
