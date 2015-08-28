import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class HashedSet <E> implements Set<E> {

	Element<E>[] table;
	int numOfKeys;
	int numOfBuckets;
	
	private class Element<E>{
		E key;
		Element next;
		
		public Element(E k, Element n){
			key = k;
			next = n;
		}
	}
	
	private void initialize(){
		numOfBuckets = 2;
		numOfKeys = 0;
		table = new Element[numOfBuckets];
	}
	
	private double loadFactor(){
		return numOfKeys/ (double) numOfBuckets;
	}
	
	private int getIndex(E key, int buckets){
		int hash = key.hashCode();
		hash = (3*hash) + 4;
		hash %= buckets;
		return hash;
	}
	
	private void resizeTable(){
		Integer newNumOfBuckets = null;
		if(loadFactor() > 0.5){
			newNumOfBuckets = numOfBuckets * 2;
		}else if(loadFactor() < 0.25){
			newNumOfBuckets = numOfBuckets / 2;
		}
		if(newNumOfBuckets != null){
			Element<E>[] newTable = new Element[newNumOfBuckets];
			Iterator <E> myIter = iterator();
			while(myIter.hasNext()){
				E key = myIter.next();
				int index = getIndex(key, newNumOfBuckets);
				if(newTable[index] != null) {
					Element newElem = new Element(key, newTable[index]);
					newTable[index] = newElem;
				}else{
					newTable[index] = new Element(key, null);
				}
			}
			table = newTable;
			numOfBuckets = newNumOfBuckets;
		}	
	}
	
	public HashedSet(){
		initialize();
	}
	
	@Override
	public boolean add(E e) {
		if(contains(e)){
			return false;
		}
		int index = getIndex(e, numOfBuckets);
		if(table[index] != null) {
			Element newElem = new Element(e, table[index]);
			table[index] = newElem;
		}else{
			table[index] = new Element(e, null);
		}
		numOfKeys++;
		resizeTable();
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		for(E key: c){
			add(key);
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
	public boolean contains(Object o) {
		int index = getIndex((E)o, numOfBuckets);
		Element e = table[index];
		while(e != null){
			if(e.key.equals(o)){
				return true;
			}
			e = e.next;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		boolean doesContainAll = true;
		for(Object key: c){
			if(!contains(key)){
				doesContainAll = false;
			}
		}
		return doesContainAll;
	}

	@Override
	public boolean isEmpty() {
		if(numOfKeys == 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new HashedSetIterator();
	}

	@Override
	public boolean remove(Object o) {
		if(!contains(o)){
			return false;
		}
		int index = getIndex((E)o, numOfBuckets);
		Element current = table[index];
		if(current.key.equals((o))){
			table[index] = table[index].next;
		}else{
			Element previous = null;
			while(!current.key.equals(o)){
				previous = current;
				current = current.next;
			}
			previous.next = current.next;
		}
		numOfKeys--;
		resizeTable();
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean setChanged = false;
		for(Object key: c){
			if(remove(key)){
				setChanged = true;
			}
		}
		resizeTable();
		return setChanged;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean setChanged = false;
		Iterator <E> myIter = iterator();
		while(myIter.hasNext()){
			if(!c.contains(myIter.next())){
				myIter.remove();
				setChanged = true;
			}
		}
		resizeTable();
		return setChanged;
	}

	@Override
	public int size() {
		return numOfKeys;
	}

	@Override
	public Object[] toArray() {
		Object[] retArr = new Object[numOfKeys];
		Iterator <E> myIter = iterator();
		for(int i = 0; i < numOfKeys; i++){
			retArr[i] = myIter.next();
		}
		return retArr;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		T[] retArr = (T[]) new Object[numOfKeys];
		Iterator <E> myIter = iterator();
		for(int i = 0; i < numOfKeys; i++){
			retArr[i] = (T)myIter.next();
		}
		return retArr;
	}
	
	public String toString(){
		String retString = "";
		for(int i = 0; i < numOfBuckets; i ++){
			retString += "Ind " + i + ": ";
			Element tempElem = table[i];
			while(tempElem != null){
				retString += tempElem.key + "->";
				tempElem = tempElem.next;
			}
			retString += '\n';
		}
		retString += "NumOfBuckets:" + numOfBuckets + " Keys: " + numOfKeys;
		return retString;
	}

	class HashedSetIterator implements Iterator<E>{

		int currentIndex;
		int previousIndex;
		Element currentElement;
		Element previousElement;
		
		public HashedSetIterator(){
			previousElement = null;
			currentIndex = 0;
			currentElement = table[currentIndex];
			while(currentElement == null && currentIndex < (numOfBuckets-1)){
				currentIndex ++;
				currentElement = table[currentIndex];
			}
		}
		
		@Override
		public boolean hasNext() {
			if(currentElement == null){
				return false;
			}
			return true;
		}

		@Override
		public E next() {
			previousElement = currentElement;
			previousIndex = currentIndex;
			currentElement = currentElement.next;
			while(currentElement == null && currentIndex < (numOfBuckets - 1)){
				currentIndex ++;
				currentElement = table[currentIndex];
			}
			return (E) previousElement.key;
		}

		@Override
		public void remove() {
			if(previousElement==null){
				throw new IllegalStateException();	
			}
			
			if(previousElement == table[previousIndex]){
				table[previousIndex] = previousElement.next;
			}else{
				Element tempElem = table[previousIndex];
				while(tempElem.next != previousElement){
					tempElem = tempElem.next;
				}
				tempElem.next = tempElem.next.next;
			}
			numOfKeys --;
			previousElement = null;
		}
		
	}
}
