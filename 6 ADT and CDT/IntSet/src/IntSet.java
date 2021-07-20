import java.util.HashSet;
import java.util.Set;

public class IntSet {
	private static final int MAX_LIMIT = 100;
	private final int[] set;
	
	/**
	 * Constructor that initializes a set by the input array
	 * @param inputArray
	 */
	public IntSet(int[] inputArray) {			// Assuming inputArray will have unique elements
		this.set = isValidInput(inputArray);
	}
	
	/**
	 * This method returns the size of the set
	 * @return size
	 */
	public int size() {
		return set.length;
	}
	
	/**
	 * Checks that an element is member of the set or not
	 * @param x the element to check
	 * @return true if element is member of the set, false if it is not
	 */
	public boolean isMember(int x) {
		for(int i=0; i<size(); i++) {
			if (set[i] == x) 
				return true;
		}
		return false;
	}
	
	/**
	 * Checks that a set is a subset of the current set or not
	 * @param otherSet the set which is to be checked
	 * @return true if otherSet is a subset of set, false if it is not 
	 */
	public boolean isSubSet(IntSet otherSet) {
		for (int i=0; i<otherSet.size(); i++) {
			if (!this.isMember(otherSet.set[i]))		// If any element of otherSet is not present in this set, immediately return false.
				return false;
		}
		return true;
	}
	
	/**
	 * Finds the complement of the set, uses [1...MAX_LIMIT] as universal set.
	 * complement(set) = UniversalSet - set
	 * @return complement of the set
	 */
	public IntSet getComplement() {
		int[] complementSetArray = new int[MAX_LIMIT - size()];
		int index = 0;
		for (int i=1; i<=MAX_LIMIT; i++) {
			if (!isMember(i)) {
				complementSetArray[index] = i;
				index++;
			}
		}
		return new IntSet(complementSetArray);
	}
	
	/**
	 * Finds the union of two sets
	 * union(s1, s2) = s1 + s2 - (intersection(s1, s2))
	 * @param s1 first set
	 * @param s2 second set
	 * @return union of s1 and s2
	 */
	public static IntSet union(IntSet s1, IntSet s2) {
		Set<Integer> tempSet = new HashSet<Integer>();
		for (int element: s1.set)
			tempSet.add(element);
		
		for (int element: s2.set)
			tempSet.add(element);
		
		int[] unionArray = new int[tempSet.size()];
		int index = 0;
		for (int element: tempSet)
			unionArray[index++] = element;
		
		return new IntSet(unionArray);
	}
	
	/**
	 * Prints the set
	 */
	public void printSet() {
		for (int i=0; i<size(); i++) {
			System.out.print(set[i] + "  ");
		}
		System.out.println();
	}

	
	

	public int[] getElements() {
		Arrays.copyOf(set, set.length);
	}

	private int[] isValidInput(int[] inputArray){
		
		//Remove duplicates from array
		Set<Integer> s = new HashSet<>();

		for (int i = 0; i < inputArray.length; i++) {
			s.add(inputArray[i]);
		}

		int arr[] = new int[s.size()];
		int i = 0;
		for (Object o : s) {
			arr[i++] = (int) o;
		}
		
		if(arr.length > MAX_LIMIT) {
			throw new AssertionError("Limit Exceeds");
		}
		
		//Check for valid range
		for(i=0;i<arr.length;i++) {
			if(arr[i] > MAX_LIMIT || arr[i] < 0) {
				throw new AssertionError("Invalid Input");
			}
		}
		
		return arr;
	}
}
