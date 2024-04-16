package core.java.functional.programming.custom;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;
	
	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	
	public String toString() {
		return name + ":" +noOfStudents + ":" + reviewScore;
	}
	
}

public class FP02CustomClass {
	//Here we want to look into the usage of allMatch, noneMatch, anyMatch
	public static void main(String ar[]) {
		List<Course> courses = List.of(
				new Course("Spring", "Framework", 98, 120),
				new Course("Spring Boot", "Framework", 95, 220),
				new Course("API", "Microservice", 97, 520),
				new Course("Microservice", "Microservice", 96, 320),
				new Course("FullStack", "FullStack", 90, 220),
				new Course("AWS", "Cloud", 99, 320),
				new Course("Azure", "Cloud", 90, 110),
				new Course("Docker", "Cloud", 97, 128),
				new Course("Kubernetes", "Cloud", 88, 90)
				);
		//****************** allMatch, noneMatch, anyMatch **********************************
		System.out.println(courses.stream().allMatch(course -> course.getReviewScore() > 90));
		System.out.println(courses.stream().allMatch(course -> course.getReviewScore() > 80));
		//Above code can be reformat as below
		Predicate<? super Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
		Predicate<? super Course> reviewscoreLessThan80Predicate = course -> course.getReviewScore() < 80;
		//ALLMATCH
		System.out.println(courses.stream().allMatch(reviewScoreGreaterThan90Predicate));
		System.out.println(courses.stream().allMatch(reviewscoreLessThan80Predicate));
		//NONEMATCH
		System.out.println(courses.stream().noneMatch(reviewScoreGreaterThan90Predicate));
		System.out.println(courses.stream().noneMatch(reviewscoreLessThan80Predicate));
		//ANYMATCH
		System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan90Predicate));
		System.out.println(courses.stream().anyMatch(reviewscoreLessThan80Predicate));
		
		//SORTING COURSES
		//Below comparator is to sort courses by increasing no of students in the course
		Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);
		System.out.println(courses.stream().sorted(comparingByNoOfStudentsIncreasing).collect(Collectors.toList()));
		//Below comparator is to sort courses by decreasing no of students in the course
		Comparator<Course> comparingByNoOfStudentsDecresing = Comparator.comparing(Course::getNoOfStudents).reversed();
		System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecresing).collect(Collectors.toList()));
		//Below comparator is to sort courses by two attributes noOfStudents and reviews
		Comparator<Course> comparingByNoOfStudentsAndNoOfReviewsIncreasing = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore);
		System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviewsIncreasing).collect(Collectors.toList()));
		//Below comparator is to sort courses by two attributes noOfStudents and reviews
		Comparator<Course> comparingByNoOfStudentsAndNoOfReviewsDecresing = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();
		System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviewsDecresing).collect(Collectors.toList()));
		
		//####### IMPORTANT ##########//
		//When you do comparing in primitive data type always go for primitive methods
		//comparingInt
		//comparingDouble
		//EG : Comparator
		//				.comparingInt(Course::getNoOfStudents)
		//				.thenComparingInt(Course::getReviewScore).reversed();
		//**********************************************************************************
		
		//******************** skip, limit, takeWhile and dropWhile *****************************
		//LIMIT -> It limit top to 5
		System.out.println(courses.stream().limit(4).collect(Collectors.toList()));
		//SKIP -> It skip top 3 and print remaining 
		System.out.println(courses.stream().skip(3).collect(Collectors.toList()));
		//COMBINED SKIP and LIMIT
		System.out.println(courses.stream().skip(3).limit(2).collect(Collectors.toList()));
		//TAKE WHILE -> It will take all elements until it finds a condition
		System.out.println(courses);
		System.out.println(courses.stream().takeWhile(course -> course.getReviewScore() > 95).collect(Collectors.toList()));
		//DROP WHILE -> It will take all the elements after satisfying a condition/ or it takes subsequent elements after satisfying a condition
		System.out.println(courses.stream().dropWhile(course -> course.getReviewScore() > 95).collect(Collectors.toList()));
		//***************************************************************************************
		
		//******************** max, min, findFirst and findAny *******************************
		//These methods are to get single elements
		
		//MAX
		//In below it return last element
		System.out.println(courses.stream().max(comparingByNoOfStudentsAndNoOfReviewsDecresing));
		//MIN
		//In below it return first element
		System.out.println(courses.stream().min(comparingByNoOfStudentsAndNoOfReviewsDecresing));
		//MIN - OPTIONAL
		//TO get empty optional. Here LessThan 80 there is no record. Optional is to avoid returning null values. especially in Functional Interface there are chances of getting lot of null values
		System.out.println(courses.stream().filter(reviewscoreLessThan80Predicate).min(comparingByNoOfStudentsAndNoOfReviewsDecresing));
		//MIN - OPTIONAL
		//TO get empty optional. And look how to handle empty optional
		System.out.println(courses.stream().filter(reviewscoreLessThan80Predicate).min(comparingByNoOfStudentsAndNoOfReviewsDecresing).orElse(new Course("Test", "Test", 0, 0)));
		//FINDFIRST
		//IT will take the first element in a collection
		System.out.println(courses.stream().filter(reviewScoreGreaterThan90Predicate).findFirst());
		System.out.println(courses.stream().filter(reviewscoreLessThan80Predicate).findFirst());
		//FINDANY
		//Return any of the element in the stream which match the criteria
		System.out.println(courses.stream().filter(reviewScoreGreaterThan90Predicate).findAny());
		//************************************************************************************
		
		//******************** sum, average, and count ***************************************
		//These methods are also to get single elements
		
		//SUM
		//It will return sum of students in all courses whose review score is greater than 90 : Sum result is not optional
		System.out.println(courses.stream().filter(reviewScoreGreaterThan90Predicate).mapToInt(Course::getNoOfStudents).sum());
		//Average
		//It will return average of students in all courses whose review score is greater than 90 : Average result is optional
		System.out.println(courses.stream().filter(reviewScoreGreaterThan90Predicate).mapToInt(Course::getNoOfStudents).average());
		//Count
		//It will return total no of courses whose review score is greater than 90 : Average result is optional
		System.out.println(courses.stream().filter(reviewScoreGreaterThan90Predicate).mapToInt(Course::getNoOfStudents).count());
		//Max
		//It will return max review value of a courses whose review score is greater than 90 : Average result is optional
		System.out.println(courses.stream().filter(reviewScoreGreaterThan90Predicate).mapToInt(Course::getNoOfStudents).max());
		//Min
		//It will return min review value of a courses whose review score is greater than 90 : Average result is optional
		System.out.println(courses.stream().filter(reviewScoreGreaterThan90Predicate).mapToInt(Course::getNoOfStudents).min());
		//**************************************************************************************
		
		//*********************** grouping ***************************************************
		//GROUPING
		//Below is to group the courses based on the category
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
		Map<String, List<Course>> hashMap = courses.stream().collect(Collectors.groupingBy(Course::getCategory));
		//Below is to group the courses based on the category
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
		//Below to get the course having maximum review in each category
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		//Below to get the course name instead of entire course and group based on the category
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));
		//****************************************************************************************
		
		
	}
}
