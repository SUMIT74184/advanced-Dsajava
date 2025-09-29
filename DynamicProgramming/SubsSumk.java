package DynamicProgramming;



public class SubsSumk {

//    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
//        // code here
//        return recur(arr,K,N-1);
//    }
//    public static boolean recur(int []arr,int K,int index){
//        if(K==0){
//            return true;
//        }
//        if(index==0){
//            if(K==arr[index]) return true;
//            return false;
//        }
//
//        boolean pick=false;
//        if(arr[index]<=K){
//            pick=recur(arr,K-arr[index],index-1);
//            if(pick){
//                return true;
//            }
//        }
//        boolean np=recur(arr,K,index-1);
//        return np || pick;
//    }


//public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
//    // code here
//    int [][]dp=new int[N][K+1];
//    return recur(arr,K,N-1,dp);
//}
//   1-->true
//   2-->false
//    0-->Not visited

//    public static boolean recur(int []arr,int K,int index,int [][]dp) {
//        if (K == 0) {
//            dp[index][K] = 1;
//            return true;
//        }
//        if (index == 0) {
//            if (K == arr[index]) {
//                dp[index][K] = 1;
//                return true;
//            }
//            dp[index][K] = 2;
//            return false;
//        }
//
//        if (dp[index][K] != 0) {
//            return (dp[index][K] == 1) ? true : false;
//        }
//
//        boolean pick = false;
//        if (arr[index] <= K) {
//            pick = recur(arr, K - arr[index], index - 1, dp);
//            if (pick) {
//                dp[index][K] = 1;
//                return true;
//            }
//        }
//        boolean np = recur(arr, K, index - 1, dp);
//        dp[index][K] = (np == true) ? 1 : 2;
//
//        return np|| pick;
//    }

    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        // code here
        int [][]dp=new int[N][K+1];
        for(int i=0;i<N;i++){
            dp[i][0]=1;
        }
        for(int tar=1;tar<=K;tar++){
            if(tar==arr[0]){
                dp[0][tar]=1;
            }else{
                dp[0][1]=2;
            }
        }
        for(int i=1;i<N;i++){
            for(int j=1;j<=K;j++){
                int  pick = 2;
        if (arr[i] <= j) {
            pick = dp[ i - 1][j - arr[i]];
            if (pick==1) {
                dp[i][j] = 1;
                continue;
            }
        }
        int np = dp[i-1][j];
        dp[i][j] = np;

            }
        }


        return (dp[N-1][K]==1);
    }



}
