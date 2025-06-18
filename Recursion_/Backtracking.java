package Recursion_;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    //permutation of string
    class Solution {

        public void solve(int nums[],int index,List<List<Integer>>res){
            int n=nums.length;

            if(index==n-1){
                List<Integer>sublist=new ArrayList<Integer>();
                for(int e1:nums){
                    sublist.add(e1);
                }
                res.add(new ArrayList<>(sublist));
                return;
            }
            //task
            for(int i=index;i<n;i++){

                swap(nums,i,index);
                solve(nums,index+1,res);

                //backtracking
                swap(nums,i,index);
            }
            return;
        }

        public void swap(int []nums,int i1,int i2){
            int temp=nums[i1];
            nums[i1]=nums[i2];
            nums[i2]=temp;
        }

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>>res=new ArrayList<List<Integer>>();
            solve(nums,0,res);
            return res;
        }
    }
}
