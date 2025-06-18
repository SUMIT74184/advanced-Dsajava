package Recursion_;

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

    public static void main(String[] args) {
        Subsequences obj = new Subsequences();
        String input = "abc";
        obj.recur(input, "", 0, input.length());
    }
}
