package core.java.functional.programming;

import java.util.List;
import java.util.function.Predicate;

//Here we are just trying out can we pass the behavior/function to another function.
//Predicate<Integer> integerPredicate = x-> x%2==0;
//Here can we pass the behavior/function 'integerPredicate' to another function.
//Below two points are important things to remember.
//We assign a function to a variable
//We passes a function to another function
public class FP02BehaviourParameterization {

	public static void main(String ar[]) {
		List<Integer> integers = List.of(11, 22, 17,9 ,13, 9, 27);
		behaviorParameterization(integers);
	}
	
	//This is the example of behavior /function parameterization
	//This will help you in most of the case where you pass the algorithm and rest of the things will be n a single place
	public static void behaviorParameterization(List<Integer> integers) {
		Predicate<Integer> evenPredicate = x->x%2==0;
		Predicate<Integer> oddPredicate = x->x%2!=0;
		filterAndPrint(integers, evenPredicate);
		filterAndPrint(integers, oddPredicate);
		
	}
	
	//Common place where we pass the behavior/function as parameter
	//We passing a function to another function.
	public static void filterAndPrint(List<Integer> integers, Predicate<Integer> predicate) {
		integers.stream().filter(predicate).forEach(System.out::println);
	}
}
