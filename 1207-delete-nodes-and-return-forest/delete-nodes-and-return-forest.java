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
    private TreeNode postorder(TreeNode node, Set<Integer>todelete,List<TreeNode>forest){
        if(node==null) return null;
        node.left=postorder(node.left,todelete,forest);
        node.right=postorder(node.right,todelete,forest);
        if(todelete.contains(node.val)){
            if(node.left!=null) forest.add(node.left);
            if(node.right!=null) forest.add(node.right);
            return null;
        }
        return node;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer>todelete=new HashSet<>();
        for(int val:to_delete) todelete.add(val);
        List<TreeNode>forest=new ArrayList<>();
        root=postorder(root,todelete,forest);
        if(root!=null) forest.add(root);
        return forest;
    }
}