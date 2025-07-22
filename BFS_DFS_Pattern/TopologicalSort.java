package BFS_DFS_Pattern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

static int [] TopoSort_kahn(int V, ArrayList<ArrayList<Integer>>adjList){

    int []indegree=new int[V];
//    for(int u=0;u<adj.size();u++){
    for (ArrayList<Integer> integers : adjList) {
        for (int v : integers) {
//            u->v
            indegree[v]++;
        }
    }
    Queue<Integer>qu=new LinkedList<>();
    for(int i=0;i<V;i++){
        if(indegree[i]==0){
            qu.offer(i);
        }
    }
    ArrayList<Integer>res=new ArrayList<>();
    while(!qu.isEmpty()){
        int node= qu.poll();
        res.add(node);
        for (int neighbour:adjList.get(node)){
            indegree[neighbour]--;
            if(indegree[neighbour]==0){
                qu.offer(neighbour);
            }
        }
    }
    if(res.size()!=V){
        return new int[V];
    }
    int []ans=new int[V];
    for (int i=0;i<V;i++){
        ans[i]= res.get(i);
    }
    return ans;

}

static int[]topodfs(int V,ArrayList<ArrayList<Integer>>adjList){
    boolean []visited=new boolean[V];
    Stack<Integer>st=new Stack<>();
    for(int i=0;i<V;i++){
        if(!visited[i]){
            dfs2(i,adjList,visited,st);
        }
    }
    int index=0;
    int []ans=new int[V];
    while(!st.isEmpty()){
        ans[index]=st.pop();
        index++;
    }
    return ans;
}
public static void dfs2(int src,ArrayList<ArrayList<Integer>>adj,boolean []visited,Stack<Integer>st){
    visited[src]=true;
    for(int neighbour: adj.get(src)){
        if (!visited[neighbour]){
            dfs2(neighbour,adj,visited,st);
        }
    }
    st.push(src);
}


    public static void main(String[] args) {
        int V = 5; // Number of vertices (0 to 4)

        // Create an adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Directed edges (u -> v)
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(3);
        adjList.get(2).add(3);
        adjList.get(3).add(4);

        // Kahn's algorithm
        System.out.println("Topological Sort using Kahn's Algorithm (BFS):");
        int[] topoKahn = TopoSort_kahn(V, adjList);
        for (int val : topoKahn) {
            System.out.print(val + " ");
        }
        System.out.println();

        // DFS-based topological sort
        System.out.println("Topological Sort using DFS:");
        int[] topoDFS = topodfs(V, adjList);
        for (int val : topoDFS) {
            System.out.print(val + " ");
        }
    }


}
