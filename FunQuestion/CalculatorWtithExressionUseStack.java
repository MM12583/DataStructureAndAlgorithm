package dataStructureAndAlgorithm;

public class CalculatorWtithExressionUseStack {

	public static void main(String[] args) {
		String expression = "7+2*6-2";
		
		ArrayStackForCal numStack = new ArrayStackForCal(10);
		ArrayStackForCal operStack = new ArrayStackForCal(10);
		
		int index = 0, right = 0, left=0, oper=0, result = 0;
		char ch = ' ';
		
		while(index < expression.length()) {
			ch = expression.charAt(index);
			if (isOper(ch)) { // 是否為運算符
				if (!operStack.isEmpty()) { 
					//*** 如果晚入棧的符號優先級小於等於前一個符號，代表前一個符號可以先計算了
					if (priority(ch) <= priority(operStack.peek())) {
						// 取兩數計算後入棧
						right = numStack.pop();
						left = numStack.pop();
						oper = operStack.pop();
						result = cal(right, left, oper);
						numStack.push(result);
						// 此次的符號入棧
						operStack.push(ch);
					} else {
						operStack.push(ch);
					}
				}else {
					operStack.push(ch); 
				}
			}else {
				numStack.push(Integer.valueOf(String.valueOf(ch))); // *char 須轉數字
			}
			
			index++; // 遍歷指針
		}
		
		// 最後剩的計算
		while(!operStack.isEmpty()) { // 沒有運算符表示已結束
			right = numStack.pop();
			left = numStack.pop();
			oper = operStack.pop();
			result = cal(right, left, oper);
			numStack.push(result);
		}
		
		System.out.printf("Expression %s = %d \n", expression, numStack.pop());
	}

	// 運算符號優先級數字表示
	public static int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1;
		}
	}

	// 判斷是否是運算符
	public static boolean isOper(char c) {
		return c == '*' || c == '/' || c == '+' || c == '-';
	}

	public static int cal(int right, int left, int oper) {
		int result = 0;
		switch (oper) {
		case '+':
			result = right + left;
			break;
		case '-':
			result = left - right; //*** 減法 : stack pop 順序, 後出為被減數
			break;
		case '*':
			result = right * left;
			break;
		case '/':
			result = left / right; //*** 除法 : stack pop 順序, 後出為被除數
			break;
		default:
			break;
		}
		return result;
	}
}

class ArrayStackForCal {

	private int maxSize;

	private int[] stack;

	private int top = -1; // 棧頂

	public ArrayStackForCal(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	
	//查看棧頂，不出棧
	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("棧空, 沒有數據");
		}
		return stack[top];
	}
	
	// 取
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("棧空, 沒有數據");
		}
		return stack[top--]; // top--後做
	}

	// 加
	public void push(int value) {
		if (isFull()) {
			System.out.println("棧滿");
			return;
		}
		top++;
		stack[top] = value;

	}

	// 遍歷
	public void list() {
		if (isEmpty()) {
			System.out.println("棧空, 沒有數據");
			return;
		}

		for (int i = top; i >= 0; i--) { // **
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











