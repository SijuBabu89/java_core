package core.java.functional.programming;

import java.util.List;

public class FP01FunctionalProgramming {

	public static void main(String ar[]) {
		List<Integer> integerList = List.of(7,99,12,31,4,7,14);
		integerList
		.stream() //Stream API -> This will convert the collection into streams of elements, so that if we want to do manipulation, we can do that against each element.
		.filter(i -> i%2 == 0) //Filter is used to filter out unwanted elements
		.map(i -> i*i) // Map is used to manipulate the elements
		.forEach(System.out::println); //ForEach is a consumer which consume the element and will not return anything
	}
}
