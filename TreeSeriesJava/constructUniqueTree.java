package TreeSeriesJava;

import java.util.HashMap;
public class constructUniqueTree {
  class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
  public TreeNode buildTree(int []preorder,int[]inorder){
    HashMap<Integer,Integer>indexMap=new HashMap<>();
    //hash the values with index
    for(int i=0;i<inorder.length;i++){
      indexMap.put(inorder[i],i);
    }

    int n=preorder.length-1;
    int m=inorder.length-1;
    TreeNode root=constructTree(preorder,inorder,indexMap,0,n,0,m);
    return root;
  }
  public TreeNode constructTree(int[]preorder,int[]inorder,HashMap<Integer,Integer>indexMap,
  int preIndStart,int preIndEnd,int inIndStart,int inIndEnd){

    if(preIndStart>preIndEnd  || inIndStart>inIndEnd){
      return null;

    }
    int rootData=preorder[preIndStart];
    int rootIndex=indexMap.get(rootData);

    TreeNode root=new TreeNode(rootData);
    int leftTreeSize=rootIndex-inIndStart;

    int rightTreeSize=inIndEnd-rootIndex;

    root.left=constructTree(preorder, inorder, indexMap, 
    preIndStart+1, preIndStart+leftTreeSize, inIndStart, rootIndex-1);

    root.right=constructTree(preorder, inorder, indexMap,
    preIndStart+leftTreeSize+1, preIndStart+leftTreeSize+rightTreeSize, rootIndex+1, inIndEnd);

    return root;
  }
  public TreeNode buildTree2(int[] inorder, int[] postorder) {
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    // Hash values to their indices in inorder
    for (int i = 0; i < inorder.length; i++) {
        indexMap.put(inorder[i], i);
    }
    int n = postorder.length - 1;
    return constructTree(postorder, inorder, indexMap, 0, n, 0, inorder.length - 1);
}

public TreeNode constructTree2(int[] postorder, int[] inorder, HashMap<Integer, Integer> indexMap,
     int postIndStart, int postIndEnd, int inIndStart, int inIndEnd) {
    if (postIndStart > postIndEnd || inIndStart > inIndEnd) {
        return null;
    }

    int rootData = postorder[postIndEnd];  // root is at the end of postorder segment
    int rootIndex = indexMap.get(rootData);  // index in inorder
    TreeNode root = new TreeNode(rootData);

    int leftTreeSize = rootIndex - inIndStart;
    int rightTreeSize = inIndEnd - rootIndex;

    // Postorder index ranges:
    // Left subtree: postIndStart to postIndStart + leftTreeSize - 1
    // Right subtree: postIndStart + leftTreeSize to postIndEnd - 1

    root.left = constructTree(postorder, inorder, indexMap,
            postIndStart, postIndStart + leftTreeSize - 1, inIndStart, rootIndex - 1);

    root.right = constructTree(postorder, inorder, indexMap,
            postIndStart + leftTreeSize, postIndEnd+leftTreeSize+rightTreeSize - 1, rootIndex + 1, inIndEnd);

    return root;
}
  
  public static void main(String[] args) {
    
  }
}
