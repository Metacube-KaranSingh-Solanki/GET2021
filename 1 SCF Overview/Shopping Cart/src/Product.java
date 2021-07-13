// This class represents a Product
public class Product{
	
	private Integer pid;
	private String name;
	private Double price;
	
	public Product(Integer pid, String name, Double price) {
		this.pid = pid;
		this.name = name;
		this.price = price;
	}

	public Integer getPid() {
		return pid;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}
	

	@Override
	public String toString() {
		return String.format("[%d] %-13s PRICE: %-4s", pid, name, price);
	}

}
