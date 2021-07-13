import java.util.Scanner;

public class Shop {

	public static void main(String[] args) {

		// Static inventory...
		String itemNames[] = { "Pencil", "Pen", "Eraser", "Sharpner" };
		double itemPrices[] = { 10, 15, 5, 3 };
		int itemUnits[] = { 5, 8, 10, 10 };
		Inventory inventory = new Inventory(itemNames, itemPrices, itemUnits);

		Cart cart = new Cart();

		Scanner sc = new Scanner(System.in);

		// Menu based system for user interaction
		int choice;
		do {
			System.out.println("\n--- Shop Menu---");
			System.out.println("[1] Display Inventory");
			System.out.println("[2] Display Cart");
			System.out.println("[3] Add Product to Cart");
			System.out.println("[4] Remove Product from Cart");
			System.out.println("[5] Generate bill");
			System.out.println("[0] Exit");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				inventory.displayProducts();
				break;

			case 2:
				cart.displayProducts();
				break;

			case 3: {
				System.out.println("----- Adding Product -----");
				System.out.println("Enter product ID: ");
				int pid = sc.nextInt();
				System.out.println("Enter number of units: ");
				int units = sc.nextInt();
				boolean status = cart.addProduct(inventory, pid, units);
				if (status)
					System.out.println("Product added successfully.");
				else
					System.out.println("Not available.\n");
			}
				break;

			case 4: {
				if (cart.totalProducts() != 0) {
					System.out.println("----- Removing Product -----");
					System.out.println("Enter product ID: ");
					int pid = sc.nextInt();
					System.out.println("Enter number of units: ");
					int units = sc.nextInt();
					boolean status = cart.removeProduct(inventory, pid, units);
					if (status)
						System.out.println("Product removed successfully.");
					else
						System.out.println("Not enough products.\n");
				} else
					System.out.println("Cart is empty.");
			}
				break;

			case 5:
				cart.generatBill();
				break;

			case 0:
				break;

			default:
				System.out.println("Invalid choice.\n");
			}
		} while (true);
	}
}