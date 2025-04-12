package BinaySearchTree;

//Inorder Traversal for the increasing order output
public class Implentation {
  static class TreeNode{
    int val;
    TreeNode left,right;
    public TreeNode(int val){
      this.val=val;
      this.left=null;
      this.right=null;
    }
  }

public static class BST{
  public void inorderTraversal(TreeNode root){
    if(root==null){
      return;
    }
    inorderTraversal(root.left);
    System.out.println(root.val+" ");
    inorderTraversal(root.right);
  }

  public TreeNode constructBST(int arr[]){
    TreeNode root=null;
    for(int i=0;i<arr.length;i++){
      root=insertIntoBST(root, arr[i]);
    }
    return root;
  }

   public TreeNode insertIntoBST(TreeNode root, int val) {
    // List<Integer>ans=new ArrayList<>();
        if (root == null) {
           return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

}
  public static void main(String[] args) {
    int arr[]={9,8,4,6,11,15,7,19,10};
    BST obj =new BST();
    TreeNode root=obj.constructBST(arr);
    obj.inorderTraversal(root);

  }
}
