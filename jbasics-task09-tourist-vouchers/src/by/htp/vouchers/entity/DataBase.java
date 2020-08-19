package by.htp.vouchers.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DataBase {

	List<TouristVoucher> vouchers = new ArrayList<TouristVoucher>();

	public DataBase add(TouristVoucher voucher) {
		vouchers.add(voucher);
		return this;
	}

	public void print(String message, List<TouristVoucher> vouchers) {
		System.out.println(message + ":");
		int i = 0;
		for (TouristVoucher voucher : vouchers) {
			i++;
			System.out.println(i + ". " + voucher.toString());
		}
		System.out.println();
	}

	public void printAll() {
		print("All vouchers", this.vouchers);
	}

	public List<TouristVoucher> getVouchersByOptions(Type type) {
		List<TouristVoucher> vouchers = new ArrayList<TouristVoucher>();
		for (TouristVoucher voucher : this.vouchers) {
			if (voucher.getType().equals(type)) {
				vouchers.add(voucher);
			}
		}
		return vouchers;
	}

	public List<TouristVoucher> getVouchersByOptions(String country) {
		List<TouristVoucher> vouchers = new ArrayList<TouristVoucher>();
		for (TouristVoucher voucher : this.vouchers) {
			if (voucher.getCountry().equals(country)) {
				vouchers.add(voucher);
			}
		}
		return vouchers;
	}

	public void sortByCountry() {
		Collections.sort(vouchers, new Comparator<TouristVoucher>() {
			public int compare(TouristVoucher o1, TouristVoucher o2) {
				return o1.getCountry().compareTo(o2.getCountry());
			}
		});
		System.out.println("\nSorted by country.\n");
	}

	public void sortByPrice() {
		Collections.sort(vouchers, new Comparator<TouristVoucher>() {
			public int compare(TouristVoucher o1, TouristVoucher o2) {
				return (o1.getPricePerDay() - o2.getPricePerDay());
			}
		});
		System.out.println("\nSorted by price.\n");
	}

	public void sortByDate() {
		Collections.sort(vouchers, new Comparator<TouristVoucher>() {
			public int compare(TouristVoucher o1, TouristVoucher o2) {
				return o1.getDateOfDeparture().compareTo(o2.getDateOfDeparture());
			}
		});
		System.out.println("\nSorted by date.\n");
	}

}
