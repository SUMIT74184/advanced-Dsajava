package DynamicProgramming;

import java.util.Arrays;

public class MinCostClimb {
//    public int minCostClimbingStairs(int[] cost) {
//        int n=cost.length;
//        return recur(n,cost);
//    }
//    public int recur(int n,int []cost){
//        if(n==0 || n==1){
//            return 0;
//        }
//                    //n-1 par aan ka cost
//        int oneStep=cost[n-1]+recur(n-1,cost);
//                                //n-1 se aage jaa ka cost
//        int TwoStep=cost[n-1]+recur(n-1,cost);
//        return Math.min(oneStep,TwoStep);
//    }

//    top-down
//    public int minCostClimbingStairs(int[] cost) {
//        int n=cost.length;
//        int []dp=new int[n+1];
//        Arrays.fill(dp,-1);
//        return recur(n,cost,dp);
//    }
//    public int recur(int n,int []cost,int []dp){
//        if(n==0 || n==1){
//            return 0;
//        }
//        if(dp[n]!=-1){
//            return dp[n];
//        }
//                   //n-1 par aan ka cost
//        int oneStep=cost[n-1]+recur(n-1,cost,dp);
//                               //n-1 se aage jaa ka cost
//        int TwoStep=cost[n-1]+recur(n-1,cost,dp);
//        dp[n]= Math.min(oneStep,TwoStep);
//        return dp[n];
//    }

    //Bottom-up
//    public int minCostClimbingStairs(int[] cost) {
//        int n=cost.length;
//        int []dp=new int[n+1];
//        dp[0]=0;
//        dp[1]=0;
//        for(int state=2;state<=n;state++){
//            int oneStep=cost[state-1]+dp[state-1];
//            //n-1 se aage jaa ka cost
//            int TwoStep=cost[state-2]+dp[state-2];
//            dp[state]= Math.min(oneStep,TwoStep);
//
//        }
//        return dp[n];
//
//    }


    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int []dp=new int[n+1];
        int prev2=0;
        int prev1=0;
        int ans=0;
        for(int state=2;state<=n;state++){
            int oneStep=cost[state-1]+prev1;
            //n-1 se aage jaa ka cost
            int TwoStep=cost[state-2]+prev2;
             ans= Math.min(oneStep,TwoStep);
            prev2=prev1;
            ans=prev2;
        }
        return ans;

    }

}
