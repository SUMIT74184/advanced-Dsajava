package DynamicProgramming;

import java.util.Arrays;

public class UniquePath {
//    public int uniquePaths(int m, int n) {
//        return recur(m-1,n-1);
//    }
//    public int recur(int m,int n){
//        //base case
//        if(m==0 && n==0){
//            return 1;
//        }
//        if(m<0 || n<0){
//            return 0;
//        }
//        int ways=recur(m-1,n)+recur(m,n-1);
//        return ways;
//    }

    public int uniquePaths(int m, int n) {
        int [][]dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return recur(m,n,dp);
    }
    public int recur(int m,int n,int [][]dp){
        //base case
        if(m==1 && n==1){
            dp[m][n]=1;
            return 1;
        }
        if(m==0 || n==0){
            dp[m][n]=0;
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int ways=recur(m-1,n,dp)+recur(m,n-1,dp);
        dp[m][n]=ways;
        return ways;
    }

//    public int uniquePaths(int m, int n) {
//        int [][]dp=new int[m+1][n+1];
//
//        for(int i=0;i<m+1;i++){
//           for(int j=0;j<n+1;j++){
//               if(i==0 || j==0){
//                   dp[i][j]=0;
//               } else if (i==1 && j==1) {
//                   dp[i][j]=1;
//
//               }else{
//                   dp[i][j]=dp[i-1][j]+dp[i][j-1];
//
//               }
//           }
//        }
//        return dp[m][n];
//    }

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            return uniquePaths(m, n, obstacleGrid);
        }

        public int uniquePaths(int m, int n, int[][] obstacleGrid) {
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i < m + 1; i++) {
                Arrays.fill(dp[i], -1);
            }
            return recur(m, n, dp, obstacleGrid);
        }

        public int recur(int m, int n, int[][] dp, int[][] obstacleGrid) {
            // Check bounds first
            if (m <= 0 || n <= 0) {
                return 0;
            }

            // Check for obstacle BEFORE base case
            if (obstacleGrid[m - 1][n - 1] == 1) {
                dp[m][n] = 0;
                return 0;
            }

            // Base case: reached destination
            if (m == 1 && n == 1) {
                dp[m][n] = 1;
                return 1;
            }

            // Check memoization
            if (dp[m][n] != -1) {
                return dp[m][n];
            }

            // Recursive case
            int ways = recur(m - 1, n, dp, obstacleGrid) + recur(m, n - 1, dp, obstacleGrid);
            dp[m][n] = ways;
            return ways;
        }
    }
}
