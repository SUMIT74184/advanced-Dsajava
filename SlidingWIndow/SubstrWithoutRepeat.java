package SlidingWIndow;

import java.util.HashSet;

public class SubstrWithoutRepeat {
        public int lengthOfLongestSubstring(String s) {
            int windowStart=0;
            int windowEnd=0;
            int n=s.length();
            HashSet<Character>set=new HashSet<>();
            int maxLen=Integer.MIN_VALUE;
            // int len=0;
            while(windowEnd<n){
                char ch=s.charAt(windowEnd);
                if(set.contains(ch)){
                    //Shrinking phase
                    while(windowStart<windowEnd && set.contains(ch)){
                        set.remove(s.charAt(windowStart));
                        windowStart++;
                    }
                }
                set.add(ch);
                maxLen=Math.max(maxLen,windowEnd-windowStart+1);
                windowEnd++;
            }
            return (maxLen==Integer.MIN_VALUE)?0:maxLen;
        }
}
