package TreeSeriesJava;

import java.util.ArrayList;
import java.util.Stack;

class Node {
  int data;
  Node left, right;

  Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

public class BoundaryTraversal {

  public ArrayList<Integer> boundary(Node node) {
    ArrayList<Integer> res = new ArrayList<>();
    if (!isLeaf(node)) {
      res.add(node.data);
    }
    // left boundary
    insertLeftBoundary(res, node);
    // leaf boundary
    insertLeafNode(res, node);
    // right boundary
    insertRightBoundary(res, node);
    return res;
  }

  public boolean isLeaf(Node node) {
    return (node.left == null && node.right == null);
  }

  public void insertLeftBoundary(ArrayList<Integer> res, Node root) {
    Node leftnode = root.left;
    while (leftnode != null) {
      if (isLeaf(leftnode)) {
        break;
      }
      res.add(root.data);
      if (leftnode.left != null) {
        leftnode = leftnode.left;
      } else {
        leftnode = leftnode.right;
      }
    }
  }

  public void insertRightBoundary(ArrayList<Integer> res, Node root) {
    Node rightnode = root.right;
    Stack<Integer> st = new Stack<>();
    while (rightnode != null) {

      if (isLeaf(rightnode)) {
        break;
      }
      st.push(rightnode.data);
      // res.add(leftnode);
      if (rightnode.left != null) {
        rightnode = rightnode.right;
      } else {
        rightnode = rightnode.left;
      }
    }
    res.add(st.pop());

  }

  public void insertLeafNode(ArrayList<Integer> res, Node root) {
    if (root == null) {
      return;
    }
    if (isLeaf(root)) {
      res.add(root.data);
    }
    insertLeafNode(res, root.left);
    insertLeafNode(res, root.right);
  }

}
