package Recursion_;

import java.util.ArrayList;

public class Subsequences {

    public void recur(String inp,String out,int index,int n){
        if(index==n){
            System.out.println(out);
            return;
        }
        recur(inp,out+inp.charAt(index),index+1,n);
        //no pickup
        recur(inp,out,index+1,n);
        return;
    }

    public static void ArrRecur(int []input, int index, ArrayList<Integer>output){
        if(index== input.length){
            System.out.println(output);
            return;
        }
        output.add(input[index]);
        ArrRecur(input,index+1,output);

        output.remove(output.size()-1);
        ArrRecur(input,index+1,output);
    }
    //find all the subsequences with k sum
    public static void recur1(int []input, int index, ArrayList<Integer>output,int target,int sum){
        if(index== input.length){
            if(sum==target){
                System.out.println(output);
            }
            return;
        }
        output.add(input[index]);
        sum=sum+input[index];
        recur1(input,index+1,output,target,sum);

        //not pick
        sum=sum-input[index];
        output.remove(output.size()-1);
        recur1(input, index+1, output, target, sum);
    }


    public static void main(String[] args) {
        Subsequences obj = new Subsequences();
        String input = "abc";
        obj.recur(input, "", 0, input.length());

        ArrayList<Integer>output=new ArrayList<>();
        int []input1={1,2,3};
        ArrRecur(input1,0,output);


        System.out.println("printing the k sum subsequences");
        recur1(input1,0,output,3,0);
    }
}
