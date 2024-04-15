package core.java.functional.programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
/*

x -> x%2==0 
---------------------------------------------
 This is the representation of below method
 
 boolean isEven(int i) {
 	return i%2 ==0;
 }
---------------------------------------------
---------------------------------------------

i -> i*i
---------------------------------------------
This is the representation of below method

int square(int i) {
    return i*i;
}
--------------------------------------------
--------------------------------------------
*/

/*
 * 
1) Predicate -> Predicate is used to test something. 
   It is used inside the filter to validate some condition and based on that condition it filters the elements
2) Functions -> Function is used to manipulate the element. It accept one argument and produce one result.  
3) Consumer -> It consumes the argument. That is it accept one argument and return no result. 
 * 
 */
public class FP02FunctionalInterface {

	public static void main(String ar[]) {
		List<Integer> integers = List.of(22, 11, 32, 17, 8, 9, 13);
		explainFunctionalInterface(integers);
	}
	
	public static void explainFunctionalInterface(List<Integer> integers) {
		integers.stream()
		.filter(x -> x%2==0)
		.map(i -> i*i)
		.forEach(System.out::println);
		//We can rewrite above into below to understand more about functional interface
		Predicate<Integer> isEvenPredicate = x -> x%2==0;
		//The compiler internally handles the above code like below. 
		//Internally something like below is created for us also the value is passed to it and get the result.
		//So by the below example the lambda functions are also a type of object.
		Predicate<Integer> isEvenPredicateInternal = new Predicate<Integer>() {			
			@Override
			public boolean test(Integer x) {
				// TODO Auto-generated method stub
				return x%2==0;
			}
		};
		
		Function<Integer, Integer> squareFunction = i -> i*i;
		//The compiler internally handles the above code like below. 
		Function<Integer, Integer> squareFunctionInternal = new Function<Integer, Integer>() {		
			@Override
			public Integer apply(Integer i) {
				// TODO Auto-generated method stub
				return i*i;
			}
		};
		
		Consumer<Integer> sysoutConsumer = System.out::println;
		//The compiler internally handles the above code like below. 
		Consumer<Integer> sysoutConsumerInternal = new Consumer<Integer>() {		
			@Override
			public void accept(Integer i) {
				System.out.println();
				
			}
		};
		
		//BinaryOperator
		
		BinaryOperator<Integer> binaryOperator  = Integer::sum;
		BinaryOperator<Integer> binaryOperatorMultiply  = FP02FunctionalInterface::multiply;
		BinaryOperator<Integer> binaryOperatorInternal  = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		integers.stream()
		.filter(isEvenPredicate)
		.map(squareFunction).forEach(sysoutConsumer);
		System.out.println("-----------------------------------");
		integers.stream()
		.filter(isEvenPredicateInternal)
		.map(squareFunctionInternal).forEach(sysoutConsumerInternal);
	}
	
	public static int multiply(int a, int b) {
		return a*b;
	}
	
	//Go through this method to understand the input and out type of functional interface.
	public static void understandFunctionalInterface() {
		
		Predicate<Integer> isEvenPredicate = x -> x%2==0; //You have a Integer input and a boolean output
		Function<Integer, Integer> squareFunction = i -> i*i; //You have a Integer input and a Integer output
		Function<Integer, String> stringSquareFunction = i -> i*i + ""; //You have a Integer input and a String output
		Consumer<Integer> sysoutConsumer = x -> System.out.println(x);//You have only a Integer input and not output
		BinaryOperator<Integer> binaryOperator  = (x, y) -> x + y;//When you see a Operator name with the functional interface then the input and output are in same type. That is why only single Integer type. Here Binary so ake two parameter
		Supplier<Integer> supplier = () -> 2; //Will not take any argument and returns a Integer output
		UnaryOperator<Integer> unaryOperator = x-> 3 + x;//As we discuss above, Operator so the input and out are of same type. Here Unary so single parameter and Single integer output.
	}
}
