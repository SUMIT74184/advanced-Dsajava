package DynamicProgramming;

public class InfiniteSupply {
//    public int coinChange(int[] coins, int amount) {
//        int n=coins.length;
//        int result=recur(coins,amount,n-1);
//        if(result==1e9){
//            return -1;
//
//        }
//        return result;
//    }
//    public int recur(int []coins,int amount,int index){
//        if(index==0){
//            if(amount % coins[index]==0){
//                return amount/coins[index];
//            }
//            return (int)(1e9);
//        }
//        int pick=(int)(1e9);
//        if(amount>=coins[index]){
//            pick=1+recur(coins,amount-coins[index],index);
//        }
//        int np=recur(coins,amount,index-1);
//        return Math.min(pick,np);
//    }

    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int [][]dp=new int[n][amount+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<amount+1;j++){
                dp[i][j]=-1;
            }
        }
        int result=recur(coins,amount,n-1,dp);
        if(result==1e9){
            return -1;
        }
        return result;
    }
    public int recur(int []coins,int amount,int index,int[][]dp){
        if(index==0){
            if(amount % coins[index]==0){
                dp[index][amount]=amount/coins[index];
                return amount/coins[index];
            }
            dp[index][amount]=(int)(1e9);
            return (int)(1e9);
        }
        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }
        int pick=(int)(1e9);
        if(amount>=coins[index]){
            pick=1+recur(coins,amount-coins[index],index,dp);//we can repeat the index again and again as provided in the question
        }
        int np=recur(coins,amount,index-1,dp);
        dp[index][amount]=Math.min(pick,np);
        return dp[index][amount];
    }

    //tabulation
    public int coinChange1(int[] coins, int amount) {
        int n=coins.length;
        int [][]dp=new int[n][amount+1];

        for(int a=0;a<amount+1;a++) {

            if (a % coins[0] == 0) {
                dp[0][a] = a / coins[0];

            } else {
                dp[0][a] = (int) (1e9);
            }
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<amount+1;j++){
                int pick=(int)(1e9);
                if(j>=coins[i]){
                    pick=1+dp[i][j-coins[i]];
                }
                int np=dp[i-1][j];
                dp[i][j]=Math.min(pick,np);
            }
        }
        int result=dp[n-1][amount];
        if(result==1e9){
            return -1;
        }
        return result;
    }



//    coin change 2
public int change(int amount, int[] coins) {
    int n=coins.length;
    int [][]dp=new int[n][amount+1];

    for(int i=0;i<n;i++){
        for(int j=0;j<amount+1;j++){
            dp[i][j]=-1;
        }
    }
    int result=recur2(coins,amount,n-1,dp);
    if(result==0){
        return 0;
    }
    return result;
}

    public int recur2(int []coins,int amount,int index,int[][]dp){
        if(index==0){
            if(amount % coins[index]==0){
                dp[index][amount]=1;
                return 1;
            }
            dp[index][amount]=0;
            return 0;
        }
        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }
        int pick=0;
        if(amount>=coins[index]){
            pick=recur2(coins,amount-coins[index],index,dp);//now we just have to count the number where occurs
        }
        int np=recur2(coins,amount,index-1,dp);
        dp[index][amount]=pick+np;
        return dp[index][amount];
    }



}
