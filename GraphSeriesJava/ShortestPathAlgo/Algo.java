package GraphSeriesJava.ShortestPathAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Algo {
  public int[] shortestPath(int [][]edges,int n,int m,int src){
    List<List<Integer>>adj=new ArrayList<>();
    for(int i=0;i<n;i++){
      adj.add(new ArrayList<>());
    }
    for(int edge[]:edges){
      int u=edge[0];
      int v=edge[1];
      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    Queue<Integer>queue=new LinkedList<>();
    queue.offer(src);
    int dist[]=new int[n];
    Arrays.fill(dist,-1);
    dist[src]=0;
    while(!queue.isEmpty()){
      int node=queue.poll();
      for(int neighbour:adj.get(node)){
        if(dist[neighbour]==-1){
          dist[neighbour]=dist[node]+1;
          queue.offer(neighbour);
        }
      }
      
    }
    return dist;
  }

  public static void main(String[] args) {
    System.out.println();
  }
}
