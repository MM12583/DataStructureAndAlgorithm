package designPattern.adapter.objectadapter;

// Turkey 適應 Duck
public class TurkeyAdapter implements Duck{
	
	Turkey turkey;

	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}
	
	// 以下方法適應(達到相同目的) 
	@Override
	public void quack() {
		turkey.gobble();
		
	}

	@Override
	public void fly() {
		for (int i = 0; i < 5; i++) {
			turkey.fly();
		}
	}
	
	
}



