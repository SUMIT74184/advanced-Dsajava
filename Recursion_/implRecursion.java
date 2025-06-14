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
    public static void main(String[] args) {
        implRecursion imp=new implRecursion();

//        imp.fun(5);
       int res=  imp.fib(6);
        System.out.println(res);
//       int ans = imp.Nat(6);



    }
}
