import java.util.Map;

import java.util.LinkedHashMap;

public class Cart {
	private Map<Product, Integer> productsByUnits;

	public Cart() {
		productsByUnits = new LinkedHashMap<>();
	}
	
	public int totalProducts() {
		return productsByUnits.size();
	}

	public void displayProducts() {
		if (totalProducts() != 0) {
			for (Product product : productsByUnits.keySet()) {
				System.out.print(product);
				System.out.println(" UNITS: " + productsByUnits.get(product));
			}
		} else System.out.println("Cart is empty.");;
	}

	public boolean addProduct(Inventory inventory, int pid, int unitsToAdd) {
		// Checks if products available and some units of product are already added, then increment them otherwise just add.
		if (inventory.getUnits(pid) >= unitsToAdd) {
			Product product = inventory.getProductByPid(pid);
			updateUnits(product, getUnits(pid) + unitsToAdd); 					  	// Increasing units in cart
			inventory.updateUnits(product, inventory.getUnits(pid) - unitsToAdd); 	// Reducing units from inventory
			return true;
		}
		return false;
	}

	public boolean removeProduct(Inventory inventory, int pid, int unitsToRemove) {
		// Checks if products available in cart then only remove
		if (getUnits(pid) >= unitsToRemove) {
			Product product = inventory.getProductByPid(pid);
			updateUnits(product, getUnits(pid) - unitsToRemove);				  		// Reducing units in cart
			inventory.updateUnits(product, inventory.getUnits(pid) + unitsToRemove);	// Increasing units in inventory
			return true;

		}
		return false;

	}

	public void generatBill() {
		double totalAmount = 0;
		for (Product product : productsByUnits.keySet()) {
			int units = productsByUnits.get(product);
			double price = product.getPrice();
			
			System.out.printf("%-10s: %-2d X Rs.%-4.2f = Rs.%-4.2f\n", product.getName(), units, price, units*price);
			
			totalAmount += units * price;
		}
		System.out.println("Total Amount: " + totalAmount);
	}

	public int getUnits(int pid) {
		for (Product product : productsByUnits.keySet()) {
			if (product.getPid() == pid) {
				int units = productsByUnits.get(product);
				return units;
			}
		}
		return 0;
	}

	public void updateUnits(Product product, int newUnits) {
		if (newUnits == 0) { 								// Removing all units of a product means removing whole product
			productsByUnits.remove(product);
		} else {
			productsByUnits.put(product, newUnits);
		}
	}

}
