package TreeSeriesJava;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Deque;


class TreeNode{
  int val;
  TreeNode left,right;
  TreeNode(int val){
    this.val=val;
    this.right=null;
    this.left=null;
  }
}
public class ZigZag {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res=new LinkedList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        int level=0;
        while(!queue.isEmpty()){
            Deque<Integer>levelSubList=new LinkedList<>();
            // List<Integer>levelSubList=new LinkedList<>();
            int size=queue.size();
            while(size>0){
                //level order traversal
                TreeNode node=queue.poll();
                if(level%2!=0){
                    levelSubList.addFirst(node.val);
                }else{
                    levelSubList.addLast(node.val);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                size--;
            }
            level++;
            res.add(new LinkedList<>(levelSubList));
        }
        return res;
    }
}
