package GraphSeriesJava.GraphQuestions;

import java.util.ArrayList;
//backtraking or the path visited in the grap series
public class CycleDirectedDfs {
  //tc--O(v+e)
  //directed graph is the main prerequisites
  //normal dfs is not going to work in this
  //we  need to check the path first ----means check the path visited
  public boolean checkCycle(int src,boolean[]visited,ArrayList<ArrayList<Integer>>adj,boolean[]pathVisited){
    visited[src]=true;
    pathVisited[src]=true;
    //checking the cycle in the graph
    for(int neighbour:adj.get(src)){
      if(pathVisited[neighbour]){
        return true;
      }else if(visited[neighbour]){
        continue;
      }else{

        //actual dfs call
        if(checkCycle(neighbour, visited, adj, pathVisited)){
          return true;
        }
      }
    }

    pathVisited[src]=false;
    return false;
  }
  public boolean isCyclic(int V,ArrayList<ArrayList<Integer>>adj){
     boolean []visited=new boolean[V];
     boolean []pathVisited=new boolean[V];
     for(int i=0;i<V;i++){
      if(!visited[i] && checkCycle(i,visited,adj,pathVisited)){
        return true;
      }
     }
    return false;
  }
  public static void main(String[] args) {
    CycleDirectedDfs graph = new CycleDirectedDfs();
    int V = 5; // Number of vertices
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

    if (graph.isCyclic(V, adj)) {
      System.out.println("Cycle detected in the graph.");
    } else {
      System.out.println("No cycle in the graph.");
    }
  }
  
}
