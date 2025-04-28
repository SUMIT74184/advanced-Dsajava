package Maths;

public class CharacterConv {

  public static char convertCharToUpperCase(int num){
    return  (char)(num & ~(1<<5)) ;
    // return (char)(num & '_')
  }

  public static char convertCharToLowerCase(int num){
    return (char)(num |(1<<5));
    //return (char)(num |' ')
  }
  public static void PrintSetBit(int num){
    for(int i=7;i>=0;i--){
     System.out.print((num >> i) & 1);
    }
    System.out.println();
  }

  public static void Swap(int num1,int num2){
    System.out.println("Num1:-" + num1+" Num2:-"+ num2);
    num1=num1^num2;
    num2=num1^num2;
    num1=num1^num2;
    System.out.println("Num1:-" + num1+" Num2:-"+ num2);
  }



  public static void PrintOnlyUniqueElement(int arr[]){
    int l=arr.length;
    int res=0;//xor of any number will not alter the array
    for(int i=0;i<l;i++){
        res=res^arr[i];
    }
    System.out.println(res);
  }

  public static void printTwoUniqueElement(int arr[]){
    int l=arr.length;
    int res=0;//xor of any number will not alter the array
    for(int i=0;i<l;i++){
        res=res^arr[i];
    }
    int setBit=0;
    int bit=0;
    while(res!=0){
      if((res>>bit & 1)!=0){
        setBit=bit;
        break;
      }
      bit++;
    }

    int res1=0;
    for(int i=0;i<l;i++){
      if((arr[i] >> setBit & 1)!=0)
          res1=res1^arr[i];
    }
    int num1=res^res1;
    int num2=num1^res;

    System.out.println("Num1 :"+num1+" Num2 :"+ num2);
  }



  public static void main(String[] args) {
    char ch=convertCharToLowerCase('A');
    System.out.println(ch);
    char ch2=convertCharToUpperCase('a');
    System.out.println(ch2);

    Swap(3, 5);


    int arr[]={1,1,4,6,7,6,7,9,8,8,9};
    PrintOnlyUniqueElement(arr);


    int arr1[]={7,2,4,2,6,3,3,1,1,6};
    printTwoUniqueElement(arr1);

  }
  
}
