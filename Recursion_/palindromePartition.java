package Recursion_;

import java.util.ArrayList;
import java.util.List;

public class palindromePartition {
        public List<List<String>> partition(String s) {
            List<List<String>> res=new ArrayList<List<String>>();
            List<String>curr=new ArrayList<String>();
            recur(s,0,s.length(),curr,res);
            return res;
        }
        public void recur(String s,int index,int n,List<String>curr,List<List<String>>res){
            if(index==n){
                res.add(new ArrayList<String>(curr));
                return;
            }
            for(int i=index;i<n;i++){
                if(isPalindrome(s,index,i)){
                    curr.add(s.substring(index,i+1));
                    recur(s,i+1,n,curr,res);
                    curr.remove(curr.size()-1);
                }
            }
        }

        public boolean isPalindrome(String s,int i1,int i2){
            while(i1<i2){
                if(s.charAt(i1)!=s.charAt(i2)){
                    return false;
                }
                i1++;
                i2--;
            }
            return true;
        }

    public static void main(String[] args) {

    }


    }

