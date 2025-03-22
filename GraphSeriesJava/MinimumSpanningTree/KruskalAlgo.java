package GraphSeriesJava.MinimumSpanningTree;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalAlgo {
  public int KruSpanningTree(int V, int E, List<List<int[]>> adj) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {
      public int compare(int p1[], int p2[]) {
        return p1[1] - p2[2];
      }
    });

    for (int i = 0; i < V; i++) {
      for (int edges[] : adj.get(i)) {
        pq.offer(new int[] { i, edges[0], edges[1] });
      }
    }
    DisJointSet dsu = new DisJointSet(V);
    int sum = 0;
    while (!pq.isEmpty()) {
      int object[] = pq.poll();
      int u = object[0];
      int v = object[1];
      int wt = object[2];
      if (dsu.unionBySize(u, v)) {
        sum += wt;
      }
    }
    return sum;
  }
}

class DisJointSet {

  int[] parent;
  int[] rank;
  int components;
  int[] Size;

  DisJointSet(int nodes) {
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