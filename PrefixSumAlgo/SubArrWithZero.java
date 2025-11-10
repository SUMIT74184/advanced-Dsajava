package PrefixSumAlgo;

import java.util.HashMap;

public class SubArrWithZero {

//Intuition: We use the concept of prefix sum to track the sum of elements from the start of the array up to each index. If at two different indices the prefix sum is the same, it means the elements between those indices sum to zero.
//
//Let prefixSum[j] = prefixSum[i] (with j > i). Then the sum from index i+1 to j is zero → arr[i+1] + ... + arr[j] = 0
//Also, if prefixSum == 0 at any index, the subarray from index 0 to that index has zero sum.
//
//Mathematical Explanation:
//
//Let’s define: prefixSum[k] = arr[0] + arr[1] + ... + arr[k]
//
//If prefixSum[j] == prefixSum[i] where j > i, then: arr[i+1] + arr[i+2] + ... + arr[j] = prefixSum[j] - prefixSum[i] = 0
//
//We use a hash map to store how many times a prefix sum has occurred.
    public static int zeroSub(int []arr){
        HashMap<Integer,Integer>prefcount=new HashMap<>();
        int sum=0;
        int count=0;

        prefcount.put(0,1);

        for(int num:arr){
            sum+=num;

            //counting the occurrence of the sum
            if(prefcount.containsKey(sum)){
                count+=prefcount.get(sum);
            }
            //storing the sum if it appear for the first time
            prefcount.put(sum,prefcount.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {

    }

}
