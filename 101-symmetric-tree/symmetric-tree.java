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
    public boolean isSymm(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null) return false;
        if(left.val!=right.val) return false;
        return isSymm(left.left,right.right) && isSymm(left.right,right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymm(root.left,root.right);
    }
}