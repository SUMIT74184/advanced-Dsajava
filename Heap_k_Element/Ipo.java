package Heap_k_Element;

import java.util.Collections;
import java.util.PriorityQueue;

public class Ipo {
    class Project implements Comparable<Project>{
        int profit;
        int capital;

        Project(int profit,int capital){
            this.profit=profit;
            this.capital=capital;
        }

        public int compareTo(Project that){
            return this.capital-that.capital;  //min heap
        }

    }


        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            PriorityQueue<Project> minpq=new PriorityQueue<>();
            int n=capital.length;
            //insert
            for(int i=0;i<n;i++){
                minpq.offer(new Project(profits[i],capital[i]));
            }

            PriorityQueue<Integer>maxpq=new PriorityQueue<>(Collections.reverseOrder());
            while(k>0){

                while(!minpq.isEmpty() && minpq.peek().capital<=w){
                    maxpq.offer(minpq.poll().profit); //above logic profit
                }
                if(maxpq.isEmpty()) break;
                w+=maxpq.poll();

                k--;

            }

            return w;

        }
    }

