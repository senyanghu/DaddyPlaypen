package prac;

/*
 * (1) how are integers represented in bits in java?
 * most significant bit
 * the sign bit, determines the number is positive or negative, there is no unsigned type in JAVA
 *
 *
 * two's complements -> 二补码
 * 取反加一 这是负数的表达方式 非常聪明
 * 
 * Integer.MAX_VALUE + 1 = Iterger.MIN_VALUE;
 * 
 * >> arithmetic 最左边补的是最高位
 * 
 * 
 * >>> logical 最左边补0
 * 
 * 
 * << 不停的乘以2
 * 
 * 
 * (2) Autoboxing and Unboxing
 * int 		Integer
 * long 		Long
 * char 		Character
 * double 	Double
 * boolean 	Boolean
 * 
 * A wrapper class is just a wrapper of the corresponding primitive type, the Object representation of primitive type class
 * Similar to String, all the wrapper class objects are immutable - internal values cann not be changed after initialization
 * 
 * 
 * It can help:
 * (1) generic type can not be primitive type, List<Integer>  not List<int>
 * (2) It can help provide useful functionalities and contracts (json serializer: obj -> json)
 * (3) How do you represent a "non-existing" int value? "Value"
 * 
 * IMMUTABLE是为了HASH的consistency
 * 
 * 
 */
public class IntegersAndStrings {

}
