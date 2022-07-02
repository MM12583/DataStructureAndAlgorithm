package designPattern.bridge;


// 定義行為類別
public abstract class Workshop {
	
	abstract public void work();
}

// 實作類別
class Produce extends Workshop{

	@Override
	public void work() {
		System.out.println("Produced");
	}
	
}

class Assemble extends Workshop{

	@Override
	public void work() {
		System.out.println("And Assembled");
	}
	
}








