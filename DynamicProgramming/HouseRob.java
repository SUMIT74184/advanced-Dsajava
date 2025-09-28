package DynamicProgramming;

import java.util.Arrays;

public class HouseRob {
//    public int rob(int[] nums) {
//        int n= nums.length;
//        return recur(nums,n-1);
//
//    }
//    public int recur(int []nums,int ind){
//        //base case
//        if(ind==0){
//            return nums[0];
//        }
//        if(ind==-1){
//            return 0;
//        }
//        int ans=nums[ind]+recur(nums,ind-2);
//        int notPick= recur(nums, ind - 1);
//        return Math.max(ans,notPick);
//    }

    //top-down

    //shifting logic refer notes
//    public int rob(int[] nums) {
//        int n= nums.length;
//        int []dp=new int[n+1];
//        Arrays.fill(dp,-1);
//        return recur(nums,n,dp);
//
//    }
//    public int recur(int []nums,int ind,int []dp){
//        //base case  tc--->o(n)
//        if(ind==1){//shifting by 1
//            dp[ind]=nums[0];
//            return nums[0];
//        }
//        if(ind==0){ //shifting -1 to 0
//            dp[ind]=0;
//            return 0;
//        }
//
//        if(dp[ind]!=-1){
//            return dp[ind];
//        }
//        //shifting logic as array cannot hold the negative value so we are shifting 1 index ahead
//        int ans=nums[ind-1]+recur(nums,ind-2,dp);
//        int notPick= recur(nums, ind - 1,dp);
//        dp[ind]= Math.max(ans,notPick);
//
//        return dp[ind];
//    }

//    public int rob(int[] nums) {
////        tc--->o(n)
//        int n= nums.length;
//        int []dp=new int[n+1];
//        dp[0]=0;
//        dp[1]=nums[0];
//        for(int state=2;state<=n;state++){
//            int ans=nums[state-1]+dp[state-2];
//            int notPick= dp[state - 1];
//            dp[state]= Math.max(ans,notPick);
//        }
//
//        return dp[n];
//
//    }

    //space optimization
    public int rob(int[] nums) {
//        tc--->o(n)

        int n= nums.length;
        if(n==1){
            return nums[0];
        }

        int prev2=0;
        int prev1=nums[0];
        int ans=0;
        for(int state=2;state<=n;state++){
            int pick=nums[state-1]+prev2;
            int notPick= prev1;
            ans= Math.max(pick,notPick);
            prev2=prev1;
            prev1=ans;
        }

        return ans;

    }

    public static void main(String[] args) {

    }

}
