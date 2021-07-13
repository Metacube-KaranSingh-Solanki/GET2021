import java.util.Scanner;

public class App {
	public static final int passingMarks = 40;

	public static void main(String[] args) {
		int numberOfStudents;
		Scanner sc = new Scanner(System.in);

		System.out.println("------------ Marksheet Generator -------------");
		System.out.println("Enter the number of students: ");
		numberOfStudents = sc.nextInt();

		Marksheet marksheet = new Marksheet(numberOfStudents);
		marksheet.readGrades();

		System.out.println("------------- Marksheet Generated --------------");
		try {
			System.out.println("Maximum grade: " + marksheet.findMaxGrade());
			System.out.println("Minimum grade: " + marksheet.findMinGrade());
			System.out.println("Average grade: " + marksheet.findAvgGrade());
			System.out.println("Percentage of students passed (>=40): " + marksheet.findResult());
		} catch (ArithmeticException e) {
			System.out.println("Something went wrong.");
		}
	}
}
