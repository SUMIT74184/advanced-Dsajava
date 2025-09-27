package BinarySearchAdvance;

public class MedianRowMat {

    static int median(int [][]matrix,int R,int C){
        int N=R*C;
        //sometimes N=matrix.length*matrix[i].length;
        int medianInd=N/2;
        int start=1;
        int end=2000;

        while(start<=end){
            int assumedMedian=start+(end-start)/2;
            //No element less than assumed median
            //k->lesser elements
            int lesserElements=findSmallerElement(matrix,assumedMedian);
            if(lesserElements<=medianInd){
                start=assumedMedian+1;
            }else{
                end=assumedMedian-1;
            }
        }
        return start;
    }

    static int findSmallerElement(int [][]matrix,int assumedMedian){
        int noOfSmallerElements=0;
        for(int i=0;i<matrix.length;i++){
            //matrix[i]->0,1,2
            //apply binary search on matrix[i]
            int start=0;
            int end= matrix[i].length-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(matrix[i][mid]<=assumedMedian){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
            noOfSmallerElements+=start;
        }
        //start
        return noOfSmallerElements;
    }

}
