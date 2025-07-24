package GreedyAlgo;

import java.util.*;

public class GlA {

    //sort the end array in terms of increasing order with pair start as it is
    public int activitySelection(List<Integer>start,List<Integer>end){
        int n=start.size();
        ArrayList<Integer>IndexArr=new ArrayList<>();
        for(int i=0;i<n;i++){
            IndexArr.add(i);
        }
        //sorting of end
//        2,1,0,5,4,3
        Collections.sort(IndexArr,(a,b)->(end.get(a)-end.get(b)));
        int maxActivity=1;
        int lastEnd= end.get(IndexArr.get(0));
        for(int i=1;i<n;i++){
            int index=IndexArr.get(i);
            if(start.get(index)>lastEnd){
                maxActivity++;
                lastEnd=end.get(index);
            }
        }
        return maxActivity;
    }


    public static void main(String[] args) {

    }
}
