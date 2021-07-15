import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class ArrOperationsTest {
	
	public static ArrOperations arrOperations = new ArrOperations();
	
	/** ------- [1.1] countClumps Parameterized Tests ------- */
	@RunWith(Parameterized.class)
	public static class ParamTestCountClumps {
		
		@Parameters
		public static Collection<Object[]> countClumpsTestData() {
			return Arrays.asList(new Object[][]{
				{new int[]{1, 2, 2, 3, 4, 4}, 2},
				{new int[]{1, 1, 2, 1, 1}, 2},
				{new int[]{1, 1, 1, 1, 1}, 1}
			});
		}
		
		private int[] inputArray;
		private int expectedOutput;
		
		public ParamTestCountClumps(int[] inputArray, int expectedOutput) {
			this.inputArray = inputArray;
			this.expectedOutput = expectedOutput;
		}
		
		@Test
		public void testCountClumps() {
			assertEquals(expectedOutput, arrOperations.countClumps(inputArray));
		}
	}
	
	/** ------- [1.2] countClumps AssertionError Tests ------- */
	@Test
	public void testCountClumps_arrayEmptyAssertionError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			arrOperations.countClumps(new int[] {});
		});
	}

	/** ------- [1.3] countClumps Negative Tests --------- */
	@Test
	public void testcountClumps_NegativeTest(){
		assertNotEquals(4, arrOperations.countClumps(new int[]{1,1,2,3}));
	}

	// ==============================================================================
	
	/** ------- [2.1] maxMirror Parameterized Tests ------- */
	@RunWith(Parameterized.class)
	public static class ParamTestMaxMirror {
		
		@Parameters
		public static Collection<Object[]> countClumpsTestData() {
			return Arrays.asList(new Object[][]{
				{new int[]{1, 2, 3, 8, 9, 3, 2, 1}, 3},
				{new int[]{7, 1, 4, 9, 7, 4, 1}, 2},
				{new int[]{1, 2, 1, 4}, 3},
				{new int[]{1, 4, 5, 3, 5, 4, 1}, 7}
			});
		}
		
		private int[] inputArray;
		private int expectedOutput;
		
		public ParamTestMaxMirror(int[] inputArray, int expectedOutput) {
			this.inputArray = inputArray;
			this.expectedOutput = expectedOutput;
		}
		
		@Test
		public void testMaxMirror() {
			assertEquals(expectedOutput, arrOperations.maxMirror(inputArray));
		}
	}
	
	/** ------- [2.2] maxMirror AssertionError Tests ------- */
	@Test
	public void testMaxMirror_arrayEmptyAssertionError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			arrOperations.maxMirror(new int[] {});
		});
	}

	/** ------- [2.3] maxMirror Negative Tests ----------- */
	@Test
	public void testmaxMirror_NegativeTest(){
			assertNotEquals(4, arrOperations.countClumps(new int[]{1,1,2,3}));
	}
	
	// ==============================================================================
	
	/** ------- [3.1] fixXY Parameterized Tests ------- */
	@RunWith(Parameterized.class)
	public static class ParamTestFixXY {
		
		@Parameters
		public static Collection<Object[]> fixXYTestData() {
			return Arrays.asList(new Object[][] {
				{new int[]{5, 4, 9, 4, 9, 5}, new int[]{9, 4, 5, 4, 5, 9}},
				{new int[]{1, 4, 1, 5}, new int[]{1, 4, 5, 1}},
				{new int[]{1, 4, 5, 1, 1, 4, 5}, new int[]{1, 4, 5, 1, 1, 4, 5}},
				{new int[]{1, 2, 3, 5, 4, 6, 7}, new int[]{1, 2, 3, 6, 4, 5, 7}}
			});
		}
		
		private int[] inputArray;
		private int[] expectedOutput;
		private int X = 4, Y = 5;
		
		public ParamTestFixXY(int[] inputArray, int[] expectedOutput) {
			this.inputArray = inputArray;
			this.expectedOutput = expectedOutput;
		}
		
		@Test
		public void testFixXY() {
			assertArrayEquals(expectedOutput, arrOperations.fixXY(inputArray, X, Y));
		}
	}
	
	/** ------- [3.2] fixXY AssertionError Tests ------- */
	@Test
	public void testFixXY_emptyArrayAssertionError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			arrOperations.fixXY(new int[] {}, 4, 5);
		});
	}

	@Test
	public void testFixXY_twoAdjacentXAssertionError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			arrOperations.fixXY(new int[] { 1, 5, 3, 4, 4, 5 }, 4, 5);
		});
	}

	@Test
	public void testFixXY_XYUnequalAssertionError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			arrOperations.fixXY(new int[] { 1, 2, 4, 2, 4, 5 }, 4, 5);
		});
	}

	/** ------- [3.3] fixXY Negative Tests -------------- */
	public void testFixXY(){
		assertNotEquals(new int[]{1,2,4,6,5,7,8}, arrOperations.fixXY(new int[]{1,2,5,4,6,7,8},5,6));
	}
	
	// ==============================================================================
	
	/** ------- [4.1] splitArray Parameterized Tests ------- */
	@RunWith(Parameterized.class)
	public static class ParamTestSplitArray {
		
		@Parameters
		public static Collection<Object[]> splitArrayTestData() {
			return Arrays.asList(new Object[][] {
				{new int[]{1, 1, 1, 2, 1}, 3},
				{new int[]{2, 1, 1, 2, 1}, -1},
				{new int[]{10, 10}, 1},
				{new int[]{3, 7, 2, 12}, 3}
			});
		}
		
		private int[] inputArray;
		private int expectedOutput;
		
		public ParamTestSplitArray(int[] inputArray, int expectedOutput) {
			this.inputArray = inputArray;
			this.expectedOutput = expectedOutput;
		}
		
		@Test
		public void testFixXY() {
			assertEquals(expectedOutput, arrOperations.splitArray(inputArray));
		}
	}
	
	/** ------- [4.2] splitArray AssertionError Test ------- */
	@Test
	public void testSplitArray_arrayEmptyAssertionError() {
		Assertions.assertThrows(AssertionError.class, () -> {
			arrOperations.splitArray(new int[] {});
		});
	}

	/** ------- [4.3] splitArray Negative Tests ----------- */
	public void testSplitArray(){
		assertNotEquals(4, arrOperations.splitArray(new int[] {1, 1, 2, 3}));
	}
	
}
