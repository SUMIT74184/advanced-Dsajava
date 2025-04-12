// package TreeSeriesJava;

// import java.util.ArrayList;

// class Node {
//     int data;
//     Node left, right;

//     Node(int data) {
//         this.data = data;
//         this.left = null;
//         this.right = null;
//     }
// }
// //All three traversal using the dfs technique
// public class DFSbinaryTree {
  
//     static ArrayList<Integer> preorder(Node root) {
//         ArrayList<Integer> res = new ArrayList<>();
//         preorderTraversal(root, res);
//         return res;
//     }

//     private static void preorderTraversal(Node root, ArrayList<Integer> res) {
//         if (root == null) {
//             return;
//         }
//         res.add(root.data);
//         preorderTraversal(root.left, res);
//         preorderTraversal(root.right, res);
//     }


//     static ArrayList<Integer>Inorder(Node root){
//       ArrayList<Integer>res=new ArrayList<>();
//       InorderTraversal(root, res);
//        return res;
//     }

//     public static void InorderTraversal(Node root,ArrayList<Integer>res){
//       if(root==null){
//         return;
//       }
//       InorderTraversal(root.left, res);
//       // System.out.println(root.data);
//       res.add(root.data);
//       InorderTraversal(root.right, res);
//     }

//     static ArrayList<Integer>PostOrder(Node root){
//       ArrayList<Integer>res=new ArrayList<>();
//       PostOrderTraversal(root, res);
//       return res;
//     }
//     public static void PostOrderTraversal(Node root,ArrayList<Integer>res){
//       if(root==null){
//         return;
//       }
//       PostOrderTraversal(root.left, res);
//       PostOrderTraversal(root.right, res);
//       // System.out.println(root.data);
//       res.add(root.data);
//     }

//     public static void main(String[] args) {
//         // Creating a sample binary tree
//         Node root = new Node(1);
//         root.left = new Node(2);
//         root.right = new Node(3);
//         root.left.left = new Node(4);
//         root.left.right = new Node(5);
//         root.right.left = new Node(6);
//         root.right.right = new Node(7);

//         // Performing preorder traversal
//         ArrayList<Integer> result = preorder(root);
//         System.out.println("Preorder Traversal: " + result);

//         ArrayList<Integer> result2 = Inorder(root);
//         System.out.println("Inorder Traversal: " + result2);

//         ArrayList<Integer> result3 = PostOrder(root);
//         System.out.println("PostOrder Traversal: " + result3);
//     }
// }