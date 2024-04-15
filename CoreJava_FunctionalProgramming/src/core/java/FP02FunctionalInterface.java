package core.java;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
public class FP02FunctionalInterface {

	public static void main(String ar[]) {
		List<Integer> integers = List.of(22, 11, 32, 17, 8, 9, 13);
	}
	
	public void explainFunctionalInterface(List<Integer> integers) {
		integers.stream()
		.filter(x -> x%2==0)
		.map(i -> i*i)
		.forEach(System.out::println);
		//We can rewrite above into below to understand more about functional interface
		Predicate<Integer> isEvenPredicate = x -> x%2==0;
		Function<Integer, Integer> squareFunction = i -> i*i;
		Consumer<Integer> sysoutConsumer = System.out::println;
		
		integers.stream()
		.filter(isEvenPredicate)
		.map(squareFunction).forEach(sysoutConsumer);
	}
}
