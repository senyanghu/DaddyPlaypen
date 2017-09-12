package prac;

/*
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

/*
 * Operation              Average             Worst
 * search                   O(1)               O(n)
 * insert / update          O(1)               O(n)
 * delete                   O(1)               O(n)
 */

/*
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

/*
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
 */
public class MapSetHash {

}
