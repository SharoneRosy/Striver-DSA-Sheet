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
    private TreeNode def_traversal(TreeNode root, Set<Integer> to_delete_set, List<TreeNode> res) {

        if (root == null)
            return null;

        root.left = def_traversal(root.left, to_delete_set, res);
        root.right = def_traversal(root.right, to_delete_set, res);

        if (to_delete_set.contains(root.val)) {
            if (root.left != null)
                res.add(root.left);
            if (root.right != null)
                res.add(root.right);
            return null;
        }
        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> to_delete_set = new HashSet<>();
        for (int val : to_delete) {
            to_delete_set.add(val);
        }
        List<TreeNode> res = new ArrayList<TreeNode>();
        root = def_traversal(root, to_delete_set, res);

        if (root != null)
            res.add(root);

        return res;
    }
}