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
    public int minSwaps(List<Integer> level){
        int swaps=0;
        List<Integer>sort_level=new ArrayList<>(level);
        Collections.sort(sort_level);
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<level.size();i++){
            map.put(level.get(i),i);
        }
        for(int i=0;i<level.size();i++){
            while(!level.get(i).equals(sort_level.get(i))){
                swaps++;
                int curr=map.get(sort_level.get(i));
                map.put(level.get(i),curr);
                Collections.swap(level,i,curr);
            }
        }
        return swaps;
    }
    public int minimumOperations(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode>q=new LinkedList<>();
        int operations=0;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer>level=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                level.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            operations+=minSwaps(level);
        }
        return operations;
    }
}