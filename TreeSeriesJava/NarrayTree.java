package TreeSeriesJava;

import java.util.*;

public class NarrayTree {

  class NArrayTreeNode<E> {
    E data;
    ArrayList<NArrayTreeNode> children;

    NArrayTreeNode(E data) {
      this.data = data;
      children = new ArrayList<>();

    }
  }

  public ArrayList<Integer>BFS(NArrayTreeNode<Integer>root){
    ArrayList<Integer>res=new ArrayList<>();
    Queue<NArrayTreeNode>queue=new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
      NArrayTreeNode<Integer>node=queue.poll();
      res.add(node.data);
      for( NArrayTreeNode child:node.children){
        if(child!=null){
          queue.offer(child);
        }
      }
    }

    return res;

  }
}
