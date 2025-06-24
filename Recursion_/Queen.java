package Recursion_;

import java.util.Arrays;

public class Queen {

    // Check if it's safe to place a queen at sol[row][col]
    public static boolean isSafe(int[][] sol, int row, int col, int N) {
        // Check this row on the left
        for (int j = 0; j < col; j++) {
            if (sol[row][j] == 1) {
                return false;
            }
        }
        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (sol[i][j] == 1) {
                return false;
            }
        }
        // Check lower left diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (sol[i][j] == 1) {
                return false;
            }
        }
        return true; // Safe to place queen
    }

    // Solve the problem starting from column 'col'
    public static boolean solve(int col, int[][] sol, int N) {
        if (col == N) {
            return true; // All queens placed successfully
        }
        for (int row = 0; row < N; row++) {
            if (isSafe(sol, row, col, N)) {
                sol[row][col] = 1; // Place queen

                if (solve(col + 1, sol, N)) {
                    return true; // Solution found
                }

                sol[row][col] = 0; // Backtrack
            }
        }
        return false; // No valid position found in this column
    }

    // Print the solution
    public static void printsol(int[][] sol) {
        for (int[] row : sol) {
            for (int cell : row) {
                System.out.print((cell == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("N Queen Problem");
        int N = 5;
        int[][] sol = new int[N][N];

        if (solve(0, sol, N)) {
            printsol(sol);
        } else {
            System.out.println("Solution is not available");
        }
    }
}
