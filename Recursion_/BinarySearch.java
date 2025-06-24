package Recursion_;

public class BinarySearch {

    public static int bsearch(int []arr,int l,int h,int target){
        if(l>h){
            return -1;
        }
        int mid=l+(h-l)/2;

        if(arr[mid]==target){
            return mid;
        } else if (target<arr[mid]) {
            bsearch(arr,l,mid-1,target);

        }else{
            bsearch(arr,mid+1,h,target);
        }
        return target;
    }

    public static void main(String[] args) {

    }
}
