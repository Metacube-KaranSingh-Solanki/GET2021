import java.util.Scanner;

public class App {
	/**
	 * These all are made static so that method getInput() and main() both can use
	 * them directly.
	 */
	static double height, width, radius;
	static int choice;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Area area = new Area();
		do {
			System.out.println("----------- Area Calculator -----------");
			System.out.println("[1] Area of Triangle");
			System.out.println("[2] Area of Rectangle ");
			System.out.println("[3] Area of Square");
			System.out.println("[4] Area of Circle");
			System.out.println("[5] Exit");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			try {
				switch (choice) {
				case 1:
					getInputs();
					System.out.println("Area of Triangle:\n" + area.findAreaOfTriangle(height, width));
					break;

				case 2:
					getInputs();
					System.out.println("Area of Rectangle: \n" + area.findAreaOfRectange(height, width));
					break;

				case 3:
					getInputs();
					System.out.println("Area of Square: \n" + area.findAreaOfSquare(width));
					break;

				case 4:
					getInputs();
					System.out.println("Area of Circle: \n" + area.findAreaOfCircle(radius));
					break;

				case 5:
					System.out.println("--Exiting--");
					break;

				default:
					System.out.println("Invalid choice, please try again.");
				}
			} catch (ArithmeticException e) {
				System.out.println("Something went wrong.");
			}

		} while (choice != 5);
	}

	// Prompt and input height, width or radius based on the choices and assigns them to static variables
	public static void getInputs() {
		if (choice == 1 || choice == 2 || choice == 3) {
			System.out.println("Enter width: ");
			width = sc.nextDouble();

			if (choice == 1 || choice == 2) {
				System.out.println("Enter height: ");
				height = sc.nextDouble();
			}
		} else {
			System.out.println("Enter radius: ");
			radius = sc.nextDouble();
		}
	}
}
