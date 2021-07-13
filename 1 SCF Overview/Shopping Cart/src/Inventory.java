import java.util.Map;

import java.util.LinkedHashMap;

public class Inventory {
	private Map<Product, Integer> productsByUnits;		

	public Inventory(String[] itemNames, double[] itemPrices, int[] units) {

		productsByUnits = new LinkedHashMap<>();
		for (int i = 0; i < itemNames.length; i++) {
			Product tempProduct = new Product(i + 1, itemNames[i], itemPrices[i]);
			productsByUnits.put(tempProduct, units[i]);
		}
	}

	public void displayProducts() {
		for (Product product : productsByUnits.keySet()) {
			System.out.print(product);
			System.out.println(" UNITS: " + productsByUnits.get(product));
		}
	}

	public Product getProductByPid(int pid) {
		for (Product product : productsByUnits.keySet()) {
			if (product.getPid() == pid) {
				return product;
			}
		}
		return null;
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
		productsByUnits.put(product, newUnits);
	}

}
