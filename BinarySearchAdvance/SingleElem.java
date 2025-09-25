package BinarySearchAdvance;

public class SingleElem {
    public int singleNonDuplicate(int[] nums) {
        int n= nums.length;
        int start=0;
        int end=n-2;
        while(start<=end){
            int m=start+(end-start)/2;
            if(nums[m]==nums[m^1]){
                start=m+1;
            }else{
                end=m-1;
            }
        }
        return nums[start];
    }
}
