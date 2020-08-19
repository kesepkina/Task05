package by.htp.state.main;

import by.htp.state.entity.*;

public class Main {

	public static void main(String[] args) {

		City minsk = new City("Minsk");

		District minskDistrict = new District("Minsk", 1902.66);
		minskDistrict.add(new City("Заславль"));

		District borisov = new District("Borisiv", 1987.63).add(new City("Borisov"));
		District logoisk = new District("Logoisk", 2365.02).add(new City("Logoisk"));

		Region minskRegion = new Region("Minsk", minsk);
		minskRegion.add(minskDistrict).add(logoisk).add(borisov);

		City grodno = new City("Grodno");
		District grodnoDistrict = new District("Grodno", 2594.05).add(grodno);
		District iwye = new District("Iwye", 1841).add(new City("Iwye"));

		Region grodnoRegion = new Region("Grodno", grodno);
		grodnoRegion.add(grodnoDistrict).add(iwye);
		
		//...

		State belarus = new State("Republic of Belarus", minsk);
		belarus.add(minskRegion).add(grodnoRegion);

		System.out.println("The capital of " + belarus.getName() + " is " + belarus.getCapital().getName());
		System.out.println("Number of regions equals " + belarus.getNumberOfRegions());
		System.out.println("Square of the state equals " + belarus.getSquare() + " sq km");
		System.out.println("Centers of the regions:\n" + belarus.getRegionsCenters());

	}

}
