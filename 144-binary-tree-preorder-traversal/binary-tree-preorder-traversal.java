class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    TreeNode curr = root;
    TreeNode pre;
    
    while (curr != null) {
        if (curr.left == null) {
            res.add(curr.val);         // Add current node
            curr = curr.right;         // Move right
        } else {
            pre = curr.left;
            while (pre.right != null && pre.right!=curr) {
                pre = pre.right;
            }
            if(pre.right==null){
                 pre.right = curr;          
                 res.add(curr.val); 
                 curr=curr.left;
             }
            else{
                pre.right=null;
                curr=curr.right;
            }
        }
    }
    return res;
}
}