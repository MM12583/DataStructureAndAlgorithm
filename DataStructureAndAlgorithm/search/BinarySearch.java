package search_algorithm;

import java.util.ArrayList;
import java.util.Arrays;

// 二分查找 : 有序
public class BinarySearch {

	public static void main(String[] args) {

//		int[] arr = { 1, 8, 10, 89, 1000, 1234, 1234, 1234 };

//		int resIndex = binarySearch(arr, 0, arr.length - 1, 1234);
//		System.out.println(resIndex);
		
		int[] arr2 = new int[100];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = i + 1;
		}
		
//		ArrayList<Integer> resIndexList = binarySearchComplete(arr2, 0, arr2.length - 1, 8);
//		System.out.println(resIndexList.toString());
		
		int resIndex2 = insertValueSearch(arr2, 0, arr2.length - 1, 2);
		System.out.println(resIndex2);
		
	}

	/**
	 * 
	 * @param arr     數組
	 * @param left    左索引
	 * @param right   右索引
	 * @param findVal 查找值
	 * @return 找到則返回下標，沒找到返回-1
	 */
	public static int binarySearch(int[] arr, int left, int right, int findVal) {

		if (left > right) { // 找不到
			return -1;
		}

		int mid = (left + right) / 2;
		int midVal = arr[mid];

		if (findVal > midVal) { // 向右遞歸
			return binarySearch(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) { // 向左遞歸
			return binarySearch(arr, left, mid - 1, findVal);
		} else {
			return mid; // 找到
		}
	}
	
	// 查找所有重複值
	// 找到後向左右兩邊查找符合 mid 之值 (有序值會相連)
	public static ArrayList<Integer> binarySearchComplete(int[] arr, int left, int right, int findVal) {
		
		System.out.println("Hello");
		
		if (left > right) { // 找不到
			return new ArrayList<Integer>(); // size = 0
		}

		int mid = (left + right) / 2;
		int midVal = arr[mid];

		if (findVal > midVal) { // 向右遞歸
			return binarySearchComplete(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) { // 向左遞歸
			return binarySearchComplete(arr, left, mid - 1, findVal);
		} else { // 找到
			
			ArrayList<Integer> resIndexList = new ArrayList<Integer>();
			
			int tempIndex = mid - 1 ;
			while(true) { // 向左線性
				if (tempIndex < 0 || arr[tempIndex] != findVal) {
					break;
				}
				resIndexList.add(tempIndex);
				tempIndex -- ;
			}
			
			resIndexList.add(mid);
			
			tempIndex = mid + 1 ;
			while(true) { // 向右線性
				if (tempIndex > arr.length - 1 || arr[tempIndex] != findVal) {
					break;
				}
				resIndexList.add(tempIndex);
				tempIndex ++ ;
			}
			
			return resIndexList; 
		}
	}
	
	// 插值查找(以二分查找改良)
	// *** "差"值：算比例
	// mid = (left + right) / 2 = left + 1/2(right - left)：中間
	// 上行改良 mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left])：算查找值所在百分比位置
	public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
		
		if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) { // 找不到
			return -1 ; // size = 0
		}
		
		int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
		int midVal = arr[mid];

		if (findVal > midVal) { // 向右遞歸
			return insertValueSearch(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) { // 向左遞歸
			return insertValueSearch(arr, left, mid - 1, findVal);
		} else { // 找到
			return mid; 
		}
	}
}











