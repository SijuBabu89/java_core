package core.java.functional.programming;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class FP02BiFunctionalInterface {

	public static void main(String ar[]) {
		biPredicate();
		biFunction();
		biConsumer();

	}
	
	//Predicate takes single any type argument and returns boolean as output.
	//BiPredicate takes two any type argument and returns any type as output
	public static void biPredicate() {
		BiPredicate<Integer, String> biPredicate = (x, string) -> string.length() > x;
		System.out.println(biPredicate.test(10, "Siju"));
	}
	//Function take any type as input argument and returns any type as output.
	//BiFunction takes any type two argument and returns any type output.
	public static void biFunction() {
		BiFunction<String, String, Integer> biFunction = (str1, str2) -> str1.length() + str2.length();
		System.out.println(biFunction.apply("Siju", "Babu"));
	}
	
	//Consumer take any type as input argument and returns nothing.
	//BiConsumer takes any type two argument and returns nothing.
	public static void biConsumer() {
		BiConsumer<String, String> biConsumer = (firstName, lastName) -> System.out.println("My name is : "+firstName +" " + lastName);
		biConsumer.accept("Siju", "Babu");
	}
	
	
	//Now lets discuss below.
	/*
	 * When you go to package -> java.util.function you can see below Functional interfaces
	 * 
	 * IntPredicate
	 * IntConsumer
	 * IntFunction
	 * ...
	 * 
	 * LongPredicate
	 * LongConsumer
	 * LongFunction
	 * ...
	 * 
	 * All these type of Functional Interfaces are for primitive type. So even if we can achieve all these using BinaryPredicate
	 * Using the primitive type we can avoid boxing and unboxing.
	 * 
	 * When when there are cases to use primitive type please go with primitive functional interfaces
	 * 
	 * 
	 * 
	 */
}
