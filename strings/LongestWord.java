package strings;

public class LongestWord {

    public static String longest(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }
        String longestWord = "";
        int maxlen = 0;
        String[] words = sentence.split(" ");

        for (String word : words) {
            if (word.length() > maxlen) {
                maxlen = word.length();
                longestWord = word;
            }

        }
        return longestWord;

    }

    // approach 2

    public static String longest1(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        char[] chars = sentence.toCharArray();
        int maxLength = 0, maxStart = 0;
        int currentLength = 0, currentStart = 0;

        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] == ' ') {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStart = currentStart;
                }
                currentLength = 0;
                currentStart = i + 1;
            } else {
                currentLength++;
            }
        }

        return sentence.substring(maxStart, maxStart + maxLength);
    }

    public static void main(String[] args) {
        String ans = longest("the hungary fox is roaming in my backyard");
        System.out.println(ans);
    }

}
