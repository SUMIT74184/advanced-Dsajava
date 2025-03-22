package GraphSeriesJava.GraphQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
  public boolean color(int src,int graph[][],int []color){
    Queue<Integer>queue=new LinkedList<>();
    queue.offer(src);
    while(!queue.isEmpty()){
      int node=queue.poll();
      for(int neighbour:graph[node]){
        if(color[neighbour]==-1){
          color[neighbour]=1-color[neighbour];
          queue.offer(neighbour);
        }else if(color[neighbour]==color[node]){
          return false;
        }
      }
     
    }
    return true;
  }
  public boolean isBipartite(int[][] graph) {
   int n=graph.length;
   int []color=new int[n];
   Arrays.fill(color,-1);
   for(int i=0;i<n;i++){
    if(color[1]==-1){
      if(!color(i,graph,color)){
        return false;
      }
    }
   } 
   return true;


     
  }
  public static void main(String[] args) {
    Bipartite bp=new Bipartite();
    int V=5;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    // Adding edges
    adj.get(0).add(1);
    adj.get(1).add(0);

    adj.get(1).add(2);
    adj.get(2).add(1);

    adj.get(2).add(3);
    adj.get(3).add(2);

    adj.get(3).add(4);
    adj.get(4).add(3);

    int[][] graph = new int[V][];
    for (int i = 0; i < V; i++) {
      graph[i] = adj.get(i).stream().mapToInt(Integer::intValue).toArray();
    }

    // Print result instead of returning
    System.out.println(bp.isBipartite(graph) ? "Graph is Bipartite" : "Graph is NOT Bipartite");

  }
}
