package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS {
//    public int lengthOfLIS(int[] nums) {
//    int n= nums.length;
//    int []lis=new int[n];
//        Arrays.fill(lis,1);
//        int maxlen=1;
//        for(int i=1;i<n;i++){
//            for(int p=0;p<i;p++){
//                if(nums[p]< nums[i]){
//                    lis[i]=Math.max(lis[i],1+lis[p]);
//                }
//            }
//            if(lis[i]>maxlen){
//                maxlen=lis[i];
//            }
//        }
//        return maxlen;
//    }

    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int []lis=new int[n];
        int []Prev=new int[n];
     for(int i=0;i<n;i++){
         lis[i]=1;
         Prev[i]=i;
     }
     int maxlen=1;
     int maxInd=0;
        for(int i=1;i<n;i++){
            for(int p=0;p<i;p++){
                if(nums[p]< nums[i]){
                    if(lis[i]<1+lis[p]){
                        lis[i]=1+lis[p];
                        Prev[i]=p;///kiski wajah se change hua
                    }

                }
            }
            if(lis[i]>maxlen){
                maxlen=lis[i];
                maxInd=i;
            }
        }
        ArrayList<Integer>list=new ArrayList<>();
        list.add(nums[maxInd]);
        while(maxInd!=Prev[maxInd]){
            maxInd=Prev[maxInd];
            list.add(0,nums[maxInd]); //handling the rev
        }

        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i)+",");
        }
        return maxlen;
    }

}
