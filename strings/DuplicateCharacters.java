package strings;

import java.util.HashMap;

public class DuplicateCharacters {
    static void findDuplicates(String str) {

        if(str==null || str.isEmpty()){
         return;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) { //converted the char into the arrays
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        map.forEach((k, v) -> {
            if (v > 1) {
                System.out.println(k + ":" + v);
            }
        });
    }

   public static String removeDuplicateString(String str) {
    if (str == null || str.isEmpty()) {
        return str;
    }

    StringBuilder result = new StringBuilder();
    boolean[] seen = new boolean[256]; // ASCII character set

    for (char c : str.toCharArray()) {
        if (!seen[c]) {
            seen[c] = true;
            result.append(c);
        }
    }

    String ans = result.toString();
    System.out.println(ans);
    return ans;
}

    public static void main(String[] args) {
        findDuplicates("rebootprogramming");
        removeDuplicateString("neelnull");
    }

}
