package Recursion_;

import java.util.ArrayList;

public class josephusProblem {
    public int josephus(int n,int k){
        ArrayList<Integer>list=new ArrayList<>();
        for (int i=1;i<=n;i++){
            list.add(i);
        }
       return recur(list,k,0);
    }
    public int recur(ArrayList<Integer>list,int k,int ind){
        if(list.size()==1){
            return list.get(0);
        }
        int nextInd=(ind+k-1)%list.size();
        list.remove(nextInd);
       return recur(list,k,nextInd);
    }
}
