package TreeSeriesJava.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// import javax.swing.tree.TreeNode;

// import org.w3c.dom.Node;

// import javax.swing.tree.TreeNode;

class TreeNode {
  int data;
  TreeNode left, right;

  TreeNode(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

}

public class leftRight {
  public List<Integer> rightSideView(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<Integer> res = new ArrayList<>();
    if (root == null)
      return res;
    queue.offer(root);

    // bfs
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size > 0) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
        size--;
        if (size == 0) {
          res.add(node.data);
        }
      }
    }
    return res;
  }

  ArrayList<Integer> leftView(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    ArrayList<Integer> res = new ArrayList<>();
    if (root == null)
      return res;

    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode current = queue.poll();
        if (i == 0) {
          res.add(current.data); // leftmost node at this level
        }
        // Enqueue left and right children (important for correct left view)
        if (current.left != null) {
          queue.offer(current.left);
        }
        if (current.right != null) {
          queue.offer(current.right);
        }
      }
    }
    return res;
  }
}
