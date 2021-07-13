/*
 * Represents a calculator for specified base. Specify the base in the constructor.
 * */
public class BaseCalc{
	private final String digits = "0123456789ABCDEF";		// To simplify the conversion
	private int base;
	
	BaseCalc(int base) {
		this.base = base;
	}
	
	// Arithmetic operations... (Performed after conversion to decimal)
	public String add(String str1, String str2) {
		int result = toDecimal(str1) + toDecimal(str2);
		return toBase(result);
	}

	public String subtract(String str1, String str2) {
		int result = toDecimal(str1) - toDecimal(str2);
		return toBase(result);
	}

	public String multiply(String str1, String str2) {
		int result = toDecimal(str1) * toDecimal(str2);
		return toBase(result);
	}

	public String divide(String str1, String str2) {
		int result = toDecimal(str1) / toDecimal(str2);
		return toBase(result);
	}
	
	// Logical operations... (Performed without conversion to decimal)
	public boolean areEqual(String str1, String str2) {
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		if (str1.length() != str2.length()) 
			return false;
		else {
			for (int i=0; i<str1.length(); i++) {			   // Length are equal
				char d1 = str1.charAt(i);
				char d2 = str2.charAt(i);
				
				if (d1 != d2)
					return false;
			}
		}
		return true;
	}
	
	// Returns true if str1 is greater than str2, false otherwise
	public boolean isGreater(String str1, String str2) {
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		if (str2.length() < str1.length())
			return true;
		else {
			for (int i=0; i<str1.length(); i++) {				// Length are equal
				char d1 = str1.charAt(i);
				char d2 = str2.charAt(i);
				
				if (d1 > d2)
					return true;
				else if (d1 == d2)
					continue;
				else
					break;
			}
		}
		return false;
	}
	
	// Returns true if str1 is lesser than str2, false otherwise
	public boolean isLesser(String str1, String str2) {
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		if (str1.length() < str2.length())
			return true;
		else {
			for (int i=0; i<str1.length(); i++) {				// Length are equal
				char d1 = str1.charAt(i);
				char d2 = str2.charAt(i);
				
				if (d2 > d1)
					return true;
				else if (d1 == d2)
					continue;
				else
					break;
			}
		}
		return false;
	}
	
	// Conversion operations...
	public int toDecimal(String hexString) {
		hexString = hexString.toUpperCase();  
        int decimal = 0;  
        for (int i = 0; i < hexString.length(); i++) {  
            char ch = hexString.charAt(i);  
            int digit = digits.indexOf(ch);  
            decimal = base * decimal + digit;  
        }  
        return decimal;
	}
	
	public String toBase(int decimal) {	
		StringBuilder hexString = new StringBuilder();
		int remainder;
		while (decimal != 0) {
			remainder = decimal % base;
			char digit = digits.charAt(remainder);
			hexString.insert(0, digit);
			decimal /= base;
		}
		return hexString.toString(); 
	}

}
