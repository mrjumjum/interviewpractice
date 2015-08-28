import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class TreeSet<E> implements Set<E> {
	
	private class Node{
		Node parent;
		Node left;
		Node right;
		E data;
		
		public Node(Node p, Node l, Node r, E d){
			parent = p;
			left = l;
			right = r;
			data = d;
		}
	}
	
	Node treeRoot;
	int size;
	static final boolean useRecursive = true;
	
	public TreeSet(){
		treeRoot = null;
		size = 0;
	}
	
	@Override
	public boolean add(E arg0) {
		if(contains(arg0)){
			return false;
		}
		if(useRecursive){
			treeRoot = recursiveAdd(arg0, treeRoot, null);
		}else{
			iterativeAdd(arg0, treeRoot);
		}
		return true;
	}
	
	private boolean iterativeAdd(E arg0, Node root){
		if(root == null){
			root = new Node(null, null, null, arg0);
			size ++;
			return true;
		}
		
		Node current = root;
		Node parent = current.parent;
		boolean isLeft = false;
		while((!(current==null)&&!current.data.equals(arg0))){
			parent = current;
			if(arg0.hashCode() > current.data.hashCode()){
				current = current.right;
				isLeft = false;
			}else{
				current = current.left;
				isLeft = true;
			}
		}
		if(current != null){
			return false;
		}else{
			if(isLeft){
				parent.left = new Node(parent, null, null, arg0);
			}else{
				parent.right = new Node(parent, null, null, arg0);
			}
		}
		size++;
		return true;	
	}
	
	private Node recursiveAdd(E arg0, Node root, Node parent){
		if(root == null){
			root = new Node(parent, null, null, arg0);
			size ++;
			return root;
		}
		
		if(root.data.equals(arg0)){
			return root;
		}
		
		if(arg0.hashCode() > root.data.hashCode()){
			root.right = recursiveAdd(arg0, root.right, root);
		}else{
			root.left = recursiveAdd(arg0, root.left, root);
		}	
		return root;
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		boolean setChanged = false;
		for(E e : arg0){
			if(add(e)){
				setChanged = true;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		treeRoot = null;
		size = 0;
		
	}

	@Override
	public boolean contains(Object arg0) {
		if(useRecursive){
			return recursiveContains(arg0, treeRoot);
		}else{
			return iterativeContains(arg0, treeRoot);
		}
	}
	
	private boolean iterativeContains(Object arg0, Node root){
		Node current = root;
		while(!(current==null) && !current.data.equals(arg0)){
			if(arg0.hashCode() > current.data.hashCode()){
				current = current.right;
			}else{
				current = current.left;
			}
		}
		if(current == null){
			return false;
		}else{
			return true;
		}
	}
	
	private boolean recursiveContains(Object arg0, Node root){
		if(root == null){
			return false;
		}
		if(root.data.equals(arg0)){
			return true;
		}
		
		if(arg0.hashCode() > root.data.hashCode()){
			return recursiveContains(arg0, root.right);
		}else{
			return recursiveContains(arg0, root.left);
		}
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		boolean containsAll = true;;
		for(Object o : arg0){
			if(!contains(o)){
				containsAll = false;
			}
		}
		return containsAll;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0){
			return true;
		}else{
			return false;
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
	
	private String recursiveToString(String retString, Node root, String prefix){
		if(root == null){
			return retString;
		}
		
		retString += prefix + root.data.toString() + "\n";
		
		if(root.left != null){
			retString = recursiveToString(retString, root.left, prefix + "<");
		}
		
		if(root.right != null){
			retString = recursiveToString(retString, root.right, prefix +">");
		}
		
		return retString;
	}

	public String toString(){
		return recursiveToString("", treeRoot, "");
	}
	
	@Override
	public int size() {
		return size;
	}

	private ArrayList <E> recursiveToArray(ArrayList<E> list, Node root){
		if(root == null){
			return list;
		}
		if(root.left != null){
			recursiveToArray(list, root.left);
		}
		list.add(root.data);
		if(root.right != null){
			recursiveToArray(list, root.right);
		}
		return list;
		
	}
	
	@Override
	public Object[] toArray() {
		ArrayList <E> returnList = new ArrayList<E>();
		return recursiveToArray(returnList, treeRoot).toArray();
		
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	class TreeSetIterator implements Iterator<E>{

		Node current;
		
		public TreeSetIterator(){
			
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
