package designPattern.bridge;

public abstract class Transportation {
	
	protected Workshop workshopProduce;
	
	protected Workshop workshopAssemble;
	
	public Transportation(Workshop workshopProduce, Workshop workshopAssemble) {
		super();
		this.workshopProduce = workshopProduce;
		this.workshopAssemble = workshopAssemble;
	}

	abstract public void manufacture();
	
}

class Car extends Transportation{

	public Car(Workshop workshopProduce, Workshop workshopAssemble) {
		super(workshopProduce, workshopAssemble);
	}

	@Override
	public void manufacture() {
		System.out.println("Car ");
		workshopProduce.work();
		workshopAssemble.work();
	}
	
}

class Bike extends Transportation{

	public Bike(Workshop workshopProduce, Workshop workshopAssemble) {
		super(workshopProduce, workshopAssemble);
	}

	@Override
	public void manufacture() {
		System.out.println("Bike ");
		workshopProduce.work();
		workshopAssemble.work();
	}
}





