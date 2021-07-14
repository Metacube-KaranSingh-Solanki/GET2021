import java.util.Scanner;

public class App {
	
	static int choice;
	static Scanner sc = new Scanner(System.in);
	static String val1, val2;
	public static void main(String[] args) {
		BaseCalc hexCalc = new BaseCalc(16);			// We can set or input from user to generalize this base to support binary and octal also
		
		do {
			System.out.println("--------------- Hex Calculator -----------------");
			System.out.println("[1] Hex to decimal");
			System.out.println("[2] Decimal to hex");
			System.out.println("[3] Addition");
			System.out.println("[4] Subtraction");
			System.out.println("[5] Multiplication");
			System.out.println("[6] Division");
			System.out.println("[7] Equality");
			System.out.println("[8] Is greater than");
			System.out.println("[9] Is less than");
			System.out.println("[0] Exit");
			System.out.println("Enter your choice: ");
			
			choice = sc.nextInt();
			
			switch (choice) {
				case 1:
					System.out.println("Enter the hex value: ");
					val1 = sc.next();
					System.out.println("Decimal is: " + hexCalc.toDecimal(val1));
					break;
					
				case 2:
					System.out.println("Enter the decimal value: ");
					System.out.println("Hex is: " + hexCalc.toBase(sc.nextInt()));
					break;
					
				case 3:
					getInputs();
					System.out.println("Addition: " + hexCalc.add(val1, val2));
					break;
					
				case 4:
					getInputs();
					System.out.println("Subtraction: " + hexCalc.subtract(val1, val2));
					break;
					
				case 5:
					getInputs();
					System.out.println("Multiplication: " + hexCalc.multiply(val1, val2));
					break;
					
				case 6:
					getInputs();
					System.out.println("Division: " + hexCalc.divide(val1, val2));
					break;
					
				case 7:
					getInputs();
					System.out.printf("%s == %s: %b\n", val1, val2, hexCalc.areEqual(val1, val2));
					break;
					
				case 8:
					getInputs();
					System.out.printf("%s > %s: %b\n", val1, val2, hexCalc.isGreater(val1, val2));
					break;
					
				case 9:
					getInputs();
					System.out.printf("%s < %s: %b\n", val1, val2, hexCalc.isLesser(val1, val2));
					break;
					
				case 0:
					System.out.println("--- Terminated ---");
					break;
					
				default:
					System.out.println("Invalid choice, please try again.");
			}
		} while (choice != 0);	
	}
	
	/** Method to take the most common input: Two hex as strings.
	 * Assuming user input valid strings.
	 */
	public static void getInputs() {
		System.out.println("Enter first hex value: ");
		val1 = sc.next();
		sc.nextLine();										// To clear the Scanner Buffer
		System.out.println("Enter second hex value: ");
		val2 = sc.next();
	}
}

/*
 * Answer of the Question: How would you generalize this to support arithmetic in any base?
 * We've made the class as BaseCalc which is capable of performing operations on any base.
 * Because we know that base only differs by a value, 16 for hex, 8 for octal, 2 for binary and 10 for decimal,
 * remaining all things are same. So the BaseCalc is already generalized, just pass the base in constructor and it'll 
 * work for that base. 
 * */
