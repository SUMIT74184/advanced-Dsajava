package GraphSeriesJava.GraphQuestions;
import java.util.*;

public class cycleDfs {
  public boolean checkIfcycleDfs(int src,int parent,ArrayList<ArrayList<Integer>>adj,boolean []visited){
    visited[src]=true;
    for(int neighbour:adj.get(src)){
      if(neighbour==parent) continue;
      if(visited[neighbour]){
        return true;
      }else if (checkIfcycleDfs(neighbour, src, adj, visited)) { // Only return if cycle found
        return true;
      }
      // }else{
      //   checkIfcycleDfs(neighbour, src, adj, visited);
      //   return true;
      // }
    }
    return false;
  }
  public boolean isCycle(int V,ArrayList<ArrayList<Integer>>adj){
    boolean []visited=new boolean[V];
    for(int i=0;i<V;i++){
      if(!visited[i] && checkIfcycleDfs(i,-1,adj,visited)){
        return true;
      }
    }
    return false;
  }
  public static void main(String[] args) {
    cycleDfs graph = new cycleDfs();
    int V = 5; // Number of vertices

    // Creating adjacency list for an undirected graph
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    // Adding edges
    // adj.get(0).add(1);
    // adj.get(1).add(0);

    // adj.get(1).add(2);
    // adj.get(2).add(1);

    // adj.get(2).add(3);
    // adj.get(3).add(2);

    // adj.get(3).add(4);
    // adj.get(4).add(3);
    adj.get(0).add(1);
    adj.get(1).add(0);

    adj.get(1).add(2);
    adj.get(2).add(1);

    adj.get(2).add(3);
    adj.get(3).add(2);

    adj.get(3).add(4);
    adj.get(4).add(3);

    // Uncomment below to create a cycle:
    adj.get(4).add(1);
    adj.get(1).add(4);

    // Checking if the graph has a cycle
    if (graph.isCycle(V, adj)) {
      System.out.println("Cycle detected in the graph.");
    } else {
      System.out.println("No cycle in the graph.");
    }
  }
}