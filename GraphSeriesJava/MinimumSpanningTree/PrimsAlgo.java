package GraphSeriesJava.MinimumSpanningTree;
import java.util.*;


// E LOG E +V LOG V
public class PrimsAlgo {
  public int SpanningTree(int V,int E,List<List<int[]>>adj){
    PriorityQueue<int[]>pq=new PriorityQueue<>(new Comparator<>(){
      public int compare(int p1[],int p2[]){
        return p1[1]-p2[2];
      }
    });
    int sum=0;
    ArrayList<int[]>edges=new ArrayList<>();//not necessary
    boolean visited[]=new boolean[V];
    pq.offer(new int []{-1,0,0});
    while(!pq.isEmpty()){
      int object[]=pq.poll();
      int parent=object[0];
      int node=object[1];
      int wt=object[2];
      if(visited[node]) continue;
      visited[node]=true;
      if(parent!=-1){
        edges.add(new int[]{parent,node});
        sum+=wt;
      }
      //now iterate to the neighbour nodes coz current node is stored
      for(int neighbourObject[]:adj.get(node)){
        int neighbourNode=neighbourObject[0];
        int neighbourwt=neighbourObject[1];
        if(!visited[neighbourNode]){
          pq.offer(new int[]{node,neighbourNode,neighbourwt});
        }
      }
    }
    return sum;
  }
  public static void main(String[] args) {
    
  }
}
