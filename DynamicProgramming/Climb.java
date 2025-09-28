package DynamicProgramming;

import java.util.Arrays;

public class Climb {
//    public int climbStairs(int n){
//        //base case
//        if(n<=2){
//            return n;
//        }
//        return climbStairs(n-1)+climbStairs(n-2);
//    }

//    public int climbStairs(int n){
//        tc-o(n)
//        sc-o(n)
//        int []dp=new int[n+1];
//        Arrays.fill(dp,-1);
//        return recur(n,dp);
//    }
    //top-down
//    public int recur(int n,int []dp){
//        //base case
//        if(n<=2){
//            dp[n]=n;
//            return n;
//        }
//        if(dp[n]!=-1){
//            return dp[n];
//        }
//        dp[n]=climbStairs(n-1)+climbStairs(n-2);
//        return dp[n];
//    }

    //Bottom-UP
    public int climbStairs(int n){
        if(n<=2){
            return n;
        }
        int []dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int state=3;state<=n;state++){
            dp[state]=dp[state-1]+dp[state-2];
        }
        return dp[n];
}

}
