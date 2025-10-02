package DynamicProgramming;

public class Lpsc {

    public int longestPalindromeSubseq(String s){
        StringBuilder str=new StringBuilder(s);
        return longestCommonSubsequence1(s,str.reverse().toString());
    }

    public int longestCommonSubsequence1(String t1, String t2) {
        int n=t1.length();
        int m=t2.length();
        int [][]dp=new int[n+1][m+1];

        dp[0][0]=0;


        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(t1.charAt(i-1)==t2.charAt(j-1)){ //shifting logic
                    dp[i][j]=1+dp[i-1][j-1];

                }else{
                    int case1=dp[i-1][j];
                    int case2=dp[i][j-1];
                    dp[i][j]= Math.max(case1,case2);

                }
            }
        }
        print(dp);
        return dp[n][m];
    }

    public void print(int [][]dp){
        int n= dp.length;
        int m=dp[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.println(dp[i][j]+" ,");
            }
            System.out.println();
        }
    }

}
