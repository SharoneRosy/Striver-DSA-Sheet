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

class Pair{
    TreeNode node;
    int row, col;

    Pair(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        q.offer(new Pair(root, 0, 0));

        while(!q.isEmpty()){

            for(int i = q.size() ; i > 0 ; i--){

               Pair p = q.poll();
               TreeNode currNode = p.node;
               int x = p.row;
               int y = p.col;

               if(!map.containsKey(x))
                    map.put(x, new TreeMap<>());

                if(!map.get(x).containsKey(y))
                    map.get(x).put(y, new PriorityQueue<>());

                map.get(x).get(y).offer(currNode.val);

               if(currNode.left != null){
                   q.offer(new Pair(currNode.left, x - 1, y + 1));
               }

               if(currNode.right != null){
                   q.offer(new Pair(currNode.right, x + 1, y + 1));
               }
            }
        }



        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> key : map.values()){
            List<Integer> currList = new ArrayList<>();

            for(PriorityQueue<Integer> nodes : key.values()){
                while(!nodes.isEmpty()){
                    currList.add(nodes.poll());
                }
            }
           
            ans.add(new ArrayList<>(currList));

        }
    
        return ans;
        
    }
}