package GraphSeriesJava.GraphQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
  // it is only possible in directed acyclic graph
  public static int[] toposort(int V, ArrayList<ArrayList<Integer>> adj) {
    int indegree[] = new int[V];
    for (int u = 0; u < adj.size(); u++) {
      for (int v : adj.get(u)) {
        // u->v
        indegree[v]++;
      }
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }
    ArrayList<Integer> res = new ArrayList<>();
    while (!queue.isEmpty()) {
      int node = queue.poll();
      res.add(node);
      for (int neighbour : adj.get(node)) {
        indegree[neighbour]--;
        if (indegree[neighbour] == 0) {
          queue.offer(neighbour);
        }
      }
    }
    //node in result will not be equal to the V
    if(res.size()!=V){
      return new int[V];
    }
    int ans[] = new int[V];
    for (int i = 0; i < V; i++) {
      ans[i] = res.get(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    int V = 6; // Number of vertices
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    // Creating a directed acyclic graph (DAG)
    adj.get(5).add(2);
    adj.get(5).add(0);
    adj.get(4).add(0);
    adj.get(4).add(1);
    adj.get(2).add(3);
    adj.get(3).add(1);

    int[] result = toposort(V, adj);

    // Printing the topological order
    System.out.println("Topological Sort:");
    for (int node : result) {
      System.out.print(node + " ");
    }
  }

}
