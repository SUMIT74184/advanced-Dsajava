package TreeSeriesJava.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// import org.w3c.dom.Node;

public class TopBottom {
  public static class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  static class CustomNode {
    Node node;
    int col;

    CustomNode(Node node, int col) {
      this.node = node;
      this.col = col;
    }
  }
  static ArrayList<Integer> topView(Node root) {
    ArrayList<Integer> res = new ArrayList<>();
    if (root == null)
      return res;
    Queue<CustomNode> queue = new LinkedList<>();
    queue.offer(new CustomNode(root, 0));
    TreeMap<Integer, Integer> map = new TreeMap<>();
    while (!queue.isEmpty()) {
      CustomNode cn = queue.poll();
      Node node = cn.node;
      int col = cn.col;

      if (!map.containsKey(col)) {
        map.put(col, node.data);
      }
      if (node.left != null) {
        queue.offer(new CustomNode(node.left, col - 1));
      }

      if (node.right != null) {
        queue.offer(new CustomNode(node.right, col + 1));
      }

    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      res.add(entry.getValue());
    }

    return res;
  }

  static ArrayList<Integer> bottomView(Node root) {
    ArrayList<Integer> res = new ArrayList<>();
    if (root == null)
      return res;
    Queue<CustomNode> queue = new LinkedList<>();
    queue.offer(new CustomNode(root, 0));
    TreeMap<Integer, Integer> map = new TreeMap<>();
    while (!queue.isEmpty()) {
      CustomNode cn = queue.poll();
      Node node = cn.node;
      int col = cn.col;

      // if(!map.containsKey(col)){ we need to override the values and return it
      map.put(col, node.data);
      // }
      if (node.left != null) {
        queue.offer(new CustomNode(node.left, col - 1));
      }

      if (node.right != null) {
        queue.offer(new CustomNode(node.right, col + 1));
      }

    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      res.add(entry.getValue());
    }

    return res;
  }

}
