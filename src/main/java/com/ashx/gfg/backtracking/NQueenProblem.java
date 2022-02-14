package com.ashx.gfg.backtracking;

public class NQueenProblem {
    public static void main(String[] args) {
        int[][] board = solve(4);
        print(board);
    }

    public static int[][] solve(int N) {
        int[][] board = new int[N][N];
        solveRec(board, 0);
        return board;
    }

    private static boolean solveRec(int[][] board, int col) {
        int N = board.length;
        if (col == N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(i, col, board)) {
                board[i][col] = 1;
                if (solveRec(board, col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int row, int col, int[][] board) {
        int N = board.length;
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void print(int[][] board) {
        int N = board.length;
        for (int[] booleans : board) {
            for (int j = 0; j < N; j++) {
                System.out.print(booleans[j] + " ");
            }
            System.out.println();
        }
    }
}
