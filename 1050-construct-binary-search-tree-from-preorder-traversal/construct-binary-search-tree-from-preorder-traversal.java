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
    int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return generate_bst(preorder,Integer.MAX_VALUE);
    }
    public TreeNode generate_bst(int [] preorder,int bound){
        if(index==preorder.length || preorder[index]>bound) return null;
        TreeNode root=new TreeNode(preorder[index++]);
        root.left=generate_bst(preorder,root.val);
        root.right=generate_bst(preorder,bound);
        return root;
    }
}