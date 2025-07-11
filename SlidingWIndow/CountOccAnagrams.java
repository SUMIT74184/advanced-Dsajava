package SlidingWIndow;

import java.util.Arrays;

public class CountOccAnagrams {

    static int counting(String pat,String txt){
        int []patFreq=new int[26];
        int k=pat.length();
        //calc pat freq
        for(int i=0;i<k;i++){
            int index=pat.charAt(i)-97;
            patFreq[index]++;
        }
        //init window
        int []txtFreq=new int[26];
        for(int i=0;i<k;i++) {
            int index=txt.charAt(i) - 97;
            txtFreq[index]++;
        }
        int count=0;
        if(Arrays.equals(txtFreq,patFreq)){
            count++;
        }
        //calc for other windows
        int n=txt.length();
        for(int i=1;i<n-k+1;i++){
            int removedCharIndex=txt.charAt(i-1)-97;//remember this is ascii value
            int addedCharIndex=txt.charAt(i+k-1)-97;
            txtFreq[addedCharIndex]++;
            txtFreq[removedCharIndex]--;
            if(Arrays.equals(txtFreq,patFreq)){
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
    String pat="for";
    String txt="forxxorfxdofrdasjorf";
    int ans=counting(pat,txt);
        System.out.println("total occurrence of anagrams is "+ans);
    }
}
