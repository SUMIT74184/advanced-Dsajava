package GreedyAlgo;

import java.util.Arrays;

public class AssignMice {

    public static int assignMiceHoles(int N,int []M,int []H){
        Arrays.sort(M);
        Arrays.sort(H);
        int maxTime=0;
        for(int i=0;i<N;i++){
            maxTime=Math.max(maxTime,Math.abs(M[i]-H[i]));

        }
        return maxTime;

    }
    public static void main(String[] args) {

    }
}
