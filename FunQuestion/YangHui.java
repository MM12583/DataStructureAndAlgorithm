import java.util.Scanner;

// 楊輝三角形 數字 = 上一層 相同位置值 + 前一位置值
public class YangHui {

	public static void main(String[] args) {
		System.out.println("輸入打印層數 : ");
		Scanner scanner = new Scanner(System.in);
		int layer = scanner.nextInt();
		
		int[][] arr = new int[layer][];
//		**可以分段開空間
		for(int i = 0 ; i < layer ; i++) {
			arr[i] = new int[i + 1];
		}
		
		
		for (int i = 0 ; i < arr.length ; i++) {
//			每一層
			int[] each = arr[i]; 
			for(int j = 0 ; j < each.length ; j++) {
				// 頭尾元素
				if(j == 0 || j == each.length - 1) {
					arr[i][j] = 1 ;
				}else {
					// 中間元素
					arr[i][j] = arr[i-1][j] + arr[i-1][j-1];						
				}
			}
		}			
		

		for(int[] each : arr) {
			for (int i : each) {
					System.out.print(i + " ");					
			}
			System.out.println("");
		}
		
		scanner.close();
	}

}
















