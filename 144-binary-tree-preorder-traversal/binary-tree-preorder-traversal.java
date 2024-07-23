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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        Stack<TreeNode>st=new Stack<>();
        if(root==null) return res;
        st.add(root);
        while(!st.isEmpty()){
            TreeNode curr=st.pop();
            if(curr.right!=null) st.add(curr.right);
            if(curr.left!=null)  st.add(curr.left);
            res.add(curr.val);
        }
        return res;
    }
}