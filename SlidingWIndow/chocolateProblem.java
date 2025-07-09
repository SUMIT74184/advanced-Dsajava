package SlidingWIndow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class chocolateProblem {
    //

    public static long findMinDiff(ArrayList<Integer>a,int n,int m){
        if(a.size()==0){
            return 0;
        }
        long res= Long.MAX_VALUE;
        Collections.sort(a);
        for(int i=0;i<n-m+1;i++){
            int minElement=a.get(i);
            int maxElement=a.get(i+m-1);
            res=Math.min(res,maxElement-minElement);
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer>res=new ArrayList<>();
        res.add(3);
        res.add(4);
        res.add(1);
        res.add(9);
        res.add(56);
        res.add(7);
        res.add(9);
        res.add(12);

        long as=findMinDiff(res,8,5);
        System.out.println(as);






    }

}
