package strings;

import java.util.HashMap;


public class FirstNon_repeatedChar {

    static char firstnonrpeated(String str){
        HashMap<Character,Integer>map=new HashMap<>();
        for(char ch:str.toCharArray()){
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        // for(Map.Entry<Character, Integer> entry : map.entrySet()){
        //     if(entry.getValue() == 1) return entry.getKey();
        // }

        //for all the no repetitive character
        // map.forEach((k,v)->{
        //     if(v==1){
        //     System.out.println(k);
        //     }

        // });

        for(char ch :str.toCharArray()){
            if(map.get(ch)==1){
                return ch;
            }
        }

        return 0;

        }
    

    public static void main(String[] args) {
    //    System.out.println("swisst"); 
    char cj= firstnonrpeated("swisst");
    System.out.println(cj);
    }
    
}
