package PrefixSumAlgo;

import java.util.ArrayList;

public class prefmatrix {
    public static ArrayList<Integer>prefix2d(int [][]mat,int [][]queries){
        int rows=mat.length;
        int cols=mat[0].length;

        //build prefix sum over rows
        for(int i=1;i<rows;i++){  // Fixed: should start from i=1
            for(int j=0;j<cols;j++){
                mat[i][j]+=mat[i-1][j];
            }
        }

        //build prefix sum over columns
        for(int j=1;j<cols;j++){
            for(int i=0;i<rows;i++){
                mat[i][j]+=mat[i][j-1];
            }
        }
        ArrayList<Integer>result=new ArrayList<>();

        //process each query using the inclusion-exclusion
        for(int []q:queries){
            int r1=q[0],c1=q[1],r2=q[2],c2=q[3];

            int total=mat[r2][c2];
            
            int left=(c1>0)?mat[r2][c1-1]:0;
            
            int top=(r1>0)?mat[r1-1][c2]:0;
            
            int overlap=(r1>0 && c1>0)?mat[r1-1][c1-1]:0;
            
            int sum=total-left-top+overlap;
            result.add(sum);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: Basic 4x4 matrix
        System.out.println("Test Case 1:");
        int[][] mat1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        
        int[][] queries1 = {
            {0, 0, 1, 1},  // Top-left 2x2 submatrix
            {1, 1, 2, 2},  // Middle 2x2 submatrix
            {0, 0, 3, 3},  // Entire matrix
            {2, 1, 3, 2}   // Bottom-middle submatrix
        };
        
        ArrayList<Integer> result1 = prefix2d(mat1, queries1);
        System.out.println("Queries and Results:");
        for(int i = 0; i < queries1.length; i++) {
            int[] q = queries1[i];
            System.out.printf("Query [%d,%d,%d,%d] -> Sum: %d%n", 
                q[0], q[1], q[2], q[3], result1.get(i));
        }
        
        // Test Case 2: 3x3 matrix
        System.out.println("\nTest Case 2:");
        int[][] mat2 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        
        int[][] queries2 = {
            {0, 0, 2, 2},  // All 9 elements
            {0, 0, 0, 0},  // Single element
            {1, 1, 2, 2}   // Bottom-right 2x2
        };
        
        ArrayList<Integer> result2 = prefix2d(mat2, queries2);
        System.out.println("Queries and Results:");
        for(int i = 0; i < queries2.length; i++) {
            int[] q = queries2[i];
            System.out.printf("Query [%d,%d,%d,%d] -> Sum: %d%n", 
                q[0], q[1], q[2], q[3], result2.get(i));
        }
        
        // Test Case 3: Matrix with varied values
        System.out.println("\nTest Case 3:");
        int[][] mat3 = {
            {2, 4, 6},
            {8, 10, 12},
            {14, 16, 18}
        };
        
        int[][] queries3 = {
            {0, 0, 1, 1},  // Top-left 2x2
            {1, 0, 2, 2},  // Bottom two rows
            {0, 1, 2, 1}   // Middle column
        };
        
        ArrayList<Integer> result3 = prefix2d(mat3, queries3);
        System.out.println("Queries and Results:");
        for(int i = 0; i < queries3.length; i++) {
            int[] q = queries3[i];
            System.out.printf("Query [%d,%d,%d,%d] -> Sum: %d%n", 
                q[0], q[1], q[2], q[3], result3.get(i));
        }
    }
}