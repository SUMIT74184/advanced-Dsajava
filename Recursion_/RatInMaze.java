package Recursion_;

import java.util.ArrayList;

public class RatInMaze {

    //d-(x+1,y)
    //u-(x-1,y)
    //L-(x,y-1)
    //R-(X,y+1)
    public static ArrayList<String>findPath(int[][]m,int n){
    ArrayList<String>res=new ArrayList<>();
    solve(m,0,0,n,"",res);
    return res;
    }
    public static void solve(int [][]mat,int i,int j,int n,String path,ArrayList<String>res){
        if(i==n-1 && j==n-1){
            res.add(path);
            return;
        }
        //dead ends
        if(i<0 || i>=n || j<0 ||j>=n || mat[i][j]==0 || mat[i][j]==2){
            return;
        }
        int orig=mat[i][j];
        mat[i][j]=2;//visit

        solve(mat,i-1,j,n,path+"U",res);
        solve(mat,i+1,j,n,path+"D",res);
        solve(mat,i,j-1,n,path+"L",res);
        solve(mat,i,j+1,n,path+"R",res);

        mat[i][j]=orig;
    }
    public static void main(String[] args) {

    }
}
