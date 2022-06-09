package designPattern.builder.practice;

public interface Item {
	
	public String name();
	
	public Packing packing();
	
	public float price();
	
}

abstract class Burger implements Item{
	
	@Override
	public Packing packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();
	
}

class VegBurger extends Burger{

	@Override
	public float price() {
		return 7.5f;
	}

	@Override
	public String name() {
		return "Veg Burger";
	}
}

class ChickenBurger extends Burger{

	@Override
	public float price() {
		return 8.5f;
	}

	@Override
	public String name() {
		return "Chicken Burger";
	}
}

abstract class ColdDrink implements Item{
	
	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();
	
}

class Pepsi extends ColdDrink{

	@Override
	public float price() {
		return 1.5f;
	}

	@Override
	public String name() {
		return "Pepsi";
	}
}

class Coke extends ColdDrink{

	@Override
	public float price() {
		return 1.25f;
	}

	@Override
	public String name() {
		return "Coke";
	}
}





