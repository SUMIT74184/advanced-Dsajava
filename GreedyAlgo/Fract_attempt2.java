package GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

public class Fract_attempt2 {

    //comparison function to sort items based on value/weight ratio
    static class ItemComparator implements Comparator<int[]>{
        public int compare(int[]a,int[]b){
            double a1=(1.0*a[0]/a[1]);
            double b1=(1.0*b[0]/b[1]);
            return Double.compare(b1,a1);
        }
    }
    static double fractionalKnapsack(int []val,int[]wt,int capacity){
        int n= val.length;

        //creating the 2d array for the value and weight

        int[][]items=new int[n][2];

        for(int i=0;i<n;i++){
            items[i][0]=val[i];//value
            items[i][1]=wt[i];//weight
        }

        //sort items based on value-to-weight ratio in descending order
        Arrays.sort(items,new ItemComparator());

        double res=0.0;
        int currCapacity=capacity;

        for(int i=0;i<n;i++) {

            //if we can take the entire items
            if (items[i][1]<=currCapacity){
                res+=items[i][0];
                currCapacity-=items[i][1];
            }
            //otherwise take a fraction of the item
            else{
                res+=(1.0*items[i][0]/items[i][1])*currCapacity;

                //Knapsack is full
                break;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[]val={60,100,120};
        int[] wt={10,20,30};
        int capacity=50;
        System.out.println(fractionalKnapsack(val,wt,capacity));

    }
}
