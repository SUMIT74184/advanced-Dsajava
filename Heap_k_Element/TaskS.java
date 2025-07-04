package Heap_k_Element;
import java.util.*;
public class TaskS {
    class Task implements Comparable<Task> {
        int freq;
        int executionTime;
        Task(int f,int t){
            freq=f;
            executionTime=t;
        }

        public int compareTo(Task that){
            return that.freq-this.freq;
        }
    }

    class Solution {
        public int leastInterval(char[] tasks, int n) {
            HashMap<Character,Integer>map=new HashMap<>();
            for(char ch:tasks){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            //insertion in heap-maxpq
            PriorityQueue<Task>pq=new PriorityQueue<>();
            // insert task in pq

            for(Character ch:map.keySet()){
                int freq=map.get(ch);
                pq.offer(new Task(freq,0)); //at early stage the time is always 0
            }
            Queue<Task>qu=new LinkedList<>();
            int time=0;
            while(!qu.isEmpty() || !pq.isEmpty()){
                time++;
                //check the max pq task and process it in queue
                if(!pq.isEmpty()){
                    Task task=pq.poll();
                    task.freq--;
                    if(task.freq>0){
                        //update the execution time
                        task.executionTime=time+n;
                        qu.offer(task);
                    }
                }
                //shift the active process to the pq
                while(!qu.isEmpty() && qu.peek().executionTime == time){
                    pq.offer(qu.poll());
                }

            }

            return time;


        }
    }
}
