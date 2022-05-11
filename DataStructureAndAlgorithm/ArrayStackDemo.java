package dataStructureAndAlgorithm;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(4);
		String key = "";
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		
		while(loop) {
			System.out.println("show : 顯示數據");
			System.out.println("exit : 離開");
			System.out.println("push : 加入數據");
			System.out.println("pop : 取出數據");
			System.out.println("請輸入選擇");
			key = scanner.next();
			switch (key) {
			case "show":
				stack.list();
				break;
			case "exit":
				scanner.close();
				loop = false;
				System.out.println("退出程序");
				break;
			case "push":
				System.out.println("請輸入一個數");
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					System.out.printf("出戰數據 : %d \n" ,stack.pop());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			
			default:
				System.out.println("無效指令");
				break;
			}
		}
	}

}

class ArrayStack {

	private int maxSize;

	private int[] stack;

	private int top = -1; // 棧頂

	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	
	//取
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("棧空, 沒有數據");//須return,所以用throw中斷
		}
//		int topValue = stack[top]; // 取得棧頂數據
//		top--;
//		return topValue;
		return stack[top--]; // top--後做
	}
	
	//加
	public void push(int value) {
		if (isFull()) {
			System.out.println("棧滿");
			return;
		}
		top++;
		stack[top] = value;

	}
	
	//遍歷
	public void list() {
		if (isEmpty()) {
			System.out.println("棧空, 沒有數據");
			return;
		}
		
		for (int i = top; i >= 0; i--) { //**
			System.out.printf("stack[%d]=%d \n", i, stack[i]);
		}
	}
	
	public boolean isFull() {
		return top == maxSize - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}
}











