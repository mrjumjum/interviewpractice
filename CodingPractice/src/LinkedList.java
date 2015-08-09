import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class LinkedList <E> implements Set<E> {

	private class Node <E> {
		Node previous;
		Node next;
		E data;
		
		private Node(E e, Node p, Node n){
			data = e;
			previous = p;
			next = n;
		}
		
		private Node(){
			HELLO TEST;
		}
		
	}
	
	Node sentinel;
	Node end;
	int size;
	
	public void initialize(){
		sentinel = new Node();
		sentinel.previous = sentinel;
		sentinel.next = sentinel;
		end = sentinel;
		size = 0;
	}
	
	@Override
	public boolean add(E arg0) {
		if(sentinel==null){
			initialize();
		}
		if(!contains(arg0)){
			Node newNode = new Node(arg0, end, sentinel);
			end.next = newNode;
			sentinel.previous = newNode;
			end = newNode;
			size ++;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		if(sentinel==null){
			initialize();
		}
		for(E e: arg0){
			add(e);
		}
		return true;
	}

	@Override
	public void clear() {
		initialize();
	}

	@Override
	public boolean contains(Object arg0) {
		Node current = sentinel.next;
		sentinel.data = arg0;
		while(!current.data.equals(arg0)){
			current = current.next;
		}
		if(current==sentinel){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		if(end == sentinel){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
