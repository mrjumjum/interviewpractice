import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Test;

public class SortAlgorithmTests {

	@Test
	public void InsertionTest() {
		int[] input = {3,10,5,2,4,2,6,7};
		int[] baseline = {2,2,3,4,5,6,7,10};
		assertFalse(Arrays.equals(SortAlgorithms.insertionSort(input), baseline));	
	}

}
