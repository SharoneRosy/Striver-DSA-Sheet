/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class SentinelNode {
    int parent;
    Node node;
    int id;

    SentinelNode(int parent, Node node, int id) {
        this.parent = parent;
        this.node = node;
        this.id = id;
    }

}

class Codec {
    // Encodes a tree to a single string.
    StringBuilder sb = new StringBuilder();
    static int id = 1;

    Node PARENT = new Node(-10000);

    public String serialize(Node root) {
        Queue<SentinelNode> q = new LinkedList<>();
        q.add(new SentinelNode(-10000, root, id++));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                SentinelNode child = q.poll();
                if (child.node == null)
                    continue;
                int parentId = child.parent;
                sb.append(parentId);
                sb.append(",");
                sb.append(child.node.val);
                sb.append(",");
                sb.append(child.id);
                sb.append("#");

                for (Node n : child.node.children) {
                    q.add(new SentinelNode(child.id, n, id++));
                }
            }
            sb.append("N");
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] nodes = data.split("N");// levels
        Map<Integer, Node> map = new HashMap<>();
        Node root = null;
        for (String node : nodes) {
            // each level
            String[] child = node.split("#");
            for (String str : child) {
                String[] arr = str.split(",");
                int parent = Integer.parseInt(arr[0]);
                int val = Integer.parseInt(arr[1]);
                int id = Integer.parseInt(arr[2]);

                if (parent == -10000) {
                    root = new Node(val, new ArrayList<>());
                    map.put(id, root);
                } else {
                    Node nNode = new Node(val, new ArrayList<>());
                    // if(map.get(parent).child)
                    Node dead = map.get(parent);
                    map.put(id, nNode);
                    // if(dead.children==null){
                    // dead.children = new ArrayList<>();
                    // }
                    map.get(parent).children.add(nNode);
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));