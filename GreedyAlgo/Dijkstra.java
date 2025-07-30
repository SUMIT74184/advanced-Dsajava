package GreedyAlgo;

import java.util.*;

public class Dijkstra {

    public static int[] dij(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                return p1[1] - p2[1];
            }
        });

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        pq.offer(new int[] { S, 0 });

        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int u = pair[0];
            int d = pair[1];

            if (d > dist[u]) continue;

            for (ArrayList<Integer> neighbour : adj.get(u)) {
                int v = neighbour.get(0);
                int w = neighbour.get(1);

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

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges in the format: [destination, weight]
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 7)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 3)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 2)));

        int[] shortestDistances = dij(V, adj, S);

        System.out.println("Shortest distances from source " + S + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " -> " + shortestDistances[i]);
        }
    }
}
