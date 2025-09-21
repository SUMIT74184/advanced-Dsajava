package Recursion_;

import java.util.Arrays;

public class KnightTour {

    public static boolean isSafe(int[][] sol, int i, int j, int N){
        if(i<0 || i>=N || j<0 || j>=N || sol[i][j]!=-1){
            return false;
        }
        return true;
    }

    public static boolean solve(int i, int j,int [][]sol,int N,int moves){
        if(moves==N*N){
            return true;
        }
        int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};


        for(int k=0;k<8;k++){
            int nextI=i+dx[k];  //i+2
            int nextJ=j+dy[k];  //j+1
            if(isSafe(sol,nextI ,nextJ,  N)){
                sol[nextI][nextJ]=moves;
                if(solve(nextI, nextJ, sol, N, moves + 1)){
                    return true;
                }else{
                    sol[nextI][nextJ]=-1; //backtrack the solve function
                    //completely reset the solution
                }
            }
        }
        return false;
    }

    public static  void printsol(int sol[][]){
        int N= sol.length;
        for(int i=0;i< N;i++){
            for(int j=0;j<N;j++){
                System.out.print(sol[i][j]+ " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int N=5;
        int [][]sol=new int[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(sol[i],-1);
        }
        sol[0][0]=0;
        if(solve(0, 0, sol, N, 1)){
            printsol(sol);
        }else{
            System.out.println("sol is not available");
        }
    }

}
