package BinarySearchAdvance;

public class MountainPeak {

    public static boolean validMountainArray(int []arr){
        //O(N)
        int index=0;
        int n= arr.length;
        //find all increasing seq...find the peak element
        while(index<n-1){
            if(arr[index]<arr[index+1]){
                index++;
            }else{
                break;
            }
        }
        if(index==0 || index==n-1){
            return false;
        }

        //find all the decreasing seq...find end of the array
        while(index<n-1){
            if(arr[index]>arr[index+1]){
                index++;
            }else{
                break;
            }
        }
        return (index==n-1);
    }

    public static void main(String[] args) {

    }
}
