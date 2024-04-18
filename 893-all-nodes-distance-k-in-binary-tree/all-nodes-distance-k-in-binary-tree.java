/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void parent_track(TreeNode root, Map<TreeNode,TreeNode>parent){
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null) {
                q.add(node.left);
                parent.put(node.left,node);
            }
            if(node.right!=null){
                q.add(node.right);
                parent.put(node.right,node);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode>parent=new HashMap<>();
        parent_track(root,parent);
        Map<TreeNode,Boolean>visited=new HashMap<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(target);
        int curr_level=0;
        visited.put(target,true);
        while(!q.isEmpty()){
            int size=q.size();
            if(curr_level==k) break;
            curr_level++;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    q.add(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    q.add(curr.right);
                    visited.put(curr.right,true);
                }
                if(parent.get(curr)!=null && visited.get(parent.get(curr))==null){
                    q.add(parent.get(curr));
                    visited.put(parent.get(curr),true);
                }
            }
        }
        List<Integer>ans=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            ans.add(curr.val);
        }
        return ans;
    }
}