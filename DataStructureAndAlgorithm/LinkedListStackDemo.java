package dataStructureAndAlgorithm;

import java.util.Scanner;

public class LinkedListStackDemo {

	public static void main(String[] args) {
		LinkedListStack stack = new LinkedListStack(4);
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
					System.out.printf("出棧數據 : %d \n" ,stack.pop());
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

// 頭插法
class LinkedListStack {

	private int maxSize;

	private LinkedListStackDemoNode head;

	public LinkedListStack(int maxSize) {
		super();
		this.maxSize = maxSize;
	}
	
	//取
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("棧空, 沒有數據");//須return,所以用throw中斷
		}
		
		int value = head.getValue();
		head = head.getNext();
		
		return value;
	}
	
	// 加
	public void push(int value) {
		if (isFull()) {
			System.out.println("棧滿");
			return;
		}
		
		if (isEmpty()) {
			head = new LinkedListStackDemoNode(value);
			head.setNo(0);
		} else {
			LinkedListStackDemoNode node = new LinkedListStackDemoNode(value);
			node.setNext(head);
			node.setNo(head.getNo() + 1);
			head = node;
		}
	}

	// 遍歷 後制前
	public void list() {
		if (isEmpty()) {
			System.out.println("棧空, 沒有數據");
			return;
		}
		
		LinkedListStackDemoNode helper = head;
		
		while(helper != null) {
			System.out.printf("stack[%d]=%d \n", helper.getNo(), helper.getValue());
			helper = helper.getNext();
		}
		
	}

	public boolean isFull() {
		return head == null ? false : head.getNo() == maxSize - 1;
	}

	public boolean isEmpty() {
		return head == null;
	}

}

class LinkedListStackDemoNode {

	private int no;

	private int value;

	private LinkedListStackDemoNode next;

	public LinkedListStackDemoNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public LinkedListStackDemoNode getNext() {
		return next;
	}

	public void setNext(LinkedListStackDemoNode next) {
		this.next = next;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

}




