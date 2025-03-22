package TreeSeriesJava;

public class CompleteBTcount {
  class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public int findLeftHeight(Node root) {
    int count = 1;
    while (root.left != null) {
      count++;
      root = root.left;
    }
    return count;
  }

  public int findRightHeight(Node root) {
    int count = 1;
    while (root.right != null) {
      count++;
      root = root.right;

    }
    return count;
  }

  public int countNumber(Node root) {
    if (root == null) {
      return 0;
    }
    // check if all levels are completely filled
    int lh = findLeftHeight(root);
    int rh = findRightHeight(root);
    if (lh == rh) {// if the left and right are matching then only we are going to use the formula
      return ((int) Math.pow(2, lh) - 1);
    } // else we are going to use recursion call itself
    return 1 + countNumber(root.left) + countNumber(root.right);
  }


  public int SumBt(Node root){
    if(root==null){
      return 0;
    }
    int leftSum=SumBt(root.left);
    int rightSum=SumBt(root.right);
    return (leftSum+rightSum+root.data);
  }

  public static void main(String[] args) {
    CompleteBTcount tree = new CompleteBTcount();

    // Create nodes for Complete Binary Tree
    Node root = tree.new Node(1);
    root.left = tree.new Node(2);
    root.right = tree.new Node(3);
    root.left.left = tree.new Node(4);
    root.left.right = tree.new Node(5);
    root.right.left = tree.new Node(6);
    // You can add root.right.right = tree.new Node(7); to make it perfect

    int totalNodes = tree.countNumber(root);
    System.out.println("Total number of nodes in the Complete Binary Tree: " + totalNodes);
  }
}
