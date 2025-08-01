package Heap_k_Element;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortelementAphaFReq {
    class Element implements Comparable<Element>{
        char ch;
        int freq;

        public Element(char ch,int freq){
            this.ch=ch;
            this.freq=freq;
        }

        public int compareTo(Element that){
            return that.freq-this.freq; //decreasing order
        }
    }

    class Solution {
        public String frequencySort(String s) {

            HashMap<Character,Integer> freqmap=new HashMap<>();

            for(char ch : s.toCharArray()){
                freqmap.put(ch,freqmap.getOrDefault(ch,0)+1);
            }


            PriorityQueue<Element> pq=new PriorityQueue<>();

            for(Map.Entry<Character,Integer>entry : freqmap.entrySet()){
                Element element=new Element(entry.getKey(),entry.getValue());
                pq.offer(element);
            }
            // result
            StringBuilder str= new StringBuilder();
            while(pq.size()>0){
                Element element=pq.poll();
                while(element.freq>0){
                    str.append(element.ch);
                    element.freq--;
                }
            }
            return str.toString();

        }
    }
}
