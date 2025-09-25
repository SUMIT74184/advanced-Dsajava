package GraphSeriesJava;
import java.util.ArrayList;
import java.util.Stack;

public class KosaRajuAlgo {
  //strongly connected components

  //tc--o(N+E);
  public void dfs(int src,boolean[]vis,ArrayList<ArrayList<Integer>>adj,Stack<Integer>st){
    //src overhere represents the nodes.....
    vis[src]=true;
    for(Integer it:adj.get(src)){
      if(!vis[it]){
        dfs(it,vis,adj,st);
      }
    }
    st.push(src);
  }

  public void dfsCount(int nodes,boolean[]vis,ArrayList<ArrayList<Integer>>adj){
    vis[nodes]=true;
    for(Integer it:adj.get(nodes)){
      if(!vis[it]){
        dfsCount(it, vis, adj);
      }
    }
  }

  public int KosaRaju(int V,ArrayList<ArrayList<Integer>>adj){
    boolean []vis=new boolean[V];
    Stack<Integer>st=new Stack<>();
    for(int i=0;i<V;i++){
      if(!vis[i]){
        dfs(i,vis,adj,st);
      }
    }
    //u->v
    //v->u
    ArrayList<ArrayList<Integer>>adjList=new ArrayList<ArrayList<Integer>>();
    for(int i=0;i<V;i++){
      adjList.add(new ArrayList<Integer>());
    }
    for(int i=0;i<V;i++){
      vis[i]=false;
      for(Integer it:adj.get(i)){
        adjList.get(it).add(i);
      }
    }
   int count=0;
   while(!st.isEmpty()){
    int node=st.peek();
    st.pop();
    if(!vis[node]){
      count++;
      dfsCount(node, vis, adjList);
    }
   }
   return count;
  
}
public static void main(String[] args) {
  int V = 5;
  ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
  for (int i = 0; i < V; i++) {
    adj.add(new ArrayList<>());
  }

  // Example graph
  adj.get(0).add(2);
  adj.get(2).add(1);
  adj.get(1).add(0);
  adj.get(0).add(3);
  adj.get(3).add(4);

  KosaRajuAlgo obj = new KosaRajuAlgo();
  int sccCount = obj.KosaRaju(V, adj);
  System.out.println("Number of Strongly Connected Components: " + sccCount);
  }

}
