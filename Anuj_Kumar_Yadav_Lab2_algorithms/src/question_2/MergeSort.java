package question_2;

import java.util.Arrays;

public class MergeSort {

	public void mergeSortArray(int[] arr, int start, int end) {
		if(start>=end) {
			return;
		}
		int mid = (start + end) /2;
		mergeSortArray(arr, start, mid);
		mergeSortArray(arr, mid+1, end);
		mergeArray(arr, start, mid, end);
	}
	
	public void mergeArray(int[] arr, int start, int mid, int end) {
		int[] arrLeft = new int[mid - start + 1];
		int[] arrRight = new int[end - mid];
		
		//System.out.print("Left Array- ");
		for (int i = 0; i < arrLeft.length; i++) {
			arrLeft[i] = arr[start+i];
		}
		
		//System.out.println(Arrays.toString(arrLeft));
		//System.out.print("Right Array- ");
		for (int i = 0; i < arrRight.length ; i++) {
			arrRight[i] = arr[mid + 1 +i];
		}
		//System.out.println(Arrays.toString(arrRight));
		
		int i ,j ,k;
		i=0;
		j=0;
		k=start;
		
		while(i< arrLeft.length && j<arrRight.length) {
			if(arrLeft[i] <= arrRight[j]) {
			arr[k] = arrLeft[i];
			i++;
			} 
			else{
				arr[k] = arrRight[j];
				j++;
			}
			k++;
		}
		
		while(i < arrLeft.length) {
			arr[k] = arrLeft[i];
			i++;
			k++;
		}
		while(j < arrRight.length) {
			arr[k] = arrRight[j];
			j++;
			k++;
		}
		
		
		
	}
	
//	public static void main(String[] args) {
//		MergeSort ms = new MergeSort();
//		
//		int[] arr = {1,2,9,4,0};
//		System.out.println("Given Array- " +Arrays.toString(arr));
//		ms.mergeSortArray(arr, 0, arr.length-1);
//		System.out.println("Sorted Array- " +Arrays.toString(arr));
//	}
	
}
