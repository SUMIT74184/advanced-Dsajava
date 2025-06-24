package Recursion_;

public class QuickSort {

    public static void qs(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = partition(arr, low, high);
        qs(arr, low, pivotIndex - 1); //left half
        qs(arr, pivotIndex + 1, high); //right half
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i < high && arr[i] <= pivot) {
                i++;
            }
            while (j > low && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);  // use custom swap
            }
        }
        swap(arr, low, j);  // place pivot at correct position
        return j;
    }

    // ✅ Custom swap function
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 7, 9, 3, 10, 5};
        qs(arr, 0, arr.length - 1);

        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
