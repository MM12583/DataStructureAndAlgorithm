package designPattern.builder.practice;

public class DirectorPractice {
	
	MealBuilder myBuilder;
	
	public void construct(MealBuilder builder) {
		myBuilder = builder;
		myBuilder.buildBurger();
		myBuilder.buildDrink();
		myBuilder.getMeal();
	}
}
