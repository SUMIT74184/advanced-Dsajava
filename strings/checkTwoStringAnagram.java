 
 package strings;

import java.util.Arrays;

public class checkTwoStringAnagram{
    public static boolean isAnagram(String str1,String str2){
        if(str1 ==null || str2==null){
            return false;
        }
        char[] a1=str1.toCharArray();
        char[] a2=str2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }
    public static void main(String[] args) {
      boolean ans= isAnagram("listen", "silent");
      System.out.println(ans);
    }

 }