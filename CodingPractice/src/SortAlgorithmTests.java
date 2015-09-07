import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Test;

public class SortAlgorithmTests {

	@Test
	public void InsertionTest() {
		int[] input = {3,10,5,2,4,2,6,7};
		int[] baseline = {2,2,3,4,5,6,7,10};
		assertTrue(Arrays.equals(SortAlgorithms.insertionSort(input), baseline));
		input = new int[0];
		baseline = new int[0];
		assertTrue(Arrays.equals(SortAlgorithms.insertionSort(input), baseline));
		input = new int[1];
		baseline = new int[1];
		input[0] = 1;
		baseline[0] = 1;
		assertTrue(Arrays.equals(SortAlgorithms.insertionSort(input), baseline));


	}
	
	@Test
	public void SelectionTest() {
		int[] input = {3,10,5,2,4,2,6,7};
		int[] baseline = {2,2,3,4,5,6,7,10};
		assertTrue(Arrays.equals(SortAlgorithms.selectionSort(input), baseline));
		input = new int[0];
		baseline = new int[0];
		assertTrue(Arrays.equals(SortAlgorithms.selectionSort(input), baseline));
		input = new int[1];
		baseline = new int[1];
		input[0] = 1;
		baseline[0] = 1;
		assertTrue(Arrays.equals(SortAlgorithms.selectionSort(input), baseline));	
	}
	
	@Test
	public void MergeTest() {
		int[] input = {3,10,5,2,4,2,6,7};
		int[] baseline = {2,2,3,4,5,6,7,10};
		assertTrue(Arrays.equals(SortAlgorithms.mergeSort(input), baseline));
		input = new int[0];
		baseline = new int[0];
		assertTrue(Arrays.equals(SortAlgorithms.mergeSort(input), baseline));
		input = new int[1];
		baseline = new int[1];
		input[0] = 1;
		baseline[0] = 1;
		assertTrue(Arrays.equals(SortAlgorithms.mergeSort(input), baseline));	
	}

	
	
}
