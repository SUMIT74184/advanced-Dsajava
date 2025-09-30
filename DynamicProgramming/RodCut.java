package DynamicProgramming;

public class RodCut {
//    public int cutRod(int[] price) {
//        // code here
//        int rodLen= price.length;
//        return recur(rodLen,rodLen-1,price);
//
//    }
//    public int recur(int rodLen,int ind,int []price){
//        if(ind==0){
//            return rodLen*price[0];
//        }
//        int pick=0;
//        int currLen=ind+1;
//        if(rodLen>=currLen) {
//            pick = price[ind] + recur(rodLen - currLen, ind, price);
//        }
//        int np=recur(rodLen,ind-1,price);
//
//        return Math.max(pick,np);
//    }

//    Memoization
// public int cutRod(int[] price) {
//     // code here
//     int rodLen= price.length;
// //    (len,rodLen)
//     int [][]dp=new int[rodLen][rodLen+1];
//             for(int i=0;i<rodLen;i++){
//                 for(int j=0;j<rodLen+1;j++){
//                     dp[i][j]=-1;
//                 }
//             }
//     return recur(rodLen,rodLen-1,price,dp);

// }
//     public int recur(int rodLen,int ind,int []price,int [][]dp){
//         if(ind==0){
//             dp[ind][rodLen]=rodLen*price[0];
//             return rodLen*price[0];
//         }
//         if(dp[ind][rodLen]!=-1){
//             return dp[ind][rodLen];
//         }
//         int pick=0;
//         int currLen=ind+1;
//         if(rodLen>=currLen) {
//             pick = price[ind] + recur(rodLen - currLen, ind, price,dp);
//         }
//         int np=recur(rodLen,ind-1,price,dp);

//         dp[ind][rodLen]=Math.max(pick,np);

//         return dp[ind][rodLen] ;
//     }

    //    Tabulation
    public int cutRod(int[] price) {
        // code here
        int rodLen= price.length;
//    (len,rodLen)
        int [][]dp=new int[rodLen][rodLen+1];

        for(int i=0;i<rodLen+1;i++){
            dp[0][i]=i*price[0];
        }

        for(int i=1;i<rodLen;i++){
            for(int j=0;j<rodLen+1;j++){
                int pick=0;
                int curlen=i+1;
                if(j>=curlen) {
                    pick = price[i] + dp[i][j-curlen];
                }
                int np=dp[i-1][j];
                dp[i][j]=Math.max(pick,np);
            }
        }
        return dp[rodLen-1][rodLen];

    }
}
