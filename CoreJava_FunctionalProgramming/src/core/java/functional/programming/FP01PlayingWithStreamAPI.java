package core.java.functional.programming;

import java.util.List;

public class FP01PlayingWithStreamAPI {

	public static void main(String ar[]) {
		List<Integer> integerList = List.of(22, 1, 8, 9, 27, 81, 37);
		reduceMethod(integerList);
		
	}
	
	public static void reduceMethod(List<Integer> integerList) {
		//StreamAPI reduce() method : Refer Java Doc for more details
		//reduce is used to aggregation over the element, It can be addition subtraction or multiplication or other operations
		//Refer Documentation. It effectively utilize the multi core that we have also it parallelize more gracefully
		integerList.stream().reduce(0, FP01PlayingWithStreamAPI::sum);
		//Below is how the reduce function works
		//	0 22
		//	22 1
		//	23 8
		//	31 9
		//	40 27
		//	67 81
		//	148 37
		//Update version by ignoring add function and applying lambda function
		integerList.stream().reduce(0, (x, y) -> x + y);
		//More updated version Integer class already have same sum method
		integerList.stream().reduce(0, Integer::sum);
	}
	
	public static void distinctANDsortMethod(List<Integer> integerList) {
		//StreamAPI distinct() method : Refer Java Doc for more details
		//Takes only distinct value
		integerList.stream().distinct().forEach(System.out::println);
		//StreamAPI sorted() method : Refer Java Doc for more details
		//Sort the values in a collection
		integerList.stream().sorted().forEach(System.out::println);
		//Distinct and Sort combined
		integerList.stream().distinct().sorted().forEach(System.out::println);
	}
	
	public void reduceMethodMoreExample(List<Integer> integerList) {
		integerList.stream().reduce(0, (x, y) -> x);
		integerList.stream().reduce(0, (x, y) -> y);
		integerList.stream().reduce(0, (x, y) -> 1);
		integerList.stream().reduce(0, (x, y) -> x*y);
		integerList.stream().reduce(0, (x, y) -> x-y);
		integerList.stream().reduce(0, (x, y) -> x+y+x);
		//If you want sum of squares of the number then you have to do like below
		integerList.stream().map(x -> x*x).reduce(0, (x, y) -> x+y+x);
		integerList.stream().filter(x->x%2==0).map(x -> x*x).reduce(0, (x, y) -> x+y+x);
	}
	
	public static int sum(int a, int b) {
		System.out.println(a + " " + b);
		return a+b;
	}
}
