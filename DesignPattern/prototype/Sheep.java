package designPattern.prototype;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Sheep implements Cloneable {
	
	private String name; // String : Object 但為final
	
	private int age;
	
	private String color;
	
	private String address = "南投";
	
	private Sheep friend;
	
	public Sheep() { // reflect newInstance 須要默認建構式
	}

	public Sheep(String name, int age, String color) {
		this.name = name;
		this.age = age;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Sheep getFriend() {
		return friend;
	}

	public void setFriend(Sheep friend) {
		this.friend = friend;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sheep [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", color=");
		builder.append(color);
		builder.append(", address=");
		builder.append(address);
		builder.append(", friend=");
		builder.append(friend);
		builder.append("]");
		return builder.toString();
	}

	// 默認(淺拷貝)
//	@Override
//	protected Object clone() {
//		
//		Sheep sheep = null;
//		
//		try {
//			sheep = (Sheep) super.clone();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		return sheep;
//	}
	
	// 默認(深拷貝)
	@Override
	protected Object clone() {
		
		Sheep sheep = null;
		
		try {
			// 基本數據及String clone
			sheep = (Sheep) super.clone();
			
			// 引用類型處理 call by value
			Field[] fields = sheep.getClass().getDeclaredFields();
			
			for(Field f : fields) {
				f.setAccessible(true);
				
				// * getClass return Object 無法判斷 isPrimitive()
				if (!f.getType().isPrimitive() &&  
					 f.getType() != String.class && // 排除String
					 f.get(sheep) != null) // sheep 該屬性值不為空
				{ 
					// 屬性名稱轉換大寫取set/get method
					StringBuilder firstUpperCase = new StringBuilder(f.getName());
					firstUpperCase.replace(0, 1, f.getName().substring(0,1).toUpperCase());
					Method methodSet = 
							sheep.getClass().getDeclaredMethod("set" + firstUpperCase, f.getType());
					Method methodGet = 
							sheep.getClass().getDeclaredMethod("get" + firstUpperCase);
					
					// 創建一個 需要深拷貝的類別 & 新物件
					Object oriO = methodGet.invoke(sheep);
					Object newO = oriO.getClass().newInstance();
					
					Field[] oriOfields = oriO.getClass().getDeclaredFields();
					
					// 賦值
					for(int i = 0 ; i < oriOfields.length ; i++) {
						if (oriOfields[i].get(oriO) != null) {
							
							StringBuilder valueName = new StringBuilder(oriOfields[i].getName());
							valueName.replace(0, 1, oriOfields[i].getName().substring(0,1).toUpperCase());
							Method methodSetValue = 
									sheep.getClass().getDeclaredMethod("set" + valueName, oriOfields[i].getType());
							
							methodSetValue.invoke(newO, oriOfields[i].get(oriO));
							
							System.out.println(methodSetValue.toString() + " : " + oriOfields[i].get(oriO));
						}
					}
					
					methodSet.invoke(sheep, newO);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sheep;
	}
	
}









