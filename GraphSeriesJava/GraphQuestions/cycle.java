// package GraphQuestions;
package GraphSeriesJava.GraphQuestions;
import java.util.*;

public class cycle {
  public boolean checkIfcycle(int src,ArrayList<ArrayList<Integer>>adj,boolean[]visited){
    Queue<int[]>queue=new LinkedList<>();
    queue.offer(new int[]{src,-1});
    visited[src]=true;
    while (!queue.isEmpty()) {
      int pair[]=queue.poll();
      int node=pair[0];
      int parent=pair[1];
      for(int neighbour:adj.get(node)){
        if(neighbour==parent) continue;
        if(visited[neighbour]) return true;
        else{
          queue.offer(new int[]{neighbour,node});
          visited[neighbour]=true;
        }
      }
    }
    return false;
  }
  // we are going to apply the bsf method to check the cycle in the graph
  public boolean isCycle(int V,ArrayList<ArrayList<Integer>>adj){
    boolean []visited=new boolean[V];
    for(int i=0;i<V;i++){
      if(!visited[i] && checkIfcycle(i,adj,visited)){
        return true;
      }
    }
    return false;
  }
  public static void main(String[] args) {
    cycle graph = new cycle();
    int V = 5; // Number of vertices

    // Creating adjacency list for an undirected graph
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

    // Uncomment below to create a cycle:
    // adj.get(4).add(1);
    // adj.get(1).add(4);

    // Checking if the graph has a cycle
    if (graph.isCycle(V, adj)) {
      System.out.println("Cycle detected in the graph.");
    } else {
      System.out.println("No cycle in the graph.");
    }
  }
}
