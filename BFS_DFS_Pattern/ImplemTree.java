package BFS_DFS_Pattern;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ImplemTree {

    public ArrayList<Integer>bfs(int V,ArrayList<ArrayList<Integer>>adj)
    {
        ArrayList<Integer>res=new ArrayList<>();
        boolean []visited=new boolean[V];
        Queue<Integer>qu=new LinkedList<>();
        visited[0]=true;
        qu.offer(0);
        while(!qu.isEmpty()){
            int node=qu.poll();
            res.add(node);
            for(int neighbour:adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    qu.offer(neighbour);//insert all the nodes associated
                }
            }
        }
        return res;

    }
        //src not given
    public ArrayList<Integer>bfs1(int V,ArrayList<ArrayList<Integer>>adj){
        ArrayList<Integer>res=new ArrayList<>();
        Queue<Integer>qu=new LinkedList<>();
        boolean []visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]) {
                bfos(i, qu, visited, res, adj);
            }
        }
        return res;
    }

    public void bfos(int src,Queue<Integer>qu,boolean []visited, ArrayList<Integer>res,
                          ArrayList<ArrayList<Integer>>adj){
        visited[src]=true;
        qu.offer(src);
        while(!qu.isEmpty()){
            int node=qu.poll();
            res.add(node);
            for(int neighbour:adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    qu.offer(neighbour);
                }
            }
        }
    }


    public ArrayList<Integer>dfs1(int V,ArrayList<ArrayList<Integer>>adj){
        boolean []visited=new boolean[V];
        ArrayList<Integer>res=new ArrayList<>();
        for(int i=0;i<visited.length;i++){
            if(!(visited[i])){
                dfs(i,visited,adj,res);
            }
        }
    return res;
    }
    public void dfs(int node,boolean []visited,ArrayList<ArrayList<Integer>>adj,ArrayList<Integer>res){
        visited[node]=true;
        res.add(node);
        for(int neighbour:adj.get(node)){
            if(!(visited[neighbour])){
                dfs(neighbour,visited,adj,res);
            }
        }
    }

    public static void main(String[] args) {

    }
}
