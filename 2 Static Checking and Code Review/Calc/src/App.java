public class App {
	public static void main(String[] args) {
		BaseCalc hexCalc = new BaseCalc(16);
		
		// Testing different cases for Hex values...
		System.out.println("Decimal of D3F23: " + hexCalc.toDecimal("D3F23"));
		System.out.println("Hex of 868131: " + hexCalc.toBase(868131));
		System.out.println("Addition: " + hexCalc.add("D3F23", "2F65"));
		System.out.println("Subtraction: " + hexCalc.subtract("D3F23", "2F65"));
		System.out.println("Multiplication: " + hexCalc.multiply("D3F23", "2F65"));
		System.out.println("Division: " + hexCalc.divide("D3F23", "2B"));
		
		System.out.println("------------------");
		System.out.println("3DF == 3DF: " + hexCalc.areEqual("3DF", "3DF"));
		System.out.println("3DF > 3DE: " + hexCalc.isGreater("3DF", "3DE"));
		System.out.println("3DF < 3DE: " + hexCalc.isLesser("3DF", "3DE"));
		
	}
	

}

/*
 * Answer of the Question: How would you generalize this to support arithmetic in any base?
 * We've made the class as BaseCalc which is capable of performing operations on any base.
 * Because we know that base only differs by a value, 16 for hex, 8 for octal, 2 for binary and 10 for decimal,
 * remaining all things are same. So the BaseCalc is already generalized, just pass the base in constructor and it'll 
 * work for that base. 
 * */
