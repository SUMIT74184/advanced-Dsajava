package TreeSeriesJava;

import java.util.*;

public class BfsBinary {
  // TREE traversal works on the recursion
  // mainly we use the DFS and BFS
  // first come first serve is the principle of the bfs traversal
  class TreeNode<E> {
    E data;
    TreeNode left;
    TreeNode right;

    public TreeNode(E data) {
      this.data = data;
      this.left = null;
      this.right = null;

    }
  }

  public ArrayList<Integer> Bfs(TreeNode<Integer> root) {
    ArrayList<Integer> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode<Integer> node = queue.poll();
      res.add(node.data);
      if (node.left != null) {
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
    }
    return res;

  }

  public static void main(String[] args) {

  }
}
