package DynamicProgramming;

import java.util.Arrays;

public class Fib {

    public int fibState(int n){
//        if(n<=1){
//            return n;
//        }
//        return fibState(n-1)+fibState(n-2);

//        int []dp=new int[n+1];
//        Arrays.fill(dp,-1);
//        return memo(n,dp);


        if(n<=1){
            return n;
        }
        int []dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int state=2;state<=n;state++){
            dp[state]=dp[state-1]+dp[state-2];
        }
        return dp[n];


    }
//    public int memo(int n,int []dp ){
//        if(n<=1){
//            dp[n]=n;
//            return dp[n];
//        }
//        if(dp[n]!=-1){
//            return dp[n];
//        }
//        dp[n]=fibState(n-1)+fibState(n-2);
//        return dp[n];
//    }

    public static void main(String[] args) {

    }

}
