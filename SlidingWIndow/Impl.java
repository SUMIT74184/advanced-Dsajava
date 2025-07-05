package SlidingWIndow;

import java.util.ArrayList;

public class Impl {
      static long maxisubarray(int K, ArrayList<Integer>arr,int N){
        long maxSum=0;
        long sum=0;

        int index=0;
        while(index<N && index<K){
            sum+=arr.get(index);
            index++;
        }
        maxSum=sum;
        for(int i=1;i<N-K+1;i++){
            int prevElement=arr.get(i-1);
            int nextElement=arr.get(i+K-1);
            sum=sum-prevElement+nextElement;
            maxSum=Math.max(maxSum,sum);

        }
        return maxSum;
    }

    public static void main(String[] args) {
        int K=3;
        int N=7;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(5);
        arr.add(1);
        arr.add(8);
        arr.add(2);
        arr.add(9);
        arr.add(1);

        long result = maxisubarray(K, arr, N);
        System.out.println("Maximum sum of subarray of size " + K + " is: " + result);


    }
}
