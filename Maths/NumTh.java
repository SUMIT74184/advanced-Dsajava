package Maths;

public class NumTh {

    public void lovi(){

    }
    public static void main(String[] args) {
        int n=5;
        int cnt=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
