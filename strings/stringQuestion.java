package strings;


import java.util.*;
public class stringQuestion {
  public int countConsistentStrings(String allowed, String[] words) {
    // char ch[] = words.length();

    int counter = 0;
    HashSet<Character> set = new HashSet<Character>();
    for (int i = 0; i < allowed.length(); i++) {
        set.add(allowed.charAt(i));
    }
    for (String str : words) {

        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                flag = false;
            }
        }
        if (flag)
            counter++;
    }
    return counter;
}
public static void main(String[] args) {
  
}
}
