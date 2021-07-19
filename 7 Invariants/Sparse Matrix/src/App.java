
public class App {
	public static void main(String[] args) {
		SparseMatrix matrix1 = new SparseMatrix(new int[][] {{0, 4, 0, 0}, {4, 2, 3, 1}, {0, 3, 0, 2}, {2, 1, 0, 0}});
		SparseMatrix matrix2 = new SparseMatrix(new int[][] {{1, 0, 0, 1}, {2, 0, 1, 0}, {0, 2, 3, 2 }, {0, 0, 4, 5}});
		
		System.out.println("Matrix 1:");
		matrix1.display();
		
		System.out.println("Matrix 2:");
		matrix2.display();

		System.out.println("Transpose of Matrix 1:");
		SparseMatrix transposeMatrix1 = matrix1.getTranspose();
		transposeMatrix1.display();
		
		System.out.println("Matrix1 is symmetric?: " + matrix1.isSymmetric());
		System.out.println("Matrix2 is symmetric?: " + matrix2.isSymmetric());

		System.out.println("Matrix 1 + Matrix 2: ");
		SparseMatrix addition = matrix1.add(matrix2);
		addition.display();

		System.out.println("Matrix 1 * Matrix 2: ");
		SparseMatrix multiplication = matrix1.multiply(matrix2);
		multiplication.display();
	}
}
