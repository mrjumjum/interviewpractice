import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

public class DataStructureUnitTests {

	@Test
	public void LinkedListTests() {
		Set<Integer> linkedList = new LinkedList();
		SetImplTest(linkedList);
	}

	public void SetImplTest(Set <Integer> setImpl){
		Set<Integer> tempSet = new LinkedHashSet<Integer>();
		assertEquals(0, setImpl.size());
		setImpl.add(2);
		setImpl.add(3);
		setImpl.add(2);	
		setImpl.add(5);
		assertEquals(3, setImpl.size());
		assertTrue(setImpl.contains(2));
		assertTrue(setImpl.contains(3));
		assertTrue(setImpl.contains(5));
		
		tempSet.add(2);
		tempSet.add(3);
		tempSet.add(5);
		assertEquals(setImpl,tempSet);
		
		//setImpl has 2,3,5
		tempSet = new LinkedHashSet<Integer>();
		tempSet.add(1);
		tempSet.add(2);
		tempSet.add(3);
		setImpl.addAll(tempSet);
		assertTrue(setImpl.containsAll(tempSet));
		setImpl.add(6);
		//setImpl has 1,2,3,5,6
		//tempSet has 1,2,3

		assertNotEquals(setImpl,tempSet);
		setImpl.retainAll(tempSet);
		assertEquals(setImpl,tempSet);
		//tempSet has 1,2,3
		//setImpl has 1,2,3
		setImpl.add(4);
		setImpl.removeAll(tempSet);
		assertEquals(1, setImpl.size());
		tempSet = new LinkedHashSet<Integer>();
		tempSet.add(4);
		//assertEquals(setImpl,tempSet);
		assertTrue(setImpl.equals(tempSet));
		setImpl.remove(2);
		setImpl.remove(4);
		assertEquals(0, setImpl.size());
		tempSet.remove(4);
		assertEquals(setImpl,tempSet);
	}
}
