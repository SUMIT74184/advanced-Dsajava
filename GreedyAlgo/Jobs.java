package GreedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;

public class Jobs {

    public ArrayList<Integer>JobSequencing(int []id,int []deadline,int []profit){
        //find the max deadline
        int n=0;
        for(int d:deadline){
            n=Math.max(n,d);
        }
        int assignedJob[]=new int[n+1];
        Arrays.fill(assignedJob,-1);
        int len= profit.length;
        Integer []index=new Integer[len];
        for(int i=0;i<len;i++){
            index[i]=i;
        }
        int count=0;
        int maxProfit=0;
        Arrays.sort(index,(a,b)->profit[b]-profit[a]);
        for(int i=0;i<len;i++){
            int ind=index[i];
            int d=deadline[ind];
            while(assignedJob[d]!=-1) d--;
            if(d==0) continue;
            assignedJob[d]=id[ind];
            maxProfit+=profit[ind];
        }
        ArrayList<Integer>res=new ArrayList<>();
        res.add(count);
        res.add(maxProfit);
        return res;
    }
    public static void main(String[] args) {

    }
}
