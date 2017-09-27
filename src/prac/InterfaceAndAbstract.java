package prac;

import java.util.*;

/**
 * (1) Class 20: Interface and Abstract class
 * 
 * (2) Override and Overload
 * 
 * List<String> myList = new LinkedList<>(); myList.add() ->
 * 这个add是LinkedList里面的方法
 * 
 * myList = new ArrayList<>(); myList.add() -> 这个add是ArrayList里面的方法
 * 
 * add是执行的时候才知道是执行的谁的方法 (Override is resolved at runtime) 运行时才知道
 *
 * Overload define two methods with the same name, but with different
 * signatures.
 * 
 *
 */
public class InterfaceAndAbstract {
	List<Integer> myList1 = new LinkedList<>();
	LinkedList<Integer> myList2 = new LinkedList<>();
	public InterfaceAndAbstract() {
		
	}
}
