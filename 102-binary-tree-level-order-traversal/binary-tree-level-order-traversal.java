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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>>ans=new ArrayList<>();
      Queue<TreeNode>q=new LinkedList<>();
      if(root==null) return ans;
      q.add(root);
      while(!q.isEmpty()){
        int len=q.size();
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<len;i++){
            TreeNode curr=q.poll();
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
            list.add(curr.val);
        }
        ans.add(list);
      }
        return ans;
    }
}