package designPattern.bridge;

public class Client {

	public static void main(String[] args) {
		
		Workshop produce = new Produce();
		Workshop assemble = new Assemble();
		
		Transportation transportationCar = new Car(produce, assemble);
		transportationCar.manufacture();
		
		Transportation transportationBike = new Bike(produce, assemble);
		transportationBike.manufacture();
	}

}





