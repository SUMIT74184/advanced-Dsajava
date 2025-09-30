package DynamicProgramming;

public class Lcs {
//    public int longestCommonSubsequence(String text1, String text2) {
//        int n=text1.length();
//        int m=text2.length();
//        return recur(n-1,m-1,text1,text2);//we are starting from the last of the sequences
//    }
//    public int recur(int i,int j,String t1,String t2){
//        //base case
//        if(i<0 || j<0){
//            return 0;
//        }
//        if(t1.charAt(i)==t2.charAt(j)){
//            return 1+recur(i-1,j-1,t1,t2);
//        }else{
//            int case1=recur(i-1,j,t1,t2);
//            int case2=recur(i,j-1,t1,t2);
//            return Math.max(case1,case2);
//        }
//    }


//    public int longestCommonSubsequence(String text1, String text2) {
//        int n=text1.length();
//        int m=text2.length();
//        int [][]dp=new int[n+1][m+1];
//        for(int i=0;i<n+1;i++){
//            for(int j=0;j<m+1;j++){
//                dp[i][j]=-1;
//            }
//        }
//        return recur(n,m,text1,text2,dp);//we are starting from the last of the sequences
//    }
//    public int recur(int i,int j,String t1,String t2,int [][]dp){
//        //base case
//        if(i==0 || j==0){
//            dp[i][j]=0;
//            return 0;
//        }
//        if(dp[i][j]!=-1){
//            return dp[i][j];
//        }
//        if(t1.charAt(i-1)==t2.charAt(j-1)){ //shifting logic
//            dp[i][j]=1+recur(i-1,j-1,t1,t2,dp);
//            return dp[i][j];
//        }else{
//            int case1=recur(i-1,j,t1,t2,dp);
//            int case2=recur(i,j-1,t1,t2,dp);
//            dp[i][j]= Math.max(case1,case2);
//            return dp[i][j];
//        }
//    }

    public int longestCommonSubsequence(String t1, String t2) {
        int n=t1.length();
        int m=t2.length();
        int [][]dp=new int[n+1][m+1];

        dp[0][0]=0;


        for(int i=1;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(t1.charAt(i-1)==t2.charAt(j-1)){ //shifting logic
            dp[i][j]=1+dp[i-1][j-1];

        }else{
            int case1=dp[i-1][j];
            int case2=dp[i][j-1];
            dp[i][j]= Math.max(case1,case2);

        }
            }
        }
        return dp[n][m];
    }
}
