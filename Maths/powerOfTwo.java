package Maths;

public class powerOfTwo {

  public static void isPowerOfTwo(int num){
    if((num & num-1)==0){
      System.out.println("number is power of two");
    }else{
      System.out.println("number is not power of two");
    }
  }

  public static void PrintSetBit(int num){
    for(int i=7;i>=0;i--){
     System.out.print((num >> i) & 1);
    }
    System.out.println();
  }

  public static int unSetRightMostSetBit(int num){
    return num & num-1;
  }

  public static void NoOfSetBits(int num){
    int count=0;
    while(num!=0){
      count++;
      num=unSetRightMostSetBit(num);
    }
    System.out.println(count);
  }


  public static void main(String[] args) {
    isPowerOfTwo(32);
    PrintSetBit(32);

    System.out.println("unsetRightMostBit");
    int res=unSetRightMostSetBit(48);
    PrintSetBit(res);


    System.out.println("counting the number of 1s");
    PrintSetBit(67);
    NoOfSetBits(67);

    
  }

}
