package GreedyAlgo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prms_krksl {

    public static int SpanPrim(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[2] - pair2[2];
            }

        });
        int sum = 0;
        ArrayList<int[]> edges = new ArrayList<>();
        boolean[] visited = new boolean[V];
        pq.offer(new int[] { -1, 1, 0 });
        while (!pq.isEmpty()) {
            int[] object = pq.poll();
            int parent = object[0];
            int node = object[1];
            int wt = object[2];
            if (visited[node])
                continue;

            if (parent != -1) {
                edges.add(new int[] { parent, node });
                sum += wt;
            }

            // if we did not visited the node of neighbour visit first and then add
            for (int[] neighbourObject : adj.get(node)) {
                int neighbourNode = neighbourObject[0];
                int neighbourWt = neighbourObject[1];
                if (!visited[neighbourNode]) {
                    pq.offer(new int[] { node, neighbourNode, neighbourWt });
                }
            }
        }
        return sum;
    }

    public static int SpanKrusk(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[2] - pair2[2];
            }

        });
        int sum = 0;
        for (int i = 0; i < V; i++) {
            for (int[] edges : adj.get(i)) {
                pq.offer(new int[] { i, edges[0], edges[1] });
            }
        }
        disjoint dsu = new disjoint(V);
        while (!pq.isEmpty()) {
            int[] object = pq.poll();
            int u = object[0];
            int v = object[1];
            int wt = object[2];
            if (dsu.unionBySize(u, v)) {
                sum += wt;
            }
        }

        return sum;
    }

    public static class disjoint {
        int[] parent;
        int[] rank;
        int components;
        int[] Size;

        disjoint(int nodes) {
            // 0 based indexing
            this.parent = new int[nodes];
            this.rank = new int[nodes];
            this.components = nodes;
            this.Size = new int[nodes];

            for (int i = 0; i < nodes; i++) {
                this.parent[i] = i;// self parent of themselves
                this.rank[i] = 0;
                this.Size[i] = 1;
            }
        }

        public int findRootParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            parent[node] = findRootParent(parent[node]);
            return parent[node];
        }

        public boolean unionBySize(int node1, int node2) {
            // find the root parent first
            int rootParent1 = findRootParent(node1);
            int rootParent2 = findRootParent(node2);

            if (rootParent1 == rootParent2) {
                return false;
            }
            // whenever we are doing the union of the things
            components--;
            if (Size[rootParent1] < Size[rootParent2]) {
                parent[rootParent1] = rootParent2;
                Size[rootParent2] += Size[rootParent1];
                // }else if(Size[rootParent1]> Size[rootParent2]){
                // parent[rootParent2]=rootParent1;
                // Size[rootParent1]+=Size[rootParent2];
                // }
            } else {
                parent[rootParent2] = rootParent1;
                Size[rootParent1] += Size[rootParent2];
            }
            return true;

        }
    }

    public static void main(String[] args) {

    }
}
