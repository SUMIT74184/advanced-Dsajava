package TreeSeriesJava;
import java.util.*;
public class vertical {
    //creating the treemap for the col first
    TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>>map=new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        if(root==null){
            return res;
        }
        //dfs
        dfs(root,0,0);//col,level
        //sort the and fill the res

        //traversing the map
        for(Map.Entry<Integer,TreeMap<Integer,ArrayList<Integer>>>entrycol:map.entrySet()){

            //creating the treemap for level
           TreeMap<Integer,ArrayList<Integer>>levelmap=entrycol.getValue();

           ArrayList<Integer>list=new ArrayList<>();//creating the list

            //traversing the level
           for(Map.Entry<Integer,ArrayList<Integer>>subEntry:levelmap.entrySet()){

            ArrayList<Integer>sublist=subEntry.getValue();

            Collections.sort(sublist);
            list.addAll(sublist);
           }

           res.add(list);
        }
        return res;

    }
    public void dfs(TreeNode root,int col,int level){
        if(root==null) return;

        //insert in map
        //col
        if(!map.containsKey(col)){
            map.put(col,new TreeMap<>());
        }
        //level
        if(!map.get(col).containsKey(level)){
            map.get(col).put(level,new ArrayList<>());
        }
        map.get(col).get(level).add(root.val);
        dfs(root.left,col-1,level+1);
        dfs(root.right,col+1,level+1);
    }

    public static void main(String[] args) {

    }
}
