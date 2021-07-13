import java.util.Scanner;

public class Marksheet {
	private int[] grades;
	private int numberOfStudents;
	private static final int PASSING_MARKS = 40;
	
	/**
	 * Constructor of Marksheet
	 * @param numberOfStudents requires positive integer
	 */
	public Marksheet(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
		grades = new int[numberOfStudents];
	}
	
	/**
	 * Reads the grades of students from user and assigns them to the grades array
	 */
	public void readGrades(){
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter grades of %d students\n", numberOfStudents);
		for (int i = 0; i < numberOfStudents; i++) {
			System.out.printf("Student %d: ",(i+1));
			grades[i] = sc.nextInt();
		}
	}
	
	/**
	 * Finds the average grade of all grades
	 * @return average grade
	 * @throws ArithmeticException
	 */
	public double findAvgGrade() throws ArithmeticException{
		double avgGrade;
		int sum = 0;
		for (int i = 0; i < numberOfStudents; i++) 
			sum += grades[i];
		avgGrade = sum / (double)numberOfStudents;
		return Math.round(avgGrade * 100.0) / 100.0;			// For rounding up to at most 2 decimal places
	}
	
	/**
	 * Finds the maximum grade of all grades
	 * @return maximum grade
	 * @throws ArithmeticException
	 */
	public int findMaxGrade() throws ArithmeticException{
		int maxGrade = grades[0];
		for (int i = 1; i < numberOfStudents; i++) {
			if (grades[i] > maxGrade)
				maxGrade = grades[i];
		}
		return maxGrade;
	}
	
	/**
	 * Finds the minimum grade of all grades
	 * @return minimum grade
	 * @throws ArithmeticException
	 */
	public int findMinGrade() throws ArithmeticException {
		int minGrade = grades[0];
		for (int i = 1; i < numberOfStudents; i++) {
			if (grades[i] < minGrade)
				minGrade = grades[i];
		}
		return minGrade;
	}
	
	/**
	 * Finds percentage of students passed
	 * @return percentage of students passed
	 * @throws ArithmeticException
	 */
	public double findResult() throws ArithmeticException {
		int numberOfStudentsPassed = 0;
		double percentageOfStudentsPassed;
		for (int i = 0; i < numberOfStudents; i++) {
			if (grades[i] >= PASSING_MARKS) 
				numberOfStudentsPassed++;
		}
		percentageOfStudentsPassed = numberOfStudentsPassed * 100 / (double)numberOfStudents;
		return Math.round(percentageOfStudentsPassed * 100.0) / 100.0;				// For rounding up to at most 2 decimal places
	}
}
