package core.java.functional.programming.custom;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP02AdvancedOperations {
	public static void main(String ar[]) {
		
		List<String> courses = List.of("Spring", "Java", "API", "Spring Boot", "Docker", "AWS", "Kubernetes");
		furtherOperations(courses);
		
	}
	
	
	//FlatMap :: Very Important
	public static void furtherOperations(List<String> courses) {
		String coursesString = courses.stream().collect(Collectors.joining(","));
		System.out.println(coursesString);
		//I want to split each character from all the courses. And to achieve this use flatMap
		System.out.println(courses.stream().map(course->course.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));
		
	}
	
	public static void higherOrderFunctions() {
		int cutoffReviewScore = 90;
		Predicate<? super Course> reviewScoreGreaterThan90Predicate = createPredicateWithCutoffReviewScore(cutoffReviewScore);
		Predicate<? super Course> reviewscoreLessThan80Predicate = course -> course.getReviewScore() < 80;
	}


	private static Predicate<? super Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
		return course -> course.getReviewScore() > cutoffReviewScore;
	}
}
