package GreedyAlgo;

import java.util.*;
public class MInPlatform {

    public static int minPlatform(int []arr,int []dep){
        int n=arr.length;

        int [][]v=new int[n][2];
        for(int i=0;i<n;i++){
            v[i][0]=arr[i];
            v[i][1]=dep[i];
        }
        Arrays.sort(v,Comparator.comparingInt(a->a[0]));

        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int ans=0;

        for(int i=0;i<n;i++){
            while(!pq.isEmpty()&& pq.peek()<v[i][0]){
                pq.poll();
            }
            pq.add(v[i][1]); //adding the departure train then comparing

            ans=Math.max(ans,pq.size());
        }
        return ans;
    }
// optimized approach


    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(minPlatform(arr, dep));
    }
}
