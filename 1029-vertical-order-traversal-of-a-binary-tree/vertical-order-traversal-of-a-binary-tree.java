class Pair {
    TreeNode node;
    int row, col;
    
    Pair(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row; // Vertical position
        this.col = col; // Horizontal position
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        q.add(new Pair(root, 0, 0)); // Start with root at row=0, col=0
        
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                Pair p = q.poll();
                TreeNode currNode = p.node;
                int y = p.col;  // Swapped: now y is column
                int x = p.row;  // Swapped: now x is row
                
                if (!map.containsKey(y)) {
                    map.put(y, new TreeMap<>());
                }
                if (!map.get(y).containsKey(x)) {
                    map.get(y).put(x, new PriorityQueue<>());
                }
                
                map.get(y).get(x).offer(currNode.val);
                
                if (currNode.left != null) {
                    q.offer(new Pair(currNode.left, x + 1, y - 1)); // Move left: x+1, y-1
                }
                
                if (currNode.right != null) {
                    q.offer(new Pair(currNode.right, x + 1, y + 1)); // Move right: x+1, y+1
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> key : map.values()) {
            List<Integer> currList = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : key.values()) {
                while (!nodes.isEmpty()) {
                    currList.add(nodes.poll());
                }
            }
            ans.add(new ArrayList<>(currList));
        }
        return ans;
    }
}
