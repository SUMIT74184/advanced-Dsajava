package BinarySearchAdvance;

public class AllocateShipment {

    public int shipWithinDays(int[] weights, int days) {
        int res=-1;
        //range will be the max of the array and the sum of the array
        int start=Integer.MIN_VALUE;
        int end=0; // sum of an array

        for(int i=0;i<weights.length;i++){
            if(weights[i]>start){
                start=weights[i];
            }
            end=end+weights[i];
        }
        while(start<=end){
            //max pages that can be allocated to single students
            int mid=start+(end-start)/2;
            if(isShipmentpossible(weights,mid,days)){
                res=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return res;
        //we have to find the combination
    }
    public static boolean isShipmentpossible(int []weights,int maxCap,int days){
        int currdays=1;
        int capacity=0;
        for(int i=0;i<weights.length;i++){
            capacity+=weights[i];

            if (capacity>maxCap){ //whenever the mid value gets bigger we need the new Student
                currdays+=1;
                capacity=weights[i];
            }
            if(currdays>days){
                return false;
            }
        }
        return true;
    }
}
