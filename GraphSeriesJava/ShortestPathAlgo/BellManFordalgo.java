package GraphSeriesJava.ShortestPathAlgo;

import java.util.*;

//tc---o(v*e)
public class BellManFordalgo {
  public static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
    int dist[] = new int[V];
    Arrays.fill(dist, (int) 1e8);
    dist[S] = 0;
    for (int i = 0; i < V; i++) {
      boolean isChanged = false;
      for (ArrayList<Integer> edge : edges) {
        int u = edge.get(0);
        int v = edge.get(1);
        int wt = edge.get(2);
        if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
          dist[v] = dist[u] + wt;
          isChanged = true;
        }
      }
      if (!isChanged) {
        break;
      }
    }
    for (ArrayList<Integer> edge : edges) {
      int u = edge.get(0);
      int v = edge.get(1);
      int wt = edge.get(2);
      if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
        return new int[] { -1 };
      }
    }
    return dist;
  }

  public static void main(String[] args) {
    int V = 5; // Number of vertices
    int S = 0; // Source vertex

    ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

    // Adding edges (u, v, weight)
    edges.add(new ArrayList<>(Arrays.asList(0, 1, 4)));
    edges.add(new ArrayList<>(Arrays.asList(0, 2, 5)));
    edges.add(new ArrayList<>(Arrays.asList(1, 2, -3)));
    edges.add(new ArrayList<>(Arrays.asList(1, 3, 6)));
    edges.add(new ArrayList<>(Arrays.asList(2, 3, 3)));
    edges.add(new ArrayList<>(Arrays.asList(3, 4, 2)));

    int[] shortestDistances = bellman_ford(V, edges, S);

    if (shortestDistances.length == 1 && shortestDistances[0] == -1) {
      System.out.println("Negative weight cycle detected!");
    } else {
      System.out.println("Shortest distances from source " + S + ":");
      for (int i = 0; i < V; i++) {
        System.out.println("Vertex " + i + " -> " + (shortestDistances[i] == (int) 1e8 ? "INF" : shortestDistances[i]));
      }
    }
  }
}
