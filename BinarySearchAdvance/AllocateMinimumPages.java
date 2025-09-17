package BinarySearchAdvance;

public class AllocateMinimumPages {

    public static int findPages(int[]books,int students,int page){
        int res=-1;

        if(books.length< students){
            return -1;
        }
        //range will be the max of the array
//        and the sum of the array
        int start=Integer.MIN_VALUE;
        int end=0; // sum of an array

        for(int i=0;i<books.length;i++){
           if(books[i]>start){
               start=books[i];
           }
           end=end+books[i];
        }
        while(start<=end){
            //max pages that can be allocated to single students
            int mid=start+(end-start)/2;
            if(isAllocationpossible(books,mid,students)){
                res=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return res;
        //we have to find the combination
    }
    public static boolean isAllocationpossible(int []books,int maxPages,int students){
        int currentStudents=1;
        int pages=0;
        for(int i=0;i<books.length;i++){
            pages+=books[i];

            if (pages>maxPages){ //whenever the mid value gets bigger we need the new Student
                currentStudents+=1;
                pages=books[i];
            }
            if(currentStudents>students){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
