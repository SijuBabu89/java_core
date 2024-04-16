package core.java.functional.programming;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

//##Intermediate Operations
//When you look into map(), distinct(), sort(), filter() etc are returns a stream. 
//So all these options are returning a stream. So the methods that returns a stream are called intermediate operations 

//##Terminal Operations
//When you look into forEach() it returns void and look at  Collect() or reduce() it returns a specific type like list or map or int etc
//So the methods that returns void or any other specific type but not stream as return are called terminal operations
public class FP01StreamOperations {

	public static void main(String ar[]) {
		List<Integer> integers = List.of(11, 3, 19, 71, 13, 4, 33, 27);
		stream(integers);
		dynamicStreamCreation();
		
	}
	
	//Creating Streams
	public static void stream(List<Integer> integers) {
		//Below is the way where we create stream from a list
		System.out.println(integers.stream());
		//We also can create stream directly
		Stream.of(11, 3, 19, 71, 13, 4, 33, 27);
		//We also do stream operation in it
		Stream.of(11, 3, 19, 71, 13, 4, 33, 27).reduce(0, Integer::sum);
		
		
		//All the above are stream created with Object Integers. Since all the above are int creating Integer stream in inefficient
		//Below is of type IntStream
		
		int[] array = {11, 3, 19, 71, 13, 4, 33, 27};
		//Below is of int stream. To know it better just look into print statement of below two.
		Arrays.stream(array);
		
		
		System.out.println(Stream.of(11, 3, 19, 71, 13, 4, 33, 27)); // java.util.stream.ReferencePipeline$Head@6b884d57 : ReferencePipeline
		System.out.println(Arrays.stream(array)); //java.util.stream.IntPipeline$Head@38af3868 :: IntPipeline
		
		System.out.println(Arrays.stream(array).min());
		System.out.println(Arrays.stream(array).max());
		
		
	}
	
	//How to create primitive stream dynamically
	public static void dynamicStreamCreation() {
		IntStream intStream = IntStream.range(0, 10);
		intStream.forEach(System.out::println);
		//0-9
		IntStream.range(0, 10).sum();
		//1-10
		IntStream.rangeClosed(0, 10).sum();
		//To manipulate range values
		IntStream.iterate(0, e-> e+2).limit(10).sum();
		
		IntStream.iterate(0, e-> e+2).limit(10).peek(System.out::println).sum();
	}
	
	//BigInteger is to do calculation on larger numbers
	public static void BigIntegers() {
		IntStream.rangeClosed(1,  50).reduce(1, (x,y) -> x*y);
		LongStream.rangeClosed(1,  50).reduce(1L, (x,y) -> x*y);
		LongStream.rangeClosed(1,  50).reduce(1, (x,y) -> x*y);
		//->
		LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
	}
}
