package designPattern.adapter.objectadapter;

public class ObjAdapterClient {

	public static void main(String[] args) {
		
		MallardDuck mallardDuck = new MallardDuck();
		
		WildTurkey wildTurkey = new WildTurkey();
		
		Duck turkeyAdapter = new TurkeyAdapter(wildTurkey);
		
		System.out.println("====Turkey行為===");
		wildTurkey.gobble();
		wildTurkey.fly();
		
		System.out.println("====Duck行為===");
		testDuck(mallardDuck);
		
		System.out.println("====Turkey做出Duck行為===");
		testDuck(turkeyAdapter);
	}
	
	static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
}








