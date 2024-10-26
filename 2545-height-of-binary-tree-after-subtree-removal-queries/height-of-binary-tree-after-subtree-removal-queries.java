/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findheight(TreeNode root,int level,int[] node_level,int [] node_height,int [][] top_two){
        if(root==null) return 0;
        int height=1+Math.max(findheight(root.left,level+1,node_level,node_height,top_two)
                        ,findheight(root.right,level+1,node_level,node_height,top_two));
        node_level[root.val]=level;
        node_height[root.val]=height;

        if(height>top_two[level][0]){
            top_two[level][1]=top_two[level][0];
            top_two[level][0]=height;
        }else if(height>top_two[level][1]){
            top_two[level][1]=height;
        }
        return height;
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n=100001;
        int[] node_level=new int[n];
        Arrays.fill(node_level,-1);
        int [] node_height=new int[n];
        Arrays.fill(node_height,0);
        int [][] top_two=new int[n][2];
        for(int [] row:top_two) Arrays.fill(row,0);

        findheight(root,0,node_level,node_height,top_two);

        int res[]=new int[queries.length];
        int j=0;
        for(int i:queries){
            int level=node_level[i];
            int height=node_height[i];
            
            int max_height=(top_two[level][0]==height)
                            ?top_two[level][1]:top_two[level][0];
            
            res[j]=max_height+level-1;
            j++;
        }
        return res;
    }
}