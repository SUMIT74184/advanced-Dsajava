package strings;

public class reverseString {
    public void rev(char[]s){
        StringBuilder reverse1=new StringBuilder(new String(s)).reverse();
        for(int i=0;i<s.length;i++){
            s[i]=reverse1.charAt(i);
        }
        
    }

    public static void main(String[] args) {

    }
}
