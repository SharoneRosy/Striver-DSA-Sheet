
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
class FindElements {
    TreeNode root;
    Set<Integer>ss;

    public FindElements(TreeNode root) {
        this.root=root;
        ss=new HashSet<>();
        root.val=0;
        ss.add(0);
        solve(root,ss);

    }
    public void solve(TreeNode root,Set<Integer>ss){
        if(root==null) return;
        if(root.left!= null){
            root.left.val=(2*root.val+1);
            ss.add(2*root.val+1);
            solve(root.left,ss);
        }
        if(root.right!= null){
            root.right.val=(2*root.val+2);
            ss.add(2*root.val+2);
            solve(root.right,ss);
        }
    }
    
    public boolean find(int target) {
        if(ss.contains(target)){
            return true;
        }
        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */