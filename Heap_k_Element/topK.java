package Heap_k_Element;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topK {
    class Number implements Comparable<Number>{
        int element;
        int freq;

        Number(int element,int freq){
            this.element=element;
            this.freq=freq;
        }
        public int compareTo(Number that){
//            return that.freq-this.freq;  //decre order
            return this.freq-that.freq;
        }
    }

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            PriorityQueue<Number> pq=new PriorityQueue<>();
            HashMap<Integer,Integer> freqMap=new HashMap<>();

            //finding the freq
            for(int element:nums){
                freqMap.put(element,freqMap.getOrDefault(element,0)+1);
            }

            //insert elements in pq
            for(Map.Entry<Integer,Integer>entry : freqMap.entrySet()){
                Number number = new Number(entry.getKey(),entry.getValue());
                pq.offer(number);
                // min element with less freq will be popped out of pq
                if(pq.size()>k){
                    pq.poll();
                }

            }
            int []res=new int[k];
            int index=0;
            while(index<k){
                Number number=pq.poll();
                res[index]=number.element;
                System.out.print(number.freq);//printing the number of times the number are repeated
                index++;
            }
            return res;


        }
    }
}
