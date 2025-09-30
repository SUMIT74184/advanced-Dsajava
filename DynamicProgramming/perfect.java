package DynamicProgramming;

public class perfect {
//    public int perfectSum(int []nums,int target){
//        int n= nums.length;
//        return recur(nums,target,n-1);
//    }
//    public int recur(int []nums,int target,int index){
//        if(index==0){
//            if(target==0 && nums[index]==0) return 2;
//            else if (target==0) {
//                return 1;
//
//            } else if (target==nums[0]) {
//                return 1;
//
//            }else{
//                return 0;
//            }
//        }
//        int pick=0;
//        if(nums[index]<=target){
//            pick=recur(nums,target-nums[index],index-1);
//
//        }
//        int np=recur(nums,target,index-1);
//
//        return pick+np;
//    }


//    public int perfectSum(int []nums,int target){
//        int n= nums.length;
//        int [][]dp=new int[n][target+1];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<target+1;j++){
//                dp[i][j]=-1;
//            }
//        }
//        return recur(nums,target,n-1,dp);
//    }
//    public int recur(int []nums,int target,int index,int [][]dp){
//        if(index==0){
//            if(target==0 && nums[index]==0){
//                dp[index][target]=2;
//                return 2;
//            }
//            else if (target==0) {
//                dp[index][target]=1;
//                return 1;
//
//            } else if (target==nums[0]) {
//                dp[index][target]=1;
//                return 1;
//
//            }else{
//                dp[index][target]=0;
//                return 0;
//            }
//        }
//        if(dp[index][target]!=-1){
//            return dp[index][target];
//        }
//        int pick=0;
//        if(nums[index]<=target){
//            pick=recur(nums,target-nums[index],index-1,dp);
//
//        }
//        int np=recur(nums,target,index-1,dp);
//        dp[index][target]=pick+np;
//
//        return dp[index][target];
//    }

    //Tabulation
public int perfectSum(int []nums,int target){
    int n= nums.length;
    int [][]dp=new int[n][target+1];
    for(int i=0;i<target+1;i++){
        if(i==0 && nums[0]==0){//i is t target
            dp[0][i]=2;
        }
        else if (i==0) {
            dp[0][i]=1;

        } else if (i==nums[0]) {
            dp[0][i]=1;

        }else{
            dp[0][i]=0;
        }
    }
    for(int i=1;i<n;i++){//as we have already solved for 0 cases thats why 1
            for(int j=0;j<target+1;j++){
                dp[i][j]=-1;
                int pick=0;
                if(nums[i]<=j){
                    pick=dp[i-1][j-nums[i]];

                }
                int np=dp[i-1][j];
                dp[i][j]=pick+np;
            }
        }
    return dp[n-1][target];

}
}
