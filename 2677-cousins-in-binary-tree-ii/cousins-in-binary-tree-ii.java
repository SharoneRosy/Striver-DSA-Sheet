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
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root==null) return root;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        List<Integer>levelsums=new ArrayList<>();
        while(!q.isEmpty()){
            int levelsum=0;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                levelsum+=curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            levelsums.add(levelsum);
        }

        q.add(root);
        int levelindex=1;
        root.val=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                int sibsum=(curr.left!=null?curr.left.val:0)+
                            (curr.right!=null?curr.right.val:0);
                if(curr.left!=null) {
                    curr.left.val=levelsums.get(levelindex)-sibsum;
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    curr.right.val=levelsums.get(levelindex)-sibsum;
                    q.add(curr.right);
                }
            }levelindex++;
        }
        return root;
    }
}