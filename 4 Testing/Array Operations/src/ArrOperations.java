import java.util.ArrayList;

public class ArrOperations {
	
	/**
	 * Returns the length of maximum mirror section in an array.
	 * Mirror section is a group of contiguous elements such that somewhere in the array,
	 * the same group appears in reverse order.
	 * @param arr Array from which maximum mirror count is to be found.
	 * @return size of maximum mirror section
	 * @throws AssertionError if the array is empty
	 */
	public int maxMirror(int[] arr) {
		int n = arr.length;
		if(arr.length==0) {
			throw new AssertionError("Array is empty!");
		}
		int count=0, max=0;
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>=0 && i+count<n; j--) {
				if(arr[i+count]==arr[j]) {
					count++;
				}else {
					if(count>0) {
						max = Math.max(max, count);
						count=0;
					}
				}
			}
		}
		return Math.max(max, count);
	}

	
	/**
	 * Finds number of clumps in a array. Clump is a series of 2 or more adjacent elements of the same value.
	 * @param arr array to find clumps
	 * @return number of clumps
	 * @throws AssertionError if array is empty
	 */
	public int countClumps(int[] arr) throws AssertionError {
		int n = arr.length;
		if (n == 0)
			throw new AssertionError("Array is empty!");
		else if (n == 1)
			return 0;
		else {
			int i, j, clumps;
			i = clumps = 0;
			while (i < n - 1) {
				j = i + 1;
				if (arr[i] == arr[j]) {
					clumps++;
					i = j + 1;
					while (i < n - 1 && arr[i] == arr[i + 1])
						i++;
				} else
					i++;
			}
			return clumps;
		}
	}

	
	/**
	 * Return an array that contains exactly the same numbers as the input array, but rearranged so that 
	 * every X is immediately followed by a Y.
	 * @param arr array to replace X with Y
	 * @X the value of X
	 * @Y the value of Y
	 * @return array arranged according to the positions of X and Y
	 * @throws AssertionError if array is empty, two or more adjacent X are there or X is found on last position
	 */
	public int[] fixXY (int[] arr, int X, int Y) {
		int n = arr.length;
		if (n == 0)
			throw new AssertionError("Array is empty!");
		else if (arr[n-1] == X)
			throw new AssertionError("X found at last position.");
		else {
			ArrayList<Integer> yIndexes = new ArrayList<>();		// Indexes of Y
			ArrayList<Integer> xIndexes = new ArrayList<>();		// Indexes of X
			
			for (int i=0; i<n; i++) {
				if (arr[i] == Y)
					yIndexes.add(i);
				else if (arr[i] == X) {
					xIndexes.add(i);
					if (arr[i+1] == X)
						throw new AssertionError("Two adjacent X found.");
				}
			}
			
			if (yIndexes.size() == xIndexes.size()) {
				int currentYIndex = 0;
				for (int currentXIndex: xIndexes) {
					int temp = arr[currentXIndex + 1];
					arr[currentXIndex + 1] = Y;
					arr[yIndexes.get(currentYIndex)] = temp;
					currentYIndex++;
				}
				return arr;
			} else 
				throw new AssertionError("Number of X and Y are unequal.");
		}
	}
	

	/**
	 * Finds a place an array such that if the array is split into two
	 * parts left and right, the sum of both parts will be equal. The element at
	 * place is counted with left part and indexing starts from one
	 * @param arr array to find the place
	 * @return place from which two parts of equal sum is possible, -1 otherwise
	 * @throws AssertionError if array is empty
	 */
	public int splitArray(int[] arr) {
		int n = arr.length;
		if (n == 0)
			throw new AssertionError("Array is empty!");
		else {
			int i = 0, j = n - 1;
			int sumLeft = arr[i];
			int sumRight = arr[j];

			while (i < j - 1) {
				if (sumLeft == sumRight) {
					i++;
					j--;
					sumLeft += arr[i];
					sumRight += arr[j];
				} else if (sumLeft < sumRight) {
					i++;
					sumLeft += arr[i];
				} else {
					j--;
					sumRight += arr[j];
				}
			}
			if (sumLeft != sumRight || i == j)
				return -1;
			else
				return i + 1;
		}
	}

}
