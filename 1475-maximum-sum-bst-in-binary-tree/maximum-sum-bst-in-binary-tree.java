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
class Node{
    int max;
    int min;
    int size;
    int maxSum;
    Node(int max,int min,int size,int maxSum){
        this.max=max;
        this.min=min;
        this.size=size;
        this.maxSum=maxSum;
    }
}
class Solution {
    int maxi=0;
    public int maxSumBST(TreeNode root) {
        solve(root);
        return maxi;
    }
    public Node solve(TreeNode root){
        if(root==null){
            return new Node(Integer.MIN_VALUE,Integer.MAX_VALUE,0,0);
        }
        Node left=solve(root.left);
        Node right=solve(root.right);
        if(left.max<root.val && root.val<right.min){
            maxi=Math.max(maxi,root.val+left.maxSum+right.maxSum);
            return new Node(Math.max(root.val,right.max),Math.min(root.val,left.min),
            (1+left.size+right.size),(root.val+left.maxSum+right.maxSum));
        }
        return new Node(Integer.MAX_VALUE,Integer.MIN_VALUE,
                Math.max(left.size,right.size),Math.max(left.maxSum,right.maxSum));
    }
}