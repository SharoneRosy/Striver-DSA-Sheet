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
    public List<Integer> postorderTraversal(TreeNode root) {
       List<Integer>res=new ArrayList<>();
       Stack<TreeNode>st1=new Stack<>();
       Stack<TreeNode>st2=new Stack<>();
       if(root==null) return res;
       st1.add(root);
       while(!st1.isEmpty()){
        TreeNode curr=st1.pop();
        st2.add(curr);
        if(curr.left!=null) st1.add(curr.left);
        if(curr.right!=null) st1.add(curr.right);
       }
       while(!st2.isEmpty()){
        res.add(st2.pop().val);
       }
       return res;
    }
}