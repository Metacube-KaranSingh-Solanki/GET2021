import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class SearchTest {

	public static Search search = new Search();

	/** ------- [2.1] binarySearch Parameterized Tests (Negative tests included)  --------- */
	@RunWith(Parameterized.class)
	public static class ParamTestLinearSearch {

		@Parameters
		public static Collection<Object[]> linearSearchTestData() {
			return Arrays.asList(new Object[][] {
					// inputArray, value, expectedIndex
					{ new int[] {}, 5, -1 }, 
					{ new int[] { 4, 1, 8, 5, 10, 6 }, 10, 4 },
					{ new int[] { 12, 9, 13, 21, 50, -45 }, 9, 1 }, 
					{ new int[] { 1, -34, -6, 0, 10, 31 }, 0, 3 },
					{ new int[] { -45, -100, -4, 0, 103, 345, 934 }, 934, 6 },
					{ new int[] { -45, -100, -4, 0, 103, 345, 934 }, 100, -1 } });
		}

		private int[] inputArray;
		private int value, expectedIndex;

		public ParamTestLinearSearch(int[] inputArray, int value, int expectedIndex) {
			this.inputArray = inputArray;
			this.value = value;
			this.expectedIndex = expectedIndex;
		}

		@Test
		public void testLinearSearch() {
			assertEquals(expectedIndex, search.linearSearch(inputArray, value));
		}
	}

	/** ------- [2.1] binarySearch Parameterized Tests (Negative tests included) --------- */
	@RunWith(Parameterized.class)
	public static class ParamTestBinarySearch {

		@Parameters
		public static Collection<Object[]> binarySearchTestData() {
			return Arrays.asList(new Object[][] {
					// InputArray, value, expectedIndex
					{ new int[] {}, 5, -1 }, 
					{ new int[] { 1, 2, 3, 4, 5, 6 }, 4, 3 },
					{ new int[] { 9, 21, 25, 31, 37, 42, 50 }, 21, 1 },
					{ new int[] { -89, -34, -6, 0, 10, 31, 40 }, -89, 0 },
					{ new int[] { -100, -45, -4, 0, 103, 345, 934, 1023 }, 934, 6 },
					{ new int[] { -100, -45, -4, 0, 103, 345, 934, 1023 }, 100, -1 }, });
		}

		private int[] inputArray;
		private int value, expectedIndex;

		public ParamTestBinarySearch(int[] inputArray, int value,  int expectedIndex) {
			this.inputArray = inputArray;
			this.value = value;
			this.expectedIndex = expectedIndex;
		}

		@Test
		public void testBinarySearch() {
			assertEquals(expectedIndex, search.binarySearch(inputArray, value));
		}
	}
}