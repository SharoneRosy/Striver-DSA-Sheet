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
    int maxDia=0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxHeight(root);
        return maxDia;
    }
    public int maxHeight(TreeNode node){
        if(node==null) return 0;
        int leftHeight=maxHeight(node.left);
        int rightHeight=maxHeight(node.right);
        maxDia=Math.max(maxDia,leftHeight+rightHeight);
        return 1+Math.max(leftHeight,rightHeight);
    }
}