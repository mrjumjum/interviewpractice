
import java.util.Arrays;
import java.util.Set;


public class DataStructureTests {

	public static void main(String[] args) {
		Set<Integer> setImpl = new TreeSet();
		setImpl.add(2);
		setImpl.add(3);
		setImpl.add(2);	
		setImpl.add(5);
		setImpl.add(4);
		setImpl.add(0);
		System.out.println(Arrays.toString(setImpl.toArray()));
		System.out.println("test");
		System.out.println(setImpl.toString());
	}

}
