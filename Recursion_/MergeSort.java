package Recursion_;

public class MergeSort {
//break problem at atomic level
   static void merging(int []arr,int l,int m, int r){
        int n1=m-l+1; //left sub arrays
        int n2=r-m; //right one
        int []a1=new int[n1];
        int []a2=new int[n2];

//        copy the arr in first
        for(int i=0;i<n1;i++){
            a1[i]=arr[l+i];
        }

//        copy the arr in second
        for(int i=0;i<n2;i++){
            a2[i]=arr[m+1+i];
        }

        //comparing and merging two arr in sorted format

        int i=0,j=0,k=0;
        while(i<n1 && j<n2){
            if(a1[i]<=a2[j]){
                arr[k]=a1[i];
                i++;
            }
            else{
                arr[k]=a2[j];
                j++;
            }
            k++;
        }

        //if any of the array is completed and other one is remaining copy to the
//       arr[k]
        while(i<n1){
            arr[k]=a1[i];
            k++;
            i++;
        }

        while(j<n2){
            arr[k]=a2[j];
            k++;
            j++;
        }
    }

   static void merge(int []arr,int l,int r){
        //base case

        if(l>=r){
            return;
        }
        int mid=l+(r-l)/2;
        merge(arr,l,mid);
        merge(arr,mid+1,r);

        merging(arr,l,mid,r);
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 6, 4, 2, 5};
        merge(arr, 0, arr.length - 1);

        // Print sorted array
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}
