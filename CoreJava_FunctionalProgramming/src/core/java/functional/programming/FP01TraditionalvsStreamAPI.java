package core.java.functional.programming;

import java.util.Iterator;
import java.util.List;


public class FP01TraditionalvsStreamAPI {

	public static void main(String ar[]) {
		List<Integer> integerList = List.of(1,2,44,12,6,7,9);
		
		System.out.println("Test..");
		
		traditionalIterating(integerList);
		//usingStreamAPI(integerList);
	}
	
	
	public static void traditionalIterating(List<Integer> integerList) {
		// Using Iterator Function
		Iterator<Integer> integerIterable = integerList.iterator();
		while(integerIterable.hasNext()) {
			System.out.println("Using Itegrator the value is " + integerIterable.next());
		}
		
		// Using ForEach
		for(Integer i : integerList) {
			System.out.println("Using ForEach the value is : " + i);
		}
	}
	
	
	public static void usingStreamAPI(List<Integer> integerList) {
		integerList.stream().forEach(System.out::println);
		integerList.stream().forEach(i -> System.out.println("Using Stream API the value is : " + i));
		
	}
	
	public static boolean isEven(int number) {
		return number%2 == 0;
	}
}
