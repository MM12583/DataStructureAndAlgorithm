package designPattern.prototype;

public class Client {

	public static void main(String[] args) {
		
		Sheep sheep = new Sheep("Tom", 1, "白色");
		Sheep friend = new Sheep("Allen", 2, "橘色");
		
		sheep.setFriend(friend);
		
//		Sheep sheep2 = (Sheep) sheep.deepCloneWithReflect();
		Sheep sheep2 = (Sheep) sheep.deepCloneWithSerialize();
		
		System.out.println(sheep.getFriend() == sheep2.getFriend()); // true(淺), false(深)
		System.out.println(sheep2.getFriend());
		
	}

}
