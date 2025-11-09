package HashMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class impl {
    public static ArrayList<ArrayList<Integer>>findFreq(int []arr){

        HashMap<Integer,Integer>freqMap=new HashMap<>();

        for(int num:arr){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        ArrayList<ArrayList<Integer>>result=new ArrayList<>();

        //storing the pair and result inside the arraylist

        for(Map.Entry<Integer,Integer>entry:freqMap.entrySet()){
            ArrayList<Integer>pair=new ArrayList<>();
            pair.add(entry.getKey());
            pair.add(entry.getValue());
            result.add(pair);
        }
        return result;
    }

    public static void main(String[] args) {
        int []arr={1, 2, 2, 3, 4, 5, 3, 4, 5, 6};
        ArrayList<ArrayList<Integer>>result=new ArrayList<>();
        result=findFreq(arr);
        System.out.println("The freq for the given array is: "+result);
    }
}
