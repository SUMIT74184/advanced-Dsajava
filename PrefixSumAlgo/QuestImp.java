package PrefixSumAlgo;

import java.util.ArrayList;

public class QuestImp{
    public static ArrayList<Integer>prefSum(int []arr){
        int n=arr.length;

        ArrayList<Integer>prefixSum=new ArrayList<>();

        //adding the first element
        prefixSum.add(arr[0]);

        //adding the previous and present element
        for(int i=1;i<n;i++){
            prefixSum.add(prefixSum.get(i-1)+arr[i]);
        }
        return prefixSum;
    }
    public static void main(String[] args) {
        int []arr={2,3,4,5,6,7};
        ArrayList<Integer>res=new ArrayList<>();
        res=prefSum(arr);
        System.out.println("prefix sum are "+ res);


    }
    
    
}