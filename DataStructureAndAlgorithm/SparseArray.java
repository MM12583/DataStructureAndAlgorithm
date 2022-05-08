package dataStructureAndAlgorithm;

import java.util.Arrays;

public class SparseArray {

	public static void main(String[] args) {
		
//		稀疏數組用於二維陣列中庸有大量沒有意義之值或相同值 (地圖、棋盤...)
//		轉換後index 0 原始數據"行"(0)"列"(1)"非無意義"值個數(2)
//		其餘index 1後為有意義之值座標
		int[][] sparseArr = {{11, 11, 2}, {1, 2, 1}, {2, 3, 2}}; 
		
		int[][] originArr = new int[sparseArr[0][0]][sparseArr[0][1]];
		
		// 以下為回復數據
		for(int i = 1 ; i < sparseArr.length ; i++) {
			originArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		
		System.out.println("以下為原始數組");
		// \t : tab
		for(int[] row : originArr) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		
		// 以下為創建稀疏數組
		
		int sum = 0 ; // 不為零之數據
		
		for (int[] data : originArr) {
			for(int i : data) {
				if (i != 0) {
					sum++;
				}
			}
		}
		
		//[不為零數據加index 0 紀錄原始數據行列數][row, col, value]
		int[][] newSparseArr = new int[sum + 1][3]; // 可自訂要記錄的更多種類值
		// 給原始數據資料
		newSparseArr[0][0] = 11 ;
		newSparseArr[0][1] = 11 ;
		newSparseArr[0][2] = sum ;
		
		int count = 0 ;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (originArr[i][j] != 0) {
					count ++ ;
					newSparseArr[count][0] = i ; // row
					newSparseArr[count][1] = j ; // col
					newSparseArr[count][2] = originArr[i][j] ; // value
				}
			}
		}
//		System.out.println(Arrays.deepToString(newSparseArr));
		
		System.out.println();
		System.out.println("以下為稀疏數組");
		for(int i = 0 ; i < newSparseArr.length ; i++) {
				System.out.printf("%d\t%d\t%d\t\n", 
						newSparseArr[i][0],
						newSparseArr[i][1],
						newSparseArr[i][2]
						);
//			System.out.println();
		}
	}

}
















