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
		System.out.println("\nМарка вашего авто: " + brand);
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
		System.out.println("------------ПОЕЗДКА");
		double petrol = km * petrolMileage / 100;
		if (volumeOfPetrol < petrol) {
			System.out.println("В баке недостаточное количество бензина!");
			return;
		}
		if (volumeOfPetrol >= petrol && volumeOfPetrol < 2 * petrol) {
			System.out.println("В баке заканчивается бензин! Не забудьте заправиться!");
		}
		System.out.println("Запускаю двигатель...");
		engine.start();
		for (Wheel wheel : wheels) {
			wheel.spin();
		}
		volumeOfPetrol -= petrol;
		System.out.println("В баке осталось " + volumeOfPetrol + " литров бензина.");
	}

	public void fillUp(double petrol) {
		System.out.println("------------ЗАПРАВКА");
		if (volumeOfPetrol + petrol > 50) {
			System.out.printf("Отмена! Свободный объём в баке равен %2.2f литров.\n", (50 - volumeOfPetrol));
			return;
		}
		volumeOfPetrol += petrol;
		System.out.println("Спасибо за заправку! Теперь в баке " + volumeOfPetrol + " литров бензина.");
	}

	public void changeTheWheel(String side, String part, Wheel newWheel) {
		System.out.println("------------ЗАМЕНА-КОЛЕСА");
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
					out += "Переднее ";
					break;
				case "back":
					out += "Заднее ";
					break;
				default:
					System.err.println("Error!");
				}
				switch (side) {
				case "left":
					out += "левое ";
					break;
				case "right":
					out += "правое ";
					break;
				default:
					System.err.println("Error!");
				}

				System.out.println(out + "колесо успешно заменено.");
			}

		}
	}

}
