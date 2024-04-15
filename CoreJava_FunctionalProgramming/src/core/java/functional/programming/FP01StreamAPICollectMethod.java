package core.java.functional.programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP01StreamAPICollectMethod {

	public static void main(String ar[]) {
		List<Integer> integerList = List.of(11, 7, 9, 13, 27, 3, 5, 19);
		collectMethod(integerList);
	}
	
	public static void collectMethod(List<Integer> integerList) {
		//Using collect method created and collection form another collecting by 
		//squaring the element of source collection
		List<Integer> resultList = squaredList(integerList);
		System.out.println(resultList);
		
	}
	
	public static List<Integer> squaredList(List<Integer> integerList) {
		return integerList.stream().map(i -> i*i).collect(Collectors.toList());
	}
}
