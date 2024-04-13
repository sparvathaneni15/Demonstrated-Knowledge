import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author Samanyu Parvathaneni
 * @author Ella Sampson
 * @author Ivor Myers
 */

/**
 * @param <K> The type of the keys of this BST. They need to be comparable by nature of the BST
 * "K extends Comparable" means that BST will only compile with classes that implement Comparable
 * interface. This is because our BST sorts entries by key. Therefore keys must be comparable.
 * @param <V> The type of the values of this BST. 
 */
public class BST<K extends Comparable<? super K>, V> implements DefaultMap<K, V> {
	/* 
	 * TODO: Add instance variables 
	 * You may add any instance variables you need, but 
	 * you may NOT use any class that implements java.util.SortedMap
	 * or any other implementation of a binary search tree
	 */
	Node<K,V> root;
	int size;

	/**
	 * Adds the specified key, value pair to this DefaultMap
	 * Note: duplicate keys are not allowed
	 * 
	 * @return true if the key value pair was added to this DefaultMap
	 * @throws IllegalArgumentException if the key is null
	 */
	public boolean put(K key, V value) throws IllegalArgumentException {
		if (key == null){
			throw new IllegalArgumentException();
		}
		if (this.isEmpty()){
			this.root = new Node<>(key,value);
			size++;
			return true;
		}
		Node<K,V> current = this.root;
		while (current != null){
			if (key.compareTo(current.getKey()) < 0){
				if (current.left == null){
					current.left = new Node<K,V>(key, value);
					current.left.parent = current;
					size++;
					return true;
				}
				current = current.left;
			}
			else if (key.compareTo(current.getKey()) > 0){
				if (current.right == null){
					current.right = new Node<K,V>(key, value);
					current.right.parent = current;
					size++;
					return true;
				}
				current = current.right;
			}
			else {
				return false;
			}
		}
		current.key = key;
		current.setValue(value);
		size++;
		return true;
	}

