package TreeSeriesJava;

import java.util.List;

public class DiameterOfNary {
  class Node {
    public int val;
    public List<Node> children;

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  public int diameter(Node root) {
    int maxi[] = new int[1];
    findHeight(root, maxi);
    return maxi[0];
  }

  public int findHeight(Node root, int maxi[]) {
    if (root == null)
      return 0;
    int h1 = 0;
    int h2 = 0;
    int h = 0;
    for (Node node : root.children) {
      h = findHeight(node, maxi);
      if (h > h1) {
        h2 = h1;
        h1 = h;
      } else if (h > h2) {
        h2 = h;

      }
    }
    maxi[0] = Math.max(maxi[0], h1 + h2);
    return (1 + h1);
  }

}
