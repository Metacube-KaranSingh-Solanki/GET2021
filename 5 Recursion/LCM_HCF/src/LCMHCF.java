public class LCMHCF {
	/**
	 * Finds the Highest Common Divisor (HCF) of two numbers
	 * 
	 * @param x First number, requires x >= 0
	 * @param y Second number, requires y >= 0
	 * @return HCF of x and y
	 */
	public int findHCF(int x, int y) {
		if (x == 0)
			return y;
		return findHCF(y % x, x);
	}

	/**
	 * Finds the Lowest Common Multiplier (LCM) of two numbers
	 * 
	 * @param x First number, requires x >= 0
	 * @param y Second number, requires y >= 0
	 * @return LCM of x and y
	 */
	public int findLCM(int x, int y) {
		return (x * y) / findHCF(x, y); // Using formulae LCM = (x * y) / HCF
	}

}
