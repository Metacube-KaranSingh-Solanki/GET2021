import java.util.Scanner;

public class App {
	/**
	 * These all are made static so that method getInput() and main() both can use them directly.
	 */
	static String str1, str2;
	static int choice;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {	
		StringOperations stringOperations = new StringOperations();
		
		do {
			System.out.println("----------- String Operations -----------");
			System.out.println("[1] Compare two strings");
			System.out.println("[2] Reverse a string");
			System.out.println("[3] Alternate case");
			System.out.println("[4] Find longest word");
			System.out.println("[5] Exit");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
				case 1:
					getInputs();
					System.out.println("Result of comparison is:\n" + stringOperations.compare(str1, str2));
					break;
					
				case 2:
					getInputs();
					System.out.println("Reverse is: \n" + stringOperations.reverse(str1));
					break;
					
				case 3:
					getInputs();
					System.out.println("String after altering case is: \n" + stringOperations.alterCase(str1));
					break;
					
				case 4:
					getInputs();
					System.out.println("Largest word is: \n" + stringOperations.findLargestWord(str1));
					break;
					
				case 5:
					System.out.println("--Exiting--");
					break;
					
				default:
					System.out.println("Invalid choice, please try again.");
			}
		} while (choice != 5);
	}
	
	//Prompt and input one or two strings and assigns them to str1 (and str2), based on choice.
	public static void getInputs() {
		System.out.println("Enter string: ");
		str1 = sc.nextLine();
		if (choice == 1) {
			System.out.println("Enter another string: ");
			str2 = sc.nextLine();
		}
	}
}
