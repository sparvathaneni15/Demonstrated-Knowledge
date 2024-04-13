import java.nio.channels.NetworkChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/**
 * 
 * @author Samanyu Parvathaneni
 * 
 * @param <K> The type of keys in this MyHashMap
 * @param <V> The type of values in this MyHashMap
 */
public class MyHashMap<K, V> implements DefaultMap<K, V> {
	public static final double DEFAULT_LOAD_FACTOR = 0.75;
	public static final int DEFAULT_INITIAL_CAPACITY = 16;
	public static final String ILLEGAL_ARG_CAPACITY = "Initial Capacity must be non-negative";
	public static final String ILLEGAL_ARG_LOAD_FACTOR = "Load Factor must be positive";
	public static final String ILLEGAL_ARG_NULL_KEY = "Keys must be non-null";
	
	private double loadFactor;
	private int capacity;
	private int size;

	// Use this instance variable for Separate Chaining conflict resolution
	private List<HashMapEntry<K, V>>[] buckets;  
	
	// Use this instance variable for Linear Probing
	private HashMapEntry<K, V>[] entries; 	

	public MyHashMap() {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
	}
	
	/**
	 * 
	 * @param initialCapacity the initial capacity of this MyHashMap
	 * @param loadFactor the load factor for rehashing this MyHashMap
	 * @throws IllegalArgumentException if initialCapacity is negative or loadFactor not
	 * positive
	 */
	@SuppressWarnings("unchecked")
	public MyHashMap(int initialCapacity, double loadFactor) throws IllegalArgumentException {
		// TODO Finish initializing instance fields
		if (initialCapacity < 0){
			throw new IllegalArgumentException(ILLEGAL_ARG_CAPACITY);
		}
		else if (loadFactor <= 0){
			throw new IllegalArgumentException(ILLEGAL_ARG_LOAD_FACTOR);
		}
		else{
			this.capacity = initialCapacity;
			this.loadFactor = loadFactor;
		}

		// if you use Separate Chaining
		buckets = (List<HashMapEntry<K, V>>[]) new List<?>[capacity];

		// if you use Linear Probing
		entries = (HashMapEntry<K, V>[]) new HashMapEntry<?, ?>[initialCapacity];
	}
	/**
	 * Adds the specified key, value pair to this MyHashMap
	 * Note: duplicate keys are not allowed
	 * 
	 * @return true if the key value pair was added to this MyHashMap
	 * @throws IllegalArgument exception if the key is null
	 */
	@Override
	public boolean put(K key, V value) throws IllegalArgumentException {
		if (key == null){
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}
		// can also use key.hashCode() assuming key is not null
		int keyHash = Math.abs(key.hashCode());
		int index = keyHash%this.capacity;
		// TODO Auto-generated method stub
		if (this.buckets[index] == null){
			this.buckets[index] = new ArrayList<HashMapEntry<K,V>>();
		}
		for (HashMapEntry<K,V> entry : this.buckets[index]){
			if (entry.getKey().equals(key)){
				return false;
			}
		}
		this.buckets[index].add(new HashMapEntry<>(key, value));
		size++;
		return true;
	}
	/**
	 * Replaces the value that maps to the key if it is present
	 * @param key The key whose mapped value is being replaced
	 * @param newValue The value to replace the existing value with
	 * @return true if the key was in this MyHashMap
	 * @throws IllegalArgument exception if the key is null
	 */
	@Override
	public boolean replace(K key, V newValue) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null){
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}
		int keyHash = Math.abs(key.hashCode());
		int index = keyHash%this.capacity;
		if (this.buckets[index] == null){
			return false;
		}
		for (HashMapEntry<K,V> entry : this.buckets[index]){
			if (entry.getKey().equals(key)){
				entry.setValue(newValue);
				return true;
			}
		}
		return false;
	}
	/**
	 * Remove the entry corresponding to the given key
	 * 
	 * @return true if an entry for the given key was removed
	 * @throws IllegalArgument exception if the key is null
	 */
	@Override
	public boolean remove(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null){
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}
		else{
			if (this.isEmpty()){
				return false;
			}
			int keyHash = Math.abs(key.hashCode());
			int index = keyHash%this.capacity;
			if (buckets[index] == null){
				return false;
			}
			for (HashMapEntry<K,V> entry : this.buckets[index]){
				if (entry.getKey().equals(key)){
					int i = this.buckets[index].indexOf(entry);
					this.buckets[index].remove(i);
					size--;
					return true;
				}
			}
			return false;
		}
	}
	/**
	 * Adds the key, value pair to this MyHashMap if it is not present,
	 * otherwise, replaces the value with the given value
	 * @throws IllegalArgument exception if the key is null
	 */
	@Override
	public void set(K key, V value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null){
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}
		int keyHash = Math.abs(key.hashCode());
		int index = keyHash%this.capacity;
		HashMapEntry<K,V> entry = new HashMapEntry<K,V>(key, value);
		if (this.buckets[index] == null){
			this.buckets[index] = new ArrayList<HashMapEntry<K,V>>();
		}
		for (HashMapEntry<K,V> currentEntry : this.buckets[index]){
			if (currentEntry.getKey().equals(key)){
				currentEntry.setValue(value);
				return;
			}
		}
		this.buckets[index].add(entry);
		size++;
		return;
	}
	/**
	 * @return the value corresponding to the specified key, null if key doesn't 
	 * exist in hash map
	 * @throws IllegalArgument exception if the key is null
	 */
	@Override
	public V get(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null){
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}
		if (this.isEmpty()){
			return null;
		}
		int keyHash = Math.abs(key.hashCode());
		int index = keyHash%this.capacity;
		if (this.buckets[index] != null){
			for (HashMapEntry<K,V> entry : this.buckets[index]){
				if (entry.getKey().equals(key)){
					return entry.getValue();
				}
			}
		}
		return null;
	}
	/**
	 * 
	 * @return The number of (key, value) pairs in this MyHashMap
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
		return this.size == 0;
	}
	/**
	 * @return true if the specified key is in this MyHashMap
	 * @throws IllegalArgument exception if the key is null
	 */
	@Override
	public boolean containsKey(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null){
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}
		int keyHash = Math.abs(key.hashCode());
		int index = keyHash%this.capacity;
		if (buckets[index] == null){
			return false;
		}
		for (HashMapEntry<K,V> entry : buckets[index]){
			if (entry.getKey().equals(key)){
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @return an array containing the keys of this MyHashMap. If this MyHashMap is 
	 * empty, returns array of length zero. 
	 */
	@Override
	public List<K> keys() {
		// TODO Auto-generated method stub
		List<K> result = new ArrayList<K>();
		for (int i = 0; i < this.capacity; i++){
			if (this.buckets[i] != null){
				for (int j = 0; j < this.buckets[i].size(); j++){
					result.add(this.buckets[i].get(j).getKey());
				}
			}
		}
		return result;
	}
	
	private static class HashMapEntry<K, V> implements DefaultMap.Entry<K, V> {
		
		K key;
		V value;
		
		private HashMapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}
		
		@Override
		public void setValue(V value) {
			this.value = value;
		}
	}
}
