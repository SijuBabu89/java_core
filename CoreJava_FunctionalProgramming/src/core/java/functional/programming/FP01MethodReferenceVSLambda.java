package core.java.functional.programming;

import java.util.List;

/**
 * Functional Programming using Method Reference vs Lambda Expression.
 * 
 * @Method Reference : Using method reference we can call already defined method inside a lambda expression. The only condition is the signature of the method should suite the Consumer, Producer or Predicate interfaces.
 * @Lambda Expression : Where as lambda function we are defining a function inside the expression. Simpler way of defining method.
 * 
 * @StreamAPI : Stream API is nothing but it is used in collections and what it does is that it stream all elements in the collection on by one. 
 * So that we can do what ever manipulation that we want against the element.
 */

public class FP01MethodReferenceVSLambda {

	public static void main(String ar[]) {
		List<Integer> integers = List.of(6,7,11,18,9,18);
		lambda(integers);
		methodReference(integers);
		/**
		 * 	Explanation
		 * ## -> public static void methodReference(List<Integer> integerList) : This method is an example of method reference
		 * 	Here we are calling a method which is already defined. It will create an instance of Predicate interface and the
		 * 	filter method will call the test method of predicate and filter it based on the result.
		 * ## ->  public static void lambda(List<Integer> integerList)  : This method we are defining the filter function inside the
		 * filter method.
		 *  	 
		 * */
	}
	
	public static void methodReference(List<Integer> integerList) {
		integerList.stream().filter(FP01MethodReferenceVSLambda::isEven).forEach(System.out::println);
	}
	
	public static void lambda(List<Integer> integerList) {
		integerList.stream().filter(i -> i%2 == 0).forEach(i -> System.out.println(i));
	}
	
	public static boolean isEven(int i) {
		return i%2 ==0;
	}
	
}
