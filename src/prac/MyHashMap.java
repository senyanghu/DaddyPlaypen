package prac;

import java.util.Arrays;

/**
 * 
 * September 11, 2017
 * Map / Set / Hash
 *
 * hashset - which stores its elements in a hashtable, is the best-performing implementation; but it
 * makes no guarantee concerning the order of iteration
 *
 * treeset - red black tree (balanced bst). Orders its elements based on their values (VALUE ORDER)
 *
 * linkedHashSet - it is a HashSet and also it is a linkedList. it maintains the order
 * when each of the elements is inserted into the HashSet (INSERTION ORDER)
 * 
 * HashMap
 *  containsValue (V value) - O(n) - 原因是通过key找value
 * 
 */

/**
 * Operation              Average             Worst
 * search                   O(1)               O(n)
 * insert / update          O(1)               O(n)
 * delete                   O(1)               O(n)
 */

/**
 * put (key, value)
 *    (1) int hash = hash(key) -- hash
 *    (2) int index = hash % table_size -- index
 *    (3) search for list resides in the bucket to see if the key already exists
 *    		* if not find the same key already existed, add a new entry node to the list
 *    		* if find an entry with the same key, update the value of that entry
 * 
 * get (key)
 *    (1) int hash = hash(key) -- hash
 *    (2) int index = hash % table_size -- index
 *    (3) search for the list resides in the bucket to see if the key already exists
 */

/**
 * ==, equals(), hashCode()
 * 
 * ==:
 * 		* determine if two primitive type has the same value
 * 		* determine if two reference are pointed the the same value
 * 
 * equals():
 * 		* default implementation of equals() is to 
 * 			check if two references are point the same object "=="
 * 		* override
 * 
 * hashCode():
 * 		* java 根据内存地址 默认的一个实现
 * 
 * if one.equals(two), it is a must that one.hashCode() == two.hashCode();
 * if one.hashCode() == two.hashCode(), it is not necessarily one.equals(two)
 * 
 * 
 * class Combo {
 * 		int a;
 * 		B b;
 * 		C c;
 * 		
 * 		public Combo (int a, B b, C c) {
 * 			this.a = a;
 * 			this.b = b;
 * 			this.c = c;
 * 		}
 * 
 * 		@Override
 * 		public int hashCode() {
 * 			return a * 31 * 31 + b.hashCode() * 31 + c.hashCode();
 * 		}
 * }
 * 
 * 	Rehashing & Load Factor
 * 	Rehashing is global wise (针对全局的)
 * 	Load Factor default's value is 0.75, it can be changed
 * 
 * 
 * * * * * * * * * * * * * * * * * * *
 * * * * * * * * * * * * * * * * * * * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  Sep 16 2017
 *  Write your own HashMap
 * 
 * 
 */

public class MyHashMap<K, V> {
	public static class Node<K, V> {
		final K key;
		V value;
		Node<K, V> next;

		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}
	}

	public static final int DEFAULT_CAPACITY = 16;
	public static final float DEFAULT_LOAD_FACTOR = 0.75f;

	private Node<K, V>[] table;
	private int size;
	private float loadFactor;

	public MyHashMap() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	public MyHashMap(int capacity, float loadFactor) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("capacity can not be smaller than 0");
		}
		this.table = (Node<K, V>[]) new Node[capacity];
		this.size = 0;
		this.loadFactor = loadFactor;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void clear() {
		Arrays.fill(this.table, null);
		this.size = 0;
	}

	// get hash value of a key
	private int getHashValue(K key) {
		if (key == null) {
			return 0;
		}
		// make all negative numbers to be positive
		return key.hashCode() & 0x7fffffff;
	}

	private boolean equalsKey(K k1, K k2) {
		// k1 == k2 to test k1, k2 both null
		return k1 == k2 || k1 != null && k1.equals(k2);
	}

	private boolean equalsValue(V v1, V v2) {
		// v1 == v2 to test v1, v2 both null
		return v1 == v2 || v1 != null && v1.equals(v2);
	}

	// get entry index from hash value
	public int getIndex(int hashvalue) {
		return hashvalue % table.length;
	}

	public boolean containsKey(K key) {
		if (this.size == 0) {
			return false;
		}

		int index = getIndex(getHashValue(key));
		Node<K, V> cur = table[index];
		while (cur != null) {
			if (equalsKey(cur.key, key)) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}

	// contains a value
	public boolean containsValue(V value) {
		for (int i = 0; i < table.length; i++) {
			Node<K, V> cur = table[i];
			while (cur != null) {
				if (value.equals(cur.value)) {
					return true;
				}
				cur = cur.next;
			}
		}
		return false;
	}

	// get
	public V get(K key) {
		int index = getIndex(getHashValue(key));

		Node<K, V> cur = table[index];
		while (cur != null) {
			// if the key is null, k will be null as well
			if (equalsKey(cur.key, key)) {
				return cur.getValue();
			}
			cur = cur.next;
		}
		return null;
	}

	// put
	public V put(K key, V value) {
		int index = this.getIndex(this.getHashValue(key));
		Node<K, V> head = table[index];
		Node<K, V> cur = head;

		while (cur != null) {
			if (equalsKey(cur.key, key)) {
				V resValue = cur.value;
				cur.setValue(value);
				return resValue;
			}
			cur = cur.next;
		}

		Node newNode = new Node(key, value);
		newNode.next = table[index];
		table[index] = newNode;
		this.size++;

		if (needRehashing()) {
			rehashing();
		}

		return null;
	}

	private boolean needRehashing() {
		float ratio = (this.size + 0.0f) / table.length;
		return ratio >= loadFactor;
	}

	private void rehashing() {
		Node<K, V>[] newTable = (Node<K, V>[]) (new Node[table.length * 2]);
		for (Node<K, V> node : table) {
			if (node != null) {
				int index = this.getIndex(this.getHashValue(node.key));
				newTable[index] = node;
			}
		}
		this.table = newTable;
	}

	public V remove(K key) {
		int index = getIndex(getHashValue(key));
		Node<K, V> head = table[index];

		Node<K, V> dummy = new Node<>(head.key, head.value);
		dummy.next = head;
		Node<K, V> p = dummy;

		while (p.next != null) {
			if (equalsKey(p.next.key, key)) {
				Node<K, V> next = p.next;
				p.next = next.next;
				return next.value;
			} else {
				p = p.next;
			}
		}

		return null;
	}
}
