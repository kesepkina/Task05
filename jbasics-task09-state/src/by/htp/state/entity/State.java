package by.htp.state.entity;

import java.util.ArrayList;
import java.util.List;

public class State {

	private String name;
	private List<Region> regions = new ArrayList<Region>();
	private City capital;
	private double square = 0;

	public State(String name, City capital) {
		super();
		this.name = name;
		this.capital = capital;
		for (Region region : regions) {
			square += region.getSquare();
		}
	}

	public State(String name, List<Region> regions, City capital) {
		super();
		this.name = name;
		this.regions.addAll(regions);
		this.capital = capital;
		for (Region region : regions) {
			square += region.getSquare();
		}
	}

	public State add(Region newRegion) {
		regions.add(newRegion);
		square += newRegion.getSquare();
		return this;
	}

	public int getNumberOfRegions() {
		return regions.size();
	}

	public String getRegionsCenters() {
		String formattedInfo = "";
		formattedInfo += "Region\t\tCenter\n";
		for (Region region : regions) {
			formattedInfo += region.getName() + "\t-\t" + region.getRegionCenter().getName() + "\n";
		}
		return formattedInfo;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public City getCapital() {
		return capital;
	}

	public void setCapital(City capital) {
		this.capital = capital;
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
