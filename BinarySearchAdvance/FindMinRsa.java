package BinarySearchAdvance;

public class FindMinRsa {
    public static int findmin (int[]nums){
        int n=nums.length;
        int start=0;
        int end=n-1;

        int minE=Integer.MAX_VALUE;
        while(start<=end){
        int mid=start+(end-start)/2;
        if(nums[start]<=nums[mid]){
            minE=Math.min(minE,nums[start]);
            start=mid+1;
        }else{
            minE=Math.min(minE,nums[mid]);
            end=mid-1;
        }
        }
        return minE;
    }
}
