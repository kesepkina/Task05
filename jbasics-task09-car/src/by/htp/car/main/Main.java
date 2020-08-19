package by.htp.car.main;

import java.util.ArrayList;
import java.util.List;

import by.htp.car.entity.*;

public class Main {

	public static void main(String[] args) {

		List<Wheel> wheels = new ArrayList<Wheel>();

		wheels.add(new Wheel("left", "front"));
		wheels.add(new Wheel("right", "front"));
		wheels.add(new Wheel("left", "back"));
		wheels.add(new Wheel("right", "back"));

		Car car1 = new Car(Company.MERCEDES, new Engine(), wheels, 7);

		car1.go(15);

		car1.fillUp(50);

		car1.go(105);

		car1.fillUp(10);

		Wheel newWheel = new Wheel();
		car1.changeTheWheel("left", "back", newWheel);

		car1.getBrand();
	}

}
