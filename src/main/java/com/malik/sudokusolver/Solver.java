package com.malik.sudokusolver;

public class Solver {

    private static final int ROW_SIZE = 9; // size of board
    private static final int COL_SIZE = 9;

    //function that check whether the number is placed correctly or not
    public static boolean isValidPlacement(String board[][], String c, int row, int col) {
        return !checkCol(board, c, col) && !checkRow(board, c, row) && !checkGrid(board, c, row, col);
    }

    //checking number in grid
    public static boolean checkGrid(String board[][], String c, int row, int col) {
        int localBoxRow = row - row % 3;
        int localBoxCol = col - col % 3;

        for (int i = localBoxRow; i < localBoxRow; i++) {
            for (int j = localBoxCol; j < localBoxCol; j++) {
                if (board[i][j].equals(c)) {
                    return true;
                }
            }
        }

        return false;
    }

    //checking is the number exist in the column
    public static boolean checkCol(String board[][], String c, int col) {

        for (int i = 0; i < ROW_SIZE; i++) {
            if (board[i][col].equals(c)) {
                return true;
            }
        }
        return false;
    }

    //checking is the number exist in the row
    public static boolean checkRow(String board[][], String c, int row) {

        for (int i = 0; i < COL_SIZE; i++) {
            if (board[row][i].equals(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean solveBoard(String board[][]) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col].equals("")) {
                    for (int numberToTry = 1; numberToTry <= 9; numberToTry++) {
                        if (isValidPlacement(board, Integer.toString(numberToTry), row, col)) {
                            board[row][col] = Integer.toString(numberToTry);

                            if (solveBoard(board)) {
                                return true;
                            } else {
                                board[row][col] = "";
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}
