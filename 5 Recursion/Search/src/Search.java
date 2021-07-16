public class Search {
	
	/**
	 * Finds a value in an array using Linear Search algorithm
	 * @param arr Array in which value to be searched
	 * @param value The value to be searched
	 * @return index such that arr[index] = value, -1 if value not found
	 */
	public int linearSearch(int[] arr, int value) {
		return linearSearchHelper(arr, value, 0);
	}
	
	
	/**
	 * Finds a value in an array using Binary Search algorithm.
	 * @param arr Array in which value to be searched, Requires array to be sorted
	 * @param value The value to be searched
	 * @return index such that arr[index] = value, -1 if value not found
	 */
	public int binarySearch(int[] arr, int value) {
		return binarySearchHelper(arr, 0, arr.length - 1, value);
	}

	
	/**
	 * Finds a value in an array using Linear Search algorithm. Helper method of linearSearch()
	 * @param arr Array in which value to be searched
	 * @param value The value to be searched
	 * @param currentIndex Index to keep track of current index, pass 0 while calling
	 * @return index such that arr[index] = value, -1 if value not found
	 */
	private int linearSearchHelper(int[] arr, int value, int currentIndex) {
		if (currentIndex == arr.length)
			return -1; // Not found
		else if (arr[currentIndex] == value)
			return currentIndex;

		return linearSearchHelper(arr, value, currentIndex + 1);
	}

	
	/**
	 * Finds a value in an array using Binary Search algorithm. Helper method of binarySearch()
	 * @param arr Array in which value to be searched, Requires array to be sorted
	 * @param start Start of the array
	 * @param end End of the array
	 * @param value The value to be searched
	 * @return index such that arr[index] = value, -1 if value not found
	 */
	private int binarySearchHelper(int[] arr, int start, int end, int value) {
		if (arr.length == 0 || start > end)
			return -1; // Array is empty or element not found
		int mid = (end + start) / 2;
		if (arr[mid] == value)
			return mid;
		else if (arr[mid] < value)
			return binarySearchHelper(arr, mid + 1, end, value);
		else
			return binarySearchHelper(arr, start, mid - 1, value);
	}
}
