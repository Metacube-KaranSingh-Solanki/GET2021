
public class SparseMatrix {
	/**
	 * COLS is number of columns used to represent any value of actual matrix i
	 * sparse matrix. There are 3 columns: ROW, COL and VALUE where each one
	 * represents what it says.
	 */
	private static final int COLS = 3, ROW = 0, COL = 1, VALUE = 2;
	private int n; // n is dimension of actual matrix, sparseSize is non-zero elements
	private int[][] sparse;

	/**
	 * Constructor to initialize a new Sparse Matrix. It stores the matrix into
	 * sparse efficient representation to save memory.
	 * @param matrix
	 */
	public SparseMatrix(int[][] matrix) {
		this.n = matrix.length;
		sparse = getSparseMatrix(matrix);
	}

	/**
	 * Finds the transpose of a matrix
	 * Time Complexity: O(n^2)
	 * @return SparseMatrix which is transpose of the matrix
	 */
	public SparseMatrix getTranspose() {
		int[][] transpose = new int[n][n];
		int[][] actualMatrix = getMatrix();
		for (int row = 0; row < n; row++) {
			for (int col=0; col < n; col++) {
				transpose[row][col] = actualMatrix[col][row];
			}
		}
		return new SparseMatrix(transpose);
	}

	/**
	 * Finds if a matrix is symmetric or not
	 * Time Complexity: O(n^2)
	 * @return true if it is symmetric, false otherwise
	 */
	public boolean isSymmetric() {
		int[][] actualMatrix = getMatrix();
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (actualMatrix[row][col] != actualMatrix[col][row])
					return false;
			}
		}
		return true;
	}

	/**
	 * Adds the other matrix with this one
	 * Time Complexity: O(n^2)
	 * @param other matrix
	 * @return SparseMatrix which is equal to this + other
	 */
	public SparseMatrix add(SparseMatrix other) {
		int[][] actual1 = this.getMatrix();
		int[][] actual2 = other.getMatrix();
		int[][] result = new int[n][n];

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				result[row][col] = actual1[row][col] + actual2[row][col];
			}
		}
		return new SparseMatrix(result);
	}

	/**
	 * Multiplies the other matrix with this one
	 * Time Complexity: O(n^3)
	 * @param other matrix
	 * @return SparseMatrix which is equal to this * other
	 */
	public SparseMatrix multiply(SparseMatrix other) {
		int[][] actual1 = this.getMatrix();
		int[][] actual2 = other.getMatrix();
		
		if (actual1.length != actual2.length)
			throw new AssertionError("Number of Rows of first matrix is unequal to number of columns of second matrix.");
			
		int[][] result = new int[n][n];

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				for (int k = 0; k < n; k++)
					result[row][col] += actual1[row][k] * actual2[k][col];
			}
		}
		return new SparseMatrix(result);
	}

	/**
	 * Private helper method to get sparse representation of a matrix
	 * @param matrix
	 * @return sparse representation of matrix
	 */
	private int[][] getSparseMatrix(int[][] matrix) {
		int len = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] != 0) {
					len++;
				}
			}
		}
		// [ROW, COL, VALUE]
		int[][] sparseMatrix = new int[len][COLS];

		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] != 0) {
					sparseMatrix[k][ROW] = i;
					sparseMatrix[k][COL] = j;
					sparseMatrix[k][VALUE] = matrix[i][j];
					k++;
				}
			}
		}
		return sparseMatrix;
	}

	/**
	 * To get actual matrix out of the sparse representation
	 * Time Complexity: O(n)
	 * @return matrix
	 */
	public int[][] getMatrix() {
		int[][] actualMatrix = new int[n][n];
		for (int i = 0; i < sparse.length; i++) {
			int row = sparse[i][ROW];
			int col = sparse[i][COL];
			actualMatrix[row][col] = sparse[i][VALUE];
		}
		return actualMatrix;
	}

	/**
	 * Displays the matrix
	 */
	public void display() {
		int matrix[][] = getMatrix();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(matrix[i][j] + "  ");
			System.out.println();
		}
	}

}
