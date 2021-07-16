import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NQueensTest {
	
	static NQueens nQueens;
	
	@BeforeEach
	public void init() {
		nQueens = new NQueens();
	}
	
	/** ------ Positive Test Cases, placing 4 queens on chess board of 4*4 ----- */
	@Test
	public void NQueensTest_4Queens() {
		int[][] chessBoard = new int[4][4];			// Default values all zeros will be populated in the array.
		boolean isSolvable = nQueens.solveNQueens(chessBoard, 0, 4);
		
		if (isSolvable)
			nQueens.printChessBoard(4);
		
		assertTrue(isSolvable);
	}
	
	
	/** ------ Positive Test Cases, placing 8 queens on chess board of 8*8  ----- */
	@Test
	public void NQueensTest_8Queens() {
		int[][] chessBoard = new int[8][8];			// Default values all zeros will be populated in the array.
		boolean isSolvable = nQueens.solveNQueens(chessBoard, 0, 8);
		
		if (isSolvable)
			nQueens.printChessBoard(8);
		
		assertTrue(isSolvable);
	}
	
	
	/** ------ Negative Test Case, placing 2 queens on chess board of 2*2 is not possible ----- */
	@Test
	public void NQueensTest_2Queens() {
		int[][] chessBoard = new int[2][2];
		boolean isSolvable = nQueens.solveNQueens(chessBoard, 0, 2);
		
		if (isSolvable)
			nQueens.printChessBoard(2);
		
		assertFalse(isSolvable);
	}
	
	
	/** ------ Null board case Assertion Error ----- */
	@Test
	public void NQueensTest_NullQueens() {
		int[][] chessBoard = new int[][] {};
		Assertions.assertThrows(AssertionError.class, () -> {
			nQueens.solveNQueens(chessBoard, 0, 0);
		});
	}
}
