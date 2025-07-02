package Heap_k_Element;

public class Implheap {
    int heapSize;
    int []heap;
    int capacity;

    Implheap(int []arr){
        heap=arr;
        heapSize=arr.length;
        capacity=arr.length;
    }
    public void swap(int i,int j){
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }
    public void heapify(int index){
        //max heap
        int largest=index;
        int leftChildIndex=2*index+1;
        int rightChildIndex=2*index+2;
        if(leftChildIndex<heapSize && heap[leftChildIndex]>heap[largest]){
            largest=leftChildIndex;
        }
        if(rightChildIndex<heapSize && heap[rightChildIndex]>heap[largest]){
            largest=rightChildIndex;
        }
        if(largest!=index){
           swap(index,largest);
           heapify(largest);
        }

    }
    public void buildTree(){
        //N/2 to N-1;
        //0 to N/2-1
        for(int index=heapSize/2-1;index>=0;index--){
            heapify(index);
        }
    }
    public int popMax(){
        if(heapSize==0){
            System.out.println("Heap is empty");
            return -1;
        }
        int max=heap[0]; // storing the max ---root
        heap[0]=heap[heapSize-1];
        heapSize--;  //delete the last element
        heapify(0);
        return max;
    }

    public void increaseKey(int index,int newVal){
        if(index<0 || index>=heapSize || heap[index]>=newVal){
            System.out.println("Wrong Operation");
            return;
        }

        heap[index]=newVal;
       while(index>0 && heap[index]>heap[(int)(Math.ceil(index/2.0)-1)]){
           swap(index,(int)(Math.ceil(index/2.0)-1));
           index= (int)(Math.ceil(index/2.0)-1);
       }

    }
    public void decreaseKey(int index,int newVal){
        if(index<0 || index>=heapSize || heap[index]<=newVal){
            System.out.println("Wrong Operation");
            return;
        }

        heap[index]=newVal;
        heapify(index);
    }

    public void printTree(){
        for(int i=0;i<heapSize;i++){
            System.out.print(heap[i] + ", ");
        }
        System.out.println();
    }


    public void increaseCapacity(){
        capacity*=2; //double
        int []newHeap=new int[capacity];
        for (int i=0;i<heapSize;i++){
            newHeap[i]=heap[i];
        }
        heap=newHeap;
    }

    public void insert(int newVal){
        if(heapSize+1>capacity){
            increaseCapacity();
        }
            heapSize++;
        heap[heapSize-1]=newVal;
        int index=heapSize-1;
        while(index>0 && heap[index]>heap[(int)(Math.ceil(index/2.0)-1)]){
            swap(index,(int)(Math.ceil(index/2.0)-1));
            index= (int)(Math.ceil(index/2.0)-1);
        }

    }

    public void extractMaxAndStore(){
        if(heapSize==0){
            System.out.println("Heap is empty");
            return;
        }
        int max=heap[0]; // storing the max ---root
        heap[0]=heap[heapSize-1];
        heap[heapSize-1]=max;//instead of deleting we will store the elements
        heapSize--;  //delete the last element
        heapify(0);
        return;
    }

    //sort the array with heap
    public int[] heapSort(){
        buildTree();
        int size=heapSize;

        for(int i=0;i<size;i++){
            extractMaxAndStore();
        }
        return heap;
    }

    public static void main(String[] args) {
        int []arr=new int[]{10,5,20,6,11};
        Implheap heap=new Implheap(arr);
        heap.buildTree();
        heap.printTree();
//        System.out.println("removed the max element->" + heap.popMax());
        heap.printTree();

        heap.increaseKey(4,15);
        heap.printTree();


        heap.decreaseKey(0,2);
        heap.printTree();


//        heap.heapSort();
        int []res=heap.heapSort();
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+", ");
        }

    }

}
