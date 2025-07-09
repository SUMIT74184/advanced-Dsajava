package SlidingWIndow;

public class VariableWindow {

    public static int smallestSubWithSum(int[] arr, int n, int x) {
        int windowStart = 0;
        int windowEnd = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (windowEnd < n) {
            //expansion case
            sum += arr[windowEnd];
            if (sum > x) {
                int len = windowEnd - windowStart + 1;
                minLen = Math.min(minLen, len);
                //i got my one answer now reduce this---shrinking
                while (windowStart < windowEnd && sum > x) {
                    sum -= arr[windowStart];
                    windowStart++;
                    if (sum > x) {
                        len = windowEnd - windowStart + 1;
                        minLen = Math.min(minLen, len);
                    }
                }
            }
            windowEnd++; //i need to expand the once getting the answer in the arr
        }
        return (minLen==Integer.MAX_VALUE)?0:minLen;
    }
        public static void main (String[]args){

  }

}
