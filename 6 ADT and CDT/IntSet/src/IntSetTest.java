import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class IntSetTest {
	
	static IntSet set1 = new IntSet(new int[] {1, 2, 3, 5, 10, 9, 8, 7});
	
	@Test
	public void testEmptySet() {
		IntSet testSet = new IntSet(new int[] {});
		assertEquals(0, testSet.size());
	}
	
	@Test
	public void testInvalidRange1() {
		int[] testArray = new int[] {110, 120};
		assertThrows(AssertionError.class, () -> {new IntSet(testArray);});
	}
	
	@Test
	public void testInvalidRange2() {
		int[] testArray = new int[] {-3, -4, 9, 8, 4};
		assertThrows(AssertionError.class, () -> {new IntSet(testArray);});
	}
	
	@Test
	public void testDuplicateValues() {
		IntSet testSet = new IntSet(new int[] {1, 2, 3, 3, 4, 4});
		assertEquals(4, testSet.size());
	}
	
	@Test
	public void testSize() {
		assertEquals(8, set1.size());
	}
	
	@Test
	public void testIsMember_Positive() {
		assertTrue(set1.isMember(10));
	}
	
	@Test
	public void tesIsMember_Negative() {
		assertFalse(set1.isMember(80));
	}
	
	@Test
	public void testIsSubSet_Positive() {
		IntSet set2 = new IntSet(new int[] {1, 3, 5});
		assertTrue(set1.isSubSet(set2));
	}
	
	@Test
	public void testIsSubSet_Negative() {
		IntSet set2 = new IntSet(new int[] {10, 20, 15});
		assertFalse(set1.isSubSet(set2));
	}

	@Test
	public void testGetComplement() {
		IntSet complementSet = set1.getComplement();
		boolean isWorking = true;
		
		for (int i=1; i<=100; i++) {								// Checking the universal set
			if (set1.isMember(i) && complementSet.isMember(i)) {	// If any member is present in both the sets, our code fails
				isWorking = false;
				break;
			}
		}
		assertTrue(isWorking);
	}
	
	@Test
	public void testUnion() {
		IntSet set2 = new IntSet(new int[] {1, 2, 3, 10, 20, 30});
		IntSet unionSet = IntSet.union(set1, set2);
		
		int[] unionArray = unionSet.getElements();
		Arrays.sort(unionArray);
		
		assertArrayEquals(new int[] {1, 2, 3, 5, 7, 8, 9, 10, 20, 30}, unionArray);
	}
}
