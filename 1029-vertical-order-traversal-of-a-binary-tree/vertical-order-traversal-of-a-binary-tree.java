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
    class Pair{
        TreeNode node;
        int row,col;
        Pair(TreeNode node,int row,int col){
            this.node=node;
            this.row=row;
            this.col=col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair>q=new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map=new TreeMap<>();
        q.add(new Pair(root,0,0));
        while(!q.isEmpty()){
            for(int i=0;i<q.size();i++){
                Pair p=q.poll();
                TreeNode curr=p.node;
                int x=p.row;
                int y=p.col;
                if(!map.containsKey(y)){
                    map.put(y,new TreeMap<>());
                }
                if(!map.get(y).containsKey(x)){
                    map.get(y).put(x,new PriorityQueue<>());
                }
                map.get(y).get(x).offer(curr.val);
                if(curr.left!=null){
                    q.add(new Pair(curr.left,x+1,y-1));
                }
                if(curr.right!=null){
                    q.add(new Pair(curr.right,x+1,y+1));
                }
            }
        }
        List<List<Integer>>ans=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>>key:map.values()){
            List<Integer>currlist=new ArrayList<>();
            for(PriorityQueue<Integer>pq:key.values()){
                while(!pq.isEmpty()){
                    currlist.add(pq.poll());
                }
            }
            ans.add(new ArrayList<>(currlist));
        }
        return ans;
    }
}