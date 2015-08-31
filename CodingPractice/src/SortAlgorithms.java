
public class SortAlgorithms {
	public static int[] insertionSort(int[] inArr){
		for(int i = 1; i < inArr.length; i++){
			int temp = inArr[i];
			int compareIndex = i-1;
			while(compareIndex >= 0 && temp < inArr[compareIndex]){
				insertSwap(inArr, compareIndex, temp);
			}
		}
		return inArr;
	}
	private static void insertSwap(int[] inArr, int index1, int index2){
		int temp = inArr[index1];
		inArr[index1] = inArr[index2];
		inArr[index2] = temp;
	}
}
