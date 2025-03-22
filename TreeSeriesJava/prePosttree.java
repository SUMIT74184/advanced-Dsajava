package TreeSeriesJava;
import java.util.HashMap;

public class prePosttree {
  class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

   HashMap<Integer,Integer>map=new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n=postorder.length;
        for(int i=0;i<n;i++){
            map.put(postorder[i],i);
        }
        return recursion(0,n-1,0,n-1,preorder,postorder);
        
    }
    public TreeNode recursion(int i1,int i2,int j1,int j2,int preorder[],int postorder[]){
        if(i1>i2 || j1>j2){ //if they overtake eachother
            return null;
        }
        TreeNode root=new TreeNode(preorder[i1]);
        if(i1 == i2){
            return root;
        }
        int r=map.get(preorder[i1+1]);
        int size=r-j1+1;
        root.left=recursion(i1+1,i1+size,j1,r,preorder,postorder);
        root.right=recursion(i1+size+1,i2,r+1,j2-1,preorder,postorder);

        return root;

    }
}
