package BinarySearchAdvance;

import java.util.Arrays;

public class AggressiveCows {

    public  static int FindStall(int n,int cows,int[] stalls){
        if(stalls.length<cows){
            return -1;
        }
        Arrays.sort(stalls);
        int start=1;
        int end=stalls[n-1]-stalls[0];
        int ans=-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            //if possible increase the distance --->array
            if(isAllocationPossible(stalls,mid,cows)){
                ans=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
    static boolean isAllocationPossible(int []stalls,int minDistance,int cows){
        int cowCount=1;
        int lastCowDistance=stalls[0];
        for(int i=0;i<stalls.length;i++){
            //check if the min distance is maintained
            //then increase count of cow and assign new location
            if(stalls[i]-lastCowDistance>=minDistance){
                cowCount+=1;
                lastCowDistance=stalls[i];

            }
            if(cowCount>=cows){
                return true;
            }
        }
        return false;
    }

}
