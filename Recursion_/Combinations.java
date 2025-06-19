package Recursion_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        ArrayList<Integer>curr=new ArrayList<>();
        solve(candidates,target,0,curr,res);
        return res;
    }
    public void solve(int []candidates, int target, int index, ArrayList<Integer>cur,List<List<Integer>>res){
        //base case
        if(index == candidates.length){
            if(target==0){
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        //pick
        if(candidates[index]<=target){//this is the main condition to use the number again
            cur.add(candidates[index]);
            solve(candidates, target-candidates[index], index, cur, res);
            cur.remove(cur.size()-1);
        }
        //not picking trying the next options
        solve(candidates, target, index+1, cur, res);

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        ArrayList<Integer>curr=new ArrayList<>();
        Arrays.sort(candidates);
        solve2(candidates,target,0,curr,res);
        return res;
    }

    public void solve2(int []candidates,int target,int index,ArrayList<Integer>cur,List<List<Integer>>res) {
            if (target == 0) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for(int i = index;i<candidates.length;i++){
            if((i==index || candidates[i-1]!=candidates[i]) && candidates[i]<=target){
                cur.add(candidates[i]);
                solve(candidates, target - candidates[i], i+1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }

    }
//over here we are given with n=target and k=3 which is not
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>res=new ArrayList<>();
        ArrayList<Integer>curr=new ArrayList<>();
        solve3(k,n,1,curr,res);
        return res;
    }
    public void solve3(int k,int target,int element,ArrayList<Integer>cur,List<List<Integer>>res){
        if (cur.size() >= k) {
            if(target==0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for(int i = element;i<=9;i++){
            if(i<=target){
                cur.add(i);
                solve3(k, target - i, i+1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }

    }


//multiple solution comes into the picture
    public int combinationSum4(int[] nums, int target) {
        //  List<List<Integer>>res=new ArrayList<>();
        // int []res=new int[1];
        int res=0;
//        ArrayList<Integer>curr=new ArrayList<>();
        HashMap<Integer,Integer>dp=new HashMap<Integer,Integer>();
        res=solve4(target,nums,dp,0);
        return res;
    }
    public int solve4(int target, int []nums,HashMap<Integer,Integer> dp, int ind){

        if(target <=0 || ind>=nums.length){
            if(target==0){
                return 1;
            }
            return 0;
        }

        if(dp.containsKey(target)){
            return dp.get(target);
        }

        int res=0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<=target){
                res+=solve4(target - nums[i],nums,dp,ind);
            }
        }
        dp.put(target,res);
        return res;
    }
}
