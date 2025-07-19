package GraphSeriesJava.ShortestPathAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Dijkstraalgo {

  public static int[] dijkstra(int V, ArrayList<ArrayList<int[]>> adj, int S) {

    //custom comparator which will help to compare between two distances in the prority queue
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      public int compare(int p1[], int p2[]) {
        return p1[1] - p2[1];       }
    });

    int dist[] = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[S] = 0;

    pq.offer(new int[] { S, 0 });

    while (!pq.isEmpty()) {
      int pair[] = pq.poll();
      int u = pair[0];
      int d = pair[1];

      if (d > dist[u]) continue;
      for (int[] neighbour : adj.get(u)) {
        int v = neighbour[0];
        int w = neighbour[1];

        if (dist[u] + w < dist[v]) {
          dist[v] = dist[u] + w;
          pq.offer(new int[] { v, dist[v] });
        }
      }
    }

    return dist;
  }

  public static void main(String[] args) {
    int V = 5; // Number of vertices
    int S = 0; // Source node

    ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
    
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    // Adding edges in the format {destination, weight}
    adj.get(0).add(new int[] { 1, 2 });
    adj.get(0).add(new int[] { 2, 4 });
    adj.get(1).add(new int[] { 2, 1 });
    adj.get(1).add(new int[] { 3, 7 });
    adj.get(2).add(new int[] { 4, 3 });
    adj.get(3).add(new int[] { 4, 2 });

    int[] shortestDistances = dijkstra(V, adj, S);

    System.out.println("Shortest distances from source " + S + ":");
    for (int i = 0; i < V; i++) {
      System.out.println("Node " + i + " -> " + shortestDistances[i]);
    }
  }
}
