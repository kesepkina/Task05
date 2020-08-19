package by.htp.state.entity;

import java.util.ArrayList;
import java.util.List;

public class District {

	private String name;
	private List<City> cities = null;
	private double square;
	
	public District(String name, double square) {
		this.name = name;
		this.square = square;
		cities = new ArrayList<City>();
	}

	public District(String name, List<City> cities, double square) {
		super();
		this.name = name;
		this.cities = new ArrayList<City>();
		this.cities.addAll(cities);
		this.square = square;
	}
	
	public District add(City newCity) {
		cities.add(newCity);
		return this;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public double getSquare() {
		return square;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
