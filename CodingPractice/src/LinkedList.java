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
			data = null;
			previous = null;
			next = null;
		}
		
	}
	
	Node sentinel;
	int size;
	
	public LinkedList(){
		initialize();
	}
	
	public void initialize(){
		sentinel = new Node();
		sentinel.previous = sentinel;
		sentinel.next = sentinel;
		sentinel.data = null;
		size = 0;
	}
	
	@Override
	public boolean add(E arg0) {
		if(sentinel==null){
			initialize();
		}
		if(!contains(arg0)){
			Node<E> newNode = new Node<E>(arg0, sentinel, sentinel.next);
			sentinel.next.previous = newNode;
			sentinel.next = newNode;
			
			if(size == 0)
				sentinel.previous = newNode;
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
	
	public boolean equals(Object o){
		if(!(o instanceof Set)){
			return false;
		}
		
		Set oSet = (Set) o;
		if(oSet.size() != this.size()){
			return false;
		}
		
		if(!oSet.containsAll(this)){
			return false;
		}
		
		return true;
	}

	@Override
	public boolean contains(Object arg0) {
		Node current = sentinel.next;
		sentinel.data = arg0;
		while(!(current.data.equals(arg0))){
			current = current.next;
		}
		sentinel.data = null;
		if(current==sentinel){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		
		boolean contains = true;
		
		for(Object o: arg0){
			if(contains(o) == false){
				contains = false;
			}
		}
		return contains;
	}

	@Override
	public boolean isEmpty() {
		if(size != 0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	@Override
	public boolean remove(Object arg0) {
		Node current = sentinel.next;
		sentinel.data = arg0;
		while(!current.data.equals(arg0)){
			current = current.next;
		}
		sentinel.data=null;
		if(current==sentinel){
			return false;
		}else{
			current.previous.next = current.next;
			current.next.previous = current.previous;
			size --;
			return true;
		}
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		boolean setChanged = false;
		Iterator <E> myIter = iterator();
		while(myIter.hasNext()){
			if(arg0.contains(myIter.next())){
				myIter.remove();
				setChanged = true;
			}
		}
		return setChanged;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		boolean setChanged = false;
		Iterator <E> myIter = iterator();
		while(myIter.hasNext()){
			if(!arg0.contains(myIter.next())){
				myIter.remove();
				setChanged = true;
			}
		}
		return setChanged;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] linkedListArray = new Object[size];
		Iterator <E> myIter = iterator();
		for(int i = 0; i < size; i++){
			linkedListArray[i] = myIter.next();
		}
		return linkedListArray;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		T[] linkedListArray = (T[]) new Object[size];
		Iterator <E> myIter = iterator();
		for(int i = 0; i < size; i++){
			linkedListArray[i] = (T) myIter.next();
		}
		return linkedListArray;
	}

	class LinkedListIterator implements Iterator<E>{

		Node current;
		Node previous;
		
		public LinkedListIterator(){
			current = sentinel.next;
			previous = null;
		}
		
		@Override
		public boolean hasNext() {
			if(current == sentinel){
				return false;
			}else{
				return true;
			}
		}

		@Override
		public E next() {
			previous = current;
			current = current.next;
			return (E) previous.data;
		}

		@Override
		public void remove() {
			if(previous == null)
				throw new IllegalStateException();	
			previous.previous.next = current;
			current.previous = previous.previous;
			previous = null;
			size --;
		}
		
	}
	
}

