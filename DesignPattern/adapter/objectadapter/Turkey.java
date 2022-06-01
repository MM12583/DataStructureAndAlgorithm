package designPattern.adapter.objectadapter;

public interface Turkey {
	
	public void gobble(); // 大吃
	
	public void fly();
}

class WildTurkey implements Turkey {

	@Override
	public void gobble() {
		System.out.println("Gobble~ Gobble~");
	}

	@Override
	public void fly() {
		System.out.println("WildTurkey flew 20m");
	}
	
}











