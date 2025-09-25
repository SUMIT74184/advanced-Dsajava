package BinarySearchAdvance;

public class SearchInRotated {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start=0;
        int end= nums.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==nums[mid]){
                return mid;
            }

            if(nums[start]<=nums[mid]){
                //can answer be found on the left side the array
                if(target>=nums[start] && target<nums[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{//we have to traverse through the next sorted half now
                if(target>nums[mid] && target<=nums[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }

            }
        }
        return ans;
    }

    public static boolean searchIn(int []nums,int target){
        if (nums == null || nums.length == 0) return false;
        int start=0;
        int end= nums.length-1;
        boolean ans=false;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==nums[mid]){
                return true;
            }
            //checkout the duplicate condition
//            if start,mid and end all are same then we can't guarantee which part is sorted so
//            we will trim down the space
            if(nums[start]==nums[mid] && nums[mid]==nums[end]){
                start++;
                end--;
            }

            else if(nums[start]<=nums[mid]){
                //can ans be found in the left side the array
                if(target>=nums[start] && target<nums[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{//we have to traverse through the next sorted half now
                if(target>nums[mid] && target<=nums[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }

            }

        }

        return ans;
    }
}
