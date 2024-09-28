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
    int maxSum=Integer.MIN_VALUE;
    public int solve(TreeNode root){
        if(root==null) return 0;
        int leftsum=Math.max(0,solve(root.left));
        int rightsum=Math.max(0,solve(root.right));
        maxSum=Math.max(root.val+leftsum+rightsum,maxSum);
        return root.val+Math.max(leftsum,rightsum);
    }
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }
}