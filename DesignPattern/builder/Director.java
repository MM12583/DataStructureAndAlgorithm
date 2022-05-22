package designPattern.builder;

// 使用方
public class Director {
	
	ProductBuilder myBuilder;

	public void construct(ProductBuilder myBuilder) {
		this.myBuilder = myBuilder;
		myBuilder.buildBody();
		myBuilder.insertWheels();
		myBuilder.addHeadlight();
	}
	
}
