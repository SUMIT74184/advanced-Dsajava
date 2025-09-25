package BinarySearchAdvance;

public class CountPSq {

    public static int mySqrt(int x) {
        int start = 1;
        int end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid) {
                if (x % mid == 0 && mid == x / mid) {
                    return mid;
                }
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
//return end; now we want the ciel value not the floor
        return start;
    }
    static int countSquares(int N){
        int sqrt=mySqrt(N);
        return sqrt-1;
    }
}
