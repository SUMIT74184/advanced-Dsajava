package strings;

import java.util.HashMap;
import java.util.Map;

public class ReturnmaxLenthrice {
    // class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        //generate all the substring and store in currstr
        int n = s.length();
        for (int i = 0; i < n; i++) {
            StringBuilder currStr = new StringBuilder();
            for (int j = i; j < n; j++) {
                if (currStr.length() == 0 || s.charAt(j) == currStr.charAt(currStr.length() - 1)){
                    currStr.append(s.charAt(j));
                    String cur = currStr.toString();
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                } else {
                    break;

                }
            }
        }
        int maxlen = -1; //if no substr is present
        for (Map.Entry<String, Integer> en : map.entrySet()) {
            String str = en.getKey();
            int freq = en.getValue();
            if (freq > 2) {
                maxlen = Math.max(maxlen, str.length());
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        
    }
}
    

