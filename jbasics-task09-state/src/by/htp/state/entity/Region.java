package by.htp.state.entity;

import java.util.ArrayList;
import java.util.List;

public class Region {

	private String name;
	private List<District> districts = new ArrayList<District>();;
	private City regionCenter;
	private double square = 0;
	
	public Region(String name, City regionCenter) {
		super();
		this.name = name;
		this.regionCenter = regionCenter;
	}

	public Region(String name, List<District> districts, City regionCenter) {
		super();
		this.name = name;
		this.districts.addAll(districts);
		this.regionCenter = regionCenter;
		for (District district : districts) {
			this.square += district.getSquare();
		}
	}
	
	public Region add(District newDistrict) {
		districts.add(newDistrict);
		square += newDistrict.getSquare();
		return this;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	public City getRegionCenter() {
		return regionCenter;
	}

	public void setRegionCenter(City regionCenter) {
		this.regionCenter = regionCenter;
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
