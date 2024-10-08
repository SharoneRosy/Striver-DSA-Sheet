/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
      public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        // Creating a hashmap to keep track of original node val and cloned Node creted for it.
        HashMap<Integer,Node> map = new HashMap<>();
        return deepClone(node, map);

    }

    private Node deepClone(Node node, HashMap<Integer,Node> map ) {
        // check if original node value is already present in map. If yes, then return that node.
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
        // creating cloned node for original node.val
        Node clonedNode = new Node(node.val);
        // Adding cloned node with original node.val in the map to keep track that which node is already cloned
        map.put(node.val, clonedNode);
        // Now we need to work on cloning it neighbours as well. So iterating over the neighbours on original node, so we can use the same neighbours to clone them and add the connections to the cloned node
        for(Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(deepClone(neighbor, map));
        }
        return clonedNode;
    }
}