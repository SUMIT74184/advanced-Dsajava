package strings;



public class StBufferAndStBuilder {

  public static void main(String[] args) {

    // Scanner obj =new Scanner(System.in);
    // System.out.println("Enter a Line");
    
    // String line=obj.nextLine();
    // System.out.println("enter the word");
    // String word=obj.next();
   

    // System.out.println("word is "+ word);
    // System.out.println("Line is "+line);

    String str="SUMIT RAI";
    String res=str.toLowerCase();//lower case character
    System.out.println(res);
    System.out.println(res.toUpperCase());

    //for the itereation of the string
    System.out.println(res.charAt(3));

    //first occurence of the char

    // System.out.println("first occurence of the character");
    // System.out.println(str.indexOf('T'));
    // System.out.println(res.indexOf('i'));
    // System.out.println("last occurence of character");
    // System.out.println(str.lastIndexOf('T'));

    // System.out.println("length of the string");
    // System.out.println(str.length());


      //making of char arrays


    // char ch[]=str.toCharArray();
    // for(int i=0;i<ch.length;i++){
    //   System.out.print(ch[i]+"");
    // }

    //comparing the Two strings
    //the word which is not matched is returned
    //IF NOT SAME THEN ASCII VALUE WILL BE PRINTED
    System.out.println("SUMIT".compareTo("AMA"));

    //Removes the space from the front and back
    System.out.println("   rohan raj   ".trim()); 

    //checks the exact true or false
    System.out.println("check whether the string is matching or not :"+"sumit rai".startsWith(res));

    System.out.println(res.endsWith("rai"));

    //substrings
    //always follows the orders
    System.out.println("substring for String :"+ res.substring(2,5));

    //subsequences

    System.out.println("***String of arrays***");
    String myLocation="hyderabad,chennai,bangalore,mumbai,pune";
    //want to make the array of string

    String myLocationList[]=myLocation.split(",");
    for(int i=0;i<myLocationList.length;i++){
      System.out.println(myLocationList[i] + " ");
    }
    System.out.println(" ");
    //extract the name of gmail
    System.out.println("Extract the company name");
    String email="sumit@gmail.com";
    String email2="randomeAvenger@hotmail.com";
    
    String emailList[]=email.split("@");
    String lastPart=emailList[emailList.length-1];
    int dotIndex=lastPart.lastIndexOf(".");
    System.out.println(lastPart.substring(0, dotIndex));



    String email2List[]=email2.split("@");
    String lastPart1=email2List[email2List.length-1];
    int dotIndex1=lastPart1.lastIndexOf(".");
    System.out.println(lastPart1.substring(0, dotIndex1));


    StringBuilder name1=new StringBuilder("ramadheer");
    StringBuilder name=new StringBuilder("ramadheer");
    StringBuilder name3=new StringBuilder("ramadheer");
    StringBuilder name4=name1;

    System.out.println(name1.equals(name));
    System.out.println(name.equals(name3));
    System.out.println(name3.equals(name4));
    System.out.println(name1.equals(name4));

//different objects are used thats why the ans is coming out to be false

    System.out.println(name1.toString().equals(name.toString())); // true

    StringBuffer sb1 = new StringBuffer("hello");
    StringBuffer sb2=new StringBuffer("hello");

    sb2.append("hii");

    System.out.println(sb1.toString().equals(sb2.toString()));

  }

   

  
    
}

