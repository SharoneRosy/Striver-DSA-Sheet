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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        boolean isLeftToRight=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer>temp=new ArrayList<>(size);
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                if(isLeftToRight){
                    temp.add(node.val);
                }else{
                    temp.add(0,node.val);
                }

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(temp);
            isLeftToRight=!isLeftToRight;
            
        }
        return res;
    }
}