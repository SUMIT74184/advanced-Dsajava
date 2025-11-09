package HashMaps;

import java.util.HashMap;

public class TwoSum {

    public static boolean tps(int []nums,int target){
        HashMap<Integer,Integer>maps=new HashMap<>();

        for(int num:nums){
            if(maps.containsKey(target-num)){
                return true;
            }
        maps.put(num,1);
        }
        return false;
    }

    public static void main(String[] args) {
        int []nums1={0,5,4};
        System.out.println(tps(nums1,5));
    }

}
