package Recursion_;

public class implRecursion {

    public int fun(int n){
        if(n==0){
            return -1;
        }
        System.out.println(n);
        return fun(n-1);
    }
        public int fib(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        int result = fib(n-1) + fib(n-2);
        System.out.println("Returning fib(" + n + ") = " + result);
        return result;
    }
    public int Nat(int n){
        if(n<=0){
            return 0;
        }

        int res=(n + Nat(n-1));
        System.out.println(res);
        return  res;
    }

    public void ReverseNum(int n){
        //divide any number from the %
        if(n==0){
            return;
        }
//        boolean flag=false;
//        if(n<0){
//            flag=true;
//        }
        System.out.print(n%10);
        ReverseNum(n/10);
    return;
    }

    //string normal technique using recursion
    public String StringReverse(String Inp, int index, String rev){

        if(index==Inp.length()){
            return rev;
        }
        rev=Inp.charAt(index)+rev;
//        rev=Inp[index]+rev;//this is for array traversing
         return StringReverse(Inp,index+1,rev);

    }

    //using the recursion technique
    public String StringRNew(String Inp,int index,String rev){
    if(index==Inp.length()){
        return rev;
    }

        rev=StringRNew(Inp,index+1,rev);//
        rev=rev+Inp.charAt(index);
        return rev;
}

    public static void main(String[] args) {
        implRecursion imp=new implRecursion();

//        imp.fun(5);
//       int res=  imp.fib(6);
//        System.out.println(res);
//       int ans = imp.Nat(6);
        imp.ReverseNum(543210);
        System.out.println();


       String res=imp.StringReverse("54321",0,"");
        System.out.println(res);

        String res1=imp.StringRNew("54321",0,"");
        System.out.println(res1);

    }
}
