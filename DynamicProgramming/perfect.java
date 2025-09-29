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
//
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
public int perfectSum(int []nums,int target){
    int n= nums.length;
    int [][]dp=new int[n][target+1];
    for(int i=0;i<n;i++){
        for(int j=0;j<target+1;j++){
            dp[i][j]=-1;
        }
    }
    return recur(nums,target,n-1,dp);
}
    public int recur(int []nums,int target,int index,int [][]dp){
        if(index==0){
            if(target==0 && nums[index]==0){
                dp[index][target]=2;
                return 2;
            }

            else if (target==0) {
                dp[index][target]=1;
                return 1;

            } else if (target==nums[0]) {
                dp[index][target]=1;
                return 1;

            }else{
                dp[index][target]=0;
                return 0;
            }
        }
        if(dp[index][target]!=-1){
            return dp[index][target];
        }
        int pick=0;
        if(nums[index]<=target){
            pick=recur(nums,target-nums[index],index-1,dp);

        }
        int np=recur(nums,target,index-1,dp);
        dp[index][target]=pick+np;

        return dp[index][target];
    }

}
