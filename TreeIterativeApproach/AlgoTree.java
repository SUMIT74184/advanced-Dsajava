package TreeIterativeApproach;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AlgoTree {

  class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public List<Integer> preorderTraversal(Node root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node node = stack.pop();
      res.add(node.data);
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }

    }
    return res;

  }

  public List<Integer> inorderTraversal(Node root) {
    List<Integer> res = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    Node node = root;
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      // print the root
      node = stack.pop();
      res.add(node.data);
      // move to right
      node = node.right;
    }
    return res;
  }

  // public List<Integer>postorderTraversal(Node root){

  // }

  public static void main(String[] args) {
    AlgoTree tree = new AlgoTree();
    Node root = tree.new Node(1);
    root.left = tree.new Node(2);
    root.right = tree.new Node(3);
    root.left.left = tree.new Node(4);
    root.left.right = tree.new Node(5);
    root.right.left = tree.new Node(6);
    root.right.right = tree.new Node(7);

    // Performing preorder traversal
    List<Integer> result = tree.preorderTraversal(root);
    System.out.println("Preorder Traversal: " + result);

    List<Integer> result1 = tree.inorderTraversal(root);
    System.out.println("InorderTraversal" + result1);
  }
}
