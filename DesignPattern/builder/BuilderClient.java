package designPattern.builder;

public class BuilderClient {

	public static void main(String[] args) {
		Director director = new Director();
		
		ProductBuilder vehicleBuilder = new Vehicle();
		ProductBuilder motorCycleBuilder = new MotorCycle();
		
		director.construct(vehicleBuilder);
		director.construct(motorCycleBuilder);
		
		Product vehicle = vehicleBuilder.getProduct();
		Product motorCycle = motorCycleBuilder.getProduct();
		
		System.out.println("=======Vehicle=======");
		vehicle.show();
		System.out.println("=======MotorCycle=======");
		motorCycle.show();
	}

}








