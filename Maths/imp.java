package Maths;

public class imp {
  public static void main(String[] args) {
    System.out.println("ad");
    printBits(35);
    System.out.println();
    printBits(32);
    System.out.println();
    printOddEven(31);

    System.out.println("setting the ith bit");
    int res = PrintSetBit(32, 5);
    System.out.println(res);
    printBits(res);
    System.out.println();

    System.out.println("Unset the ith bit");
    int res2=unSetBit(33,5);
    // System.out.println(res2);
    printBits(res2);
  }

  public static void printBits(int num) {
    for (int i = 7; i >= 0; i--) {
      System.out.print((num >> i) & 1);
    }

  }

  static void printOddEven(int num) {
    if (isBitSet(num, 0)) {
      System.out.println("Number is odd");
    } else {
      System.out.println("Number is even");
    }
  }

  static boolean isBitSet(int num, int bit) {
    int res = num & (1 << bit);
    return (res == 0) ? false : true;
  }

  static int PrintSetBit(int num, int bit) {
    return num | (1 << bit);

  }

  public static int ToggleElement(int num, int bit) {
    return num ^ (1 << bit);
  }

  static int unSetBit(int n,int b){
    return n & ~(1<<b);
  }

  

}
