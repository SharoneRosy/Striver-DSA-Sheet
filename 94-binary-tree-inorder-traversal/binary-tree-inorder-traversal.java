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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        Stack<TreeNode>st=new Stack<>();
        if(root ==null) return res;
        TreeNode curr=root;
        while(true){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }else{
                if(st.isEmpty()) break;
                curr=st.pop();
                res.add(curr.val);
                curr=curr.right;
            }
        }
        return res;
    }
}