package by.htp.car.entity;

import java.util.List;

public class Car {

	private final Company brand;
	private Engine engine;
	private List<Wheel> wheels;
	private double volumeOfPetrol;
	private final double petrolMileage;

	public Car(Company brand, Engine engine, List<Wheel> wheels, double petrolMileage) {
		super();
		this.brand = brand;
		this.engine = engine;
		this.wheels = wheels;
		this.volumeOfPetrol = 0;
		this.petrolMileage = petrolMileage;
	}

	public void getBrand() {
		System.out.println("\n����� ������ ����: " + brand);
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public double getVolumeOfPetrol() {
		return volumeOfPetrol;
	}

	public void setVolumeOfPetrol(double volumeOfPetrol) {
		this.volumeOfPetrol = volumeOfPetrol;
	}

	public void go(double km) {
		System.out.println("------------�������");
		double petrol = km * petrolMileage / 100;
		if (volumeOfPetrol < petrol) {
			System.out.println("� ���� ������������� ���������� �������!");
			return;
		}
		if (volumeOfPetrol >= petrol && volumeOfPetrol < 2 * petrol) {
			System.out.println("� ���� ������������� ������! �� �������� �����������!");
		}
		System.out.println("�������� ���������...");
		engine.start();
		for (Wheel wheel : wheels) {
			wheel.spin();
		}
		volumeOfPetrol -= petrol;
		System.out.println("� ���� �������� " + volumeOfPetrol + " ������ �������.");
	}

	public void fillUp(double petrol) {
		System.out.println("------------��������");
		if (volumeOfPetrol + petrol > 50) {
			System.out.printf("������! ��������� ����� � ���� ����� %2.2f ������.\n", (50 - volumeOfPetrol));
			return;
		}
		volumeOfPetrol += petrol;
		System.out.println("������� �� ��������! ������ � ���� " + volumeOfPetrol + " ������ �������.");
	}

	public void changeTheWheel(String side, String part, Wheel newWheel) {
		System.out.println("------------������-������");
		Wheel wheel = new Wheel();
		for (int i = 0; i < wheels.size(); i++) {
			wheel = wheels.get(i);
			if (wheel.getPart() == part && wheel.getSide() == side) {
				wheels.set(i, newWheel);
				newWheel.setPart(part);
				newWheel.setSide(side);
				String out = new String();
				switch (part) {
				case "front":
					out += "�������� ";
					break;
				case "back":
					out += "������ ";
					break;
				default:
					System.err.println("Error!");
				}
				switch (side) {
				case "left":
					out += "����� ";
					break;
				case "right":
					out += "������ ";
					break;
				default:
					System.err.println("Error!");
				}

				System.out.println(out + "������ ������� ��������.");
			}

		}
	}

}
