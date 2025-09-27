package BinarySearchAdvance;

public class KthSmallestEkMat {//sorted matrix
    public int kthSmallest(int[][] matrix, int k) {
        int R=matrix.length;
        int C=matrix[0].length;
        int N = R * C;

        //sometimes N=matrix.length*matrix[i].length;
        int RequiredSmallerEl =k-1;
        int start = matrix[0][0];
        int end = matrix[R-1][C-1];

        while (start <= end) {
            int assumedMedian = start + (end - start) / 2;
            //No element less than assumed median
            //k->lesser elements
            int lesserElements = findSmallerElement(matrix, assumedMedian);
            if (lesserElements <= RequiredSmallerEl) {
                start = assumedMedian + 1;
            } else {
                end = assumedMedian - 1;
            }
        }
        return start;
    }

    static int findSmallerElement(int[][] matrix, int assumedMedian) {
        int noOfSmallerElements = 0;
        for (int i = 0; i < matrix.length; i++) {
            //matrix[i]->0,1,2
            //apply binary search on matrix[i]
            int start = 0;
            int end = matrix[i].length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (matrix[i][mid] <= assumedMedian) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            noOfSmallerElements += start;
        }
        //start
        return noOfSmallerElements;
    }
}
