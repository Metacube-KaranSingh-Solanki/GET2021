import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SparseMatrixTest {

	public static SparseMatrix matrix1, matrix2;

	@BeforeEach
	public void init() {
		matrix1 = new SparseMatrix(new int[][] { { 0, 4, 0 }, { 4, 2, 3 }, { 0, 3, 0 } });
		matrix2 = new SparseMatrix(new int[][] { { 1, 0, 0 }, { 2, 1, 0 }, { 0, 2, 2 } });
	}

	@Test
	public void TestGetMatrix() {
		int[][] expectedMatrix = new int[][] { { 0, 4, 0 }, { 4, 2, 3 }, { 0, 3, 0 } };
		assertArrayEquals(expectedMatrix, matrix1.getMatrix());
	}

	@Test
	public void TestTranspose() {
		int[][] expectedMatrix = new int[][] { { 1, 2, 0 }, { 0, 1, 2 }, { 0, 0, 2 } };
		assertArrayEquals(expectedMatrix, matrix2.getTranspose().getMatrix());
	}

	@Test
	public void TestSymmetricTrue() {
		assertTrue(matrix1.isSymmetric());
	}

	@Test
	public void TestSymmetricFalse() {
		assertFalse(matrix2.isSymmetric());
	}

	@Test
	public void TestAdd() {
		int[][] expectedMatrix = new int[][] { { 1, 4, 0 }, { 6, 3, 3 }, { 0, 5, 2 } };
		assertArrayEquals(expectedMatrix, matrix1.add(matrix2).getMatrix());
	}

	@Test
	public void TestMultiply() {
		int[][] expectedMatrix = new int[][] { { 8, 4, 0 }, { 8, 8, 6 }, { 6, 3, 0 } };
		assertArrayEquals(expectedMatrix, matrix1.multiply(matrix2).getMatrix());
	}
	
	@Test
	public void TestMultiplyNotPossibleAssertionError() {
		SparseMatrix matrix3 = new SparseMatrix(new int[][] {{0, 4, 0, 0}, {4, 2, 3, 1}, {0, 3, 0, 2}, {2, 1, 0, 0}});
		assertThrows(AssertionError.class, () -> {matrix1.multiply(matrix3);});
	}
}
