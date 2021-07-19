
public class App {
	public static void main(String[] args) {
		
		IntSet set1 = new IntSet(new int[] {1, 2, 3, 10, 4, 8, 5, 9, 15});
		System.out.println(set1.size());
		System.out.println(set1.isMember(3));
		System.out.println(set1.isMember(12));
		
		IntSet set2 = new IntSet(new int[] {3, 8, 4, 12, 13, 15});
		System.out.println(set1.isSubSet(set2));
		
		IntSet set3 = new IntSet(new int[] {2, 8, 12});
		System.out.println(set1.isSubSet(set3));
		
		IntSet complementOfSet1 = set1.getComplement();
		complementOfSet1.printSet();
		
		IntSet unionSet = IntSet.union(set1, set2);
		unionSet.printSet();
		
		IntSet testSet = new IntSet(new int[] {1, 5, 7, 2, 10, 15, 30, 23, 87, 55, 43, 98, 34});
		IntSet testComplement = testSet.getComplement();
		testComplement.printSet();
		
		System.out.println(testSet.isSubSet(new IntSet(new int[] {1, 7, 15, 5, 34})));
	}
}
