package com.ashx.gfg.backtracking;

import java.util.Arrays;

public class Sudoku {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 3, 0},
                {0, 0, 2, 1},
                {0, 1, 0, 2},
                {2, 4, 0, 0}
        };
        boolean solve = solve(grid);
        if (!solve) {
            System.out.println("Not able to solve Sudoku.");
        } else {
            System.out.println(Arrays.deepToString(grid)
                    .replace("],", "\n")
                    .replace(",", " ")
                    .replaceAll("[\\[\\]]", " "));
        }
    }

    public static boolean solve(int[][] grid) {
        int row, col = 0;
        int N = grid.length;
        outer:
        for (row = 0; row < N; row++) {
            for (col = 0; col < N; col++) {
                if (grid[row][col] == 0) {
                    break outer;
                }
            }
        }
        if (row == N && col == N) {
            return true;
        }
        for (int currNum = 1; currNum <= N; currNum++) {
            if (isSafe(grid, row, col, currNum)) {
                grid[row][col] = currNum;
                if (solve(grid)) {
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] grid, int row, int col, int currNum) {
        int N = grid.length;
        for (int pos = 0; pos < N; pos++) {
            if (grid[pos][col] == currNum || grid[row][pos] == currNum) {
                return false;
            }
        }
        int subN = (int) Math.sqrt(N);
        int rowSubN = row - row % subN;
        int colSubN = col - col % subN;

        for (int rowSub = 0; rowSub < subN; rowSub++) {
            for (int colSub = 0; colSub < subN; colSub++) {
                if (grid[rowSub + rowSubN][colSub + colSubN] == currNum) {
                    return false;
                }
            }
        }

        return true;
    }
}
