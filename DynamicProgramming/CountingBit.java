package DynamicProgramming;

import java.util.Arrays;

public class CountingBit {

    public int[] countBits(int n) {
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
        recur(n,dp);
        return dp;
    }

    public int recur(int n,int[]dp){
        if(n<=1){
            dp[n]=n;
            return dp[n];
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = recur(n >> 1, dp) + (n & 1);
        return dp[n];
    }

    //Bottom-up
//    public int[] countBits(int n) {
//        int []dp=new int[n+1];
//        for(int i=0;i<=n;i++){
//            dp[i]=dp[i>>1]+(i&1);
//        }
//      return dp;
//    }
}
