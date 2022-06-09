package designPattern.builder.practice;

public class Client {

	public static void main(String[] args) {
		DirectorPractice director = new DirectorPractice();
		
		MealBuilder vegBuilder = new VegMealBuilder();
		MealBuilder nonVegBuilder = new NonMealBuilder();
		
		// making veg meal
		System.out.println("===== Making Veg Meal =====");
		director.construct(vegBuilder);
		Meal vegMeal = vegBuilder.getMeal();
		vegMeal.showItems();
		System.out.println("Total Cost : " + vegMeal.getCost());
		
		// making non veg meal
		System.out.println("===== Making Non Veg Meal =====");
		director.construct(nonVegBuilder);
		Meal nonVegMeal = nonVegBuilder.getMeal();
		nonVegMeal.showItems();
		System.out.println("Total Cost : " + nonVegMeal.getCost());
	}

}
