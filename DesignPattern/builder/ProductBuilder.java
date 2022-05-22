package designPattern.builder;

public interface ProductBuilder {
	
	// 建造步驟
	public void buildBody();
	
	public void insertWheels(); // 輪
	
	public void addHeadlight(); // 頭燈
	
	Product getProduct();
}

// 以下兩個Class為自訂(實現類)，依實際情況修改
class Vehicle implements ProductBuilder{
	
	private Product product = new Product();

	@Override
	public void buildBody() {
		product.add("Build body of a vehicle");
	}

	@Override
	public void insertWheels() {
		product.add("Build 4 wheels of a vehicle");
	}

	@Override
	public void addHeadlight() {
		product.add("Build 2 headlights of a vehicle");
	}

	@Override
	public Product getProduct() {
		return product;
	}
}

class MotorCycle implements ProductBuilder{
	
	private Product product = new Product();

	@Override
	public void buildBody() {
		product.add("Build body of a motorCycle");
	}

	@Override
	public void insertWheels() {
		product.add("Build 2 wheels of a motorCycle");
	}

	@Override
	public void addHeadlight() {
		product.add("Build a headlight of a motorCycle");
	}

	@Override
	public Product getProduct() {
		return product;
	}
}







