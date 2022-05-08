package dataStructureAndAlgorithm;

import java.util.Scanner;

// 應用於叫號系統
public class QueueArray {

	public static void main(String[] args) {
		
		ArraQueue aq = new ArraQueue(4); // maxSize = 3
		
		char key = ' '; //接收用戶輸入
		Scanner sc = new Scanner(System.in);
		
		boolean loop = true;
		while(loop) {
			System.out.println("s(show) : 顯示隊列");
			System.out.println("e(exit) : 退出隊列");
			System.out.println("a(add) : 加入隊列");
			System.out.println("g(get) : 從隊列取出數據");
			System.out.println("h(head) : 查看隊列首數據");
			
			key = sc.next().charAt(0); // 接收一個字符
			
			switch (key) {
			case 's':
				aq.showQueue();
				break;
			case 'a':
				System.out.println("請輸入一個數字");
				int value = sc.nextInt();
				aq.addQueue(value);
				break;
			case 'g':
				try {
					int result = aq.getQueue();
					System.out.println("取出的數據為 : " + result);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int result = aq.peek();
					System.out.println("隊列首數據為 : " + result);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				sc.close();
				loop = false;
				System.out.println("退出程序");
				break;
			default:
				break;
			}
		}
	}

}

class ArraQueue {
	
	private int maxSize; //數組最大容量
	
	private int front; // 隊列前端
	
	private int rear;   // 隊列後端
	
	private int[] arr; // 模擬隊列

	public ArraQueue(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
		// 非環形隊列作法
//		front = -1; // 指向隊列首([0])的前一個位置(沒有數據[-1])
//		rear = -1; // 指向隊列尾具體位置 *默認沒有數據
		// 環形隊列作法
		front = 0; // 指向隊列首具體位置
		rear = 0; // 指向隊列尾後一個位置(該位置為空ps:預留空間)
		// 有效數據個數 : (rear + maxSize -front) % maxSize // 跑步領先一圈又未追過落後者情況想像
	}
	
	//滿否
	public boolean isFull() {
//		return rear == maxSize - 1;
		return (rear + 1) % maxSize == front;
	}
	
	//空否
	public boolean isEmpty() {
		return rear == front;
	}
	
	// 加入
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("隊列已滿,不能再加入數據");
			return;
		}
		// 非環形隊列作法
//		rear ++;
//		arr[rear] = n;
		
		// 環形隊列作法
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}
	
	// 取值(首位)
	public int getQueue() {
		if (isEmpty()) {
			// throw 會直接停止 同return;
			throw new RuntimeException("現在沒有任何數據");
		}
		// 非環形隊列作法
//		front ++; //後移 because 一開始設定為首位前一個位置
//		return arr[front];
		
		// 環形隊列作法
//		1. front 保存到臨時變量
//		2. front 後移
//		3. 返回保存變量(front)
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
		
	}
	
	// 顯示所有數據
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("現在沒有任何數據");
			return;
		}
		// 非環形隊列作法
//		System.out.println(Arrays.toString(arr));
		
		// 環形隊列作法
		for (int i = front; i < front + size() ; i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
		
	}
	
	// 有效數據個數
	public int size() {
		return (rear + maxSize -front) % maxSize ;
	}
	
	// 顯示數據首
	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("現在沒有任何數據");
		}
//		return arr[front + 1];
		return arr[front];
	}
	
}














