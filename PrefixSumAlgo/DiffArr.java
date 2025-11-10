package PrefixSumAlgo;

import java.util.ArrayList;

public class DiffArr {

  static void update(int []d,int l,int r,int x){
      d[l]+=x;
      if(r+1<d.length){
          d[r+1]=-x;
      }
  }

  static ArrayList<Integer>diff(int []arr,int [][]opr){
      int n=arr.length;
      int[]d=new int[n+1];

      //apply all operations to the difference array

      for(int []query:opr){
          int l=query[0];
          int r=query[1];
          int v=query[2];
          update(d,l,r,v);
      }
      // apply prefix sum and construct result

      for(int i=0;i<n;i++){
          if(i>0)d[i]+=d[i-1];
          arr[i]+=d[i];
      }
      ArrayList<Integer>res=new ArrayList<>();
      for(int num:arr){
          res.add(num);
      }
      return res;
  }

    public static void main(String[] args) {

    }
}
