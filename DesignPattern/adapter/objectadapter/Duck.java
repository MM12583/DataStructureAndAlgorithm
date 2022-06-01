package designPattern.adapter.objectadapter;

public interface Duck {
	
	public void quack();
	
	public void fly();
}

class MallardDuck implements Duck{ //綠頭鴨

	@Override
	public void quack() {
		System.out.println("Quack~ Quack~");
	}

	@Override
	public void fly() {
		System.out.println("MallardDuck flew 100 m");
	} 
	
	
	
}