	/**
	 * Replaces the value that maps to the key if it is present
	 * @param key The key whose mapped value is being replaced
	 * @param newValue The value to replace the existing value with
	 * @return true if the key was in this DefaultMap
	 * @throws IllegalArgumentException if the key is null
	 */
	@Override
	public boolean replace(K key, V newValue) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}
		
		if (!this.containsKey(key)) {
			return false;
		}
		
		Node<K, V> current = root;
		while (key.compareTo(current.getKey()) != 0) {
			if (key.compareTo(current.getKey()) < 0) {
				if (current.left == null) {
					break;
				}
				current = current.left;
				
			}
			if (key.compareTo(current.getKey()) > 0) {
				if (current.right == null) {
					break;
				}
				current = current.right;
			}
		}
		
		if (key.compareTo(current.getKey()) == 0) {
			current.setValue(newValue);
			return true;
		}
		
		return false;
	}

	/**
	 * Remove the entry corresponding to the given key
	 * 
	 * @return true if an entry for the given key was removed
	 * @throws IllegalArgumentException if the key is null
	 */
	@Override
	public boolean remove(K key) throws IllegalArgumentException{
		if (key == null){
			throw new IllegalArgumentException();
		}
		if (!this.containsKey(key)){
			return false;
		}
		Node<K,V> current = this.root; // key is in tree
		while (key.compareTo(current.getKey()) != 0){ // traverses down
			if (key.compareTo(current.getKey()) < 0){
				if (current.left == null) {
					break;
				}
				current = current.left;
			}
			else if (key.compareTo(current.getKey()) > 0){
				if (current.right != null){
					current = current.right;
				}
			}
		}
		// found node that is equal to key
		if (current.left == null && current.right == null){  // no child nodes
			if (current.equals(this.root)){ // root is equal to key
				this.root = null;
			}
			else {
				if (current.parent.left.equals(current)){
					current.parent.left = null;
				}
				else if (current.parent.right.equals(current)){
					current.parent.right = null;
				}
			}
		}
		else if (current.left != null && current.right == null){ // left child node
			if (current.equals(this.root)){
				this.root = current.left;
			}
			else {
				if (current.parent.left.equals(current)){
					current.parent.left = current.left;
					current.left.parent = current.parent;

				}
				else if (current.parent.right.equals(current)){
					current.parent.right = current.left;
					current.left.parent = current.parent;
				}
			}
		}
		else if (current.left == null && current.right != null){ // right child node
			if (current.equals(this.root)){
				this.root = current.right;
			}
			else {
				if (current.parent.left.equals(current)){
					current.parent.left = current.right;
					current.left.parent = current.parent;
				}
				else if (current.parent.right.equals(current)){
					current.parent.right = current.right;
					current.right.parent = current.parent;
				}
			}
		}
		else if (current.left != null && current.right != null){ // two child nodes
			if (current.equals(this.root)){
				Node<K,V> temp = current.left;
				this.root = current.right;
				current = this.root;
				while (current.left != null){
					current = current.left;
				}
				current.left = temp;
			}
			else{ // not at root
				if (current.parent.left.equals(current)){
					Node<K,V> temp = current.left;
					current.parent.left = current.right;
					current = current.parent.left;
					while (current.left != null){
						current = current.left;
					}
					current.left = temp;
				}
				else if (current.parent.equals(current)){
					Node<K,V> temp = current.left;
					current.parent.right = current.right;
					current = current.parent.right;
					while (current.left != null){
						current = current.left;
					}
					current.left = temp;
				}
			}
		}
		size--;
		return true;
	}


	/**
	 * Adds the key, value pair to this DefaultMap if it is not present,
	 * otherwise, replaces the value with the given value
	 * @throws IllegalArgumentException if the key is null
	 */
	@Override
	public void set(K key, V value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null){
			throw new IllegalArgumentException();
		}
		if (this.containsKey(key) == false){
			this.put(key, value);
		}
		else{
			this.replace(key, value);
		}
		
	}

	/**
	 * @return the value corresponding to the specified key
	 * @throws IllegalArgumentException if the key is null
	 */
	@Override
	public V get(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null){
			throw new IllegalArgumentException();
		}
		Node<K,V> current = this.root;
		while (current != null){
			if (key.compareTo(current.getKey()) < 0){
				current = current.left;
			}
			else if (key.compareTo(current.getKey()) > 0){
				current = current.right;
			}
			else {
				return current.getValue();
			}
		}
		return null;
	}

	/**
	 * 
	 * @return The number of (key, value) pairs in this DefaultMap
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	/**
	 * 
	 * @return true iff this.size() == 0 is true
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size() == 0;
	}

	/**
	 * @return true if the specified key is in this DefaultMap
	 * @throws IllegalArgumentException if the key is null
	 */
	@Override
	public boolean containsKey(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null){
			throw new IllegalArgumentException();
		}
		return this.keys().contains(key);
	}
	// Keys must be in ascending sorted order
	// You CANNOT use Collections.sort() or any other sorting implementations
	// You must do inorder traversal of the tree
	/**
	 * 
	 * @return an array containing the keys of this DefaultMap. If this DefaultMap is 
	 * empty, returns array of length zero. 
	 */
	@Override
	public List<K> keys() {
		// TODO Auto-generated method stub
		List<K> list = new ArrayList<K>();
		
		return this.inOrder(root, list);
	}
	
	/**
	 * traveres the binary search tree in ascending order and adds it to the list
	 * @param current the node to start from 
	 * @param list list that each node's key is being added to
	 * @return the list that has all of the keys in ascending order
	 */
	private List<K> inOrder(Node<K,V> current, List<K> list) {
		if (current != null) {
			inOrder(current.left, list);
			list.add(current.getKey());
			inOrder(current.right, list);
		}
		return list;
	}
	
	private static class Node<K extends Comparable<? super K>, V> 
								implements DefaultMap.Entry<K, V> {
		/* 
		 * TODO: Add instance variables
		 */
		
		 Node<K,V> left;
		 Node<K,V> right;
		 Node<K,V> parent;

		 K key;
		 V value;

		 private Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return this.key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return this.value;
		}

		@Override
		public void setValue(V value) {
			// TODO Auto-generated method stub
			this.value = value;
			
		}
		
		
	}
	 
}