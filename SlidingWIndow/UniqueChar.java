package SlidingWIndow;

public class UniqueChar {

    public static int longestKSubstr(String s,int k){
        int n=s.length();
        int windowStart=0;
        int windowEnd=0;
        int len=0;
        int maxLen=Integer.MIN_VALUE;
        int []freqHash=new int[26];

        int uniqueCharCount=0;
        //expansion case
        while(windowEnd<n){
            int index=s.charAt(windowEnd)-97;
            if(freqHash[index]==0){
            uniqueCharCount++;
            freqHash[index]++;
            }
            else{
                freqHash[index]++;
            }
            if(uniqueCharCount==k){
                len=windowEnd-windowStart+1;
                maxLen=Math.max(maxLen,len);
            } //shrinking
            else if (uniqueCharCount>k) {
                while (windowStart<windowEnd && uniqueCharCount>k){
                    index=s.charAt(windowEnd)-97;
                    windowStart++; //inside the first str the window will move ahead
                    freqHash[index]--;
                    if(freqHash[index]==0){
                        uniqueCharCount--;
                    }
                }
            }
           windowEnd++; //will move ahead to after shrinking just keep in mind
        }
        return (maxLen==Integer.MIN_VALUE)?-1:maxLen;
    }

    public static void main(String[] args) {


    }

}
