package BinarySearchAdvance;

import java.util.*;

public class KthRsa {
    public int findKRotation(List<Integer> arr) {
        int n = arr.size();
        int start = 0;
        int end = n - 1;
        int minInd = -1;   // safer than Integer.MAX_VALUE
        int minE = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // left half sorted
            if (arr.get(start) <= arr.get(mid)) {
                if (arr.get(start) < minE) {
                    minE = arr.get(start);
                    minInd = start;
                }
                start = mid + 1;
            }
            // right half sorted
            else {
                if (arr.get(mid) < minE) {
                    minE = arr.get(mid);
                    minInd = mid;
                }
                end = mid - 1;
            }
        }
        return minInd;
    }

    public static void main(String[] args) {
        KthRsa obj = new KthRsa();

        List<Integer> arr1 = Arrays.asList(15, 18, 2, 3, 6, 12);
        List<Integer> arr2 = Arrays.asList(7, 9, 11, 12, 5);
        List<Integer> arr3 = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Rotation index for arr1: " + obj.findKRotation(arr1)); // Expected 2
        System.out.println("Rotation index for arr2: " + obj.findKRotation(arr2)); // Expected 4
        System.out.println("Rotation index for arr3: " + obj.findKRotation(arr3)); // Expected 0
    }
}
