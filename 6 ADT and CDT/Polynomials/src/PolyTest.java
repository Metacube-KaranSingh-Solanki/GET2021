import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PolyTest {
	private Poly polynomial; 
	
	/**
	 * Test evaluate method on value 0
	 */
	@Test
	public void TestEvaluateZero() {
		polynomial = new Poly(new int[] {1,2,0,3});
		Assertions.assertEquals(1, polynomial.evaluate(0));
	}
	
	/**
	 * Test evaluate method on value 1
	 */
	@Test
	public void TestEvaluateOne() {
		polynomial = new Poly(new int[] {1,2,0,3});
		Assertions.assertEquals(6, polynomial.evaluate(1));
	}
	
	/**
	 * Test evaluate method on negative value
	 */
	@Test
	public void TestEvaluateNegative() {
		polynomial = new Poly(new int[] {1,2,0,3});
		Assertions.assertEquals(-4, polynomial.evaluate(-1));
	}
	
	/**
	 * Test evaluate method on float value
	 */
	@Test
	public void TestEvaluate() {
		polynomial = new Poly(new int[] {1,2,0,3});
		Assertions.assertEquals(14.125, polynomial.evaluate(1.5));
	}
	
	/**
	 * Test on degree method
	 */
	@Test
	public void TestDegree() {
		polynomial = new Poly(new int[] {1,2,0,3});
		Assertions.assertEquals(3, polynomial.degree());
	}
	
	/**
	 * Test on degree method 0
	 */
	@Test
	public void TestDegreeZero() {
		polynomial = new Poly(new int[] {1});
		Assertions.assertEquals(0, polynomial.degree());
	}
	
	/**
	 * Test the addPoly method to add the polynomial values
	 */
	@Test
	public void TestAddPoly() {
		Poly output = Poly.addPoly(new Poly(new int[] {1,2,0,3}), new Poly(new int[] {1,2,0,3}));
		Assertions.assertTrue(Poly.compare(output, new Poly(new int[]{2,4,0,6})));
	}
	
	/**
	 * Test the multiplyPly method to multiply the polynomial values
	 */
	@Test
	public void TestMultiplyPoly() {
		Poly output = Poly.multiplyPoly(new Poly(new int[] {1,2,3,0}), new Poly(new int[] {1,2}));
		Assertions.assertTrue(Poly.compare(output, new Poly(new int[]{1,4,7,6})));
		
	}
}
