public class NQueens {
	int[][] chessBoard;

	/**
	 * Checks that the specified position is safe or not for placing a Queen
	 * @param board      
	 * @param row        index of row where queen is placed
	 * @param column     index of column where queen is placed
	 * @return returns true if specified position is safe or false if specified position is not safe
	 */
	public boolean isSafe(int[][] board, int row, int column) {
		chessBoard = board;
		boolean isSafe = true;
		// Checking the current row
		for (int i = 0; i < row; i++) {
			if (chessBoard[i][column] == 1) {
				isSafe = false;
				break;
			}
		}
		// Checking the diagonal
		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (chessBoard[i][j] == 1) {
				isSafe = false;
				break;
			}
		}
		// Checking the diagonal
		for (int i = row, j = column; i >= 0 && j < chessBoard.length; i--, j++) {
			if (chessBoard[i][j] == 1) {
				isSafe = false;
				break;
			}
		}

		return isSafe;
	}

	/**
	 * The N Queen is the problem of placing N chess queens on an N×N chess board so
	 * that no two queens attack each other.
	 * @param board
	 * @param startRow
	 * @param dimensions of chess board
	 * @return boolean value, true if queens can be placed, false if they can't be placed
	 */

	public boolean solveNQueens(int[][] board, int startRow, int dimensions) {
		if (board.length == 0)
			throw new AssertionError("Board is null, solution not possible.");
		chessBoard = board;
		if (startRow >= dimensions) { // All rows had been traversed
			return true;
		}
		for (int i = 0; i < dimensions; i++) {
			if (isSafe(chessBoard, startRow, i)) {
				chessBoard[startRow][i] = 1;
				if (solveNQueens(chessBoard, startRow + 1, dimensions)) {
					return true;
				}
				chessBoard[startRow][i] = 0;
			}
		}
		return false;
	}

	/**
	 * Prints the chess board where Q indicates a queen and 0 indicates empty places
	 * 
	 * @param dimensionOfChessBoard
	 */
	void printChessBoard(int dimensions) {
		System.out.println("Board type: " + dimensions + " * " + dimensions);
		System.out.println("Solutions [Q indicates a queen]: ");
		for (int j = 0; j < dimensions; j++) {
			for (int i = 0; i < dimensions; i++) {
				if (chessBoard[i][j] == 1)
					System.out.print("Q  ");
				else
					System.out.print(chessBoard[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

}