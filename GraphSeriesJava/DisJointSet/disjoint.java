package GraphSeriesJava.DisJointSet;

public class disjoint {
  int[] parent;
  int[] rank;
  int components;
  int []Size;

  disjoint(int nodes) {
    // 0 based indexing
    this.parent = new int[nodes];
    this.rank = new int[nodes];
    this.components = nodes;
    this.Size=new int[nodes];

    for(int i=0;i<nodes;i++){
      this.parent[i]=i;//self parent of themselves
      this.rank[i]=0;
      this.Size[i]=1;
    }
  }
  public int findRootParent(int node){
    if(node==parent[node]){
      return node;
    }
    parent[node]=findRootParent(parent[node]);
    return parent[node];
  }

  public void unionByRank(int node1,int node2){
    //find the root parent first
    int rootParent1=findRootParent(node1);
    int rootParent2=findRootParent(node2);

    if(rootParent1==rootParent2){
      return;
    }
    //whenever we are doing the union of the things
    components--;
    if(rank[rootParent1] < rank[rootParent2]){
      parent[rootParent1]=rootParent2;
    }else if(rank[rootParent1]>rank[rootParent2]){
      parent[rootParent2]=rootParent1;
    }else{
      parent[rootParent2]=rootParent1;
      rank[rootParent1]++;
    }

  }

  public void unionBySize(int node1,int node2){
    //find the root parent first
    int rootParent1=findRootParent(node1);
    int rootParent2=findRootParent(node2);

    if(rootParent1==rootParent2){
      return;
    }
    //whenever we are doing the union of the things
    components--;
    if(Size[rootParent1] < Size[rootParent2]){
      parent[rootParent1]=rootParent2;
      Size[rootParent2]+=Size[rootParent1];
    // }else if(Size[rootParent1]> Size[rootParent2]){
    //   parent[rootParent2]=rootParent1;
    //   Size[rootParent1]+=Size[rootParent2];
    // } 
    }else{
      parent[rootParent2]=rootParent1;
      Size[rootParent1]+=Size[rootParent2];
    }

  }


  public static void main(String[] args) {
    disjoint dsu=new disjoint(4);
    System.out.println("total components->"+dsu.components);
    System.out.println(dsu.findRootParent(0)==dsu.findRootParent(3));
    dsu.unionByRank(0, 3);
    System.out.println(dsu.findRootParent(0)==dsu.findRootParent(3));  }


}
