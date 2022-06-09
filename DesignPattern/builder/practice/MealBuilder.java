package designPattern.builder.practice;

public interface MealBuilder {
	
	void buildBurger();
	
	void buildDrink();
	
	Meal getMeal(); // result
}

class VegMealBuilder implements MealBuilder{
	
	private Meal meal = new Meal();
	
	@Override
	public void buildBurger() {
		meal.addItem(new VegBurger()); // 依業務選擇適當產出
	}

	@Override
	public void buildDrink() {
		meal.addItem(new Coke());
	}

	@Override
	public Meal getMeal() {
		return meal;
	}
	
}

class NonMealBuilder implements MealBuilder{
	
	private Meal meal = new Meal();
	
	@Override
	public void buildBurger() {
		meal.addItem(new ChickenBurger()); // 依業務選擇適當產出
	}

	@Override
	public void buildDrink() {
		meal.addItem(new Pepsi());
	}

	@Override
	public Meal getMeal() {
		return meal;
	}
	
}









