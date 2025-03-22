package GraphSeriesJava.GraphQuestions;

import java.util.*;


//tc---3v+e
public class TopoLogicalSortDfs {
  public static void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
    visited[src] = true;
    for (int neighbour : adj.get(src)) {
      if (!visited[neighbour]) {
        dfs(neighbour, adj, visited, st);
      }
    }
    st.push(src);
  }

  public static int[] topoSortDfs(int V, ArrayList<ArrayList<Integer>> adj) {
    // whenver the dfs call is over for the node then only the node is added to the
    // stack
    // otherwise the nodes having child will be entered first according to the dfs
    // call
    Stack<Integer> st = new Stack<>();
    boolean visited[] = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfs(i, adj, visited, st);
      }
    }
    int index = 0;
    int res[] = new int[V];
    while (!st.isEmpty()) {
      res[index] = st.pop();
      index++;
    }
    return res;

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

    int[] result = topoSortDfs(V, adj);

    // Printing the topological order
    System.out.println("Topological Sort:");
    for (int node : result) {
      System.out.print(node + " ");
    }
  }
}
