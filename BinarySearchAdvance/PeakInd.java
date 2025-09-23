package BinarySearchAdvance;

public class PeakInd {

    public int peakIndexInMountainArray(int []arr){
        int n=arr.length;
        int start=0;
        int end=n-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid!=0 && mid!=n-1 && arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            } else if (mid!=n-1 && arr[mid]<arr[mid+1]) { //increasing order
                start=mid+1;
            }else{ // decreasing order
                end=mid-1;
            }
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n=mountainArr.length();
        int start=0;
        int end=n-1;
        int mid=-1;
        while(start<=end){
            mid=start+(end-start)/2;
            int cur=mountainArr.get(mid);
            if(mid!=0 && mid!=n-1 && cur > mountainArr.get(mid-1)
                    && cur>mountainArr.get(mid+1)){
                if(cur==target){
                    return mid;
                }
                break;
            }else if(mid!=n-1 && cur < mountainArr.get(mid+1)){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }


        //find in first half (increasing order)
        start=0;
        end=mid-1;
        while(start<=end){
            int m=start+(end-start)/2;
            int cur=mountainArr.get(m);
            if(cur==target){
                return m;
            }else if(cur>target){
                end=m-1;
            }else{
                start=m+1;
            }
        }


        //find in second half (decreasing array)
        start=mid+1;
        end=n-1;
        while(start<=end){
            int m=start+(end-start)/2;
            int cur=mountainArr.get(m);
            if(cur==target){
                return m;
            }else if(target<cur){
                start=m+1;
            }else{
                end=m-1;
            }
        }
        return -1;

    }


}
