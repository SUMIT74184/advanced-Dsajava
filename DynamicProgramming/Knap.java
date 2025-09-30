package DynamicProgramming;

public class Knap {
//    static int KnapSack(int capacity,int []val,int []wt){
//        int n= val.length;
//        return recur(capacity,val,wt,n-1);
//    }
//    static int recur(int capacity,int []val,int []wt,int index){
//        //base case
//        if(capacity==0) return 0;
//        if(index==0){
//            if(wt[index]<=capacity){
//                return val[index];
//            }else{
//                return 0;
//            }
//        }
//        int pick=0;
//        if(wt[index]<=capacity){
//            pick=val[index]+recur(capacity-wt[index],val,wt,index-1);
//        }
//        int np=recur(capacity,val,wt,index-1);
//        return Math.max(pick,np);
//    }


    //Memoization
//    static int KnapSack(int capacity,int []val,int []wt){
//        int n= val.length;
//        int [][]dp=new int[n][capacity+1];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<capacity+1;j++){
//                dp[i][j]=-1;
//            }
//        }
//        return recur(capacity,val,wt,n-1,dp);
//    }
//    static int recur(int capacity,int []val,int []wt,int index,int [][]dp){
//        //base case
//        if(capacity==0) {
//            dp[index][capacity]=0;
//            return 0;
//        }
//        if(index==0){
//            if(wt[index]<=capacity){
//                dp[index][capacity]=val[index];
//                return val[index];
//            }else{
//                dp[index][capacity]=0;
//                return 0;
//            }
//        }
//        if(dp[index][capacity]!=-1){
//            return dp[index][capacity];
//        }
//        int pick=0;
//        if(wt[index]<=capacity){
//            pick=val[index]+recur(capacity-wt[index],val,wt,index-1,dp);
//        }
//         int np=recur(capacity,val,wt,index-1,dp);
//        dp[index][capacity]=Math.max(pick,np);
//        return dp[index][capacity];
//    }

//    Tabulation
static int KnapSack(int capacity,int []val,int []wt){
    int n= val.length;
    int [][]dp=new int[n][capacity+1];

    for(int i=0;i<n;i++){
        dp[i][0]=0;
    }

    for(int c=0;c<capacity+1;c++){
        if(wt[0]<=c){
            dp[0][c]=val[0];
        }else{
            dp[0][c]=0;
        }
    }
    for(int i=1;i<n;i++){
        for(int j=0;j<capacity+1;j++){
            int pick=0;
            if(wt[i]<=j){
                pick=val[i]+dp[i-1][j-wt[i]];
            }
            int np=dp[i-1][j];
            dp[i][j]=Math.max(pick,np);
        }
    }
    return dp[n-1][capacity];
}


}
