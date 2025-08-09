package strings;

public class countVowelsConsonant {
    static int  countVowelsConsonants(String str){
      
        int vowels=0;
        int consonants=0;
        str=str.toLowerCase();

        for(char ch :str.toCharArray()){
            if("aeiou".indexOf(ch)!=-1){
                vowels++;
            }else{
                consonants++;
            }
        }
        
        System.out.println("vowels: " + vowels + ", consonants:" + consonants);
        return Math.max(vowels,consonants);

    }
    public static void main(String[] args) {
       int max=countVowelsConsonants("helloioudandaserio");
       System.out.println("max of both of this " + max);
    }
    
}
