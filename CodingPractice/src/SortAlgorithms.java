import java.util.Arrays;

public class SortAlgorithms {
	public static int[] insertionSort(int[] inArr){
		for(int i = 1; i < inArr.length; i++){
			int candidateInd = i;
			int compareIndex = i-1;
			while(compareIndex >= 0 && inArr[candidateInd] < inArr[compareIndex]){
				swap(inArr, compareIndex, candidateInd);
				compareIndex--;
				candidateInd--;
			}
		}
		return inArr;
	}
	private static void swap(int[] inArr, int index1, int index2){
		int temp = inArr[index1];
		inArr[index1] = inArr[index2];
		inArr[index2] = temp;
	}
	
	public static int[] selectionSort(int[] inArr){
		for(int i = 0; i < inArr.length-1; i++){
			int compareInd = i+1;
			int smallestInd = i;
			while(compareInd < inArr.length){
				if(inArr[compareInd] < inArr[smallestInd])
					smallestInd = compareInd;
				compareInd++;
			}
			swap(inArr, i, smallestInd);
		}
		return inArr;
	}
	
	public static int[] mergeSort(int[] inArr){
		merge(inArr, 0, inArr.length);
		return inArr;
	}
	
	
	
	private static void merge(int[] arr, int ind, int length){
		if(length <= 1)
			return;
		
		int leftStart = ind;
		int rightStart = ind+length/2;
		int leftLength = length/2;
		int rightLength = length - length/2;
		
		merge(arr, leftStart, leftLength);
		merge(arr, rightStart, rightLength);
		int leftInd = leftStart;
		int rightInd = rightStart;
		int currentInd = 0;
		int[] newArr = new int[length];
		
		while(currentInd < newArr.length){
			if((rightInd < rightStart + rightLength)&&(leftInd >= leftStart + leftLength || arr[leftInd] > arr[rightInd])){
				newArr[currentInd] = arr[rightInd];
				rightInd ++;
			}else{
				newArr[currentInd] = arr[leftInd];
				leftInd++;
			}
			currentInd ++;
		}

		for(int i = 0; i < newArr.length; i++){
			arr[i+ind] = newArr[i];
		}
		
		return;

	}
	
	public static int[] quickSort(int[] inArr){
		quick(inArr, 0, inArr.length - 1);
		return inArr;
	}
	
	
	private static void quick(int[] arr, int first, int last){
		if(last <= first){
			return;
		}	
		
	}
	
	public static int[] heapSort(int[]arr){
		int[] heap = new int[arr.length];
		
		
	}
	
	private static 
	
	//quick
	//heap
	
}
