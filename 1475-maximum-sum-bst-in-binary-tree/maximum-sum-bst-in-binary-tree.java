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

 class NodeValue{
    int maxValue;
    int minValue;
    int size;
    int maxSum;
    NodeValue(int maxValue,int minValue,int size,int maxSum){
        this.maxValue=maxValue;
        this.minValue=minValue;
        this.size=size;
        this.maxSum=maxSum;
    }
 }
class Solution {
    int max=0;
    public int maxSumBST(TreeNode root) {
        //Why this didnt work .Because in the tree if both positive and negative numbers present.
        //Negative shoud be ignored and set to zero.How to do use Math.max
        /*int maxSum=maxSumBstHelper(root).maxSum;
        if(maxSum>0){
            return maxSum;
        }else{
            return 0;
        }*/
        maxSumBstHelper(root);
        return max;

    }

    public NodeValue maxSumBstHelper(TreeNode root){
        //if tree is empty return 0 size
        if(root==null){
            return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,0,0);
        }
        NodeValue left=maxSumBstHelper(root.left);
        NodeValue right=maxSumBstHelper(root.right);

        //If current node is greater than largest in left and smaller than smallest in right
        //it is valid bst
        if(left.maxValue<root.val && root.val<right.minValue){
            //it is valid bst
            max=Math.max(max,root.val+left.maxSum+right.maxSum);
            return new NodeValue(Math.max(root.val,right.maxValue),Math.min(root.val,left.minValue),
                                (1+left.size+right.size),(root.val+left.maxSum+right.maxSum));
        }

        //if invalid BST.pass such values that it cannot pass in future.
        return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,
                                Math.max(left.size,right.size),Math.max(left.maxSum,right.maxSum));

    }
}