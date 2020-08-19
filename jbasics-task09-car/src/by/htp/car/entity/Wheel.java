package by.htp.car.entity;

public class Wheel {

	private String side;
	private String part;
	
	public Wheel() {
		
	}

	public Wheel(String side, String part) {
		super();
		this.side = side;
		this.part = part;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public void spin() {
		String spin = new String();
		if (part == "front") {
			spin += "�������� ";
		} else {
			spin += "������ ";
		}
		if (side == "left") {
			spin += "����� ";
		} else {
			spin += "������ ";
		}
		System.out.println(spin + "������ ��������.");
	}

}
