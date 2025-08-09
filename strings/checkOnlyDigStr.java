package strings;

public class checkOnlyDigStr {

    public static boolean isNum(String str){
        return str.matches("\\d+");
    }

    public static void main(String[] args) {
        
        System.out.println(isNum("12342"));
        System.out.println(isNum("12as121"));
    }

    
}
