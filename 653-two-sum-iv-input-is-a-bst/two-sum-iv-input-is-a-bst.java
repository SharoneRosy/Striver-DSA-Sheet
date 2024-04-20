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
class BSTIterator{
    Stack<TreeNode>st=new Stack<>();
    Boolean reverse=true;
    public BSTIterator(TreeNode root,Boolean reverse){
        this.reverse=reverse;
        pushAll(root);
    }
    public int next(){
        TreeNode temp=st.pop();
        if(reverse==false){
            pushAll(temp.right);
        }else{
            pushAll(temp.left);
        }
        return temp.val;
    }
    public boolean hasnext(){
        return !st.isEmpty();
    }
    public void pushAll(TreeNode node){
        if(reverse==false){
            while(node!=null){
                st.push(node);
                node=node.left;
            }
        }else{
            while(node!=null){
                st.push(node);
                node=node.right;
            }
        }
    }

}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left=new BSTIterator(root,false);
        BSTIterator right=new BSTIterator(root,true);
        int i=left.next();
        int j=right.next();
        while(i<j){
            if(i+j==k) return true;
            else if(i+j<k) i=left.next();
            else j=right.next();
        }
        return false;
    }
}