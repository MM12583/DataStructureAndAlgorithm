package designPattern.builder;

import java.util.LinkedList;

// 最終結果
public class Product {
	
	private LinkedList<String> parts;

	public Product() {
		parts = new LinkedList<String>();
	}
	
	public void add(String part) {
		parts.addLast(part);
	}
	
	public void show () {
		System.out.println("Product completed as below");
		parts.forEach(System.out::println);
	}
	
}







