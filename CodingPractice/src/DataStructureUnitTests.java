import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class DataStructureUnitTests {

	@Test
	public void LinkedListSetTest() {
		Set<Integer> testSet = new LinkedList<Integer>();
		
		assertEquals(0, testSet.size());
		testSet.add(2);
		testSet.add(3);
		assertEquals(2, testSet.size());
		
	}

}
