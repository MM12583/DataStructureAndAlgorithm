import java.util.Arrays;

//數組擴容
public class ArrayAdd {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3} ;
		int[] newArr = new int[arr.length + 1] ;
		
		for(int i = 0 ; i < arr.length ; i++) {
			newArr[i] = arr[i];
		}
		
		
		newArr[3] = 4 ;
		
		// **指向,讓原始空間垃圾回收
		arr = newArr;
		
		System.out.println(Arrays.toString(arr));
	}

}














