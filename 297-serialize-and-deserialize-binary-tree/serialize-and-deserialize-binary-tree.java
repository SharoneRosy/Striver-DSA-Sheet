/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        if(root==null) return "";
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null){
                sb.append("null ");
                continue;
            }
            sb.append(curr.val).append(" ");
            q.add(curr.left);
            q.add(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        String []list=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(list[0]));
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        for(int i=1;i<list.length;i++){
            TreeNode parent=q.poll();
            if(!list[i].equals("null")){
                TreeNode left=new TreeNode(Integer.parseInt(list[i]));
                parent.left=left;
                q.add(left);
            }
            i++;
            if(i < list.length && !list[i].equals("null")){
                TreeNode right=new TreeNode(Integer.parseInt(list[i]));
                parent.right=right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));